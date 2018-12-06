package bitcamp.pms.domain;

import java.sql.Date;


public class Project{

  String  title;
  Date startDate;
  Date endDate;
  String  descript;
  int state;

  public Project(){}

  public Project(String n, Date start, Date end) {
    title = n;
    startDate =start;
    endDate = end;

  }

  public String toString(){
    return title +","+startDate+","+endDate+","+state+","+descript;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public void setDescript(String descript) {
    this.descript = descript;
  }
  public void setState(int state) {
    this.state = state;
  }

  public String getTitle() {
    return title;
  }
  public Date getStartDate() {
    return startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public String getDescript() {
    return descript;
  }
  public int getState() {
    return state;
  }



}
