
/* 주제: 값을 저장할 메모리 준비하기-변수 선언*/
package step02$memory;
public class Exam01 {

  public static void main(String[] args) {
    //정수값을 저장할 메모리를 준비하는 명령어
    byte b;     //  1byte 메모리
    short s;    //  2byte 메모리
    int i;      //  4byte 메모리
    long l;     //  8byte 메모리

    //실수값을 저장할 메모리를 준비하는 명령어
    float f;    //  4byte 메모리
    double d;   //  8byte 메모리
    //문자 코드값을 저장할 메모리를 준비하는 명령어
    char c;     //  2byte 메모리
    //논리값을 저장할 메모리를 저장하는 명령어
    boolean bl; // 자바 언어 규약집에는 크기가 정의되어있지 않음.
  }
}

/*
* 변수 선언
-메모리를 준비시키는 명령어
-문법 :
  -> [데이터의 종류] 메모리별명 ;
- 용어
data type  : [데이터의 종류]
variable : 메모리 별명(변수)

왜 데이터 종류 별로 메모리를 준비하는가 !?
- 효율적으로 메모리를 사용하기 위해.
  -> 작은 값은 작은 크기의 메모리에 저장한다  -> 메모리를 절약할 수 있다.
- 데이터를 잘못 사용하는 것을 방지하기 위해.
  ->정수 메모리에 정수값만 넣을 수 있다  ->  잘못 사용할 가능성을 줄인다.

자바에서 기본으로 제공하는 데이터 타입?
- Java primitive data type (원시 데이터 타입)
-정수 : byte(1), short(2), int(4), long(8)
 실수 : float(4), double (8)
 문자 : char(2) / 논리 : boolean(?)
- char 와 short 의 차이점 .
  -> short: signed int 저장가능(음수 저장 가능) -32768 ~32767
  -> char : unsigned int 저장(양수만 저장) : 0~65535
            유니코드는 음수가 없다.


*/
