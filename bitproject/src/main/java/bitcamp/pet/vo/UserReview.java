package bitcamp.pet.vo;

import java.util.Date;

public class UserReview {
  int mbno;
  int pno;
  int mno;
  String content;
  Date cdt;
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
  public Date getCdt() {
    return cdt;
  }
  public void setCdt(Date cdt) {
    this.cdt = cdt;
  }
  
}
