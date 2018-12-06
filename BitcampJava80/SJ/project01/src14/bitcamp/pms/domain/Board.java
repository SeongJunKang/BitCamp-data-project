package bitcamp.pms.domain;

import java.sql.Date;

public class Board {

    private String title;
    private String content;
    private int view = 0;
    private String password;
    private Date createdDate;
    
    public Board() {}

    
    public String toCSV() {
      return String.format("%s,%s,%d,%s,%s", this.title, 
          this.content, this.view, this.password, this.createdDate.toString());
    }
    
    @Override
    public String toString() {
      return title + ","+ view + ","+ createdDate;
    }
    
    public String getTitle() {
      return title;
    }
    public void setTitle(String title) {
      this.title = title;
    }
    public String getContent() {
      return content;
    }
    public void setContent(String content) {
      this.content = content;
    }
    public int getView() {
      return view;
    }
    public void setView(int view) {
      this.view = view;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
    public Date getCreatedDate() {
      return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
    }
  
    
    
}
