/* 주제:배열 초기화*/
package step02$memory;
public class Exam07{

  public static void main(String[] args) {
    int[] a;
    a = new int[3];
    a[0]=1;
    a[1]=2;
    a[2]=3;
    System.out.println(a[2]);
    int[] b;
    b= new int[]{10,20,30};
    System.out.println(b[2]);

    int[] c = {100,200,300,400};
    /* 문법오류 !
    int[] c;
    c = {100,200,300,400};  // 이 방식으로 배열을 초기화시킬 떄는
                            // 배열 변수 선언문과 함꼐 사용해야 한다.
                             */
    System.out.println(c[3]);

  }
}

/*


*/
