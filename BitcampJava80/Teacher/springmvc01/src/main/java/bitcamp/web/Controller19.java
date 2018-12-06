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
  @Autowired ServletContext servletContext;
  
  @RequestMapping
  public String m1(String name, int age, MultipartFile photo) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("name=%s\n", name);
    System.out.printf("age=%d\n", age);
    System.out.printf("photo.originalFilename=%s\n", photo.getOriginalFilename());
    System.out.printf("photo.name=%s\n", photo.getName());
    System.out.printf("photo.size=%d\n", photo.getSize());
    
    int extPoint = photo.getOriginalFilename().lastIndexOf(".");
    String filename = System.currentTimeMillis() + "-" + count()
                       + photo.getOriginalFilename().substring(extPoint);
    System.out.printf("새파일명=%s\n", filename);
    
    String realPath = servletContext.getRealPath("/upload/" + filename);
    System.out.printf("새 파일을 저장할 실제 경로=%s\n", realPath);
    
    try {
      photo.transferTo(new File(realPath));
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return "/hello.jsp";
  }
  
  int no = 0;
  synchronized private int count() {
    if (++no == 100) no = 1;
    return no;
  }
}

/*
# 멀티파트 파라미터 값 받기
- 스프링 IoC 컨테이너에 멀티파트 파라미터 값을 처리할 수 있는 객체를 등록해야 한다.
  => 스프링 설정 파일 편집
    <bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="10000000"/>
    </bean>   
- 멀티파트 데이터 중에서 파일 데이터를 받고 싶다면 MultipartFile 타입으로
  변수를 선언해야 한다.
*/
















