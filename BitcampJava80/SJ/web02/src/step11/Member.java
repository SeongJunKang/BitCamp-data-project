package step11;

public class Member {

  private int no;
  private String name;
  private String id;
  private String email;
  private String password;
  private String tel;
  
  public Member(int no, String name, String id, String email, String password, String tel) {
    this.no = no;
    this.name = name;
    this.id = id;
    this.email = email;
    this.password = password;
    this.tel = tel;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
}
