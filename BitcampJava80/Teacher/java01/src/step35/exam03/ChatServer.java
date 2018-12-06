package step35.exam03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer implements MessageDispatcher {
  ArrayList<ClientThread> clients = new ArrayList<>();
  
  public ChatServer() {}
  
  @Override
  synchronized public void send(String message) {
    for (ClientThread client : clients) {
      client.send(message);
    }
  }
  
  public void execute() {
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      System.out.println("서버 준비 중...");
      serverSocket = new ServerSocket(9999);
      
      ClientThread clientThread = null;
      
      while (true) {
        System.out.println("클라이언트 대기 중...");
        socket = serverSocket.accept();
        
        clientThread = new ClientThread(this, socket);
        clientThread.start();
        clients.add(clientThread);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {serverSocket.close();} catch (Exception e) {}
    }
  }
  
  
  class ClientThread extends Thread {
    Socket socket;
    MessageDispatcher messageDispatcher;
    Scanner in = null;
    PrintStream out = null;
    
    public ClientThread(MessageDispatcher messageDispatcher, Socket socket) {
      this.messageDispatcher = messageDispatcher;
      this.socket = socket;
    }
    
    public void send(String message) {
      try {
        out.println(message);
      } catch (Exception e) {
        System.out.println("메시지 전송 중 오류 발생!");
      }
    }

    @Override
    public void run() {
      String message = null;
      
      try {
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        while (true) {
          message = in.nextLine();
          if (message.equals("quit")) {
            messageDispatcher.send("즐거운 하루되세요.");
            break;
          }
          messageDispatcher.send(message);
        }
        
      } catch (Exception e) {
        System.out.println("클라이언트 통신 오류!");
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }

  public static void main(String[] args) {
    ChatServer server = new ChatServer();
    server.execute();
  }
}









