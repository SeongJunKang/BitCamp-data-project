package step14$SpecialGeneral.exam05;

public abstract class  Car {

  String model;
  String maker;
  int cc;
  int capacity;
  public void printInfo() {
    System.out.printf("모델 : %s \n",this.model);
    System.out.printf("제조사 : %s \n",this.maker);
    System.out.printf("CC : %d \n",this.cc);
    System.out.printf("최대수용인원 : %d \n",this.capacity);

  }

}
