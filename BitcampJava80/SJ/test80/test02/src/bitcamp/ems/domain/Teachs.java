package bitcamp.ems.domain;

public class Teachs {
  private int tno;
  private String tnm;
  private String tel;
  private String email;
  private String phot;
  
  
  
  
  public Teachs() {
  }
  public Teachs(int tno, String tnm, String tel, String email, String phot) {
    this.tno = tno;
    this.tnm = tnm;
    this.tel = tel;
    this.email = email;
    this.phot = phot;
  }
  @Override
  public String toString() {
    return "Teachs [tno=" + tno + ", tnm=" + tnm + ", tel=" + tel + ", email=" + email + ", phot=" + phot + "]";
  }
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  public String getTnm() {
    return tnm;
  }
  public void setTnm(String tnm) {
    this.tnm = tnm;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhot() {
    return phot;
  }
  public void setPhot(String phot) {
    this.phot = phot;
  }
  
  

}
