package step18$BucketType.exam01;
public class Test01 {
  public static void main(String[] args) {
    Bucket p = new Bucket();
    p.value = new String("okok");
    System.out.println((String)p.value);
  }
}



/*
Object 레퍼런스 변수
  장점
  - 모든 인스턴스의 주소를 담을 수 있다.

  단점
  - 꺼낼때마다 원래의 타입으로 캐스팅 해야하는 번거로움이 있다.
*/
