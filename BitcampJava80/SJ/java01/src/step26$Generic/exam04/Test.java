
package step26$Generic.exam04;

import java.io.FileWriter;
import java.io.Writer;

public class Test {
  
  public static void main(String[] args) throws Exception {
    Object r1 = new FileWriter("");
    Writer r2 = new FileWriter("");
    
    FileWriter r3 = new FileWriter("");
    
    Box<String> b1 = new Box<String>();
    //Box<Object> b2 = new Box<String>();  // 컴파일 오류 
    //Box<Object>는 Box<String> 의 상위 타입이 아니다.
    //Box<FIleWriter> b3 = new Box<Writer>(); // 컴파일 오류
     
  }
}

/*
 *  
 * 
 * 
*/