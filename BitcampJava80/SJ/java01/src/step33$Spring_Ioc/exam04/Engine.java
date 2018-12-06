package step33$Spring_Ioc.exam04;

public class Engine {
  private int cc;
  private int valve;
  private String type;

  @Override
  public String toString() {
    return "Engine [cc=" + cc + ", valve=" + valve + ", type=" + type + "]";
  }

  public int getCc() {
    return cc;
  }

  public void setCc(int cc) {
    System.out.println("setcc");
    this.cc = cc;
  }

  public int getValve() {
    return valve;
  }

  public void setValve(int valve) {
    System.out.println("setvalve");
    this.valve = valve;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    System.out.println("settype");
    this.type = type;
  }

  public Engine() {
  }

}
