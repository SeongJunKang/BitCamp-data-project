# Java Basic
## step01
- Hello.java :서블릿 만들고 배포하기
- Hello2.java : 서블릿 만들기2

## 이클립스에서 톰캣 서버 실행환경 구축하기
### 톰캣서버가 설치된 경로를 설정한다.
- window 메뉴 > Preferences > Server 노드 > Runtime Environments 노드에
  톰캣 서버의 경로를 추가한다.
### 웹 애플리케이션 테스트를 위한 톰캣 개발 환경 구축
- servers 뷰 > 새 서버 추가
- 이클립스 왼편의 "Project Explorer" 창에 "Servers" 폴더가 생성된다.
  ex) Servers/A고객사-config
- 톰캣 실행 환경 폴더에는 원래 톰캣 서버에 있던 설정 파일을 복사한 파일이 있다.
  => 이클립스에서 톰캣 서버를 실행할 때 마다 이 설정 파일을 사용한다.
  
### 이클립스에서 실행한 톰캣 서버에 웹 애플리케이션 배포
- 톰캣 서버가 설치된 원래의 폴더($톰캣서버/webapps)를 사용하지 않는다.
- 대신 워크스페이스의 특정 폴더에 별도의 배포 폴더를 구축하여 사용한다.
  C:\bitcamp\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
- 왜 톰캣 서버가 설치된 폴더를 사용하지 않는가 ?
  다양한 고객사나 웹 애플리케이션을 동시에 테스트하기 위해서이다.
- 이클립스에서 실행한 톰캣 서버에 웹 애플리케이션을 배포하려면,
  이클립스 규칙에 따라 웹 애플리케이션 프로젝트를 만들어야 한다.
  ex) File 메뉴/ New 메뉴 /Dynamic WEb Project 를 선택하여 웹 프로젝트를 만든다