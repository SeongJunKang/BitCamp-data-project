package step09$Contructor;

public class Quiz {

  static int testFraction(int[] n, int[] d){

    int in=0;
    for ( int i =0; i < n.length ; i ++ ) {
      if(n[i]*d[in]>n[in]*d[i])
        in=i;
    }

    return in;
  }

  public static void main (String[] args) {

    int index = testFraction(new int[]{5,2,5}, new int[]{6,3,4});

    System.out.println(index);

  }

}
