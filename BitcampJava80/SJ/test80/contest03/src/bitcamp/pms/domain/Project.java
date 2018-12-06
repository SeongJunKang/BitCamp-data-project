package bitcamp.pms.domain;

import java.sql.Date;
public class Project{

      String title;
      Date startDate;
      Date endDate;
      String description;
      int state;

      public Project() {

      }
      public Project(String n,Date e, Date p) {
        title =n;
        startDate = e;
        endDate=p;
      }

      @Override
      public String toString() {
        return title + "," + startDate + "," +endDate + "," +description+","+state;
      }

      public void setTitle(String n) {
        title = n;
      }
      public void setStartDate(Date n) {
        startDate = n;
      }
      public void setEndDate(Date n) {
        endDate = n;
      }
      public void setDescription(String n) {
        description = n;
      }

      public void setState(int n) {
        state = n;
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
      public String getDescription() {
        return description;
      }

      public int getState() {
        return state;
      }





}
