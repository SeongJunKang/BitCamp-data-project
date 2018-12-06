package step14$SpecialGeneral.exam03;
//Generalization 의 예
// Sedan 과 Truck 의 공통점을 찾아서 일반적인 기능을 갖는 수퍼 클래스를 정의한다.
//



// public class Sedan {
public class Sedan extends Car{

/* Car 클래스로 옮김
  String title;     //모델명
  String company;   //제조사명
  int cc;           //CC
  int maxcount;        //수용인원
*/
  boolean isSunroof;
  boolean isAutomatic;


}
