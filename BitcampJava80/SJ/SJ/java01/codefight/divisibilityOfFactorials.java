public class divisibilityOfFactorials {

  public static void main(String[] args) {
        //
        ///2.3.4.5.3.7.4.6.5.11.4.13.7.5.6.17.6.19.5.7.11.23.4
        int Sn=10;
        int sn=2;
        int Fn=0;
        int x=0;
        for( ; sn <= Sn  ; sn++) {
          x=sn;
          for( long i = 2, tmp=1; i <= sn ; i++ ) {

            tmp *= i;

            if( tmp % sn == 0 ) {
              System.out.print(i+ " ");
              Fn+=i;
              break;
            }
          }
        }
        System.out.print("\n");
        System.out.println(Fn);
  }
}
