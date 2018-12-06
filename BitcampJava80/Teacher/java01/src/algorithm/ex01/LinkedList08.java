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
        cursor = cursor.next;
    }

    return cursor.value;
  }

  public int size() {
    return count;
  }

  public Object remove(int index) {
    if (index < 0 || index >= count) {
      return null;
    }

    count--;

    if (index == 0) {
      Object value = start.value;
      start = start.next;
      return value;
    }

    Bucket cursor = start;
    for (int i = 1; i < index; i++) {
      cursor = cursor.next;
    }
    Object value = cursor.next.value;
    cursor.next = cursor.next.next;

    return value;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= count) {
      return null;
    }

    Bucket cursor = start;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    Object oldValue = cursor.value;
    cursor.value = value;
    return oldValue;
  }
}
