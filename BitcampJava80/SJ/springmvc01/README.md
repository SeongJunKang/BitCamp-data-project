# 스프링 WEB MVC 프레임 워크 사용법

## 프론트 컨트롤러 설정하기
1) web.xml에 DispatcherServlet 클래스를 등록한다.
2) 스프링 설정 파일을 추가한다.
  - conf/dispatcher-servlet.xml
  - 만약 스프링 설정 파일을 /WEB-INF 폴더에 놓고,
    설정 파일의 이름을 "서블릿이름-servlet.xml"로 지정한다면
    스프링 설정 파일의 위치를 지정하는 초기화 파라미터("contextConfigLocation")
    를 생략할 수 있다.
  - 위의 규칙을 따르지 않는다면 명확하게 스프링 설정 파일의 위치를 지정해야 한다.
  
## 페이지 컨트롤러 만들기
- Controller01.java : 페이지 컨트롤러 클래스의 기본 구조
- Controller02.java : @RequestMapping 사용법 - 메서드에 붙이기 
- Controller03.java : @RequestMapping 사용법 - 클래스와 메서드에 모두 붙이기
- Controller04.java : 요청 핸들러에서 뷰 url 리턴하기
- Controller05.java : @RequestMapping 사용법 - GET 요청과 POST 요청 구분
  Controller05.jsp  : GET/POST 요청을 위한 페이지
- Controller06.java : @RequestMapping 사용법 - GET 요청과 POST 요청 구분2
  Controller06.jsp  : GET/POST 요청을 위한 페이지2
- Controller07.java : @RequestMapping 사용법 - 파라미터 이름으로 요청 구분하기
- Controller08.java : @RequestMapping 사용법 - 요청 프로토콜의 헤더로 요청을 구분하기
  Controller08.html : 서버에 임의의 요청을 보내는 페이지
- Controller09.java : 요청 핸들러 파라미터 - @RequestParam 애노테이션
- Controller10.java : 요청 핸들러 파라미터 - @RequestParam 애노테이션의 필수 여부 지정
                                            => required, defaultValue 속성
- Controller11.java : 요청 핸들러 파라미터 - @RequestParam 애노테이션의 value 속성 생략
- Controller12.java : 요청 핸들러 파라미터 - @RequestParam 애노테이션의 생략
- Controller13.java : 요청 핸들러 파라미터 - VO 객체를 파라미터로 선언하기
- Controller14.java : 요청 핸들러 파라미터 - request, response 받기
- Controller15.java : 요청 핸들러 파라미터 - ServletContext 받기(불가!)
- Controller16.java : 요청 핸들러 파라미터 - String을 java.util.Date 타입으로 변환하기(v3.0)
- Controller17.java : 요청 핸들러 파라미터 - String을 java.util.Date 타입으로 변환하기(v2.5)
- Controller18.java : 요청 핸들러 파라미터 - String을 java.util.Date 타입으로 변환하기(v3.2)
  GlobalInitBinder.java : 공통 @InitBinder를 모아둔 클래스
- Controller19.java : 요청 핸들러 파라미터 - 멀티파트 파라미터 값(파일업로드) 다루기.
  Controller19.html : 파일 업로드 폼 페이지
- Controller20.java : 뷰 컴포넌트 값 전달 - ServletRequest 보관소에 직접 담기
- Controller21.java : 뷰 컴포넌트 값 전달 - Map 객체 사용
- Controller22.java : 뷰 컴포넌트 값 전달 - Model 객체 사용
- Controller23.java : 뷰 컴포넌트 값 전달 - ModelAndView 객체 사용
- Controller24.java : 요청 핸들러의 리턴 다루기 - JSP를 경유하지 않고 콘텐츠 직접 리턴하기.
- Controller25.java : 요청 핸들러의 리턴 다루기 - ResponseEntity 객체를 통해 콘텐츠 리턴하기.
- Controller26.java : 쿠키 사용하기 - 로그인 폼에서 아이디 저장하기. 
  /controller26/form.jsp  : 로그인 폼
  /controller26/loginResult.jsp : 로그인 결과
- Controller27.java : 쿠키 사용하기 - 마지막 방문일 출력하기(JSP의 EL이용)
  /controller27.jsp 
- Controller28.java : 세션 사용하기 - HttpSession 객체 활용
- Controller29.java : 세션 사용하기 - @SessionAttributes, Model 객체활용
- Controller30.java : 세션 사용하기 - 로그아웃 처리, 세션 무효화시킴.
- Controller31.java : 세션 사용하기 - 로그인 폼 및 로그인 처리하기
  /controller31.jsp : 로그인 폼
- Controller32.java : 세션 사용하기 - 로그인 사용자만 접근할 수 있도록 제어하기
  /controller32.jsp
- AuthFilter.java   : 로그인 여부 검사하기 - 서블릿 필터 사용
- Interceptor01.java: 스프링 인터셉터 사용하기 - HandlerInterceptor 직접 구현하기
- Controller33.java : 인터셉터 확인용  
  /Controller32.jsp : 인터셉터 확인용
- Interceptor02.java: 스프링 인터셉터 사용하기 - HandlerInterceptorAdapter 상속받아 구현하기
- AuthInterceptor0.java: 로그인 검사 인터셉터 만들기