/* 주제: 비트 연산자 사용 */
package step04$operator;

public class Exam05 {
  public static void main(String[] args) {
      //&(AND) => 특정 비트들을 걸러낼 때 사용
      int a = 0b0101_0011;
      int b = 0b0000_1111;
      String result =Integer.toBinaryString( a & b );   //0000_0011
      System.out.println(result);

      //|(or) => 특정 비트의 값을 추가할 때 사용
      String result2 =Integer.toBinaryString( a | b );   //0101_1111
      System.out.println(result2);


      //~(NOT) => 전체 비트 값을 반전시키는 효과
      String result3 =Integer.toBinaryString(~ a );   //1010_1100
      System.out.println(result3);

      //^(Xor) => 특정 비트의 값을 제거(반전))하는 것
      // 크로마킹 기법에 많이 사용
      a = 0b0101_0011;
      b = 0b0000_1111;
      String result4 =Integer.toBinaryString(a ^ b );   //0101_1100
      System.out.println(result4);
  }
}
