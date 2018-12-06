public class jegob {

  public static void main(String[] args) {

        int R=3;
        int N=256;

        int i = 0 , j , m[][] = new int[--R][2];

        while(i < R) {
           for( j = 1 ; Math.pow(j , i + 2) <= N ; j++){
             System.out.println(Math.pow(j , i + 2));
           }

           m[i][0] = i + 2;
           m[i++][1] = j - 1 ;
        }

        for( i = 0 ; i < R ; i++)
        System.out.println(m[i][0]+ " : " + m[i][1]);



  }
}
