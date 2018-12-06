package bitcamp.pms.domain;

public class Member{

  String name;
  String email;
  String password;
  String tel;

  public Member() {

  }
  public Member(String n,String e, String p, String t  ) {
    name =n;
    email = e;
    password=p;
    tel = t;
  }

  @Override
  public String toString() {
    return name + "," + email + "," +password + "," +tel;
  }

  public void setName(String n) {
    name = n;
  }
  public void setEmail(String n) {
    email = n;
  }
  public void setPassword(String n) {
    password = n;
  }
  public void setTel(String n) {
    tel = n;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
  public String getPassword() {
    return password;
  }
  public String getTel() {
    return tel;
  }




}
