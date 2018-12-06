# Web Application
## 이클립스에서 톰캣 서버 실행환경 구축하기
### 톰캣 서버가 설치된 경로를 설정한다.
- window 메뉴 > Preferences 메뉴 > Server 노드 > Runtime Environments 노드 에
  톰캣 서버의 경로를 추가한다.

### 웹 애플리케이션 테스트를 위한 톰캣 실행 환경 구축
- Servers 뷰 > 새 서버 추가
- 이클립스 왼편의 "Project Explorer" 창에 "Servers" 폴더가 생성된다.
- Servers 폴더 아래에 톰캣 실행 환경 폴더가 생성된다.
  예) Servers/A고객사-config
- 톰캣 실행 환경 폴더에는 원래 톰캣 서버에 있던 설정 파일을 복사한 파일이 있다.
  => 이클립스에서 톰캣 서버를 실행할 때 마다 이 설정 파일을 사용한다.

### 이클립스에서 실행한 톰캣 서버에 웹 애플리케이션 배포
- 톰캣 서버가 설치된 원래의 폴더($톰캐서버/webapps)를 사용하지 않는다.
- 대신 워크스페이스의 특정 폴더에 별도의 배포 폴더를 구축하여 사용한다.
  C:\bitcamp\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
- 왜 톰캣 서버가 설치된 폴더를 사용하지 않는가?
  다양한 고객사나 웹 애플리케이션을 동시에 테스트하기 위해서이다.
- 이클립스에서 실행한 톰캣 서버에 웹 애플리케이션을 배포하려면,
  이클립스 규칙에 따라 웹 애플리케이션 프로젝트를 만들어야 한다.
  예) File 메뉴 > New 메뉴 > Dynamic Web Project 메뉴를 선택하여 웹 프로젝트를 만든다.
  
## Dynamic Web Project 폴더 구조
- src : 자바 소스 파일을 두는 폴더.
- WebContent : HTML, CSS, JavaScript, 이미지 파일, JSP 파일을 두는 폴더.
               WEB-INF 폴더도 이 폴더에 생성한다. 

## 웹 애플리케이션을 톰캣 실행 환경에 배치
- 톰캣 실행환경의 배치 폴더에 프로젝트 이름으로 하위 폴더를 생성한다.
  예) ...\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web02
- WebContent 폴더에 있던 모든 파일과 디렉토리를 배치 폴더에 복사한다.
- src 폴더에 있던 자바 파일을 컴파일하여 배치 폴더의 WEB-INF/classes 밑에 복사한다.
- 이 모든 것을 자동으로 수행한다.

## step02
- 웹 애플리케이션의 세가지 컴포넌트
- MyServlet.java : 서블릿 
  => 클라이언트의 요청을 처리하기.
  => Servlet 인터페이스를 구현해야 한다.
  
- MyFilter.java : 필터
  => 서블릿을 호출하기 전/후에 실행되는 컴포넌트.
  => Filter 인터페이스를 구현해야 한다.   

- MyServletContextListener.java : 리스너
  => 서블릿 컨테이너가 특정 상태가 되었을 때 호출되는 컴포넌트.
  => 상태 예)
     - 웹 애플리케이션이 시작되거나 종료될 때,
     - 서블릿 요청 속성이 추가되거나 제거될 때,
     - 세션 속성이 추가되거나 제거될 때,
     - 세션이 활성화되거나 비활성화될 때,
     - 세션이 생성되거나 제거될 때,
  => 각 상태 별로 정의된 인터페이스를 구현하면 된다.       

## step03
- Servlet01.java => @WebServlet 애노테이션을 이용한 서블릿 배치
- Servlet02.java => 웹 브라우저로 출력하기
- Servlet03.java => 한글이 출력 안되는 문제 해결 
- Servlet04.java => 출력하는 데이터의 형식을 HTTP 클라이언트에게 알려주기
- Servlet05.java => 클라이언트가 보낸 파라미터 값 알아내기
- Servlet06.java => 중복 이름의 파라미터 값 다루기
- Servlet07.java => 파라미터 이름과 값을 알아내기
- Servlet08.java => 파라미터 이름과 값을 알아내기2
- Servlet09.java => 기타 요청과 관련된 정보를 추출하기
- Servlet10.java => HTTP 프로토콜과 관련된 정보를 추출하기 - HttpServletRequest
- Servlet11.java => HttpServlet 클래스를 상속하여 HTTP 정보 추출하기
- Servlet12.java => HTTP 프로토콜의 요청 방식을 식별하기 - HTTP 요청 프로토콜 분석
- Servlet13.java => HTTP 응답 헤더 추가하기 - HTTP 응답 프로토콜 분석

## step04
- Servlet14.java => JavaEE에서 제공하는 HttpServlet 클래스 상속하기
- Servlet15.java => GET 요청과 POST 요청
  getpost.html
- Servlet16.java => GET 요청과 POST 요청 프로토콜 상세 분석
  getpost2.html
- Servlet17.java => POST 요청 시 한글 깨짐 현상 해결
  getpost3.html
- Servlet18.java => 파일업로드와 HTTP 요청 프로토콜 분석
  upload.html
- Servlet19.java => 파일업로드 처리
  upload2.html
- servlet20 패키지 => 요청을 다른 서블릿에게 위임하기 - forward
  calculator.html 
  CalculatorServlet.java
  PlusServlet.java
  MinusServlet.java
  MultipleServlet.java
  DivideServlet.java
- servlet21 패키지 => 요청을 다른 서블릿에게 위임하기 - include
  calculator2.html 
  CalculatorServlet.java
  PlusServlet.java
  MinusServlet.java
  MultipleServlet.java
  DivideServlet.java
- servlet22 패키지 => 서블릿 끼리 값을 주고 받기 - getAttribute()/setAttribute()
  HeaderServlet.java
  TailerServlet.java
  calculator3.html 
  CalculatorServlet.java
  PlusServlet.java
  MinusServlet.java
  MultipleServlet.java
  DivideServlet.java
- Servlet23.java => 서블릿 초기화 파라미터 다루기, 서블릿 컨텍스트 파라미터 다루기
  CharacterEncodingFilter.java => 필터 초기화 파라미터 다루기
- Servlet24.java => GET/POST 요청을 분리하여 처리하기 - getMethod()
- Servlet25.java => GET/POST 요청을 분리하여 처리하기2
- Servlet26.java => GET/POST 요청을 분리하여 처리하기2 - doGet(), doPost(), ...
 
## step05
- test00.html => HTML4 기본 구조
- test01.html => HTML5 기본 구조와 HTML5 목표
- test02.html => 제목(header) 표현할 사용할 태그. <h1>,<h2>,...
- test03.html => 시맨틱 웹의 의미
- test04.html => 문단(paragraph) 구성하기. <p> 
- test05.html => 목록을 구성하기. <ol>, <ul>
- test06.html => 폼 만들기. <form>, <input>, <select>, <button>
- test07.html => 테이블 만들기. <table>, <thead>, <tbody>
- test08.html => 테이블 만들기 초 간단 버전.
- test09.html => 테이블 셀 병합 기법. colspan, rowspan 속성
- test10.html => 링크 축가하기. <a href="url">
- test11.html => 태그 달기. <a href="#태그">
- test12.html => 사용자 정의 태그 사용하기.
- test13.html => 데이터 목록 출력하기. <dl>, <dt>, <dd>
- test14.html => 그림 출력하기. <img>
- test15.html => UI 컴포넌트 묶기 : <div>, 콘텐츠 구분 : <span> 
- test16.html => HTML5 Semantic 태그 사용하기

## step06
- Servlet27.java => 리프레시 - HTML <meta> 태그 이용
- Servlet28.java => 리프레시2 - 응답 헤더를 이용
- Servlet29.java => 리다이렉트

## step07
- Test01.jsp => JSP 개념과 동작원리
- Test02.jsp => JSP 문법: 템플릿 데이터(template data)
- Test03.jsp => JSP 문법: 스크립트릿(scriptlet element, <% 자바 코드 %>)
- Test04.jsp => JSP 문법: 표현식(expression element, <%= 표현식 %>)
                          리턴 결과가 있는 부분 자바 코드 
- Test05.jsp => JSP 문법: 선언문(declaration element, <%! 클래스에 삽입할 코드 %>)
- Test06.jsp => JSP 문법: 지시문(directive element, <%@ 지시어 속성=값 ... %>)
- Test07.jsp => JSP 문법: 지시문 => include
- Test08.jsp => JSP 액션 태그: <jsp:useBean> 사용법1 => 개요 
- Test09.jsp => JSP 액션 태그: <jsp:useBean> 사용법2 => class 속성
- Test10.jsp => JSP 액션 태그: <jsp:useBean> 사용법3 => type과 class 속성
- Test11.jsp => JSP 액션 태그: <jsp:useBean> 사용법4 => type 속성
- Test12.jsp => JSP 액션 태그: <jsp:include> 사용법 => including 수행 
  BasicStyle.jsp 

## step08
- Test01.jsp => EL 사용법: 개요
- Test02.jsp => EL 사용법: 보관소에 저장된 객체의 프로퍼티 값 출력하기
- Test03.jsp => EL 사용법: 보관소명 생략하기
- Test04.jsp => EL 사용법: 파라미터 값 꺼내기
- Test05.jsp => EL 사용법: 요청 프로토콜에 있는 헤더 값 꺼내기
- Test06.jsp => EL 기초 문법: 표현식
- Test07.jsp => EL 기초 문법: 배열에서 값 꺼내기
- Test08.jsp => EL 기초 문법: List에서 값 꺼내기
- Test09.jsp => EL 기초 문법: Map에서 값 꺼내기
- Test10.jsp => EL 기초 문법: 산술 연산자 사용법 
- Test11.jsp => EL 기초 문법: 논리 연산자 사용법 
- Test12.jsp => EL 기초 문법: 관계 연산자 사용법 
- Test13.jsp => EL 기초 문법: empty와 조건 연산자 사용법

## step09
- Test01.jsp => JSTL 사용법 : 개요
- Test02.jsp => JSTL 사용법 : Core 라이브러리 - c:out
- Test03.jsp => JSTL 사용법 : Core 라이브러리 - c:set, c:remove
- Test04.jsp => JSTL 사용법 : Core 라이브러리 - c:if
- Test05.jsp => JSTL 사용법 : Core 라이브러리 - c:choose
- Test06.jsp => JSTL 사용법 : Core 라이브러리 - c:forEach
- Test07.jsp => JSTL 사용법 : Core 라이브러리 - c:forTokens
- Test08.jsp => JSTL 사용법 : Core 라이브러리 - c:import
- Test09.jsp => JSTL 사용법 : Core 라이브러리 - c:redirect
- Test10.jsp => JSTL 사용법 : i18n 라이브러리 - fmt:parseDate
- Test11.jsp => JSTL 사용법 : i18n 라이브러리 - fmt:formatDate

## step10
- Servlet30.java => 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
- Servlet31.java => 클라이언트에서 서버로 쿠키 전달하기 - HTTP 요청 프로토콜과 쿠키
- Servlet32.java => 쿠키의 사용 범위 확인 - 같은 경로(하위 경로 포함)만 가능
- Servlet33.java => 쿠키의 사용 범위를 지정하기 - 다른 경로에도 쿠키 보내는 방법
- Servlet34.java => 쿠키의 사용 범위 확인 - / 
- Servlet35.java => 쿠키의 사용 범위 확인 - /other
- Servlet36.java => 쿠키의 사용 범위 확인 - /step10/other
- Servlet37.java => 쿠키의 유효기간 지정하기
- Servlet38.java => 쿠키 응용: 로그인 폼에서 아이디 저장할 때
- Servlet39.java => 쿠키 응용: 마지막 방문일 출력하기

## step11
- Servlet40A.java => 세션을 사용하지 않고 페이지 간의 데이터를 전달하는 방법
  Servlet40B.java
  Servlet40C.java
  Servlet40C.java
- Servlet41A.java => 세션을 사용해 페이지 간의 데이터를 전달하는 방법
  Servlet41B.java
  Servlet41C.java
  Servlet41C.java
- Servlet42.java => GET(로그인 폼 출력), POST(로그인 처리)
- Servlet43.java => 로그아웃 처리
- Servlet44.java => 세션에서 로그인 정보를 꺼내 출력. 로그아웃 링크 출력.

## step12
- css00.html : CSS 스타일 개요
- css1-01.html : selector 사용법
- ...






