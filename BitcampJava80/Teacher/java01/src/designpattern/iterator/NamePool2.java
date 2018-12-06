/* Iterator 패턴 적용 */
package designpattern.iterator;

public class NamePool2 {
  public static final int ASCENDING = 0;
  public static final int DESCENDING = 1;
  public static final int ODD = 2;

  String[] names = {"홍길동", "임꺽정", "장보고", "이순신", "권율", "이율곡",
    "이황", "황희", "선조", "왕건", "최재우", "신채호"};
  
  //1) 순서대로 값을 꺼내주는 객체 정의
  class AscIterator implements Iterator {
    int index = 0;
    public boolean hasNext() {
      if (index < /*NamePool2.this.*/names.length) return true;
      else return false;
    }
    public Object next() {
      return names[index++];
    }
    
  }
  
  //2) 역순으로 값을 꺼내주는 객체 정의
  class DescIterator implements Iterator {
    int index = names.length - 1;
    public boolean hasNext() {
      if (index >= 0) return true;
      else return false;
    }
    public Object next() {
      return names[index--];
    }
    
  }
  
  //3) 홀수 번째 값을 꺼내주는 객체 정의
  class OddIterator implements Iterator {
    int index = 1;
    public boolean hasNext() {
      if (index < names.length) return true;
      else return false;
    }
    public Object next() {
      Object value = names[index];
      index += 2;
      return value;
    }
  }
  
  
  public Iterator interator(int type) {
    switch (type) {
    case ASCENDING: return new AscIterator();
    case DESCENDING: return new DescIterator();
    case ODD: return new OddIterator();
    }
    return null;
  }
}














