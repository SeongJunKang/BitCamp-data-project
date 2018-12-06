package step33$Spring_Ioc.exam10;

import org.springframework.stereotype.Component;

@Component
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
    this.cc = cc;
  }

  public int getValve() {
    return valve;
  }

  public void setValve(int valve) {
    this.valve = valve;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Engine() {
  }

}
