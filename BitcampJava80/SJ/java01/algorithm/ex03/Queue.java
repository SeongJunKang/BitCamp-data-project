package algorithm.ex03;

public class Queue {
  //FIFO
  Bucket head;
  Bucket rear;
  int count;
  public Queue() {
    this.head = new Bucket();
    this.rear = this.head;
  }

  public void put(Object value) {
    Bucket newHead = new Bucket();
    this.rear.value = value;
    this.rear.tail = newHead;
    this.rear = newHead;
    this.count++;
  }

  public Object poll() {
    if (count == 0) {
      return null;
    }
    Object oldValue = head.value;
    head = head.tail;
    count--;
    return oldValue;
  }

  public int size() {
    return this.count;
  }
}
