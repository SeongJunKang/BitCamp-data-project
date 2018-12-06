package algorithm.ex01;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    Object obj1;
    Object obj2;
    list.add("홍길동");      //인덱스 0
    list.add("임꺽정");
    //"오예"
    list.add("유관순");
    list.add("안창호");
    list.add("김원봉");
    list.add("김구");        //인덱스 5

    obj1 = list.set(0,"ㅎㄱㄷ");
    obj2 = list.set(2,"ㅇㄱㅅ");
    System.out.println(obj1);
    System.out.println(obj2);
    System.out.println();
    for( int i = 0 ; i < list.size() ; i ++)
      System.out.println(list.get(i));

  }

}
