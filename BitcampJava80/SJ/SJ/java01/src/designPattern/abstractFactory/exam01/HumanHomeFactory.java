package designPattern.abstractFactory.exam01;

public class HumanHomeFactory {
  public Home createHome() {
    Home h = new Home();
    h.이미지 = "human-home.gif";
    h.방어력 = 100;
    h.공격력 = 30;
    return h;
  }
}
