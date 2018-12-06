package bitcamp.pms.domain;

import java.sql.Date;

public class Project {
  
  String title;
  Date startDate;
  Date endDate; 
  String description;
  int state;
  
  
  public Project(){}
  
  
  
  @Override
  public String toString() {
    return title + "," + startDate + "," + endDate + "," + description + "," + state;
  }



  public Project(String title, Date startDate, Date endDate) {
    super();
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;

  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public int getState() {
    return state;
  }
  public void setState(int state) {
    this.state = state;
  }
  
  
}
