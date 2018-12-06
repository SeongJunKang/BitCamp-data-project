package bitcamp.pms0.domain;
import java.sql.Date;
public class Project {
  protected String title;
  protected Date startDate;
  protected Date endDate;
  protected String description;
  protected int state;

  Project() {}

  Project(String title, Date start, Date end) {
    this.title = title;
    startDate = start;
    endDate = end;
  }

  public String getTitle(){
    return title;
  }
  public void setTitle(String title){
    this.title =title;
  }

  public Date getStartDate(){
    return startDate;
  }
  public void setStartDate(Date start){
    startDate = start;
  }

  public Date getEndDate(){
    return endDate;
  }
  public void setEndDate(Date endDate){
    this.endDate = endDate;
  }

  public String getDescription(){
    return description;
  }
  public void setDescription(String description){
    this.description = description;
  }

  public int getState(){
    return state;
  }
  public void setState(int state){
    this.state = state;
  }
  @Override
  public void toString() {
    return title+","+startDate+","+endDate+","+description+","+state;
  }
}
