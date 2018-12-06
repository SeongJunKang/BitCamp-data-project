package designPattern.abstractFactory.exam02;

public class HumanHomeFactory extends HomeFactory {
  @Override
  public Home createHome() {
    Home h = new Home();
    h.이미지 = "human-home.gif";
    h.방어력 = 100;
    h.공격력 = 30;
    return h;
  }
}
