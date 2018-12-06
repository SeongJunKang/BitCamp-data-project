package step18$BucketType.exam01;
public class Test04 {
  public static void main(String[] args) {
    Bucket p = new Bucket();
    Bucket2 p2 = new Bucket2();
    Bucket3 p3 = new Bucket3();
    Bucket4 p4 = new Bucket4();
    p2.value = new String("okok");
    p3.value = new java.util.Date();
    p4.value = new Integer(20);
    p.value = new Float(3.14f);

    System.out.println((String)p2.value);

  }
}



/*
- 이번 프로젝트는 Bucket 에 Integer 인스턴스만 저장하기로 했다.
- 개발자의 실수를 방지할수있도록 문법적으로 막아야 한다.
- 해결책 ?
  -> Bucket 은 Integer 이 아닌 다른 타입의 인스턴스 주소를 저장할 수 있기 때문에
    바람직하지 않다.
  -> Integer 외에 다른 타입의 인스턴스를 저장하려 할 때 컴파일 오류가 발생하여
    개발자가 바로 오류를 확인할 수 있다.

  -> a
*/
