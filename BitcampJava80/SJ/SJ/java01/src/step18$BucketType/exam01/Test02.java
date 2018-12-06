package step18$BucketType.exam01;
public class Test02 {
  public static void main(String[] args) {
    Bucket p = new Bucket();
    Bucket2 p2 = new Bucket2();
    p2.value = new String("okok");
    System.out.println((String)p.value);

    p.value = new Integer(20);
    p.value = new Float(3.14f);
    p.value = new java.util.Date();
  }
}



/*
* 요구사항 :
- 특정 프로젝트에서는 한 가지 타입의 인스턴스만 저장하고 싶다.
- 해결책 ?
  Bucket 의 value 변수를  String 으로 선언.

- 프로그래밍마다 버킷에 저장하는 데이터가 다를 수 있다.


*/
