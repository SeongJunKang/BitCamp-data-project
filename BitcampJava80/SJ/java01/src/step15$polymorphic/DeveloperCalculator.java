package step15$polymorphic;

public class DeveloperCalculator extends CalculatorPlus {

  public void printResult(int radix) {
    switch(radix) {
      case 2 : System.out.println(Integer.toBinaryString(this.result));
        break;
      case 8 : System.out.println(Integer.toOctalString(this.result));
        break;
      case 16 : System.out.println(Integer.toHexString(this.result));
        break;
      default :
        super.printResult();
        break;
    }
  }

}
