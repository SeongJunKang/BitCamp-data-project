## MAVEN 기본 Web Application 폴더 구조

src/main/java       => 자바 소스 파일을 두는 폴더
        /resources  => 설정 파일을 두는 폴더. 예: .properties, .xml, .txt 등
        /webapp     => 웹 자원을 두는 폴더. 예 : .html .css .js .gif .jsp
   /test/java       => 단위 테스트(JUnit) 자바 소스 파일을 두는 폴더
        /resources  => 단위 테스트에 사용되는 설정 파일을 두는 폴더.

## 이클립스 프로젝트 준비
1) build.gradle 파일을준비
    -현재 프로젝트에 맞게끔 편집한다.
2) "gradle eclipse" 명령실행
3) 이클립스로 프로젝트 로딩

## ContextLoaderListener 준비
- 서블릿에서 공통으로 사용할 스프링 IoC 컨테이너를 준비한다.
1) "bitcamp.pms.listener" 패키지 생성
2) ServletContextListener 구현체 "ContextLoaderListener" 클래스 생성
3) web.xml에 리스너 배치 설정
   - src/main/webapp/WEB-INF 폴더 추가
   - web.xml 파일 준비( 기존 프로젝트의 파일을 가져온다. )
   - web.xml 파일을 현재 프로젝트에 맞게끔 초기화 시킨다.
   - 리스너 등록
3) 톰캣 서버에 추가한 후 실행 테스트