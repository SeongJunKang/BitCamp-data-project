// 주제: 랩퍼(wrapper class) 클래스
package step13;

// 클래스의 패키지 정보를 미리 등록한다. --> 컴파일러가 사용하는 정보.
// => 컴파일 한 후에는 버려지는 코드이다.
// => java.lang 패키지의 모든 클래스는 자동으로 import 된다.
// => 주의! 그 하위 패키지는 대상이 아니다.
//import java.lang.Integer;

// System과 String 클래스도 java.lang 패키지 소속이기 때문에
// import 하지 않고 사용한 것이다.

public class Exam01 {
  public static void main(String[] args) {
    // 랩퍼 클래스의 인스턴스 만들기 1
    //java.lang.Integer i = new java.lang.Integer(10);

    // 랩퍼 클래스의 인스턴스 만들기 2
    // import를 이용하여 클래스의 패키지 정보를 미리 등록한 후 클래스를 사용한다.
    Integer i = new Integer(10);
    Float f = new Float(3.14f);
    Character c = new Character('A');

    Float v2 = Float.parseFloat("3.14f");

    String s1 = f.toString();
    String s2 = Integer.toString(74, 16);

    System.out.println(s1);
    System.out.println(s2);
  }
}

/*
랩퍼 클래스?
- 원시 데이터 타입을 좀 더 다양하게 다룰 수 있도록 별도의 클래스로 정의한 것.
- 클래스 목록
byte    --> java.lang.Byte
short   --> java.lang.Short
int     --> java.lang.Integer
long    --> java.lang.Long
float   --> java.lang.Float
double  --> java.lang.Double
boolean --> java.lang.Boolean
char    --> java.lang.Character





*/
