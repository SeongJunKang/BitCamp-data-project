주제: 숫자가 자동으로 증가하는 컬럼 만들기

1. create table 에서 지정하기
=> auto_increment 컬럼은 반드시 키 컬럼이어야 한다.
drop table test01;
create table test01(
  tno int primary key auto_increment,
  name char(5)
);

insert into test01(name) values('홍길동');
insert into test01(name) values('홍길동2');
insert into test01(name) values('홍길동3');

2. alter table 로 지정하기
drop table test01;
create table test01(
  tno int,
  name char(5)
);

alter table test01
  add constraint test01_pk primary key (tno);


/* auto_increment는 키 컬럼에 대해 지정할 수 있다.*/
alter table test01
	modify column tno int not null auto_increment;



  
  
  
  
  
  
  
  