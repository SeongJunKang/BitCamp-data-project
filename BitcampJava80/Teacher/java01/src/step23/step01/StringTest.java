package step23;

public class StringTest {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = "Hello"; // new String("Hello")
    String s3 = new String("Hello");
    String s4 = "Hello"; // 기존에 있는 인스턴스 주소를 리턴한다. 즉 s2의 주소
    if (s1 == s3) System.out.println("s1 == s3");
    if (s2 == s4) System.out.println("s2 == s4");
  }
}
