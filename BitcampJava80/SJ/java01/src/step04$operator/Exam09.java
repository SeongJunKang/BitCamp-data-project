/* 주제: 전위 증가/감소 연산자 */
package step04$operator;

public class Exam09 {
  public static void main(String[] args) {

    int i=10;
    i= i+1;
    i+=1;
    ++i;//prefix 연산자

    int j =10;
    j = j-1;
    j-=1;
    --j;

    System.out.println(i);
    System.out.println(j);
    i=10;
    j=10;
    System.out.println(++i);
    System.out.println(++j);
  }
}
