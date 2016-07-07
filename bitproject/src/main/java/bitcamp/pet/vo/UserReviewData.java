package bitcamp.pet.vo;

import java.sql.Timestamp;

public class UserReviewData {
  Timestamp cdt;
  int mno;
  String name;
  String content;
  String prof;
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public Timestamp getCdt() {
    return cdt;
  }
  public void setCdt(Timestamp cdt) {
    this.cdt = cdt;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getProf() {
    return prof;
  }
  public void setProf(String prof) {
    this.prof = prof;
  }
  
}
