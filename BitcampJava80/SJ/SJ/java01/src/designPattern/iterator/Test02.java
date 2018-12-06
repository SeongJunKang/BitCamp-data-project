/* Iterator 패턴 적용*/
package designPattern.iterator;

public class Test02 {

  public static void main(String[] args) {
    NamePool2 namePool = new NamePool2();
    
    Iterator iterator = namePool.interator(NamePool2.ASCENDING);
    printValues(iterator);
    printHypoon(namePool);
    iterator = namePool.interator(NamePool2.DSECENDING);
    printValues(iterator);
    printHypoon(namePool);
    iterator = namePool.interator(NamePool2.ODD);
    printValues(iterator);
    printHypoon(namePool);
  }
  public static void printValues(Iterator iterator) {
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();
  }
  public static void printHypoon(NamePool2 pool) {
    for (int i = 0; i < pool.getLength() * 7; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

}
/*
# Iterator 패턴
- 목록에서 값을 꺼내는 알고리즘을 객체화 시키는 방법
- 이점
  개발자는 목록에서 값을 꺼낼 때 알고리즘에 상관없이
  일관된 코드를 작성할 수 있다.
- 방법
  1) 값을 꺼낼 때 호출할 메서드의 규칙을 정의한다.
    => Iterator 인터페이스
  2) Iterator 규칙에 따라서 실제 목록에서 값을 꺼내는 클래스를 만든다.
    => AscIterator, DescIterator, OddIterator, ThreeMultipleIterator
 */

