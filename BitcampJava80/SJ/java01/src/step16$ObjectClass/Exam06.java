// 주제 : hashcode() 오버라이딩
package step16$ObjectClass;

public class Exam06 {

  int age;
  int weight;

  @Override
  public String toString(){
    return "[ "+this.age+", "+this.weight+" ]";
  }

  public Exam06(int age,int weight) {
    this.age = age;
    this.weight = weight;
  }

  @Override
  public boolean equals(Object other) {


      if(other == null || !(other instanceof Exam06))
        return 1==0;

      Exam06 obj = (Exam06)other;
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
    Exam06 p = new Exam06(18,90);
    System.out.println( p.toString());
    System.out.println( p);     // println(object ) -- > 파라미터로 넘어오는 객체에 대해
                                // toString 을 실행한후 리턴을 출력.

  }
}

/*
toString () 재정의 하는 이유
- 간단하게 인스턴스의 값을 확인하고 싶을 때.









*/
