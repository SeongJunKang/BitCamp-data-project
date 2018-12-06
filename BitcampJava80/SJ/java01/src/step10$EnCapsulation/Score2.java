package step10$EnCapsulation;

public class Score2 {

  //패키지 직속 클래스는 static 을 붙이지 않는다.
      private String name ;
      // 점수를 저장할 변수에 대해 접근 레벨을 조정.
      // 외부 접근에 대해 격리 레벨을 높인다.
      // name 은 직접 접근해도 실행에 문제가 없지만
      // 일관성 있는 접근 레벨 제어를 위해 다른 변수와 접근 레벨을 맞춘다.


      private int kor;
      private int eng;
      private int math;
      private int sum;
      private float avr;

      Score2(String name, int kor, int eng, int math){
        this.setName(name);
        this.setKor(kor);
        this.setEng(eng);
        this.setMath(math);
        
      }
      void summ() {//국영수 합계를 계산하는 연산하
        this.sum = this.kor+ this.eng + this.math;
        this.aver();
      }
      void aver() {
        this.avr = this.sum / 3f;
      }

      String getName() {
        return this.name;
      }

      int getKor() {
        return this.kor;
      }

      int getEng() {
        return this.eng;
      }

      int getMath() {
        return this.math;
      }

      int getSum() {
        return this.sum;
      }

      float getAver() {
        return this.avr;
      }


      void setName(String str) {
        this.name = str;
      }

      void setKor(int value) {
        if(value >= 0 && value<= 100) {
          this.kor = value;
          this.summ();
        }
      }

      void setEng(int value) {
        if(value >= 0 && value<= 100) {
          this.eng = value;
          this.summ();
        }
      }

      void setMath(int value) {
        if(value >= 0 && value<= 100) {
          this.math = value;
          this.summ();
        }
      }


}
