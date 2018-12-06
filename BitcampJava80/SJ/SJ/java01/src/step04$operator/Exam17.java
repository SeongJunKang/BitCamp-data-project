/* 주제: 암시적형변환의 규칙 */
package step04$operator;

public class Exam17 {
  public static void main(String[] args) {

      byte b = 10;
      short s = 20;
      int i = 30;
      long l = 40;
      float f = 3.14f;
      double d = 345.5;

      double r = b + s + f - i -d + l;
      System.out.println(r);
/*형변환규칙
byte short ->> 무조건 int
int long ->> float , double
float ->> double.

*/
  }
}
