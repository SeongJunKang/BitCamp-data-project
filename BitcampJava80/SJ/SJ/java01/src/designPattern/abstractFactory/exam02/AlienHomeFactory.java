package designPattern.abstractFactory.exam02;

public class AlienHomeFactory extends HomeFactory{
  @Override
  public Home createHome() {
    Home h = new Home();
    h.이미지 = "alien-home.gif";
    h.방어력 = 80;
    h.공격력 = 90;
    return h;
  }
}
