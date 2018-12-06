package algorithm.practice;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("명재환");      //인덱스 0
    list.add("송지환");
    list.add("강성준");
    list.add("곽용호");
    list.add("김한준");

    list.add(0,"알파고<<");
    // list.remove(0);
    // list.set(1,"이세돌>>");
    System.out.println("---------------------------------");
    for( int i = 0 ; i < list.size() ; i ++)
      System.out.println(list.get(i));
    System.out.println("---------------------------------");

  }

}
