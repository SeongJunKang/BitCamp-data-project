package step12$StaticInstance;

public class Member {

  static int count;

  private int No;
  private String Name;
  private String Id;
  private String Password;
  private String PhoneNumber;
  private String E_mail ;

  {
    this.No = ++Member.count;
  }

  Member(){

  }

  Member(String name, String id, String password, String phonenumber, String e_mail) {
    this.setName(name);
    this.setId(id);
    this.setPassword(password);
    this.setPhoneNumber(phonenumber);
    this.setEmail(e_mail);

  }

  public int getNo(){
    return this.No;
  }
  public void setNo(int no){
    this.No = no;
  }
  public String getName(){
    return this.Name;
  }
  public void setName(String name) {
    this.Name = name;
  }
  public String getId(){
    return this.Id;
  }
  public void setId(String id) {
    this.Id = id;
  }
  public String getPassword(){
    return this.Password;
  }
  public void setPassword(String password) {
     this.Password = password;
  }
  public String getPhoneNumber(){
    return this.PhoneNumber;
  }
  public void setPhoneNumber(String phonenumber) {
  this.PhoneNumber = phonenumber;
  }
  public String getEMail(){
    return this.E_mail;
  }
  public void setEmail(String email) {
    this.E_mail = email;
  }

}
