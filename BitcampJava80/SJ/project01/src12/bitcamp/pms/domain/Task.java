package bitcamp.pms.domain;


public class Task {

  private String title ;
  private String description ;
  private int memberno;
  private int projectno;
  private int state;

  Task() {}

  Task(String title , String description){// , int memberno ,int projectno, int state) {
    this.title = title;
    this.description = description;
    // this.memberno = memberno;
    // this.projectno = projectno;
    // this.state = state;
  }

  public void setTitle(String title){
    this.title = title;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public void setProjectno(int projectno) {
    this.projectno = projectno;
  }
  public void setState(int state) {
    this.state = state;
  }

  public String getTitle() {
    return this.title;
  }
  public String getDescription() {
    return this.description;
  }
  public int getMemberno() {
    return this.memberno;
  }
  public int getProjectno() {
    return this.projectno;
  }
  public int getState() {
    return this.state;
  }


}



// 6) 프로젝트의 작업 정보를 다루는 클래스를 추가한다.
//   => bitcamp.pms.domain.Task 클래스 추가
//     - title:String
//     - description:String
//     - memberNo:int
//     - projectNo:int
//     - state:int
//   => bitcamp.pms.controller.TaskController 클래스 추가
//   => "go task" 명령을 처리할 수 있도록 ProjectApp 클래스를 변경
