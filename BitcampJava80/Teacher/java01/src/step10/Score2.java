/* Score 클래스에 setter를 추가한다.*/

package step10;

class Score2 {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  Score2(String name, int kor, int eng, int math) {
    this.name = name;
    //this.kor = kor;
    //this.eng = eng;
    //this.math = math;
    //this.summary();

    this.setKor(kor);
    this.setEng(eng);
    this.setMath(math);
  }

  void summary() {
    this.sum = this.kor + this.eng + this.math;
    this.average();
  }

  void average() {
    this.aver = this.sum / 3f;
  }

  // 겟터 연산자(메서드) --> 값을 꺼내주는 연산자
  // 셋터 연산자도 추가한다. --> 값을 저장할 때 사용하는 연산자
  String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

  int getKor() {
    return this.kor;
  }

  void setKor(int kor) {
    if (kor >= 0 && kor <= 100) {
      this.kor = kor;
      this.summary();
    }
  }

  int getEng() {
    return this.eng;
  }

  void setEng(int eng) {
    if (eng >= 0 && eng <= 100) {
      this.eng = eng;
      this.summary();
    }
  }

  int getMath() {
    return this.math;
  }

  void setMath(int math) {
    if (math >= 0 && math <= 100) {
      this.math = math;
      this.summary();
    }
  }

  int getSummary() {
    return this.sum;
  }

  float getAverage() {
    return this.aver;
  }

}
