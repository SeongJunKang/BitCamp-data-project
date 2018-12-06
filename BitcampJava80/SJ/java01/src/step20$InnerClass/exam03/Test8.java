package step20$InnerClass.exam03;
public class Test8 {

  public static void main(String[] args) {
    Outer7 p = new Outer7();
    p.m();

  }
}

/*
중첩클래스와 .class 파일

- 자바 컴파일러는 클래스 선언 당 한개의 .class(bytecode) vkdlfdmf todtjdgksek.
- 중첩 클래스의 경우 "바깥클래스명 $ 중첩클래스명.class" 형식으로 클래스파일을 만듦
- 익명 중첩 클래스는 "바깥클래스명$1.class" 처럼 $ 다음에 선언된 순서대로 번호가 붙음
*/
