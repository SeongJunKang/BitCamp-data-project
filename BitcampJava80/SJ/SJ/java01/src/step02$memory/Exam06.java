/* 주제: 배열 값을 저장하고 꺼내기 */
package step02$memory;
public class Exam06{

  public static void main(String[] args) {
      int[] a = new int[3];

      for(int i=1;i<4;i++)
        a[i-1]=i*10;

        System.out.println(a[2]);
      //System.out.println(a[5]); //실행 할 떄 오류(Runtime) 오류(Exception)
      //a[3]= 40;     // 컴파일 통과 ! 실행할 떄 오류 발생 !
                      // 유효한 인덱스가 아니기 때문에.
        //배열의 개수 알아내기
        System.out.println(a.length);

  }
}

/*
* 배열 사용
- 배열에서 특정 항목의 변수를 사용하기.
- 배열[인덱스]
  예) int[] a =new int[5];
      a[0] = 10;
      a[5] = 10; // 오류 존재하지 않는 인덱스.
- 인덱스는 배열의 항목을 가리키는 번호이다. 0부터 시작.

*/
