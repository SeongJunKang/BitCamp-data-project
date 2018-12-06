/* 주제 : 변수와 메소드 정리*/

package step12$StaticInstance;

public class Exam10 {


  public static void main(String[] args) {
    Car7 c1 = new Car7(0,"티코", "비트자동차", 2000, 5);
      Car7 c2 = new Car7(1,"그랜저", "비트자동차", 3000, 5);
      Car7 c3 = new Car7();

      c3.setModel("코란도");
      c3.setMaker("비트자동차");
      c3.setCC(3500);
      c3.setCapacity(-30);

      System.out.printf("%d, %s, %s, %d, %d\n",
        c1.getNo(), c1.getModel(), c1.getMaker(), c1.getCC(), c1.getCapacity());

      System.out.printf("%d, %s, %s, %d, %d\n",
        c2.getNo(), c2.getModel(), c2.getMaker(), c2.getCC(), c2.getCapacity());

      System.out.printf("%d, %s, %s, %d, %d\n",
        c3.getNo(), c3.getModel(), c3.getMaker(), c3.getCC(), c3.getCapacity());

      System.out.println(c3.toString());
  }
}

/*

*/
