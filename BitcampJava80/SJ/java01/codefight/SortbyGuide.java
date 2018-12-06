public class testfight {

  public static void main(String[] args) {

    int[] a     = new int[] {27,67,80,38,21};
    int[] guide = new int[] {2,5,3,1,4} ;
    int[] arr = new int[a.length];
    int cnt = 0,i,j ;

      for( j = 0; j < a.length ; j++) {
        if(guide[j] == -1 ) {
          arr[j] = a[j];
          cnt++;
        }
    }
    int[] tmp = new int[a.length - cnt/a.length];
    for( i = 0 ; i< a.length+1 ; i ++) {
      for( j = 0; j < a.length ; j++) {
        if(guide[j] == i ) {
          tmp[ i - 1 ] = a[j];
        }
      }
    }
    for( i = 0 ; i < a.length ;  i++) {
      for( j = 0; j < a.length ; j++) {
        if(arr[j] == 0) {
          arr[j]=tmp[i];
          break;
        }
      }
    }

    for( i = 0 ; i < a.length ;  i++)
      System.out.print(arr[i] + "  ");
    System.out.print("\n");

    for( i = 0 ; i < tmp.length ;  i++)
      System.out.print(tmp[i] + "  ");
    System.out.print("\n");
  }
}
