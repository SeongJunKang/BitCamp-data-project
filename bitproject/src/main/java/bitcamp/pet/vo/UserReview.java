package bitcamp.pet.vo;

import java.sql.Timestamp;

public class UserReview {
  int mbno;
  int pno;
  int mno;
  String content;
  Timestamp cdt;
  public int getMbno() {
    return mbno;
  }
  public void setMbno(int mbno) {
    this.mbno = mbno;
  }
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Timestamp getCdt() {
    return cdt;
  }
  public void setCdt(Timestamp cdt) {
    this.cdt = cdt;
  }
  
}
