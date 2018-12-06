package step33.exam03;

public class Car {
  String model;
  int cc;
  String maker;
  
  public Car() {
    System.out.println("Car()");
  }
  
  public Car(String model, int cc) {
    System.out.println("Car(String model, int cc)");
    this.model = model;
    this.cc = cc;
  }
  
  public Car(String model, String maker) {
    System.out.println("Car(String model, String maker)");
    this.model = model;
    this.maker = maker;
  }
  
  
  public Car(String model, int cc, String maker) {
    System.out.println("Car(String model, int cc, String maker)");
    this.model = model;
    this.cc = cc;
    this.maker = maker;
  }

  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + ", maker=" + maker + "]";
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getCc() {
    return cc;
  }

  public void setCc(int cc) {
    this.cc = cc;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }
  
  

  
}




