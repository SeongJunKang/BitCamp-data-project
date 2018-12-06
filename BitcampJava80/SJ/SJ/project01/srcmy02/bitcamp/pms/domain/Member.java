package bitcamp.pms.domain;


public class Member {

  // private String name ;
  // private String email ;
  // private String password ;
  // private String tel ;

  protected String name ;
  protected String email ;
  protected String password ;
  protected String tel ;

  public Member() {}

  public Member(String name , String email , String password, String tel) {
    this.setName(name);
    this.setEmail(email);
    this.setPassword(password);
    this.setTel(tel);
  }

  public void setName(String name) {
    this.name = name ;
  }
  public String getName() {
    return this.name;
  }

  public void setEmail(String email) {
    this.email = email ;
  }
  public String getEmail() {
    return this.email;
  }

  public void setPassword(String password) {
    this.password = password ;
  }
  public String getPassword() {
    return this.password;
  }

  public void setTel(String tel) {
    this.tel = tel ;
  }
  public String getTel() {
    return this.tel;
  }

  @Override
  public String toString() {
    return this.name + ", \t" + this.email + ", \t" +
    this.password + ", \t" + this.tel ;
  }


}
