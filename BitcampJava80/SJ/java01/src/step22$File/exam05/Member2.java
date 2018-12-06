package step22$File.exam05;
import java.io.Serializable;
public class Member2 implements Serializable {
 /**
   * 
   */
  private static final long serialVersionUID = 1L;
String name;
 int age;
 int height;
 int weight;
 transient float bmi;
/*
Transient
-> 사전적 의미 " 일시적인, 순간적인"
-> 인스턴스 변수 중에서 일시적인 데이터를 저장하는 용도나
  또는 다른 인스턴스 변수의 값을 사용하여 계산한 결과를 저장하는
  용도인 경우, 출력 대상에서 제외하는 것도 정확도 측면에서 좋다.
  즉, 읽어들이는 쪽에서 계산을 다시 수행하도록 한다.
  그래서 중간에 데이터가 조작되는 것을 막을 수 있다.
-> Serialize 대상에서 제외할 변수에 대해 이 옵션을 붙여라!
*/
 public Member2(){}

 public Member2(String name, int age, int height, int weight) {
   this.name = name;
   this.age = age;
   this.height = height;
   this.weight = weight;
   this.calculateBMI();
 }

 @Override
 public String toString() {
   return this.name + ", "+ this.age + ", " +this.height+ ", "+this.weight+
   ", "+this.bmi;
 }

 public void calculateBMI() {
   float h = this.height / 100f;
   this.bmi = this.weight / (h * h);
 }
}
