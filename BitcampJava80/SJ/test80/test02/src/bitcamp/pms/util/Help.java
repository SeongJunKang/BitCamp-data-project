package bitcamp.pms.util;

import java.io.PrintStream;

import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;

@Controller
public class Help {

  @RequestMapping("-roomsHelp")
  public void roomsHelp(PrintStream out) {
    out.println("rooms : /add.do?roomcode=K001&roomname=강남");
    out.println("rooms : /delete.do?roomcode={강의실코드}");
    out.println("rooms : /list.do");
    out.println("rooms : /update.do?roomcode={강의실코드}&roomname={강의실이름}");
  }
  
  @RequestMapping("-teachsHelp")
  public void teachsHelp(PrintStream out) {
    out.println("teachs : /add.do?tnm={강사이름}&tel={전화번호}&email={이메일}");
    out.println("teachs : /delete.do?tno={강사번호}");
    out.println("teachs : /list.do");
    out.println("teachs : /update.do?tnm={강사이름}&tel={전화번호}&email={이메일}");
  }
  
  @RequestMapping("-assignHelp")
  public void assignHelp(PrintStream out) {
    out.println("teaAssign : /add.do?lno={강의번호}&tno={강사번호}");
    out.println("teaAssign : /delete.do?tno={강사번호}");
    out.println("teaAssign : /list.do");
    out.println("teaAssign : /update.do?lno={강의번호}&tno={강사번호}");
  }
  
  @RequestMapping("-lectsHelp")
  public void lectsHelp(PrintStream out) {
    out.println("lects : /add.do?title={타이틀}&description={설명}&startdate={시작일}&enddate={종료일}\n&deadline={마감일}&totalhour={총강의시간}&dayhour={하루강의시간}[&rno={강의실번호}]");
    out.println("lects : /delete.do?no={강의번호}");
    out.println("lects : /regist.do?no={강의번호}&rno={강의실번호}");
    out.println("lects : /list.do");
    out.println("lects : /update.do?no={강의번호}&title={타이틀}&description={설명}&startdate={시작일}&enddate={종료일}\n&deadline={마감일}&totalhour={총강의시간}&dayhour={하루강의시간}[&rno={강의실번호}]");
  }
  
}
