package step12$StaticInstance;

public class BoardExam {

  public static void main( String[] args) {

    board b = new board("성준","This is board","게시판 예제 입니다");
    board b2 = new board();

    // b2("쭈니","게시판","예제");

    System.out.println(b.getNo());
    System.out.println(b.getName());
    System.out.println(b.getTitle());
    System.out.println(b.getCotents());
    System.out.println(b.getCount());
    System.out.println(b.getDate());
    System.out.println("------------------------------------------------------");



  }
}
