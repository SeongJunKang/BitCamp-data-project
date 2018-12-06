// 주제 : equals 오버라이딩
package step16$ObjectClass;

public class Exam04 {

  int age;
  int weight;

  @Override
  public String toString(){
    return "동해물과 백두산이";
  }

  public Exam04(int age,int weight) {
    this.age = age;
    this.weight = weight;
  }

  @Override
  public boolean equals(Object other) {


      if(other == null || !(other instanceof Exam04))
        return 1==0;

      Exam04 obj = (Exam04)other;
      if(this.age != obj.age){
        return 1==0;
      }
      if(this.weight != obj.weight){
        return 1==0;
      }

      return true;

  }

  public static void main(String[] args) {

    Exam04 p = new Exam04(18,90);
    Exam04 p2 = new Exam04(18,90);
    System.out.println( p == p2);
    System.out.println( p.equals(p2));

  }
}

/*











*/
