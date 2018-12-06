package step12$StaticInstance;

public class board {

  static int cnt;

  private int No;
  private String Title;
  private String Contents;
  private String Name;
  private int Count;
  private long Date;


  {
    this.No = ++board.cnt;
  }

  board(){

  }

  board( String name, String title, String contents) {
    this.setTitle(title);
    this.setName(name);
    this.setContents(contents);
    this.setDate (System.currentTimeMillis());

  }

  public void setNo(int no) {
    this.No = no;
  }

  public void setTitle(String title) {
    this.Title = title;
  }


  public void setName(String name) {
    this.Name = name;
  }

  public void setContents(String contents) {
      this.Contents = contents;
   }

   public void setDate(long date) {
       this.Date = date;
    }

   public int getNo() {
    return this.No ;
   }

  public String getTitle() {
   return this.Title ;
  }

  public String getCotents() {
   return this.Contents ;
  }

  public String getName() {
   return this.Name ;
  }

  public int getCount() {
   return this.Count;
   }

  public long getDate() {
   return this.Date ;
  }


}
