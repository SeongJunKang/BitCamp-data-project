// 주제 : class 로 사용자 정의타입 만들기


public class ClosedBracketWord {

  public static void main(String[] args) {

    String w = "strabzs"
    int l = w.length(), i = 0;
    while(i < l / 2)
      if( 97 - w.charAt(++i) != w.charAt(l - i) - 'z' || l % 2 == 1 )
        System.out.println(1==0);
    //     return 1 == 0;
    // return true;
    System.out.println(1==1);
  }
}
