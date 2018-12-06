package step18$BucketType.exam01;
public class Test05 {
  public static void main(String[] args) {
    Bucket p = new Bucket();
    Bucket2 p2 = new Bucket2();
    Bucket3 p3 = new Bucket3();
    Bucket4 p4 = new Bucket4();
    Bucket5 p5 = new Bucket5();
    p2.value = new String("okok");
    p3.value = new java.util.Date();
    p4.value = new Integer(20);
    p5.value = new Float(3.14f);

    System.out.println((String)p2.value);

  }
}



/*
- 이번 프로젝트는 Bucket 에 float 인스턴스만 저장하기로 했다.
- 개발자의 실수를 방지할수있도록 문법적으로 막아야 한다.
- 해결책 ?
  -> Bucket 은 float 이 아닌 다른 타입의 인스턴스 주소를 저장할 수 있기 때문에
    바람직하지 않다.
  -> float 외에 다른 타입의 인스턴스를 저장하려 할 때 컴파일 오류가 발생하여
    개발자가 바로 오류를 확인할 수 있다.
-> 질문 : 만약 나중에 임의적으로 만든 클래스의 인스턴스를 저장하려 한다면,
          또 새로운 버킷을 생성해야 하나요 ?
  -답변 : 예!, 아주많이.

  대안책 ?
  -> 한 개의 클래스로 다양한 타입에 대응할 수 있는 문법이 필요!
  -> "Generic" 등장 !!!!!


- 설명
  -> 시스템 소프트웨어의 규모는 점점 커지고 있다.
  -> 대단위의 사람들이 함께 같은 소르를 편집하는 경우가 많다.
  -> 문법을 제대로 사용하는 지 감시하기가 점점 더 힘들어진다.
  -> 가능한 개발자의 실수를 최대한 막을 수 있는 문법이 필요한다.
*/
