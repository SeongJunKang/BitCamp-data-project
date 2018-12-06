/*
회원 데이터를 다룰 사용자 정의 데이터 타입 선언하라!
회원번호, 이름, 아이디, 암호, 전화, 이메일
*/
package step12;

public class Member {
  private int no;
  private String name;
  private String id;
  private String password;
  private String tel;
  private String email;

  public Member() {}

  public Member(String id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public int getNo() { return no; }
  public void setNo(int no) { this.no = no; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  public String getTel() { return tel; }
  public void setTel(String tel) { this.tel = tel; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

}
