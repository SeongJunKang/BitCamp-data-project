/* 주제 : 변수와 메소드 정리*/

package step12$StaticInstance;

public class Exam09 {


  public static void main(String[] args) {

    Car6 car = new Car6();    // 인스턴스 묶음 하나 준비
    Car6 car2 = new Car6();    // 인스턴스 묶음 하나 더 준비 ( 총 2개)
    Car6 car3 = new Car6();    // 인스턴스 묶음 하나 더 준비 ( 총 3개)

    // car3.setNo(1234);
    car3.setModel("코란도");
    car3.setMaker( "비트자동차");
    car3.setCC(3500);
    car3.setCapacity(-30);

    car2.setModel("티코");
    car2.setMaker( "비트자동차");
    car2.setCC(1500);
    car2.setCapacity(4);

    car.setModel("그랜저");
    car.setMaker( "비트자동차");
    car.setCC(3000);
    car.setCapacity(6);


    System.out.printf("%d, %s , %s , %d , %d \n",car3.getNo(),car3.getModel(),car3.getMaker(),car3.getCC(),car3.getCapacity());
    System.out.printf("%d ,%s , %s , %d , %d \n",car2.getNo(),car2.getModel(),car2.getMaker(),car2.getCC(),car2.getCapacity());
    System.out.printf("%d ,%s , %s , %d , %d \n",car.getNo(),car.getModel(),car.getMaker(),car.getCC(),car.getCapacity());

  }
}

/*

*/
