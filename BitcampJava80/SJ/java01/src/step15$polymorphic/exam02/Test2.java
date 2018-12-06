package step15$polymorphic.exam02;

public class Test2 {

  public static void main(String[] args) {

    Member s1 = new Student();
    s1.id = "hong";
    s1.password = "1111";
    // s1.isWorking = true;

    Student s2 = (Student)s1;
    s2.isWorking =true;

  }
}
