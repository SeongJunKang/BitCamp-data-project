/* 주제 : 변수와 메소드 정리*/

package step12$StaticInstance;

public class Exam08 {


  public static void main(String[] args) {

    Car5 car = new Car5();    // 인스턴스 묶음 하나 준비
    Car5 car2 = new Car5();    // 인스턴스 묶음 하나 더 준비 ( 총 2개)
    Car5 car3 = new Car5();    // 인스턴스 묶음 하나 더 준비 ( 총 3개)

    car3.setModel("코란도");
    car3.setMaker( "비트자동차");
    car3.setCC(3500);
    car3.setCapacity(-30);

    System.out.printf("%s , %s , %d , %d \n",car3.getModel(),car3.getMaker(),car3.getCC(),car3.getCapacity());

  }
}

/*

*/
