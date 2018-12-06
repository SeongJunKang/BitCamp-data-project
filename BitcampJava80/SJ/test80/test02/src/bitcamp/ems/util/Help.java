package bitcamp.ems.util;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;

import bitcamp.ems.annotation.RequestMapping;

@Controller
public class Help {

  @RequestMapping("/roomsHelp.do")
  public void roomsHelp(PrintWriter out) {
    out.println("rooms : /add.do?roomcode=K001&roomname=강남");
    out.println("rooms : /delete.do?roomcode={강의실코드}");
    out.println("rooms : /list.do");
    out.println("rooms : /update.do?roomcode={강의실코드}&roomname={강의실이름}");
  }
  
  @RequestMapping("/teachsHelp.do")
  public void teachsHelp(PrintWriter out) {
    out.println("teachs : /add.do?tnm={강사이름}&tel={전화번호}&email={이메일}");
    out.println("teachs : /delete.do?tno={강사번호}");
    out.println("teachs : /list.do");
    out.println("teachs : /update.do?tnm={강사이름}&tel={전화번호}&email={이메일}");
  }
  
  @RequestMapping("/assignHelp.do")
  public void assignHelp(PrintWriter out) {
    out.println("teaAssign : /add.do?lno={강의번호}&tno={강사번호}");
    out.println("teaAssign : /delete.do?tno={강사번호}");
    out.println("teaAssign : /list.do");
    out.println("teaAssign : /update.do?lno={강의번호}&tno={강사번호}");
  }
  
  @RequestMapping("/lectsHelp.do")
  public void lectsHelp(PrintWriter out) {
    out.println("lects : /add.do?title={타이틀}&description={설명}&startdate={시작일}&enddate={종료일}\n&deadline={마감일}&totalhour={총강의시간}&dayhour={하루강의시간}[&rno={강의실번호}]");
    out.println("lects : /delete.do?no={강의번호}");
    out.println("lects : /regist.do?no={강의번호}&rno={강의실번호}");
    out.println("lects : /list.do");
    out.println("lects : /update.do?no={강의번호}&title={타이틀}&description={설명}&startdate={시작일}&enddate={종료일}\n&deadline={마감일}&totalhour={총강의시간}&dayhour={하루강의시간}[&rno={강의실번호}]");
  }
  
  @RequestMapping("/exdata.do")
  public void data(PrintWriter out) {
    out.println("lects/add.do?title=뉴강의&description=90기&startdate=2016-04-04&enddate=2016-05-05&deadline=2010-10-10&totalhour=960&dayhour=10");
    out.println("rooms/add.do?rno=H001&rnm=하남");
    out.println("teaAssign/add.do?lno=3&tno=3");
    out.println("teachs/add.do?tnm=나선생&tel=111-1111&email=na@test.com");
  }
  
}
