import java.util.Arrays;
public class replaceWord {
  public static void main(String[] args) {

        String sentence = "Disentangle correctly could no one";
        String tmp="",str[] = sentence.split(" ");
        int l[] = new int[str.length] ;

        for(int i = 0 ;  i < str.length; i ++) {
          l[i] = str[i].length();
        }
        Arrays.sort(l);

        for(int i = 0 ; i< l.length / 2 ; i++) {
          oh :{
            for(int j = 0 ; j < l.length ; j++) {
              for(int k = 0 ; k < l.length ; k++) {
                 if(str[j].length() == l[i] && str[k].length() == l[str.length - i -1]) {
                  tmp = str[j];
                  str[j] = str[k];
                  str[k] = tmp;
                    break oh;
                }
              }
            }
          }
        }
      for(int i = 0 ;  i < str.length; i ++)
        if(! str[i].equals("I"))
          str[i]=str[i].toLowerCase();

       tmp = str[0].substring(0,1).toUpperCase().concat( str[0].substring(1));

      for(int i = 1 ;  i < str.length; i ++)
        tmp+=" "+str[i];
      System.out.println(tmp);

  }
}
