package step26.exam03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Test {

  public static void main(String[] args) throws Exception {
    // Writer 계열의 클래스만 지정 가능!
    //Box<String> box1 = new Box<>(); // 컴파일 오류!
    //Box<Object> box2 = new Box<>(); // 컴파일 오류!
    
    Box<FileWriter> box3 = new Box<>(); //OK
    box3.setValue(new FileWriter("")); // OK
    
    Box<Writer> box4 = new Box<>(); // OK
    box4.setValue(new FileWriter("")); //OK
    box4.setValue(new BufferedWriter(null));//OK
    

  }

}







