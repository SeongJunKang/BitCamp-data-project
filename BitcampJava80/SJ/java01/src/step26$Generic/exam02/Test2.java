package step26$Generic.exam02;

import java.util.Date;

public class Test2 {
  
  public static void main(String[] args) {
    
    Box box = new Box();
    box.setValue("문자열");
    
     //raw type 으로 사용할 경우 직접 형변환 해야한다.
    String s = (String)box.getValue(); // 형변환할 필요가 없음.
  }
}

/*
 * # 제네릭 사용 후 
 * 1) 컴파일 할 떄 데이터형을 엄격히 검사할 수 있다.
 * 2) 값을 꺼낼 때 마다 형 변환할 필요가 없다.
*/
