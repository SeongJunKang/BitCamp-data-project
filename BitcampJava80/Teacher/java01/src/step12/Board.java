/* 게시물 데이터를 다룰 사용자 정의 데이터 타입을 선언하라!
게시물번호, 제목, 내용, 작성자, 조회수, 작성일(long)
*/
package step12;

public class Board {
  static int count;

  private int no;
  private String title;
  private String content;
  private String writer;
  private int views;
  private long createdDate;

  {
    this.no = ++count;
  }

  public Board() {}

  public Board(String title, String content, String writer) {
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.createdDate = System.currentTimeMillis();
    // System.currentTimeMillis()
    // => 1970년 1월 1일 0시 0분 0초부터 지금까지 흐른 시간을
    //    밀리초로 환산하여 리턴한다.
  }

  public int getNo() { return no; }
  public void setNo(int no) { this.no = no; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }
  public String getWriter() { return writer; }
  public void setWriter(String writer) { this.writer = writer; }
  public int getViews() { return views; }
  public void setViews(int views) { this.views = views; }
  public long getCreatedDate() { return createdDate; }
  public void setCreatedDate(long createdDate) { this.createdDate = createdDate; }
}
