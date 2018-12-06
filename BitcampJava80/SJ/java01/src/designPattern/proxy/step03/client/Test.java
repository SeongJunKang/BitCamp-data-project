/* 클라이언트 개발자가 Calculator 객체를 쉽게 사용할 수 있도록
 *  서버 개발자 쪽에서 계산기 대행자(proxy)를 만들어 제공한다
 # 이점
   => 클라이언트 개발자는 계산기 대행자를 사용하여 서버 계산기를 이용한다.
      대행자가 서버측 계산기와 같은 인터페이스를 구현하기 때문에
      클라이언트 개발자는 마치 로컬 객체인 것 처럼 사용할 수 있다.
   단점
   => 서버 개발자가 클라이언트 개발자를 위해 서비스 호출 대행자를 만들어
      제공해야한다.
   > 용어정리!
  1) 스켈레톤(skeleton) 
      => 서버 쪽에서 클라이언트 요청을 받아 실제 서비스 객체를 호출하는 역할.
  2) 스텁(stub)
      => 클라이언트 쪽에서 서버에게 요청을 중개해주는 역할
         인터페이스는 서버쪽 비즈니스 객체와 같다.
  3) ORB(Object Request Broker)
      => 클라이언트 또는 서버쪽에서 요청 중개를 담당하는 스켈레톤, 스텁 객체를 말한다.
 */

package designPattern.proxy.step03.client;

import java.io.IOException;

import designPattern.proxy.step03.server.Calculator;

public class Test {
  
  public static void main(String[] args) throws IOException{
    Calculator calc = new CalcStub();
    System.out.println("10 + 20 = " +calc.plus(10, 20));
    System.out.println("10 - 20 = " +calc.minus(10, 20));
    System.out.println("10 * 20 = " +calc.multiple(10, 20));
    System.out.println("10 / 20 = " +calc.divide(10, 20));
    System.out.println("오호라");
  }
}
