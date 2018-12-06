/* 주제: 비트 이동 연산자 (쉬프트) */
package step04$operator;

public class Exam07 {
  public static void main(String[] args) {

    //왼쪽으로 비트 이동시키기
    int a= 0b0000_1100; // 0x0c =12;
    System.out.println(a << 1);
    System.out.println(a << 2);
    System.out.println(a << 3);

    //  왼쪽으로 x 비트만큼 이동 -> 값 *2^x 배 한 것과 같다.
    //  곱하기를 하는 것 보다 실행 속도가 빠르다.
    //  빈자리는 0으로 채워진다.

    //오른쪽으로 비트를 이동시키기.
    int b = 0b1100_0000; // 0xc0 =192;
    System.out.println(b >> 1);
    System.out.println(b >> 2);
    System.out.println(b >> 3);

    //  x 비트만큼 오른쪽 으로 이동 -> 값 /2^x 한 것과 같다.

    b=-3;
    System.out.printf("%s %d\n",Integer.toBinaryString(b),b);
    System.out.printf("%s %d\n",Integer.toBinaryString(b >> 1),b>>1);
    System.out.printf("%s %d\n",Integer.toBinaryString(b << 1),b<<1);

    //오른쪽으로 이동시키는 특별한 연산  >>>
    //-> 빈자리를 무조건 0으로 채운다.
    //-> 음수의 경우 양수로 변환된다.
    System.out.printf("%s %d\n",Integer.toBinaryString(b >>> 1),b>>>1);
  }
}
