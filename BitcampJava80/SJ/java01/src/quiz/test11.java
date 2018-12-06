package quiz;

//출처: codefights.com
//한 줄에 버그가 있다. 고쳐라!
/*
Given a string, find the number of different characters in it.

for "cabca" output should be 3

[input] string s

a string of lowercase latin letters
[output] integer
 */
public class test11 {
  static int differentSymbolsNaive(String s) {

    int result = 0;
    boolean found = false;
    for (int i = 0; i <= 26; i++) {
    //for (int i = 1; i <= 26; i++) {
      found = false;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == 'a' + i) {
          found = true;
          break;
        }
      }
      if (found) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(differentSymbolsNaive("cabcaaadbf"));

  }

}
