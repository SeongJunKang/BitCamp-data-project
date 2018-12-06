
public class testfight {
  
  static int Count4s(int n) {
    int m = 4 , cnt = 0,i;
    while( m <= n - 1) {
        m += 4 ;
        for(i = 0 ; i < Integer.toString(m).length() ; i++ )
            if (Integer.toString(m).charAt(i) == '4') cnt++;
    }
    return cnt;
  }
<>
  public static void main(String[] args) {


    System.out.println(Count4s(14));
  }
}
