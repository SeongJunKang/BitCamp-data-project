package algorithm.ex04;

public class LinkedList<T> {

  Bucket<T> start;
  Bucket<T> end;
  int count;

  public LinkedList() {
    this.start = new Bucket<T>();
    this.end = this.start;
  }

  public void add(T value) {
    Bucket<T> newBucket = new Bucket<T>();
    this.end.value = value;
    this.end.next = newBucket;
    this.end = newBucket;
    this.count++;
  }

  public void add(int index, T value) {

    if (index < 0 || index > count) {
      return;
    }
    if (index == count) {
      this.add(value);
      return ;
    }
    count++;
    if (index == 0) {
      Bucket<T> newBucket = new Bucket<T>(value,start);
      start = newBucket;
      return ;
    }
    Bucket<T> cursor = start;
    for (int i = 1; i < index ; i++ ) {
      cursor = cursor.next;
    }
    cursor.next = new Bucket<T>(value,cursor.next);

  }

  public int size() {
    return this.count;
  }

  public T get(int index) {
    if (index < 0 || index >= count) {
      return null;
    }
    Bucket<T> cursor = start;
    cursor =  currentLocation(0,index,cursor);
    return cursor.value;
  }

  public T remove(int index) {
    if (index < 0 || index >= count) {
      return null;
    }
    count--;
    if (index == 0) {
      T returnValue = start.value;
      start = start.next;
      return returnValue;
    }
    Bucket<T> cursor = start;
    cursor = currentLocation(1, index, cursor);
    T value = cursor.next.value;
    cursor.next = cursor.next.next;
    return value;
  }

  public T set(int index,T value) {
    if (index < 0 || index >= count) {
      return null;
    }
    Bucket<T> cursor = start;
    cursor = currentLocation(0, index, cursor);

    T returnValue = cursor.value;
    cursor.value = value ;
    return returnValue;
  }

  private Bucket<T> currentLocation(int i,int index, Bucket<T> cursor) {
    while (i++ < index) {
      cursor = cursor.next;
    }
    return cursor;
  }



}
