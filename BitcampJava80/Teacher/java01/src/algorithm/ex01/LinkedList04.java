package algorithm.ex01;

public class LinkedList {
  Bucket start;
  Bucket end;

  public LinkedList() {
    start = new Bucket();
    end = start;
  }

  public void add(Object value) {
    end.value = value;
    Bucket temp = new Bucket();
    end.next = temp;
    end = temp;
  }

  public Object get(int index) {
    if (index < 0) {
      return null;
    }
    
    Bucket cursor = start;

    for (int i = 0 ; i < index; i++) {
        if (cursor.next == null) { // 목록의 끝이라면,
          return null;
        }
        cursor = cursor.next;
    }

    return cursor.value;
  }








}
