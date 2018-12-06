package bitcamp.pms;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;

public class ProjectApp {
  
  static ApplicationContext appContext ;
  static  RequestHandlerMapping requestHandlerMapping;
  static Scanner keyScan = new Scanner(System.in); 
  
  public static void main(String[] args) {
    appContext = new ApplicationContext("bitcamp.pms");
    
    requestHandlerMapping = new RequestHandlerMapping(appContext);
    
    appContext.addBean("stdin", keyScan);
    
    String input="";
    
    do {
      input = prompt(); 
      processCommand(input);
    } while (!input.equals("quit"));

    keyScan.close();
    
    
    
  }
  
  
  
  static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine().toLowerCase();
  }
  
  static void processCommand(String input) {
    
    if (input.equals("quit")) {
      doQuit();
    } else if (input.equals("about")) {
      doAbout();
    } else {
      RequestHandler requestHandler =
          (RequestHandler)requestHandlerMapping.getRequestHandler(input);
      
      if (requestHandler == null) {
        doError();
        return;
      }
      ArrayList<Object> args = new ArrayList<>();
      Method method = requestHandler.getMethod();
      Object obj = requestHandler.getObj();
      Object arg;
      Parameter[] params = method.getParameters();
      for(Parameter param : params) {
        arg = appContext.getBean(param.getType());
        args.add(arg);
      }
      try{
      method.invoke(obj, args.toArray());
      }catch(Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
  static void doError() {
    System.out.println("에러입니다.");
  }
  static void doQuit() {
     System.out.println("안녕히가세요!");
  }
  
  static void doAbout() {
    System.out.println("비트캠프 자바80기 관리프로그램");
  }
  
  
  
  
  
  
  
}