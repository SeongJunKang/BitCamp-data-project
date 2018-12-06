DROP database testdb;
CREATE DATABASE testdb CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON testdb.* TO java80@localhost ;
use testdb;
-- 교육과정
DROP TABLE IF EXISTS LECTS RESTRICT;

-- 강의장
DROP TABLE IF EXISTS ROOMS RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEACHS RESTRICT;

-- 강사배치
DROP TABLE IF EXISTS TEA_ASSIGN RESTRICT;

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

-- 강사배치 유니크 인덱스
CREATE UNIQUE INDEX UIX_TEA_ASSIGN
  ON TEA_ASSIGN ( -- 강사배치
    TNO ASC -- 강사번호
  );

ALTER TABLE TEA_ASSIGN
  MODIFY COLUMN TANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사배치번호';

-- 교육과정
ALTER TABLE LECTS
  ADD CONSTRAINT FK_ROOMS_TO_LECTS -- 강의장 -> 교육과정
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