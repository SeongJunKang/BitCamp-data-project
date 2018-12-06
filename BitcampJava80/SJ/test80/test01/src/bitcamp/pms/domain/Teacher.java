package bitcamp.pms.domain;

public class Teacher {
  protected int tno;
  protected String clas;
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  public String getClas() {
    return clas;
  }
  @Override
  public String toString() {
    return "Teacher [tno=" + tno + ", clas=" + clas + "]";
  }
  public Teacher() {
  }
  public Teacher(int tno, String clas) {
    super();
    this.tno = tno;
    this.clas = clas;
  }
  public void setClas(String clas) {
    this.clas = clas;
  }


}
