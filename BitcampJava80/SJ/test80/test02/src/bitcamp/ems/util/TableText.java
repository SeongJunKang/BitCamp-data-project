package bitcamp.ems.util;

import java.io.PrintWriter;

public class TableText {

  public static void show(PrintWriter out, String msg) {
    int length = msg.length()*2;
    for (int i = 0 ; i < length ; i ++) 
      out.print("-");
    out.println();
    
    out.println(msg);
    
    for (int i = 0 ; i < length ; i ++) 
      out.print("-");
    out.println();
  }

  public static void show(PrintWriter out, String msg ,int length) {
    for (int i = 0 ; i < length ; i ++) 
      out.print("-");
    out.println();
    
    out.println(msg);
    
    for (int i = 0 ; i < length; i ++) 
      out.print("-");
    out.println();
  }
 
}
