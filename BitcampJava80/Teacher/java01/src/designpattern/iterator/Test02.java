/* Iterator 패턴 적용 */
package designpattern.iterator;

public class Test02 {

  public static void main(String[] args) {
    NamePool2 namePool = new NamePool2();
    
    // NamePool2에서 값을 꺼내 주는 객체를 얻는다.
    Iterator iterator = namePool.interator(NamePool2.ODD);
    
    // 그 객체를 통해 값을 출력한다.
    // => 값을 꺼내는 방법(알고리즘)에 상관없이 코드는 동일하다. 
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    
  }
}

/*
# Iterator 패턴
- 목록에서 값을 꺼내는 알고리즘을 객체화시키는 방법
- 이점
  개발자는 목록에서 값을 꺼낼 때 알고리즘에 상관없이 
  일관된 방식으로 코드를 작성할 수 있다.
- 방법
  1) 값을 꺼낼 때 호출할 메서드의 규칙을 정의한다.
     => Iterator 인터페이스
  2) Iterator 규칙에 따라서 실제 목록에서 값을 꺼내는 클래스를 정의한다.
     => AscIterator, DescIterator, OddIterator, ThreeMultipleIterator 클래스
      
  
 */

















