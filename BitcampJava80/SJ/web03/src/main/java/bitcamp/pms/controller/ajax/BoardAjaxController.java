package bitcamp.pms.controller.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pms.service.BoardService;
import bitcamp.pms.vo.Board;

@Controller
@RequestMapping("/ajax/board/")
public class BoardAjaxController {

  @Autowired
  BoardService boardService;

  @RequestMapping("add")
  public String add(String title, String content, String password)
      throws ServletException, IOException {
    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);
    board.setPassword(password);
    boardService.add(board);
    return "redirect:list.do";
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="delete")
  @ResponseBody
  public String delete(int no) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      boardService.delete(no);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="detail")
  @ResponseBody
  public String detail(int no) 
      throws ServletException, IOException {
    Board board = boardService.retrieve(no);
    board.setViews(board.getViews() + 1);
    boardService.change(board);
    return new Gson().toJson(board);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="list")
  @ResponseBody
  public String list(
      @RequestParam(defaultValue="1")int pageNo,
      @RequestParam(defaultValue="3")int pageSize)
      throws ServletException, IOException {
    if (pageSize < 3) {
      pageSize = 3;
    } else if (pageSize > 20) {
      pageSize = 20;
    }
    if (pageNo < 1) {
      pageNo = 1;
    }
    int totalPage = boardService.countPage(pageSize);
    if (pageNo > totalPage ) {
      pageNo = totalPage;
    }
    List<Board> list = boardService.list(pageNo,pageSize);
    HashMap<String,Object> result = new HashMap<>();
    result.put("pageNo", pageNo);
    result.put("pageSize", pageSize);
    result.put("totalPage", totalPage);
    result.put("list", list);
    return new Gson().toJson(result);
  }

  @RequestMapping("new")
  public String newform() throws ServletException, IOException {
    return "/board/BoardNewForm";
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(int no, String title, String content) 
      throws ServletException, IOException {
    Board board = boardService.retrieve(no);
    board.setTitle(title);
    board.setContent(content);
    HashMap<String,Object> result = new HashMap<>();
    try {
      boardService.change(board);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

}
