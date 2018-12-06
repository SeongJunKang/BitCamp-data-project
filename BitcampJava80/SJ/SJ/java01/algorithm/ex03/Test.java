package algorithm.ex03;

public class Test {

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.put("홍길동");      //인덱스 0
    queue.put("임꺽정");
    queue.put("유관순");
    queue.put("안창호");
    queue.put("김원봉");
    queue.put("김구");        //인덱스 5

    Object value = null;
    while((value = queue.poll()) != null)
      System.out.println(value);

  }

}
