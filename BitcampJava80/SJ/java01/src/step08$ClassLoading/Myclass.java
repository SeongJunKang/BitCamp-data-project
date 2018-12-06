// 중간 계산 결과를 개별적으로 저장할 변수를 추가하나다.
package step08$ClassLoading;
public class Myclass {

  static int sv;    //클래스변수 , 스태틱 변수 -> method area
  int iv;           //인스턴스 변수 -> heap area

  static void setSValue(int a) {
    sv = a;
  }

  void setIvalue(int a) {
    this.iv = a;
  }

}
