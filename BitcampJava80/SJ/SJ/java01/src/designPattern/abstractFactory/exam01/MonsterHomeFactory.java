package designPattern.abstractFactory.exam01;

public class MonsterHomeFactory {
  public Home createHome() {
    Home h = new Home();
    h.이미지 = "human-home.gif";
    h.방어력 = 70;
    h.공격력 = 100;
    return h;
  }
}
