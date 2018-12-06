/*Iterator 패턴 적용
 */

package designPattern.iterator;

public class NamePool2 {
  public static final int ASCENDING = 0;
  public static final int DSECENDING = 1;
  public static final int ODD = 2;
  String[] names = { "홍길동", "임꺽정", "장보고", "이순신", "권율", "이율곡",
      "이황", "황희", "왕건", "신채호", "채재우", "장영실", "정약용" };
  int length = names.length;
  public int getLength() {
    return length;
  }
  class AscIterator implements Iterator {
    int index = 0;

    @Override
    public boolean hasNext() {
      if (index < NamePool2.this.names.length) {
        return true;
      } else {
        return false;
      }
    }

    @Override
    public Object next() {
      return names[index++];
    }
  }

  class DescIterator implements Iterator {
    int index = names.length - 1;

    @Override
    public boolean hasNext() {
      if (index >= 0) {
        return true;
      } else {
        return false;
      }
    }

    @Override
    public Object next() {
      return names[index--];
    }
  }

  class OddIterator implements Iterator {
    int index = 1;

    @Override
    public boolean hasNext() {
      if (index < names.length) {
        return true;
      } else {
        return false;
      }
    }

    @Override
    public Object next() {
      Object value = names[index];
      index += 2;
      return value;
    }
  }

  public Iterator interator(int type) {
    switch (type) {
    case ASCENDING:
      return new AscIterator();
    case DSECENDING:
      return new DescIterator();
    case ODD:
      return new OddIterator();
    default:
      return null;
    }
  }
}
