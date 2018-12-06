package designPattern.abstractFactory.exam02;

public class MonsterHomeFactory extends HomeFactory{
  @Override
  public Home createHome() {
    Home h = new Home();
    h.이미지 = "Monster-home.gif";
    h.방어력 = 70;
    h.공격력 = 100;
    return h;
  }
}
