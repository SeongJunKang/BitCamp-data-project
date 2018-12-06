// 주제 : class 로 사용자 정의타입 만들기


public class removenum {


  public static void main(String[] args) {

    String s = "36936912345";// 12457812145 -> 4578121
    String [] n = new String[s.length()];
    int x=0,y=0,i=0;
    for(i = s.length() -1 ; i >= 0 ; i --)
    {
      n[i]=s.substring(s.length()-i-1,s.length()-i);
      n[i] = (Integer.parseInt(n[i]) % 3 == 0) ? "": n[i];
    }

    String D="";
    for (i = s.length()-1 ; i >= 0  ; i-- ) {
      D+=n[i];
    }

    String[] k = new String[D.length()];
    for(i = D.length() -1 ; i >= 0 ; i --) {
      k[i]=D.substring(D.length()-i-1,D.length()-i);
    }

    for(i = 0 ; i < D.length()/2 ; i++) {
      if((Integer.parseInt(k[i])+Integer.parseInt(k[D.length()-i-1])) % 3 == 0) {
      k[i]="";
      k[D.length()-i-1]="";
      }
    }

    n[0]="";
    for (i = D.length()-1 ; i >= 0  ; i-- ) {
      n[0]+=k[i];
    }

    System.out.println(n[0]);
  }
}
