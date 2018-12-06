// Score4 의  접근 레벨을 public 으로 공개한다.

package step11$OverLoading;

public class Score {


      private String name ;
      private int kor;
      private int eng;
      private int math;
      private int sum;
      private float avr;

      //기존의 생성자의 다음 디폴트 생성자를 추가한다.
      // -> 오버로딩
      public Score(){}

      public Score(String name, int kor, int eng, int math) {
        this.setName(name);
        this.setKor(kor);
        this.setEng(eng);
        this.setMath(math);

      }
    private void summ() {
        this.sum = this.kor+ this.eng + this.math;
        this.aver();
      }
      private void aver() {
        this.avr = this.sum / 3f;
      }

      public String getName() {
        return this.name;
      }

      public int getKor() {
        return this.kor;
      }

      public int getEng() {
        return this.eng;
      }

      public int getMath() {
        return this.math;
      }

      public int getSum() {
        return this.sum;
      }

      public float getAver() {
        return this.avr;
      }


      public void setName(String str) {
        this.name = str;
      }

      public void setKor(int value) {
        if(value >= 0 && value<= 100) {
          this.kor = value;
          this.summ();
        }
      }

      public void setEng(int value) {
        if(value >= 0 && value<= 100) {
          this.eng = value;
          this.summ();
        }
      }

      public void setMath(int value) {
        if(value >= 0 && value<= 100) {
          this.math = value;
          this.summ();
        }
      }
}
