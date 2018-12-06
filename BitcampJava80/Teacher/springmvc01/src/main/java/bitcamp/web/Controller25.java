package bitcamp.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller25")
public class Controller25 {
  @RequestMapping(value="/ex1",produces="text/html;charset=UTF-8")
  public ResponseEntity<String> m1() {
    return new ResponseEntity<String>(
        "hello안녕", 
        HttpStatus.OK);
  }
  
  @RequestMapping(value="/ex2")
  public ResponseEntity<String> m2() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");
    headers.add("where", "bitcamp");
    headers.add("who", "java80");
    
    return new ResponseEntity<String>(
        "hello안녕", 
        headers,
        HttpStatus.OK);
  }
}

/*
# 요청 핸들러에서 직접 콘텐츠를 클라이언트로 출력하기
- ResponseEntity 객체에 담아서 리턴할 수 있다.
*/
















