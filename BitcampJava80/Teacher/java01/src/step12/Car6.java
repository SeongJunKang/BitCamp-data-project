package step12;

public class Car6 {
  // 모든 인스턴스가 공유하는 데이터는 스태틱 변수에 보관하라!
  static int count;

  private int no;
  private String model;
  private String maker;
  private int cc;
  private int capacity;

  {
    this.no = ++Car6.count;
  }

  public Car6() {}

  public Car6(String model, String maker, int cc, int capacity) {
    this.setModel(model);
    this.setMaker(maker);
    this.setCc(cc);
    this.setCapacity(capacity);
  }
  public int getNo() { return this.no; }

  public String getModel() { return this.model; }
  public void setModel(String model) { this.model = model; }

  public String getMaker() { return this.maker; }
  public void setMaker(String maker) { this.maker = maker; }

  public int getCc() { return this.cc; }
  public void setCc(int cc) {
    if (cc > 0 && cc <= 10000) {
      this.cc = cc;
    }
  }

  public int getCapacity() { return this.capacity; }
  public void setCapacity(int capacity) {
    if (capacity > 0 && capacity < 100) {
      this.capacity = capacity;
    }
  }

}
/*





*/
