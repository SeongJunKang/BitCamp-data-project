package test01;

public class Calculator3 {

  int result;
  static void plus (Calculator3 t,int a) {
    t.result += a ;
  }

  static void minus (Calculator3 t,int a) {
    t.result -= a  ;
  }

  static void mul (Calculator3 t,int a ) {
    t.result *= a  ;
  }

  static void div (Calculator3 t,int a) {
    t.result /= a  ;
  }

}
