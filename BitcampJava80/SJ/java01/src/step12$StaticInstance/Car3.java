package step12$StaticInstance;

public class Car3{

  // 자동차 마다 개별정보를 저장할 변수
   String model;
   String maker;
   int cc;
   int capacity;

   Car3(String model,String maker, int cc, int capacity){
     this.model = model;
     this.maker = maker;
     this.cc = cc;
     this.capacity = capacity;
   }
}
