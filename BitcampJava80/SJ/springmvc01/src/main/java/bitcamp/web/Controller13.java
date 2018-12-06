//요청 핸들러 파라미터 - VO 객체를 파라미터로 선언하기
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.vo.Board;

@Controller
@RequestMapping("/controller13")
public class Controller13 {

  @RequestMapping
  public String m1(Board board, String okok) {
    System.out.println("m1()-----------------------------");
    System.out.printf("no = %s\ntitle = %s\ncontent = %s\nokok=%s\n",
        board.getNo(),board.getTitle(),board.getContent(),okok);
    return "/hello.jsp";
  }
}

/*
# VO 객체를 사용하여 요청 파라미터 값을 바로 받기
- VO 객체로 요청 파라미터 값을 바로 받을 때는 값이 없어도 오류가 발생하지 않는다.
- 프론트 컨트롤러는 요청 파라미터의 이름과 일치하는
  VO 객체의 프로퍼티를 찾아 셋터 메서드를 호출하여 값을 저장한다.
- 만약 요청 파라미터 이름과 같은 VO 객체의 프로퍼티를 찾지 못한다면 그 값을 무시한다.
- VO 객체와 낱개의 변수 선언을 섞어 쓸 수 있다.
 */
