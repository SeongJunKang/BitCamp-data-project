package step26$Generic.exam01;

import java.util.Date;

public class Test {
  
  public static void main(String[] args) {
    Box box = new Box();
    box.setValue("문자열");
    box.setValue(new Date());
    box.setValue(10); //< auto - boxing 
  }
}

/*
 * # 제네릭 사용 전 문제점 ?
 * 1) 컴파일 할 떄 데이터형을 엄격히 검사할 수 없다.
 * 2) 값을 꺼낼 때 마다 형 변환해야한다..
*/
