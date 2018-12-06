//문제 1 입력받은 두 수중 더 큰수를 출력하세요.
// 34 78


package step13$WrapperAutoBoxingDate;

public class Quiz01 {
  public static void main(String[] args){

    int[] minmax = new int[args.length];
    for(int i = 0 ; i < args.length ;) {
      minmax[i] = Integer.parseInt(args[i++]);
    }

    for(int i = 0,tmp ; i < args.length -1 ; ) {
      if(minmax[i] < minmax[i+1] ){
          tmp = minmax[i];
          minmax[i]= minmax[i+1];
          minmax[++i]=tmp;
        }
    }
    System.out.println(minmax[0]);
  }
}
