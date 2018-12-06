package bitcamp.pms.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;
import bitcamp.pms.util.Session;

public class ServiceThread extends Thread {
  ApplicationContext beanContainer;
  RequestHandlerMapping requestHandlerMapping;
  Socket socket;
  Scanner in = null;
  PrintStream out = null;
  Session session = new Session();
  
  public ServiceThread(
      Socket socket, 
      RequestHandlerMapping requestHandlerMapping,
      ApplicationContext beanContainer) {
    this.socket = socket;
    this.requestHandlerMapping = requestHandlerMapping; 
    this.beanContainer = beanContainer;
  }
  
  @Override
  public void run() {
    try {
      in = new Scanner(new BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
      
      String command = null;
      while (true) {
        command = in.nextLine();
        if (command.equals("quit")) {
          break;
        }
        processCommand(command);
      }
    
      out.println("Good bye!");
      out.println();
      out.flush();
      
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  private void processCommand(String input) {
    String[] tokens = input.split("\\?");
    
    // 1) 클라이언트가 보낸 파라미터 값을 맵 객체에 담는다.
    Map<String,String> paramMap = null; 
    if (tokens.length > 1) {
      paramMap = parseParameters(tokens[1]);
    }
    
    // 2) 클라이언트의 요청을 처리할 메서드를 찾는다.
    RequestHandler requestHandler = 
        (RequestHandler) requestHandlerMapping.getRequestHandler(tokens[0]);
      
    if (requestHandler == null) { // 명령 처리기를 못 찾았다면,
      out.println("해당 명령어가 없습니다.");
      out.println();
      out.flush();
      return;
    }
        
    Method method = requestHandler.getMethod();
    Object obj = requestHandler.getObj();
    
    try {
      ArrayList<Object> args = new ArrayList<>();
      Parameter[] params = method.getParameters();
      Object arg = null;
      
      for (Parameter param : params) {
        if (param.getType() == Session.class) {
          arg = session;
        } else if (param.getType() == PrintStream.class) {
          arg = out;
        } else if (param.getType() == Map.class) {
          arg = paramMap;
        } else {
          arg = beanContainer.getBean(param.getType());
        }
        args.add(arg);
      }
      
      method.invoke(obj, args.toArray());
      
    } catch (Exception e) {
      out.println("명령 처리 중에 오류가 발생했습니다!");
      e.printStackTrace(out);

    } finally {
      out.println(); // 클라이언트에게 응답 종료를 알리기 위해 빈 줄을 보낸다.
      out.flush();
    }
  }
  
  private HashMap<String,String> parseParameters(String str) {
    HashMap<String,String> paramMap = new HashMap<>();
    
    String[] tokens = str.split("&");
    String[] kv = null;
    for (String token : tokens) {
      kv = token.split("=");
      paramMap.put(kv[0], kv[1]);
    }
    
    return paramMap;
  }
}








