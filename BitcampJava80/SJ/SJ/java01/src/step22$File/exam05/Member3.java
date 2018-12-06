package step22$File.exam05;
import java.io.Serializable;
public class Member3 implements Serializable {
 /**
   * 
   */
  private static final long serialVersionUID = 1L;
String name;
 int age;
 int height;
 int weight;
 float bmi;

 public Member3(){}

 public Member3(String name, int age, int height, int weight) {
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

 private void calculateBMI() {
   float h = this.height / 100f;
   this.bmi = this.weight / (h * h);
 }
}
