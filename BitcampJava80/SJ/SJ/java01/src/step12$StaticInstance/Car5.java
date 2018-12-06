package step12$StaticInstance;

public class Car5{

  // 자동차 마다 개별정보를 저장할 변수
   private String model;
   private String maker;
   private int cc;
   private int capacity;

   Car5(){

   }

   Car5(String model,String maker, int cc, int capacity){
     this.setModel( model);
     this.setMaker (maker);
     this.setCC (cc);
     this.setCapacity(capacity);
   }

   public String setModel(String model) {
      return this.model = model;
   }

   public String setMaker(String maker) {
     return this.maker = maker;
   }

   public int setCC(int cc) {

     if(cc >= 0 && cc <10000) {
        return this.cc =cc;
      }
      return this.cc;
   }
   public int setCapacity(int capacity) {

     if( capacity >= 0 && capacity < 100 ) {
        this.capacity = capacity;
     }
     return this.capacity;
   }


   public String getModel() {
     return this.model ;
   }

   public String getMaker() {
     return this.maker ;
   }

   public int getCC() {


      return  this.cc ;

   }
   public int getCapacity() {


    return   this. capacity ;

   }

}
