package step28;

public class KangnamCarFactory implements CarFactory {

  @Override
  public Car create() {
    return new Tico();
  }
  
  public boolean isRent() {
    return true;
  }

}
