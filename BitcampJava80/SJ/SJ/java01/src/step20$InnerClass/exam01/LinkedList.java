package step20$InnerClass.exam01;

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

  public Object get(int index) {
    if (index < 0 || index >= count) {
      return null;
    }
    Bucket cursor = start;
    for (int i = 1 ; i <= index ; i ++ ) {
        cursor = cursor.next;
    }
    return cursor.value;
  }

  public int size() {
    return this.count;
  }

  public void add(int index, Object value) {
    Bucket newBucket = new Bucket(value,null);

    if(index == 0 ) {
      newBucket.next = start;
      start = newBucket;
      count++;
      return ;
    } else if (index == count) {
      this.add(value);
      return ;
    } else if (index > count) {
      System.out.println("인덱스가 사이즈를 넘었습니다");
      return ;
    }

    Bucket cursor = start;
    for (int i = 1 ; i < index ; i ++ ) {
      cursor = cursor.next;
    }

    Bucket tmp = cursor.next ;
    cursor.next = newBucket;
    newBucket.next = tmp;
    count++;
  }

  public Object remove(int index) {

    Bucket cursor = start;
    if (index >= count || index < 0) {
      System.out.println("존재하지 않는 인덱스");
      return null;
    }

    count--;
    if (index == 0 ) {
      start = cursor.next;
      return cursor.value;
    }

    for (int i = 1 ; i < index  ; i ++ ) {
      cursor = cursor.next;
    }
    Bucket delete = cursor.next;
    cursor.next = delete.next;
    return delete.value;
  }

  public Object set(int index,Object value) {
    if (index >= count || index < 0) {
      System.out.println("존재하지 않는 인덱스");
      return null;
    }
    Bucket cursor = start;
    Object pre ;

    for (int i = 0 ; i < index  ; i ++ ) {
      cursor = cursor.next;
    }
    pre = cursor.value;
    cursor.value = value;
    return pre;
  }

}
