public class palindrome {

  public static void main(String[] args) {

    String s  = "abb";
    String[] n = new String[s. length()];
    int i = 0 , l = s. length();

     while(  i < l   ) {
       n[i]=s.substring(i++,i);
     }
     for( i = 0; i < l / 2 ; ){
       if(!n[i].equals(n[l - ++i]));
       return "No";
        // System.out.println("no");
     }
     return "yes";
    //  System.out.println("Yes");





  }
}
