package bitcamp.pms.domain;

public class Member{

  String  name;
  String  email;
  String  password;
  String  tel;

  public Member(){}

  public Member(String n,String e, String p, String t) {
    name = n;
    email = e ;
    password = p;
    tel = t;
  }

  public String toString(){
    return name +","+email+","+password+","+tel;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public void setTel(String tel) {
    this.tel = tel;
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
