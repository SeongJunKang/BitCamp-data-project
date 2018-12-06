package bitcamp.pms.domain;

public class Member {
  protected int memd;
  protected int auth;
  protected String nm;
  protected String addre;
  protected String tel;
  protected String photo;
  protected String email;
  protected String pwd;
  
  public Member() {}

  public int getMemd() {
    return memd;
  }

  public void setMemd(int memd) {
    this.memd = memd;
  }

  public int getAuth() {
    return auth;
  }

  public void setAuth(int auth) {
    this.auth = auth;
  }

  public String getNm() {
    return nm;
  }

  public void setNm(String nm) {
    this.nm = nm;
  }

  public String getAddre() {
    return addre;
  }

  public void setAddre(String addre) {
    this.addre = addre;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }



}
