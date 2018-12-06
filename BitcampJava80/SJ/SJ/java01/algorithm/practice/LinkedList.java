package algorithm.practice;

public class LinkedList {

  Bucket start;
  Bucket end;
  int count;

  public LinkedList() {
    this.start = new Bucket();
    this.end = this.start;
  }

  public void add(Object value) {
    Bucket newBucket = new Bucket();
    this.end.value = value;
    this.end.next = newBucket;
    this.end = newBucket;
    this.count++;
  }

  public void add(int index, Object value) {

    if (index < 0 || index > count) {
      return;
    }
    if (index == count) {
      this.add(value);
      return ;
    }
    count++;
    if (index == 0) {
      Bucket newBucket = new Bucket(value,start);
      start = newBucket;
      return ;
    }
    Bucket cursor = start;
    for (int i = 1; i < index ; i++ ) {
      cursor = cursor.next;
    }
    cursor.next = new Bucket(value,cursor.next);
    
  }

  public int size() {
    return this.count;
  }

  public Object get(int index) {
    if (index < 0 || index >= count) {
      return null;
    }
    Bucket cursor = start;
    cursor =  currentLocation(0,index,cursor);
    return cursor.value;
  }

  public Object remove(int index) {
    if (index < 0 || index >= count) {
      return null;
    }
    count--;
    if (index == 0) {
      Object returnValue = start.value;
      start = start.next;
      return returnValue;
    }
    Bucket cursor = start;
    cursor = currentLocation(1, index, cursor);
    Object value = cursor.next.value;
    cursor.next = cursor.next.next;
    return value;
  }

  public Object set(int index,Object value) {
    if (index < 0 || index >= count) {
      return null;
    }
    Bucket cursor = start;
    cursor = currentLocation(0, index, cursor);

    Object returnValue = cursor.value;
    cursor.value = value ;
    return returnValue;
  }

  private Bucket currentLocation(int i,int index, Bucket cursor) {
    while (i++ < index) {
      cursor = cursor.next;
    }
    return cursor;
  }



}
