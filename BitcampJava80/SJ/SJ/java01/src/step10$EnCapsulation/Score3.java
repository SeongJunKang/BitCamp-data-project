// Score2 의 메소드 접근 레벨을 조정한다.
package step10$EnCapsulation;

public class Score3 {

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

      // Score3 클래스를 오로지 step10 패키지에서만 사용할 것이라면 -> (default)
      // 다른 패키지에서도 사용할 수 있게 하려면 -> public
      public Score3(String name, int kor, int eng, int math){
        this.setName(name);
        this.setKor(kor);
        this.setEng(eng);
        this.setMath(math);
        this.summ();
      }

      // summ() 과 aver()는 점수값을 설정할 때만 호출하기 때문에
      // 굳이 외부로 공개할 필요가 없다.
      // -> 같은 패키지 클래스에게도 공개할 필요가 없다.
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
