package quiz;

// 출처: codefights.com
//
// 숫자 배열에서 각 이웃하는 숫자간의 차가 가장 큰 것을 알아내기
// 예)
// [2, 4, 1, 0] => 3
//
// 한 줄에 버그가 있다. 고쳐라!

public class test02 {

  public static void main(String[] args) {


    int[] value = new int[]{2,4,1,0};
    int answer = 0;
    for ( int i = 0; i< value.length - 1 ; i++) {
      //if((value[i] - value[i + 1]) > answer) {
      if( Math.abs(value[i] - value[i + 1]) > answer) {
        answer = Math.abs(value[i] - value[i + 1]);
      }
    }
    System.out.println(answer);

/*
    int[] values = new int[]{2,4,1,0};
    int answer =0;
    for( int i = 0 ; i < values.length - 1 ; i ++) {
        if( Math.abs(values[i] - values[i+1] > answer)) {
          answer = Math.abs(values[i]-values[i+1]);
        }
    }
    System.out.print(answer);
    */
  }

}
