
package bitcamp.pms;
import bitcamp.pms.dto.PlayManagement;

public class ProjectApp {

  public static void main(String[] args) {
    PlayManagement.PlayManagement();
  }
}


/*
* v . 1 . 0

* v . 0 . 9
- 명령 > add
이름 ?
이메일
암호
전화
저장 ?
저장.
명령 > list
0 홍길동 , hong@test.com , 1111 , 1111-2222
1
2
3


* v . 0 . 8
- 사용자로부터 저장 여부 또는 계속 입력 여부를 묻는 코드를 다음의 메서드로 분리하라
boolean confirm(String message) {}
=> message :vmfhavmxmdp cnffurgksms answkduf
예) confirm("저장하시겠습니까 ");
"저장하시겠습니까 (y/n)"
confirm("계속하시겠습니까");
"계속하시겠습니까?"

* v . 0 . 7
- 저장하시겠습니까 ? y
저장하였습니다.
계속 입력하시겠습니까 ?

* v . 0 . 6
- 회원 정보를 입력한 후 저장할 것인지 여부를 물어본다.
저장하시겠습니까 ? (y/n) y
저장하였습니다
저장하시겠습니까 ? (y/n) n
저장을 취소하였습니다.
저장하시겠습니까 ? (y/n) x
잘못된 명령어입니다.
저장하시겠습니까 ? (y/n) x
----------------------------

* v . 0 . 5
- 다섯명의 회원 정보를 입력 받아 출력하라.
- 사용 문법 : 레퍼런스 배열을 이용하여 인스턴스의 주소를 저장.
              반복문 활용

* v . 0 . 4
- 값 객체를 (value object) 를 이용하여 입력받은 회원정보를 저장하라.
  동작은 v.0.3버전과 같다.
  => Value Object class 선언 Member class 선언

* v . 0 . 3
- 다음과 같이 회원 정보를 입력받아 출력하라!
이름 : 홍길동
이메일 : hong@test.com
암호 : 1111
전화 : 111-1111
-------------------------------------------
홍길동 , hong@test , 1111, 111-1111

* v . 0 . 2
- 다음의 회원 정보를 입력 받아 출력하라.
 이름 :
 이름은 xxx 입니다.


* v . 0 . 1
- 프로젝트 관리 시스템 환영 메시지 출력
  PMS에 오신걸 환영합니다.

*/
