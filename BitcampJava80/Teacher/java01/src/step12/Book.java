/*
책 데이터를 다룰 사용자 정의 데이터 타입을 선언하라!
책번호, ISBN, 제목, 저자들, 출판사, 총페이지수, 가격, 소개
*/
package step12;

public class Book {
  private int no;
  private String isbn;
  private String title;
  private String[] authors;
  private String press;
  private int pages;
  private int price;
  private String intro;

  public Book() {}

  public Book(String title, String[] authors, String isbn) {
    this.title = title;
    this.authors = authors;
    this.isbn = isbn;
  }

  // 
}
