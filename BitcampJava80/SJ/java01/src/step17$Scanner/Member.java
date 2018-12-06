package step17$Scanner;

public class Member {

  private String name;
  private String email;
  private String password;
  private String tel;

  Member(){}

  Member(String name, String email, String password, String tel) {
    this.setName(name);
    this.setEmail(email);
    this.setPassword(password);
    this.setTel(tel);
  }

  public void Printmember() {
    System.out.print(this.getName() + "\t" +this.getEmail() + "\t" +this.getPassword() + "\t" +this.getTel() +"\n");

  }

  public void setName(String name) {
      this.name = name ;
  }
  public void setEmail(String email) {
      this.email = email ;
  }
  public void setPassword(String password) {
      this.password = password ;
  }
  public void setTel(String tel) {
      this.tel = tel ;
  }

  public String getName() {
    return this.name;
  }
  public String getEmail() {
    return this.email;
  }
  public String getPassword() {
    return this.password;
  }
  public String getTel() {
    return this.tel;
  }


}
