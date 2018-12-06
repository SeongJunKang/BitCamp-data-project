//문제 3 주어진 수의 약수를 모두 출력
// 72

package step13$WrapperAutoBoxingDate;

public class Quiz03 {
  public static void main(String[] args){


    int primal = Integer.parseInt(args[0]);
    for(int i = 1 ; i <= primal ; i++){
      if(primal % i == 0)
        System.out.print(i+ " ");
    }
        System.out.print("\n");
  }
}
