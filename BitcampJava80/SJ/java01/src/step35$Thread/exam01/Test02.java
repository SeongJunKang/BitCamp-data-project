//스레드 생성과 우선순위
package step35$Thread.exam01;

public class Test02 {

  public static void main(String[] args) {
    Thread main = Thread.currentThread();
    System.out.println("스레드명 : "+main.getName());
    System.out.println("아이디   : "+main.getId());
    System.out.println("우선순위 : "+main.getPriority());
    System.out.println("--------------------------------");
    Thread child = new Thread();
    System.out.println("스레드명 : "+child.getName());
    System.out.println("아이디   : "+child.getId());
    System.out.println("우선순위 : "+child.getPriority());
    System.out.println("--------------------------------");
    System.out.println("자바의 스레드 우선순위");
    System.out.printf("%d ~ %d \n",Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);
  }
}
/* # 스레드 우선순위
 * => 자식 스레드는 부모 스레드의 우선 순위와 같다.
 * => JVM의 스레드와 OS의 스레드 우선순위 범위가 다르다.
 *    => Windows OS 스레드 레벨은 0 ~ 31
 *    => Linux OS 스레드 레벨은 1 ~ 99
 *    => Solaris OS 스레드 레벨인 0 ~ 169
 * => Thread 관리는 OS에 의존한다.
 * => 결론 :
 *      우선순위에 기반하여 스레드 프로그래밍을 하지 말라!
 *    이유 : OS 처리 방법에 따라 동작이 다르기 때문이다.
 */