package step12$StaticInstance;

public class Car4{

  // 자동차 마다 개별정보를 저장할 변수
    String model;
   String maker;
   int cc;
   int capacity;

   Car4(){

   }

   Car4(String model,String maker, int cc, int capacity){
     this.model = model;
     this.maker = maker;
     this.cc = cc;
     this.capacity = capacity;
   }

}
