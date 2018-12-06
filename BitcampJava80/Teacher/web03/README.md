# MAVEN 기본 Web Application 프로젝트 폴더 생성
src/main/java         => 자바 소스 파일을 두는 폴더
        /resources    => 설정 파일을 두는 폴더.
                         예: .properties, .xml, .txt 등
        /webapp       => 웹 자원을 두는 폴더.
                         예: .html, .css, .js, .gif, .jsp 등
   /test/java         => 단위 테스트(JUnit) 자바 소스 파일을 두는 폴더
        /resources    => 단위 테스트에 사용되는 설정 파일을 두는 폴더.

# 이클립스 프로젝트 준비
1) build.gradle 파일 준비(project01 프로젝트에서 가져온다)
   - 현재 프로젝트에 맞게끔 편집한다.
2) "gradle eclipse" 명령 실행
3) 이클립스로 프로젝트 로딩

# ContextLoaderListener 준비
- 서블릿에서 공통으로 사용할 스프링 IoC 컨테이너를 준비한다.
1) "bitcamp.pms.listener" 패키지 생성
2) ServletContextListener 구현체 "ContextLoaderListener" 클래스 생성
3) web.xml에 리스너 배치 설정
   - src/main/webapp/WEB-INF 폴더 추가
   - web.xml 파일 준비(기존 프로젝트의 파일을 가져온다)
   - web.xml 파일을 현재 프로젝트에 맞게끔 초기화시킨다.
   - 리스너 등록
  <listener>
    <listener-class>bitcamp.pms.listener.ContextLoaderListener</listener-class>
  </listener>
4) 톰캣 서버에 추가한 후 실행 테스트    
5) 스프링 설정 파일 준비
   - src/main/webapp/WEB-INF/conf 폴더 추가
   - 스프링 설정 파일 준비(project01에서 가져온다)
     WEB-INF/conf/application-context.xml
   - 스프링 설정 파일을 현재 프로젝트에 맞게 변경한다.
6) 스프링 설정 파일의 위치 정보를 컨텍스트 파라미터로 등록한다.
   - web.xml에 등록
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/conf/application-context.xml</param-value>
  </context-param>
7) 리스너에서 스프링 IoC 객체 생성하기
   - ContextLoaderListener.contextInitialized() 메서드 편집
   
# 게시판을 위한 mybatis 준비
1) "bitcamp.pms.vo" 패키지 생성
2) Board 값 객체 준비
3) "bitcamp.pms.dao" 패키지 생성
4) 게시판 DAO 준비
   - BoardDao 인터페이스 준비
5) 게시판 맵퍼 파일 준비
   - src/main/resources/bitcamp/pms/dao 폴더 생성
   - BoardDao.xml 파일 준비   

# 게시판 서블릿 준비(src01)
1) "bitcamp.pms.servlet" 패키지 생성
2) BoardListServlet 클래스 생성
   - BoardDao를 사용하여 게시물 출력한다.
3) BoardAddServlet 클래스 생성
   - doGet(): 게시물 입력 폼 출력
   - doPost(): 게시물 입력 결과 출력
4) POST 요청 데이터에 대한 한글 처리
   - 스프링에서 제공하는 필터 사용할 것.
   - web.xml에 스프링 필터 등록하라!    
5) BoardDetailServlet, BoardUpdateServlet, BoardDeleteServlet 클래스 생성
6) 리다이렉트 적용.

# JSP를 이용한 MVC 아키텍처 적용(src02)
1) BoardListServlet에서 출력 부분을 분리하여 BoardList.jsp에 맡긴다.
   - webapp/board 폴더 생성
   - webapp/board/BoardList.jsp 생성
   - BoardListServlet 변경
2) 회원 관리에도 적용하기

# JSP 액션 태그 적용하기(src02)
1) <jsp:useBean> 적용
2) <jsp:include> 적용
   - Copyright.jsp 작성
   - 목록 또는 상세정보 출력 화면에 Copyright.jsp 실행을 포함하라!

# JSP 페이지에 EL, JSTL 적용하기(src02)
1) BoardDetail.jsp, MemberDetail.jsp 페이지에 EL 적용
2) BoardList.jsp, MemberList.jsp 페이지에 EL, JSTL 적용.

# Front Controller 적용하기(src03)
1) 프론트 컨트롤러 생성
   - DispatcherServlet 클래스 작성
2) 프론트 컨트롤러 배치
   - web.xml에 서블릿 정보 및 매핑 정보 등록
3) 기존 서블릿을 페이지 컨트롤러로 만들기
   - BoardXxxServlet, MemberXxxServlet 클래스를 변경

# 페이지 컨트롤러를 Spring IoC 컨테이너에서 관리하기(src04)
=> 페이지 컨트롤러 클래스를 일반 클래스(POJO)로 변경한다.
=> POJO 클래스는 스프링 IoC 컨테이너에서 관리할 수 있다.
1) BoardXxxServlet 서블릿 클래스를 POJO 클래스로 변경한다.
   - BoardListServlet --> BoardListController
   - BoardAddServlet --> BoardNewFormController, BoardAddController
   - BoardDetailServlet --> BoardDetailController
   - BoardUpdateServlet --> BoardUpdateController
   - BoardDeleteServlet --> BoardDeleteController 
2) MemberXxxServlet 서블릿 클래스를 POJO 클래스로 변경한다.
   - MemberListServlet --> MemberListController
   - MemberAddServlet --> MemberNewFormController, MemberAddController
   - MemberDetailServlet --> MemberDetailController
   - MemberUpdateServlet --> MemberUpdateController
   - MemberDeleteServlet --> MemberDeleteController    

# CRUD 페이지 컨트롤러들을 한 클래스로 합치기(src05)
1) BoardXxxController를 BoardController로 합치기
   - BoardController 클래스를 작성한다.
   - 각 BoardXxxController의 execute()를 가져와서 이름을 바꾼다.
   - 요청을 처리하는 각 메서드에 @RequestMapping 애노테이션을 붙인다.
2) MemberXxxController를 MemberController로 합치기
   - MemberController 클래스를 작성한다.
   - 각 MemberXxxController의 execute()를 가져와서 이름을 바꾼다.
   - 요청을 처리하는 각 메서드에 @RequestMapping 애노테이션을 붙인다.
3) DispatcherServlet 프론트 컨트롤러 변경
   - 페이지 컨트롤러에서 서블릿 경로에 대응하는 메서드를 찾아 호출한다.

# 페이지 컨트롤러의 파라미터 선언을 자유화하기(src06)
1) DispatcherServlet 프론트 컨트롤러 변경
   - 요청 핸들러(메서드)를 호출할 때 파라미터 정보를 추출하여 
     그 메서드가 원하는 파라미터 값을 던져준다.
2) 각 페이지 컨트롤러의 메서드에 대해 파라미터 선언 변경

# 스프링 MVC 프레임워크 적용하기(src07)
1) 프론트 컨트롤러 교체
   - 스프링에서 제공하는 프론트 컨트롤러로 교체한다.
   - web.xml 파일을 편집한다.
   - application-context.xml --> dispatcher-servlet.xml 로 이름 변경. 
   - 기존의 DispatcherServlet 클래스 삭제한다.
   - 기존의 ContextLoaderListener 클래스 삭제한다.
  
# 스프링 MVC 프레임워크 적용하기2(src08)
1) 웹 컴포넌트와 비즈니스 객체를 분리하여 관리한다.
   => 웹 컴포넌트? 페이지 컨트롤러, JSP, InitBinder, 프로퍼티 에디터 등
   => 비즈니스 컴포넌트? DAO, Service 등 
   => 비즈니스 컴포넌트를 여러 프론트 컨트롤러가 공유할 수 있다.
   => 어떻게?
      웹 컴포넌트는 DispatcherServlet 프론트 컨트롤러에서 관리하고,
      비즈니스 컴포넌트는 ContextLoaderListener에서 관리한다.
   => 설정
      1. /WEB-INF/conf/applicationContext.xml 스프링 설정 파일을 만든다.
         => 이 파일에서는 DAO, Service, Mybatis 등 비즈니스 관련 
            컴포넌트만 준비하게 만든다.
      2. web.xml에 스프링에서 제공하는 ContextLoaderListener를 등록한다.
         => 이 클래스는 ServletContextListener의 구현체이다.
         => 웹 애플리케이션이 시작되거나 종료될 때 호출되는 메서드를 갖고 있다.
         => 웹 애플리케이션이 시작될 때 applicationContext.xml을 읽어서
            이 설정 파일에 있는대로 객체를 준비한다.
      3. /WEB-INF/conf/dispatcher-servlet.xml 에서 비즈니스 관련 설정을 제거한다.  
      
2) 페이지 컨트롤러 정리
- @Component 대신 @Controller를 사용하라!
- ServletRequest 보관소에 모델 관련 객체를 담는 대신 Model 객체에 담아라! 
- 요청 핸들러의 파라미터 변수 이름이 클라이언트가 보낸 파라미터 이름과 같다면,
  @RequestParam을 생략하라!

3) JSP를 WEB-INF에 밑에 감춰라.
- MVC 구조에서는 JSP를 직접 실행해서는 안된다. 반드시 페이지 컨트롤러를 경유해
  실행해야 한다.
  왜? 페이지 컨트롤러에서 JSP가 출력할 데이터를 준비하기 때문이다.
  예를 들면 BoardList.jsp는 직접 실행해 봐야 소용없다.
- 기존의 JSP를 모두 /WEB-INF/views/ 폴더에 둔다.
- JSP가 어느 폴더에 있는지 대신 찾아주는 해결사를 등록하라!
  뷰를 찾아주는 해결사(ViewResolver)
- /WEB-INF/conf/dispatcher-servlet.xml 파일에 다음 빈을 등록한다.
    <bean id="jspViewResolver"  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
      <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
      <property name="prefix" value="/WEB-INF/views/"/>
      <property name="suffix" value=".jsp"/>
  </bean>
- 뷰리졸버에서 페이지 컨트롤러가 리턴하는 JSP URL 앞,뒤로 경로를 붙이기 때문에
  페이지 컨트롤러의 리턴 값을 정리하라!  

# 스프링 MVC 프레임워크 적용하기2(src09)
## 로그인 및 검증 인터셉터 추가하라
1) 로그인 검사하는 인터셉터 추가
   - AuthInterceptor 클래스 작성
   - dispatcher-servlet.xml에 인터셉터 등록
2) 로그인 페이지 컨트롤러 추가   
   - AuthController 클래스 작성
   - /WEB-INF/views/auth/form.jsp 작성

## 비즈니스 로직 분리 - Service Layer 추가(src09)
=> Service Layer?
   - 업무 관련 로직을 수행
   - 트랜잭션 제어
1) BoardController에서 업무 관련 로직을 분리하여 BoardService를 만든다.
2) MemberController에서 업무 관련 로직을 분리하여 MemberService를 만든다.   
3) AuthController는 MemberService를 이용하여 요청을 처리한다.

## 페이징 처리(src09)
1) BoardMapper.xml, MemberMapper.xml 변경
2) BoardDao, MemberDao 변경
3) BoardService, MemberService 변경
4) BoardController, MemberController 변경ㅇ

## 실무 프로젝트 구조로 개선(src10)
1) 서비스 계층에 인터페이스 도입하기
=> 컨트롤러 계층에서 서비스 계층의 클래스를 직접 사용하면,
   향후 서비스 로직을 바꿀 필요가 있을 때 대체하기가 쉽지 않다.
=> 해결책?
   컨트롤러 계층과 서비스 계층 사이의 호출 규칙을 정의한 후,
   그 구현체를 사용하면 
   나중에 서비스 로직이 바뀌더라도 간단히 구현체를 교체함으로써
   변경에 대응하기가 쉬워진다.
=> 기존의 Service 클래스를 인터페이스과 구현체로 분리하라!
   BoardService --> BoardService 인터페이스와 BoardServiceImpl 클래스로 분리한다.
   MemberService --> MemberService 인터페이스와 MemberServiceImpl 클래스로 분리한다.
   
2) AOP 기술을 이용하여 트랜잭션 적용하기
=> 방법1) @Transactional 애노테이션 이용
   트랜잭션을 사용해야 하는 메서드에 @Transactional을 붙인다.
   문제는 각 클래스에 코드를 첨가해야 한다. => 번거롭다.
   해결책? AOP 기술 사용
   
=> 방법2) AOP를 사용하여 트랜잭션을 적용할 메서드를 지정한다.
   기존 코드를 손댈 필요가 없다.
   트랜잭션 정책이 바뀌더라도 기존 코드를 변경하지 않는다.

=> 트랜잭션을 사용해야 하는 메서드?
   insert, update, delete 을 실행하는 메서드
   DAO가 아니라 Service 객체의 메서드    
=> 예) 
   DefaultBoardService: add(), delete(), change()
   DefaultMemberService: add(), delete(), change()
   
=> AOP를 사용하여 트랜잭션 다루기
1) DataSource(DB 커넥션 풀)에 트랜잭션 관리자를 도입한다.
   => ContextLoaderListener의 스프링 설정 파일에 추가하라! 
<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

2) DB 커넥션의 트랜잭션을 관리할 AOP 어드바이스(필터)를 추가하라!
   => 개발자가 클래스를 만들 필요가 없다.
   => 스프링에서 제공하는 객체를 사용하라
<tx:advice id="txAdvice" transaction-manager="txManager">
  <tx:attributes>
      <tx:method name="retrieve*" read-only="true"/>
      <tx:method name="list*" read-only="true"/>
      <tx:method name="count*" read-only="true"/>
      <tx:method name="*"/>
  </tx:attributes>
</tx:advice> 

3) 포인트 컷(Point Cut)을 지정하라!
   => 어떤 클래스에 대해 Advice를 적용할 것인지 지정한다.
   => 스프링 AOP 기능 활성화시킨다.
<aop:aspectj-autoproxy/>
   => 포인트 컷을 지정하고 어드바이스와 연결한다.
<aop:config>
      <aop:pointcut id="serviceOperationPointCut" 
                    expression="execution(* *.service.impl.*.*(..))"/>
      <aop:advisor advice-ref="txAdvice" 
                   pointcut-ref="serviceOperationPointCut"/>
</aop:config>

4) AOP 라이브러리 추가해야 한다.
  compile 'org.springframework:spring-aop:4.3.0.RC2'
  compile 'org.aspectj:aspectjweaver:1.8.9'

## AJAX와 JSON을 활용하여 프론트엔드와 백엔드를 분리한다(src11)
1) build.gradle 파일에 Google-gson 라이브러리 추가한다.
2) bitcamp.pms.controller.ajax.BoardAjaxController 작성
   - 기존의 BoardController를 복사하여 편집한다..3) HTML 준비
   - src/main/webapp/board 폴더 생성성   - board.html 파일 작성성






    





