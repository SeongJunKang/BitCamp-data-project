// 주제 : hashcode() 오버라이딩
package step16$ObjectClass;

public class Exam05 {

  int age;
  int weight;

  @Override
  public String toString(){
    return "동해물과 백두산이";
  }

  public Exam05(int age,int weight) {
    this.age = age;
    this.weight = weight;
  }

  @Override
  public boolean equals(Object other) {


      if(other == null || !(other instanceof Exam05))
        return 1==0;

      Exam05 obj = (Exam05)other;
      if(this.age != obj.age){
        return 1==0;
      }
      if(this.weight != obj.weight){
        return 1==0;
      }

      return true;

  }

  @Override
  public int hashCode() {
    StringBuffer buf = new StringBuffer();
    buf.append(Integer.toString(age));
    buf.append("@");
    buf.append(Integer.toString(weight));

    return buf.toString().hashCode();

  }

  public static void main(String[] args) {

    String s = new String("Hello");
    String s2 = new String("Hello");
    System.out.println( s == s2);
    System.out.printf("%d ---- %d \n",s.hashCode(),s2.hashCode());

    Exam05 p = new Exam05(18,90);
    Exam05 p2 = new Exam05(18,90);
    System.out.println( p == p2);
    System.out.printf("%d ---- %d \n",p.hashCode(), p2.hashCode());

  }
}

/*
* hashcode() 재정의 하는 이유.
- 같은 값을 갖는 인스턴스에 대해 같은 해시코드를 리턴하게 함으로써
  인스턴스 비교를 더 쉽게만든다.










*/
