
package step26$Generic.exam03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Test {
  
  public static void main(String[] args) throws Exception {
// Writer의 자손들만 지정 가능 !
//  Box<String> box = new Box<>();
//  Box<Object> box2 = new Box<>();
  Box<FileWriter> box3 = new Box<>();
  box3.setValue(new FileWriter(""));

  Box<Writer> box4 = new Box<>();
  box4.setValue(new FileWriter(""));
  box4.setValue(new BufferedWriter(null));
  
  }
}

/*
 *  
 * 
 * 
*/