/* 주제: 사칙연산자 사용*/
package step03$String;
public class Exam01 {
  public static void main(String[] args) {
    int v[]= new int[2];
    for(int i=1;i<3;i++)
      v[i-1]=i*10;
    int result = v[0]+v[1];
    System.out.println(result);

    byte b=10;            //  리터럴 값 예외 규칙에 의해 컴파일 OK!
    //byte b=v[0];        //  오류! 변수의 경우 비록 작은 수라 할 지라도 허락하지 않는다.

    byte b1=10;
    byte b2=20;
    //byte b3=b1+b2;      //  컴파일 오류!
    //byte b3 =10  + 20;  //  OK!!
    //byte b3 =b1  + 20;  //  컴파일 오류!
    //byte b3 =10  + b2;  //  컴파일 오류!

    short s1=20;
    //short s3=b1+s1;     // 컴파일 오류! 이유 ? byte, short 메모리는
                          // 무조건 int 메모리로 취급된다.
    }
}

/*
* 4byte 리터럴 값을 byte, short 메모리에 저장할 때, 저장이 가능하면 허락한다.
  4byte 변수의 값을 byte, short 메모리에 저장할 때,
                                값을 저장할 수 있더라도 <무조건> 컴파일 오류

* 리터럴 값들의 연산 결과는 리터럴 값으로 취급한다.
- 리터럴은 값이 연산을 하더라도 변하지 않는다. -> 컴파일(번역) 과정에서 검증할 수 있다.
- 기존의 법칙 : 리터럴 값이 비록 4바이트라고 하더라도 메모리에 저장할 수 있다면, 허락

*byte 변수와 byte 변수의 연산 결과는 ?
- int 이다. short와 short 연산도 동일.
- 자바에서는 byte, short, int  메모리의 값을 다룰 떄 int 로 취급한다.

* 리터럴과 변수의 연산 결과는 변수로 취급.
  -> 변수의 값에 따라 연산 결과가 달라지기 때문에 메모리에 저장할 수 있는지 확실하지 않다.
    그래서 기본 크기 보다 작은 메모리에 저장하는 것을 허락하지 않는다.
 */
