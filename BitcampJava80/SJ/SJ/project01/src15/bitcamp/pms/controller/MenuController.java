package bitcamp.pms.controller;

import java.util.Map;
public interface MenuController {
  void init();
  void service(Map<String,Object> paramMap);
  void destroy();

}
