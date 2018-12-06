//요청 핸들러 파라미터 - 멀티파트 파라미터 값(파일업로드) 다루기.
package bitcamp.web;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/controller19")
public class Controller19 {

  @Autowired
  ServletContext servletContext;

  @RequestMapping
  public String m1(String name, int age, MultipartFile photo) {
    System.out.println("name = " + name);
    System.out.println("age = " + age);
    System.out.println("photo.originalFilename() = " + photo.getOriginalFilename());
    System.out.println("photo.name() = " + photo.getName());
    System.out.println("photo.size() = " + photo.getSize());
    int extPoint = photo.getOriginalFilename().lastIndexOf(".");
    String fileName = System.currentTimeMillis() + "-" + count() 
                      + photo.getOriginalFilename().substring(extPoint);
    System.out.println("새 파일명 : " + fileName);
    String realpath = servletContext.getRealPath("/upload/" + fileName);
    System.out.printf("새 파일을 저장할 실제 경로 = %s\n", realpath);
    try {
      photo.transferTo(new File(realpath));
      // 자원을 해제 시킬 필요가 없다.
      // 임시폴더이기 때문에 스프링에서 자동으로 삭제해줌.
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "/hello.jsp";
  }

  int no = 0;

  synchronized private int count() {
    int i = ++no;
    if (i == 1000)
      i = 1;
    return i;
  }
}

/*
# 멀티파트 파라미터 값 받기 
- 스프링 IoC 컨테이너에 멀티파트 파라미터 값을 처리할 수 있는 객체를 등록해야 한다.
  => 스프링 설정 파일 편집
  <bean id="multipartResolver"
    class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <property name="maxUploadSize" value="10000000"></property>
  </bean>
- 멀티 파트 데이터 중에서 파일 데이터를 받고 싶다면 MultipartFile 타입으로 변수를
  선언해야 한다.
 */
