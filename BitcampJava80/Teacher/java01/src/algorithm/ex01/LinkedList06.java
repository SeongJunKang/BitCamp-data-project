package algorithm.ex01;

public class LinkedList {
  Bucket start;
  Bucket end;
  int count;

  public LinkedList() {
    start = new Bucket();
    end = start;
  }

  public void add(Object value) {
    end.value = value;
    Bucket temp = new Bucket();
    end.next = temp;
    end = temp;
    count++;
  }

  public void add(int index, Object value) {
    if (index < 0 || index > count) {
      return;
    }

    Bucket newBucket = new Bucket(value, null);

    if (index == 0) {
      newBucket.next = start;
      start = newBucket;
      count++;
      return;
    }

    if (index == count) {
      add(value);
      return;
    }

    Bucket cursor = start;
    int i = 1;
    while (i < index) {
      cursor = cursor.next;
      i++;
    }
    Bucket nextBucket = cursor.next;
    cursor.next = newBucket;
    newBucket.next = nextBucket;
    count++;
  }

  public Object get(int index) {
    if (index < 0 || index >= count) { // 유효 범위가 아니라면,
      return null;
    }

    Bucket cursor = start;

    for (int i = 1 ; i <= index; i++) {
        if (cursor.next == null) { // 목록의 끝이라면,
          return null;
        }
        cursor = cursor.next;
    }

    return cursor.value;
  }

  public int size() {
    return count;
  }








}
