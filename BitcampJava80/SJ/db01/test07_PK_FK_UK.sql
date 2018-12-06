주제: PK,FK,UK를 지정하는 다양한 방법
1. create table 에서 지정하기 
drop table test01;
create table test01(
  tno int primary key,
  name char(5)
);

2. create table의 제약조건 설정 부분에서 지정하기
drop table test01;
create table test01(
  tno int,
  name char(5),
  constraint test01_pk primary key (tno)
);
  
3. alter table 에서 primary key 지정하기
=> 실무에서는 이 방법을 많이 사용한다.
drop table test01;
create table test01(
  tno int,
  name char(5)
);

alter table test01
  add constraint test01_pk primary key (tno);
  
alter table test01
  add constraint test01_uq unique (name);
  
4. FK를 지정하는 방법
drop table team;
drop table member;
create table member(
  mno int,
  name varchar(50),
  teamno int
);

create table team(
  tno int,
  name varchar(50)
);

alter table member
  add constraint member_pk primary key (mno);

alter table team
  add constraint team_pk primary key (tno);
  
alter table member
  modify name varchar(50) not null;

alter table member
  modify teamno int not null;

alter table team
  modify name varchar(50) not null;

/* 존재하지 않는 팀 번호를 넣을 수 있다. => 데이터에 결함이 발생 */
insert into member values(1,'홍길동',100);

/* member의 teamno 컬럼에 반드시 team 테이블의 존재하는 PK 값을 넣도록 제약을 가해야 한다.*/
alter table member
  add constraint member_team_fk foreign key (teamno) references team (tno);

/* member 에서 팀 번호를 사용하려면 먼저 팀을 데이터를 추가해야 한다.*/
insert into team values(100, '오호라팀');
insert into team values(200, '우헤헤팀');

/* 존재하는 팀 번호를 넣을 때만 회원 정보 입력이 가능하다*/
insert into member values(1, '홍길동', 100);

/* 팀 삭제*/
delete from team where tno=200; /* OK */
delete from team where tno=100; /* 자식 테이블에서 이 데이터를 참조하기 때문에 오류! */

/* 자식테이블의 데이터를 모두 지운 다음에, 부모 테이블의 데이터를 지울 수 있다.*/
delete from member where mno=1; /* 부모 테이블의 데이터를 참조하는 자식 테이블의 데이터를 먼저 지운다.*/
delete from team where tno=100; /* 부모 테이블의 데이터를 지운다*/







  
  
  
  
  
  
  
  