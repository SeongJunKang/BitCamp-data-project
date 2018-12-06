

public class PascalMatrixSol {
  public static void main(String[] args) {
        int n =11;
        int j=0,m=-~n/2,r[][] = new int [m][n];
        for(;m-- > 0;j=0)
            for(long s =1;j<=m;s = (m-j)*s/++j)
                r[m][n/2-m+2*j]=(int)s;




  }

}
