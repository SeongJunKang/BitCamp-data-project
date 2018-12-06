package step18$BucketType.exam01;
public class Test07 {
  public static void main(String[] args) {
    Bucket p1 = new Bucket();
    Bucket6<String> p2 = new Bucket6<String>();
    Bucket6<Integer> p3 = new Bucket6<Integer>();
    p1.value = new String("okok");
    p2.value = new String("okko");
    p3.value = new Integer(123);

    String s1 = (String)p1.value; // Bucket 의 value 는 Object 타입이기 때문에
                          //원래 타입 변수에 저장하려면 타입캐스팅해야함.
    String s2 = p2.value; // Bucket6는 타입캐스팅 안해도 된다.
                          // p2변수 선언할 때 타입 정보를 넘겨주었기 때문.
  }
}
