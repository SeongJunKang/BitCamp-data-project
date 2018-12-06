package step12$StaticInstance;

public class Book {

  private String bookNo;
  private String bookTitle;
  private String[] writer = new String[10];
  private String isbn;
  private String publish;
  private int page;
  private int cost;
  private String intro;

  Book(){

  }

  Book(String no,String title,String[] writer,String isbn,String publish,int page, int cost, String intro) {

    this.setBookNo(no);
    this.setBookTitle(title);
    this.setWriter(writer);
    this.setISBN(isbn);
    this.setPublish(publish);
    this.setPage(page);
    this.setCost(cost);
    this.setIntro(intro);

  }

  public String getBookNo() {
    return this.bookNo;
  }
  public void setBookNo(String bookno) {
    this.bookNo = bookno;
  }

  public String getBookTitle() {
    return this.bookTitle;
  }
  public void setBookTitle(String title) {
    this.bookTitle = title;
  }

  public String[] getWriter() {
    return this.writer;
  }
  public void setWriter(String[] writer) {
    this.writer = writer;
  }

  public String getISBN() {
    return this.isbn;
  }
  public void setISBN(String isbn) {
    this.isbn = isbn;
  }

  public String getPublish() {
    return this.publish;
  }
  public void setPublish(String publish) {
    this.publish = publish;
  }

  public String getIntro() {
    return this.intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }

  public int getPage() {
    return this.page;
  }
  public void setPage( int page) {
    this.page = page;
  }

  public int getCost() {
    return this.cost;
  }
  public void setCost( int cost) {
    this.cost = cost;
  }

}
