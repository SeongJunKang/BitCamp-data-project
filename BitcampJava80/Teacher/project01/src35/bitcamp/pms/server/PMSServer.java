package bitcamp.pms.server;

import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.pms.context.request.RequestHandlerMapping;

public class PMSServer {
  ApplicationContext beanContainer;
  RequestHandlerMapping requestHandlerMapping;
  
  ServerSocket serverSocket;
  
  public PMSServer() throws Exception {
    // 1) 스프링 IoC 컨테이너 준비 
    // => 객체를 생성하고 의존 객체를 주입.
    beanContainer = new ClassPathXmlApplicationContext(
        "conf/application-context.xml");
    
    // 2) @RequestMapping 애노테이션 처리
    // => 클라이언트 요청을 처리할 메서드를 등록
    requestHandlerMapping = new RequestHandlerMapping(beanContainer);
    
    // 3) 서버 통신 준비
    serverSocket = new ServerSocket(this.getServerPort());
  }
  
  public void execute() {
    Socket socket = null;
    try {
      while (true) {
        socket = serverSocket.accept();
        new ServiceThread(socket, requestHandlerMapping, beanContainer).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void close() {
    try {serverSocket.close();} catch (Exception e) {}
  }
  
  private int getServerPort() {
    //java -Dport=8989 -cp ./bin PMSServer
    String value = System.getProperty("port");
    if (value != null) {
      return Integer.parseInt(value);
    }
    return 9999;
  }
  
  public static void main(String[] args) {
    PMSServer server = null;
    try {
      server = new PMSServer();
      System.out.println("PMSServer 실행 중...2");
      
      server.execute();
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      server.close();
    }
  }
  

}









