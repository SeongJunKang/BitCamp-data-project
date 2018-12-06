package designPattern.iterator;

public class Test01 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    NamePool np = new NamePool();
    String[] names = np.names;
    // Iterator 사용전
    // 값을 어떻게 꺼낼 것인지는 사용하는 쪽에서 결정한다.
    // 꺼내는 방식에 따라 코드가 다르다.
    //1) 순서대로 꺼내기
    for (int i = 0; i < names.length; i++) {
      System.out.print(i+":"+names[i]+",");
    }
    System.out.println("\n------------------------------");
    
    //2) 역순으로 꺼내기
    for (int i = names.length-1 ; i >=0 ; i--) {
      System.out.print(i+":"+names[i]+",");
    }
    System.out.println("\n------------------------------");
    
    //3) 홀수 번째 값 꺼내기
    for (int i = 1; i < names.length; i+=2) {
      System.out.print(i+":"+names[i]+",");
    }
    System.out.println("\n------------------------------");
    
    //4) 3의 배수에 해당하는 인덱스의 값 꺼내기
    for (int i = 0; i < names.length; i+=3) {
      System.out.print(i+":"+names[i]+",");
    }
    System.out.println("\n------------------------------");
    
  }

}
