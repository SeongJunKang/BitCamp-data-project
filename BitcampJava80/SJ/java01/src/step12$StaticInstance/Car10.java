package step12$StaticInstance;

//클래스 앞에 final 붙이면 상속 불가.
public final class Car10 {


  public static int plus(final int a,final int b) {
    // 만약 파라미터로 받은 값을 실수로 변경하려 한다면.
    //컴파일 오류
    //a = 30 ;  // 파라미터값을 일반 로컬 변수로 착각하지 않도록 하기 위함.
    return a + b;
  }
}
