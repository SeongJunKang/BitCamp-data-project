package step12$StaticInstance;

public class Car6{

  // 모든 인스턴스가 공유하는 데이터는 스태틱 변수에 보과
  // 자동차 마다 개별정보를 저장할 변수
  static int count;
   private int no;
   private String model;
   private String maker;
   private int cc;
   private int capacity;

   {

     this.no = ++Car6.count;;
   }

   Car6(){

   }

   Car6(int no,String model,String maker, int cc, int capacity){
    //  this.setNo( no);
     this.setModel( model);
     this.setMaker (maker);
     this.setCC (cc);
     this.setCapacity(capacity);
   }

  //  public String setNo(int no) {
  //     return this.no = no;
  //  }


  public void setModel(String model) {
       this.model = model;
   }

   public void setMaker(String maker) {
      this.maker = maker;
   }

   public void setCC(int cc) {

     if(cc >= 0 && cc <10000) {
         this.cc =cc;
      }

   }
   public void setCapacity(int capacity) {

     if( capacity >= 0 && capacity < 100 ) {
        this.capacity = capacity;
     }

   }

   public int getNo() {
      return this.no ;
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
