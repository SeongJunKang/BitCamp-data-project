package step05$ifswitchforwhile;

public class Exam01{

  public static void main(String[] args){
    int a= 10;
    {
      //int a=20; //오류 메서드 블록 안에서 변수를 이중으로 선언할 수 없다
      a= 20; // 안쪽에서 바깥족 변수를 사용할수 있다.
      int b=30;
    }

    a=30;
    //b=40 ;// 그 블록안에서 선언된 변수는 삭제된다.
  }
}
