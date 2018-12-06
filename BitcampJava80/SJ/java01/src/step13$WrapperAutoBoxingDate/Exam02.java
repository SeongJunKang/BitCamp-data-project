//주제 : 랩퍼 (wrapper class) 클래스와 원시 타입간 오토박싱(auto- boxing)
package step13$WrapperAutoBoxingDate;


public class Exam02 {

  public static void main(String[] args) {
    //(auto-boxing) -->오토박싱
    Integer i = 10;    // 내부에서 랩퍼 클래스의 인스턴스 생성.
                       // new Integer (10); 과 같다.

    // auto - unboxing
    // 랩퍼 클래스의 인스턴스 값을 원시 타입 값을 자동으로 리턴;

    Integer i2 = new Integer(100);
    int v1 = i2 ; //  i2.intValue();


  }
}


/*

*/
