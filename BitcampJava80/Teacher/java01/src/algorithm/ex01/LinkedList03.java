package algorithm.ex01;

public class LinkedList {
  Bucket start;
  Bucket end;

  public void add(Object value) {
    end.value = value;
    Bucket temp = new Bucket();
    end.next = temp;
    end = temp;
  }

}
