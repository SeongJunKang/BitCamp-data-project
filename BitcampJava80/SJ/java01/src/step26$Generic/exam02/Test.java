package step26$Generic.exam02;

import java.util.Date;

public class Test {
  
  public static void main(String[] args) {

  Box<String> box = new Box<>();
  box.setValue("문자열");
//  box.setValue(new Date());   //컴파일 오류 !
//  box.setValue(10); //컴파일 오류 !
  
  String s = box.getValue(); // 형변환할 필요가 없음.
}
}

/*
 * # 제네릭 사용 후 
 * 1) 컴파일 할 떄 데이터형을 엄격히 검사할 수 있다.
 * 2) 값을 꺼낼 때 마다 형 변환할 필요가 없다.
*/
