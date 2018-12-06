package bitcamp.pms.domain;
import java.sql.Date;

public class Project {

  protected String title;
  protected Date startDate;
  protected Date endDate;
  protected String description;
  protected int state;


  public Project() {}

  public Project(String title, Date startDate, Date endDate) {
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getStartDate() {
    return this.startDate.toString();
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public String getEndDate() {
    return this.endDate.toString();
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public String getDescription() {
    return this.description ;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public int getState() {
    return this.state;
  }

  public void setState(int state) {
    this.state = state;
  }
  @Override
  public String toString() {
    return this.title + "," + this.startDate + "," +
            this.endDate + "," +this.description +","+this.state;
  }


}
