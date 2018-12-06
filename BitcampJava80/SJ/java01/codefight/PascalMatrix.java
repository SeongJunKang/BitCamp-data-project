

public class PascalMatrix {

  int[][] pascalMatrix(int n) {

    int[][] m = new int[1 + n / 2][n];

    for(int i = 0,j ; i < 1 + n / 2 ; i ++) {
        for(j = 0 ; j < n ; j ++)
          if( i + j == n/2 || j - i == n/2)
              m[i][j] = 1;
        if(i > 1)
         for( j = 2; j < n - 2 ;)
              m[i][j] = m[i - 1][j - 1] + m[i - 1][++j];

    }
    return m;
}


  public static void main(String[] args) {
/*
    for(int i = 0 ; i < pascal.length ; i ++) {
      for ( int j = 0  ; j < pascal[0].length ; j++ ) {
          System.out.print(pascal[i][j]);
      }
      System.out.print("\n");
    }
*/

  }
}
