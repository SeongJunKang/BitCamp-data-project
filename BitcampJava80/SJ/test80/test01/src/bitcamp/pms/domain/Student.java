package bitcamp.pms.domain;

public class Student {
  protected int sno;
  protected String cour;
  protected String grd;
  protected String work;
  protected String cnt;
  public Student() {
  }
  public Student(int sno, String cour, String grd, String work, String cnt) {
    super();
    this.sno = sno;
    this.cour = cour;
    this.grd = grd;
    this.work = work;
    this.cnt = cnt;
  }
  @Override
  public String toString() {
    return "Student [sno=" + sno + ", cour=" + cour + ", grd=" + grd + ", work=" + work + ", cnt=" + cnt + "]";
  }
  public int getSno() {
    return sno;
  }
  public void setSno(int sno) {
    this.sno = sno;
  }
  public String getCour() {
    return cour;
  }
  public void setCour(String cour) {
    this.cour = cour;
  }
  public String getGrd() {
    return grd;
  }

  public void setGrd(String grd) {
    this.grd = grd;
  }
  public String getWork() {
    return work;
  }
  public void setWork(String work) {
    this.work = work;
  }
  public String getCnt() {
    return cnt;
  }
  public void setCnt(String cnt) {
    this.cnt = cnt;
  }

  



}
