/*주제 : 반복문 for(:)*/
package step05$ifswitchforwhile;

public class Exam14{

  public static void main(String[] args){
    int[] scores =new int[]{100,60,70,0};

    //배열을 좀 더 쉽게 다루기 위해 등장한 for 문법
    // for(배열 항목을 저장할 변수 : 배열 또는 collection 물건 ){...}
    int index=0;
    for (int value : scores){
        scores[3]+=value;
        if(++index==3)
          break;
    }
    System.out.println(scores[3]);
    //특징 : 배열 갯수만큼 자동으로 반복 한다.
    // 중간에 멈추고 싶으면 별도의 코드를 작성해야한다.
  }
}
