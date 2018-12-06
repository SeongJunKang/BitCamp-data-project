-- 수강신청
DROP TABLE IF EXISTS LEC_APPL RESTRICT;

-- 교육과정
DROP TABLE IF EXISTS LECTS RESTRICT;

-- 강의장
DROP TABLE IF EXISTS ROOMS RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEACHS RESTRICT;

-- 주소
DROP TABLE IF EXISTS ADDRS RESTRICT;

-- 강의장사진
DROP TABLE IF EXISTS ROOM_PHOT RESTRICT;

-- 강사배치
DROP TABLE IF EXISTS TEA_ASSIGN RESTRICT;

-- 회원
DROP TABLE IF EXISTS MEMBS RESTRICT;

-- 수강신청
CREATE TABLE LEC_APPL (
  APNO   INTEGER     NOT NULL COMMENT '수강신청번호', -- 수강신청번호
  LNO    INTEGER     NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  MNO    INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  AP_TYP VARCHAR(10) NOT NULL COMMENT '신청유형', -- 신청유형
  CR_DT  DATE        NOT NULL COMMENT '신청일' -- 신청일
)
COMMENT '수강신청';

-- 수강신청
ALTER TABLE LEC_APPL
  ADD CONSTRAINT PK_LEC_APPL -- 수강신청 기본키
    PRIMARY KEY (
      APNO -- 수강신청번호
    );

ALTER TABLE LEC_APPL
  MODIFY COLUMN APNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강신청번호';

-- 교육과정
CREATE TABLE LECTS (
  LNO    INTEGER      NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  RNO    VARCHAR(10)  NULL     COMMENT '강의장코드', -- 강의장코드
  TITL   VARCHAR(255) NOT NULL COMMENT '과목명', -- 과목명
  DESCT  TEXT         NOT NULL COMMENT '설명', -- 설명
  ST_DT  DATE         NOT NULL COMMENT '강의시작일', -- 강의시작일
  EN_DT  DATE         NOT NULL COMMENT '강의종료일', -- 강의종료일
  DAY_HR INTEGER      NOT NULL COMMENT '일강의시간', -- 일강의시간
  TOT_HR INTEGER      NOT NULL COMMENT '총강의일', -- 총강의일
  FI_DT  DATE         NOT NULL COMMENT '신청마감일' -- 신청마감일
)
COMMENT '교육과정';

-- 교육과정
ALTER TABLE LECTS
  ADD CONSTRAINT PK_LECTS -- 교육과정 기본키
    PRIMARY KEY (
      LNO -- 교육과정번호
    );

-- 교육과정 인덱스
CREATE INDEX IX_LECTS
  ON LECTS( -- 교육과정
    TITL ASC -- 과목명
  );

ALTER TABLE LECTS
  MODIFY COLUMN LNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교육과정번호';

-- 강의장
CREATE TABLE ROOMS (
  RNO VARCHAR(10)  NOT NULL COMMENT '강의장코드', -- 강의장코드
  RNM VARCHAR(100) NOT NULL COMMENT '이름' -- 이름
)
COMMENT '강의장';

-- 강의장
ALTER TABLE ROOMS
  ADD CONSTRAINT PK_ROOMS -- 강의장 기본키
    PRIMARY KEY (
      RNO -- 강의장코드
    );

-- 강의장 유니크 인덱스
CREATE UNIQUE INDEX UIX_ROOMS
  ON ROOMS ( -- 강의장
    RNM ASC -- 이름
  );

-- 강사
CREATE TABLE TEACHS (
  TNO   INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
  TNM   VARCHAR(100) NOT NULL COMMENT '강사명', -- 강사명
  TEL   VARCHAR(30)  NOT NULL COMMENT '강사전화', -- 강사전화
  EMAIL VARCHAR(40)  NOT NULL COMMENT '강사이메일', -- 강사이메일
  PHOT  VARCHAR(255) NULL     COMMENT '강사사진' -- 강사사진
)
COMMENT '강사';

-- 강사
ALTER TABLE TEACHS
  ADD CONSTRAINT PK_TEACHS -- 강사 기본키
    PRIMARY KEY (
      TNO -- 강사번호
    );

-- 강사 유니크 인덱스
CREATE UNIQUE INDEX UIX_TEACHS
  ON TEACHS ( -- 강사
    EMAIL ASC -- 강사이메일
  );

-- 강사 인덱스
CREATE INDEX IX_TEACHS
  ON TEACHS( -- 강사
    TNM ASC -- 강사명
  );

ALTER TABLE TEACHS
  MODIFY COLUMN TNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사번호';

-- 주소
CREATE TABLE ADDRS (
  ANO      INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  POSNO    VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  BAS_ADDR VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE ADDRS
  ADD CONSTRAINT PK_ADDRS -- 주소 기본키
    PRIMARY KEY (
      ANO -- 주소번호
    );

-- 주소 인덱스
CREATE INDEX IX_ADDRS
  ON ADDRS( -- 주소
    POSNO ASC -- 우편번호
  );

ALTER TABLE ADDRS
  MODIFY COLUMN ANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 강의장사진
CREATE TABLE ROOM_PHOT (
  RPNO INTEGER      NOT NULL COMMENT '강의장사진번호', -- 강의장사진번호
  RNO  VARCHAR(10)  NOT NULL COMMENT '강의장코드', -- 강의장코드
  PHOT VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '강의장사진';

-- 강의장사진
ALTER TABLE ROOM_PHOT
  ADD CONSTRAINT PK_ROOM_PHOT -- 강의장사진 기본키
    PRIMARY KEY (
      RPNO -- 강의장사진번호
    );

ALTER TABLE ROOM_PHOT
  MODIFY COLUMN RPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의장사진번호';

-- 강사배치
CREATE TABLE TEA_ASSIGN (
  TANO  INTEGER NOT NULL COMMENT '강사배치번호', -- 강사배치번호
  LNO   INTEGER NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TNO   INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  ST_DT DATE    NULL     COMMENT '강의시작일', -- 강의시작일
  EN_DT DATE    NULL     COMMENT '강의종료일', -- 강의종료일
  DESCT TEXT    NULL     COMMENT '강의내용', -- 강의내용
  HR    INTEGER NULL     COMMENT '강의시간' -- 강의시간
)
COMMENT '강사배치';

-- 강사배치
ALTER TABLE TEA_ASSIGN
  ADD CONSTRAINT PK_TEA_ASSIGN -- 강사배치 기본키
    PRIMARY KEY (
      TANO -- 강사배치번호
    );

ALTER TABLE TEA_ASSIGN
  MODIFY COLUMN TANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사배치번호';

-- 회원
CREATE TABLE MEMBS (
  MNO      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  MNM      VARCHAR(100) NOT NULL COMMENT '이름', -- 이름
  TEL      VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  EMAIL    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  ANO      INTEGER      NULL     COMMENT '주소번호', -- 주소번호
  DET_ADDR VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  STEP     VARCHAR(10)  NULL     COMMENT '학력', -- 학력
  SCH_NM   VARCHAR(255) NULL     COMMENT '학교', -- 학교
  WORK     CHAR(1)      NOT NULL COMMENT '재직여부', -- 재직여부
  PHOT     VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '회원';

-- 회원
ALTER TABLE MEMBS
  ADD CONSTRAINT PK_MEMBS -- 회원 기본키
    PRIMARY KEY (
      MNO -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_MEMBS
  ON MEMBS ( -- 회원
    EMAIL ASC -- 이메일
  );

-- 회원 인덱스
CREATE INDEX IX_MEMBS
  ON MEMBS( -- 회원
    MNM ASC -- 이름
  );

ALTER TABLE MEMBS
  MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 수강신청
ALTER TABLE LEC_APPL
  ADD CONSTRAINT FK_LECTS_TO_LEC_APPL -- 교육과정 -> 수강신청
    FOREIGN KEY (
      LNO -- 교육과정번호
    )
    REFERENCES LECTS ( -- 교육과정
      LNO -- 교육과정번호
    );

-- 수강신청
ALTER TABLE LEC_APPL
  ADD CONSTRAINT FK_MEMBS_TO_LEC_APPL -- 회원 -> 수강신청
    FOREIGN KEY (
      MNO -- 회원번호
    )
    REFERENCES MEMBS ( -- 회원
      MNO -- 회원번호
    );

-- 교육과정
ALTER TABLE LECTS
  ADD CONSTRAINT FK_ROOMS_TO_LECTS -- 강의장 -> 교육과정
    FOREIGN KEY (
      RNO -- 강의장코드
    )
    REFERENCES ROOMS ( -- 강의장
      RNO -- 강의장코드
    );

-- 강의장사진
ALTER TABLE ROOM_PHOT
  ADD CONSTRAINT FK_ROOMS_TO_ROOM_PHOT -- 강의장 -> 강의장사진
    FOREIGN KEY (
      RNO -- 강의장코드
    )
    REFERENCES ROOMS ( -- 강의장
      RNO -- 강의장코드
    );

-- 강사배치
ALTER TABLE TEA_ASSIGN
  ADD CONSTRAINT FK_LECTS_TO_TEA_ASSIGN -- 교육과정 -> 강사배치
    FOREIGN KEY (
      LNO -- 교육과정번호
    )
    REFERENCES LECTS ( -- 교육과정
      LNO -- 교육과정번호
    );

-- 강사배치
ALTER TABLE TEA_ASSIGN
  ADD CONSTRAINT FK_TEACHS_TO_TEA_ASSIGN -- 강사 -> 강사배치
    FOREIGN KEY (
      TNO -- 강사번호
    )
    REFERENCES TEACHS ( -- 강사
      TNO -- 강사번호
    );

-- 회원
ALTER TABLE MEMBS
  ADD CONSTRAINT FK_ADDRS_TO_MEMBS -- 주소 -> 회원
    FOREIGN KEY (
      ANO -- 주소번호
    )
    REFERENCES ADDRS ( -- 주소
      ANO -- 주소번호
    );