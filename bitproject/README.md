# 산책할개 개발 내용 정리


## 6월
  * 1 week : balsamiq을 통해 웹페이지의 UI를 구축.
  
  * 2 week : balsamiq에서 invision으로 만들 UI 구축환경을 바꾸고, 페이지 UI 제작.
  
  * 3 week : invision으로 구축된 페이지 소스코딩 시작.
  
  * 4 week : 메인, 마이페이지, 펫시터 등록 대부분 완료 / 펫시터 상세정보 진행중
  
## 7월
  * 1 week: - Mypage에 펫시터 등록정보 추가. 신청페이지 제작.
  
  * 2 week: - 우편번호 찾기, DB에 주소록 추가 CSS ,JS 분리, DB cascade 오류 제거 
            - 프로필사진 Default 이미지 적용 및 DB에 저장.
            - 신청페이지 제작 UI. 
            - Petsitter -> DogWalker로 변경 ,프로필사진 Default 이미지 적용 및 DB에 저장. 사용자 후기 등록 
            - 캠타시아 작업으로 지도 적용 설명 gif 만듬.
            - 신청페이지 제작 부트스트랩에서 datepicker 채용, 신청페이지와 DB 연동.
            - 사용자 후기 수정, 삭제 추가 , 좋아요 버그 및 코드 수정
            - 캠타시아 작업으로 만든 지도를 펫시터 등록 페이지에 설정.
            - 신청페이지에서 신청 후 도그워커가 받는 팝업창 제작
             
  * 3 week: - 신청자와 도그워커 팝업 연결, 키워드 검색 적용, Mypage 버그수정
            - JS, CSS 분리
            - 이메일 인증(Google SMTP 서버) 사용
            - 포토박스 가져오기.
            - 신청 조회 페이지 UI 제작
            - 신청 조회 페이지 DB 연동, 게시판 형식으로 바꿈.
            - 클릭시 dialog를 띄워서 세부내용 확인가능. 
            
  * 4 week: - 이메일 인증 버그 제거. JSP 추가
            - Mypage 프로필 등록 버그 제거.
            - PhotoBox 하드 코딩 제거 , 한번에 많은 사진 등록.
            - search 페이지 페이징에서 append 형식으로 변경.
            - 수정한 DB 변경.
            
## cf ) 이메일 인증의 경우 EmailAuthController에서 아래 Google 아이디에 본인의 아이디를 적어야 적용됩니다. 