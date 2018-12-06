-- 프로젝트
DROP TABLE IF EXISTS `PROJECTS` RESTRICT;

-- 강사
DROP TABLE IF EXISTS `TEACHERS` RESTRICT;

-- 매니저
DROP TABLE IF EXISTS `MANAGERS` RESTRICT;

-- 학생
DROP TABLE IF EXISTS `STUDENTS` RESTRICT;

-- 게시판
DROP TABLE IF EXISTS `BOARDS` RESTRICT;

-- 회원 관리
DROP TABLE IF EXISTS `MEMBERS` RESTRICT;

-- 파일
DROP TABLE IF EXISTS `BOARDFILE` RESTRICT;

-- 프로젝트산출물
DROP TABLE IF EXISTS `PROJECTFILE` RESTRICT;

-- 그룹
DROP TABLE IF EXISTS `GROUP` RESTRICT;

-- 프로젝트
CREATE TABLE `PROJECTS` (
  `PCD`   INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  `PNM`   VARCHAR(100) NOT NULL COMMENT '프로젝트명', -- 프로젝트명
  `PTNM`  VARCHAR(50)  NOT NULL COMMENT '팀명', -- 팀명
  `ST_DT` DATE         NOT NULL COMMENT '시작일', -- 시작일
  `ED_DT` DATE         NULL     COMMENT '종료일', -- 종료일
  `CONT`  TEXT         NULL     COMMENT '내용', -- 내용
  `SUMM`  TEXT         NOT NULL COMMENT '요약', -- 요약
  `STAT`  VARCHAR(30)  NULL     COMMENT '상태', -- 상태
  `PEOP`  INTEGER      NOT NULL COMMENT '인원', -- 인원
  `SNO`   INTEGER      NULL     COMMENT '학생회원번호' -- 학생회원번호
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE `PROJECTS`
  ADD CONSTRAINT `PK_PROJECTS` -- 프로젝트 기본키
    PRIMARY KEY (
      `PCD` -- 프로젝트번호
    );

-- 프로젝트 인덱스
CREATE INDEX `IX_PROJECTS`
  ON `PROJECTS`( -- 프로젝트
    `ST_DT` ASC -- 시작일
  );

ALTER TABLE `PROJECTS`
  MODIFY COLUMN `PCD` INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 강사
CREATE TABLE `TEACHERS` (
  `MEMID` INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  `TNO`   INTEGER     NOT NULL COMMENT '강사회원번호', -- 강사회원번호
  `CLASS` VARCHAR(30) NULL     COMMENT '담당과정' -- 담당과정
)
COMMENT '강사';

-- 강사
ALTER TABLE `TEACHERS`
  ADD CONSTRAINT `PK_TEACHERS` -- 강사 기본키
    PRIMARY KEY (
      `TNO` -- 강사회원번호
    );

ALTER TABLE `TEACHERS`
  MODIFY COLUMN `TNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사회원번호';

-- 매니저
CREATE TABLE `MANAGERS` (
  `MNO`   INTEGER NOT NULL COMMENT '매니저회원번호', -- 매니저회원번호
  `MEMID` INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '매니저';

-- 매니저
ALTER TABLE `MANAGERS`
  ADD CONSTRAINT `PK_MANAGERS` -- 매니저 기본키
    PRIMARY KEY (
      `MNO` -- 매니저회원번호
    );

ALTER TABLE `MANAGERS`
  MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '매니저회원번호';

-- 학생
CREATE TABLE `STUDENTS` (
  `MEMID` INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  `SNO`   INTEGER     NOT NULL COMMENT '학생회원번호', -- 학생회원번호
  `COUR`  VARCHAR(30) NOT NULL COMMENT '교육과정', -- 교육과정
  `GRD`   CHAR(1)     NULL     COMMENT '졸업여부', -- 졸업여부
  `WORK`  CHAR(1)     NOT NULL COMMENT '재직여부', -- 재직여부
  `CNT`   VARCHAR(30) NOT NULL COMMENT '기수' -- 기수
)
COMMENT '학생';

-- 학생
ALTER TABLE `STUDENTS`
  ADD CONSTRAINT `PK_STUDENTS` -- 학생 기본키
    PRIMARY KEY (
      `SNO` -- 학생회원번호
    );

ALTER TABLE `STUDENTS`
  MODIFY COLUMN `SNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '학생회원번호';

-- 게시판
CREATE TABLE `BOARDS` (
  `BNO`   INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
  `BNM`   VARCHAR(100) NOT NULL COMMENT '이름', -- 이름
  `BCDT`  DATE         NOT NULL COMMENT '등록일', -- 등록일
  `BCNM`  VARCHAR(50)  NOT NULL COMMENT '작성자', -- 작성자
  `VW`    INTEGER      NULL     COMMENT '조회수', -- 조회수
  `CONT`  TEXT         NOT NULL COMMENT '내용', -- 내용
  `MEMID` INTEGER      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '게시판';

-- 게시판
ALTER TABLE `BOARDS`
  ADD CONSTRAINT `PK_BOARDS` -- 게시판 기본키
    PRIMARY KEY (
      `BNO` -- 게시물번호
    );

-- 게시판 인덱스
CREATE INDEX `IX_BOARDS`
  ON `BOARDS`( -- 게시판
    `BCDT` ASC -- 등록일
  );

ALTER TABLE `BOARDS`
  MODIFY COLUMN `BNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시물번호';

-- 회원 관리
CREATE TABLE `MEMBERS` (
  `MEMID` INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  `AUTH`  INTEGER      NOT NULL COMMENT '권한', -- 권한
  `NM`    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  `ADDRE` VARCHAR(255) NULL     COMMENT '주소', -- 주소
  `TEL`   VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
  `PHOTO` VARCHAR(255) NULL     COMMENT '사진', -- 사진
  `EMAIL` VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  `PWD`   VARCHAR(10)  NOT NULL COMMENT '비밀번호' -- 비밀번호
)
COMMENT '회원 관리';

-- 회원 관리
ALTER TABLE `MEMBERS`
  ADD CONSTRAINT `PK_MEMBERS` -- 회원 관리 기본키
    PRIMARY KEY (
      `MEMID` -- 회원번호
    );

-- 회원 관리 유니크 인덱스
CREATE UNIQUE INDEX `UIX_MEMBERS`
  ON `MEMBERS` ( -- 회원 관리
    `EMAIL` ASC -- 이메일
  );

ALTER TABLE `MEMBERS`
  MODIFY COLUMN `MEMID` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 파일
CREATE TABLE `BOARDFILE` (
  `FNM`   VARCHAR(50) NOT NULL COMMENT '파일명', -- 파일명
  `FTYP`  VARCHAR(30) NULL     COMMENT '파일타입', -- 파일타입
  `FSIZE` INTEGER     NULL     COMMENT '파일용량', -- 파일용량
  `APATH` TEXT        NULL     COMMENT '파일절대주소', -- 파일절대주소
  `RPATH` TEXT        NULL     COMMENT '파일상대주소', -- 파일상대주소
  `BNO`   INTEGER     NULL     COMMENT '게시물번호' -- 게시물번호
)
COMMENT '파일';

-- 파일
ALTER TABLE `BOARDFILE`
  ADD CONSTRAINT `PK_BOARDFILE` -- 파일 기본키
    PRIMARY KEY (
      `FNM` -- 파일명
    );

-- 프로젝트산출물
CREATE TABLE `PROJECTFILE` (
  `FNM`   VARCHAR(50) NOT NULL COMMENT '파일명', -- 파일명
  `FTYP`  VARCHAR(30) NULL     COMMENT '파일타입', -- 파일타입
  `FSIZE` INTEGER     NULL     COMMENT '파일용량', -- 파일용량
  `APATH` TEXT        NULL     COMMENT '파일절대주소', -- 파일절대주소
  `RPATH` TEXT        NULL     COMMENT '파일상대주소', -- 파일상대주소
  `PCD`   INTEGER     NULL     COMMENT '프로젝트번호' -- 프로젝트번호
)
COMMENT '프로젝트산출물';

-- 프로젝트산출물
ALTER TABLE `PROJECTFILE`
  ADD CONSTRAINT `PK_PROJECTFILE` -- 프로젝트산출물 기본키
    PRIMARY KEY (
      `FNM` -- 파일명
    );

-- 그룹
CREATE TABLE `GROUP` (
  `PCD` INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  `SNO` INTEGER NOT NULL COMMENT '학생회원번호' -- 학생회원번호
)
COMMENT '그룹';

-- 그룹
ALTER TABLE `GROUP`
  ADD CONSTRAINT `PK_GROUP` -- 그룹 기본키
    PRIMARY KEY (
      `PCD`, -- 프로젝트번호
      `SNO`  -- 학생회원번호
    );

-- 프로젝트
ALTER TABLE `PROJECTS`
  ADD CONSTRAINT `FK_STUDENTS_TO_PROJECTS` -- 학생 -> 프로젝트
    FOREIGN KEY (
      `SNO` -- 학생회원번호
    )
    REFERENCES `STUDENTS` ( -- 학생
      `SNO` -- 학생회원번호
    );

-- 강사
ALTER TABLE `TEACHERS`
  ADD CONSTRAINT `FK_MEMBERS_TO_TEACHERS` -- 회원 관리 -> 강사
    FOREIGN KEY (
      `MEMID` -- 회원번호
    )
    REFERENCES `MEMBERS` ( -- 회원 관리
      `MEMID` -- 회원번호
    );

-- 매니저
ALTER TABLE `MANAGERS`
  ADD CONSTRAINT `FK_MEMBERS_TO_MANAGERS` -- 회원 관리 -> 매니저
    FOREIGN KEY (
      `MEMID` -- 회원번호
    )
    REFERENCES `MEMBERS` ( -- 회원 관리
      `MEMID` -- 회원번호
    );

-- 학생
ALTER TABLE `STUDENTS`
  ADD CONSTRAINT `FK_MEMBERS_TO_STUDENTS` -- 회원 관리 -> 학생
    FOREIGN KEY (
      `MEMID` -- 회원번호
    )
    REFERENCES `MEMBERS` ( -- 회원 관리
      `MEMID` -- 회원번호
    );

-- 게시판
ALTER TABLE `BOARDS`
  ADD CONSTRAINT `FK_MEMBERS_TO_BOARDS` -- 회원 관리 -> 게시판
    FOREIGN KEY (
      `MEMID` -- 회원번호
    )
    REFERENCES `MEMBERS` ( -- 회원 관리
      `MEMID` -- 회원번호
    );

-- 파일
ALTER TABLE `BOARDFILE`
  ADD CONSTRAINT `FK_BOARDS_TO_BOARDFILE` -- 게시판 -> 파일
    FOREIGN KEY (
      `BNO` -- 게시물번호
    )
    REFERENCES `BOARDS` ( -- 게시판
      `BNO` -- 게시물번호
    );

-- 프로젝트산출물
ALTER TABLE `PROJECTFILE`
  ADD CONSTRAINT `FK_PROJECTS_TO_PROJECTFILE` -- 프로젝트 -> 프로젝트산출물
    FOREIGN KEY (
      `PCD` -- 프로젝트번호
    )
    REFERENCES `PROJECTS` ( -- 프로젝트
      `PCD` -- 프로젝트번호
    );

-- 그룹
ALTER TABLE `GROUP`
  ADD CONSTRAINT `FK_STUDENTS_TO_GROUP` -- 학생 -> 그룹
    FOREIGN KEY (
      `SNO` -- 학생회원번호
    )
    REFERENCES `STUDENTS` ( -- 학생
      `SNO` -- 학생회원번호
    );

-- 그룹
ALTER TABLE `GROUP`
  ADD CONSTRAINT `FK_PROJECTS_TO_GROUP` -- 프로젝트 -> 그룹
    FOREIGN KEY (
      `PCD` -- 프로젝트번호
    )
    REFERENCES `PROJECTS` ( -- 프로젝트
      `PCD` -- 프로젝트번호
    );