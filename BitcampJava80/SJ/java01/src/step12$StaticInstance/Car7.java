package step12$StaticInstance;

public class Car7{

  // 모든 인스턴스가 공유하는 데이터는 스태틱 변수에 보과
  // 자동차 마다 개별정보를 저장할 변수
  static int count;
   private int no;
   private String model;
   private String maker;
   private int cc;
   private int capacity;

   {

       // 인스턴스 블록/ 메서드에서는 this 생략 가능.
       //자기가 속해있는 클래스의 스태틱 변수나 메서드를 호출할때
       // 클래스 이름을 생략할 수 있다.
     no = ++count;   // 가능한 스태틱 변수의 클래스명을 생략하지말라.
   }

   Car7(){

   }

   Car7(int no,String model,String maker, int cc, int capacity){
     //인스턴스 블록/ 메서드에서 다른 인스턴스 메서드를 호출할 때
     // this 를 생략할 수 있다.
     // 생략하면 컴파일할 때 컴파일러가 자동으로 붙인다.
     setModel( model);
     setMaker (maker);
     setCC (cc);
     setCapacity(capacity);
   }
   // set 의 경우는 생략 할 수 없다.
   // 로컬변수와 인스턴스 변수의 이름과 같기 떄문에
   // this 를 빼면 둘을 구분할 수 없다.
   public String setModel(String model) {
      return this.model = model;
   }

   public String setMaker(String maker) {
     return this.maker = maker;
   }

   public int setCC(int cc) {

     if(cc >= 0 && cc <10000) {
         this.cc =cc;
      }
      return this.cc ;
   }
   public int setCapacity(int capacity) {

     if( capacity >= 0 && capacity < 100 ) {
        this.capacity = capacity;
     }
     return this.capacity ;
   }

   public int getNo() {
      return no ;
   }

   public String getModel() {
     return model ;
   }

   public String getMaker() {
     return maker ;
   }

   public int getCC() {
      return  cc ;
   }
   public int getCapacity() {
    return  capacity ;
   }

}
