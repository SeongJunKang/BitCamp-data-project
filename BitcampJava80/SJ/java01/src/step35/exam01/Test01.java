//JVM의 기본 스레드들 조사
package step35.exam01;

public class Test01 {

  public static void main(String[] args) {
    //1)  main() 을 실행하는 현재 스레드 알아내기
    Thread currentThread = Thread.currentThread();
    System.out.println("1)Thread : "+currentThread.getName());
    System.out.println("------------------------------");
    //2) "main" 스레드가 소속된 스레드 그룹 알아내기
    ThreadGroup mainThreadGroup = currentThread.getThreadGroup();
    System.out.println("2)Thread Group : "+mainThreadGroup.getName());
    System.out.println("------------------------------");
    //3) "main" 스레드 그룹에 소속된 자식 스레드들 알아내기
    Thread[] childThreads = new Thread[10];
    int count =mainThreadGroup.enumerate(childThreads);
    for (int i = 0; i < count; i++) {
      System.out.println("3)main => Thread :"+childThreads[i].getName());
    }
    System.out.println("------------------------------");
    //4) "main" 스레드 그룹에 소속된 자식 스레드 그룹들 알아내기
    ThreadGroup[] childThreadGroups = new ThreadGroup[10];
    count =mainThreadGroup.enumerate(childThreadGroups);
    if( count <= 0) System.out.println("4)main => ChildThreadGroup : 없음"); 
    for (int i = 0; i < count; i++) {
      System.out.println("4)main => ChildThreadGroup :"+childThreadGroups[i].getName());
    }
    System.out.println("------------------------------");
    //5) "main" 스레드 그룹의 부모 스레드 그룹을 알아내기
    ThreadGroup systemThreadGroup = mainThreadGroup.getParent();
    System.out.println("5)main => ParentsThreadGroup : "+systemThreadGroup.getName());
    System.out.println("------------------------------");
    //6) "system" 스레드 그룹의 자식 스레드들 알아내기
    Thread[] systemThreads = new Thread[10];
    count =systemThreadGroup.enumerate(systemThreads);
    
    for (int i = 0; i < count; i++) {
      System.out.println("6)System => ChildThread :"+systemThreads[i].getName());
    }
    System.out.println("------------------------------");
    //7) "system" 스레드 그룹의 자식 스레드 그룹들
    ThreadGroup[] systemChildThreadGroups = new ThreadGroup[10];
    count =systemThreadGroup.enumerate(systemChildThreadGroups);
    for (int i = 0; i < count; i++) {
      System.out.println("7)System => ChildThreadGroup :"+systemChildThreadGroups[i].getName());
    }
    System.out.println("------------------------------");
    //8) "system" 스레드 그룹의 부모 스레드 그룹을 알아내기
    try{
    ThreadGroup systemParentThreadGroup = systemThreadGroup.getParent();
    System.out.println("8)System => ParentsThreadGroup : "+systemParentThreadGroup.getName());
    }catch(Exception e){
      System.out.println("8)System => ParentsThreadGroup : 없음 ");
    }
    System.out.println("------------------------------");
  }

}
/*
 * #JVM 기본 스레드와 스레드 그룹
 * => Thread Group : System
      => Thread :Reference Handler  : 인스턴스의 레퍼런스를 관리
      => Thread :Finalizer          : 가비지 수집
      => Thread :Signal Dispatcher
      => Thread :Attach Listener
      => Thread :main
           => Thread :main          : main 실행
 * 
 */
