package algorithm.ex02;

import algorithm.ex01.LinkedList;

public class Stack {

  Bucket top;
  int count;
  public Stack() {
  }

  public void push(Object value) {
    Bucket newTop = new Bucket(value,top);
    top = newTop;
    count++;
  }

  public Object pop() {
    if (count == 0) {
      return null;
    }
    Bucket oldTop = top;
    top = top.previous;
    count--;
    return oldTop.value;
  }
  public int size() {
    return this.count;
  }

  // LinkedList list = new LinkedList();
  // int count;
  // public void push(Object value) {
  //   list.add(value);
  //   count ++;
  // }
  //
  // public Object pop() {
  //   Object p = list.get(list.size() - 1);
  //   Object r = list.remove(list.size() - 1);
  //   return p;
  // }
  //
  // public int size() {
  //   return this.count;
  // }

}
