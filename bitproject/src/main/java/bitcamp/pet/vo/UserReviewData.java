package bitcamp.pet.vo;

import java.util.Date;

public class UserReviewData {
  Date cdt;
  String name;
  String content;
  String prof;
  public Date getCdt() {
    return cdt;
  }
  public void setCdt(Date cdt) {
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
