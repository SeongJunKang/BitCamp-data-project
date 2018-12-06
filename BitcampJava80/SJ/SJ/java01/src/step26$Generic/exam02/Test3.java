package step26$Generic.exam02;

import java.util.Date;

public class Test3 {
  
  public static void main(String[] args) {
    Box<String> box1 = new Box<>();
    Box<Integer> box2 = new Box<>();
    Box<Date> box3 = new Box<>();
    Box<Object> box4 = new Box<>();
    
    box1.setValue("문자열");
    box2.setValue(10);
    box3.setValue(new Date());
    box4.setValue(10);
    
    // 지정된 타입 외의 값을 저장할떄 컴파일 오류 발생.
    // box1.setValue(10);

  }
}

/*
 * # 제네릭 사용 후 
 * 1) 컴파일 할 떄 데이터형을 엄격히 검사할 수 있다.
 * 2) 값을 꺼낼 때 마다 형 변환할 필요가 없다.
*/
