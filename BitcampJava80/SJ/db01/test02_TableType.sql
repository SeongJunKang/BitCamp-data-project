/*
 *  not null , unique , default , primary key
 */
1.테이블 생성
drop table test01;
create table test01(
    tno int,
    name char(5)
);
2.값 입력
/*
 * 컬럼을 지정하지 않는 경우,
 * create table에 선언된 순서대로 모든 컬럼의 값을 지정해야 한다.
 */
insert into 테이블명(컬럼명, 컬럼명,...) values(값,값,...);

insert into test01 values('hong',1);    /*tno 값이 0이 됨*/
insert into test01 values(2,'park');    /* ok */
insert into test01 values(3);           /* Fail */
/*
 * 특정 컬럼의 값 입력을 생략한 경우,
 * null 값으로 설정된다.
 */
insert into test01(tno) values(3);
insert into test01(name) values("홍길동");

3. 특정 컬럼을 필수 입력 컬럼으로 만드는 방법.
=> 컬럼선언에 not null 선언을 붙인다.
=> MySQL 의 경우 not null 컬럼의 값을 생략하면 그 타입의 기본 값이 저장된다.
int : 0 , char : 빈문자열
예 ) tno 컬럼을 필수 입력 컬럼으로 만든다.
drop table test01;
create table test01(
    tno int unique,
    name char(5) not null
);

4. 특정 컬럼의 값이 중복되지 않게 만드는 방법.
=> unique 옵션을 붙인다.
=> 값이 중복되면 오류 발생. 값이 없으면 중복 여부를 검사하지 않는다.

insert into test01(name,tno) values('홍길동',1);
insert into test01(name,tno) values('임꺽정',2);
insert into test01(name,tno) values('이순신',1);  /*값 중복 오류*/
insert into test01(name) values('이순신'); /*Null 값은 값의 중복으로 취급 안하기 때문에 허용*/
insert into test01(name) values('이순신');

5. 특정 컬럼의 값이 중복되지 않게 만드는 방법.
=> unique 옵션을 붙인다.
> 컬럼선언에 not null 선언을 붙인다.
drop table test01;
create table test01(
    tno int unique not null,
    name char(5) not null
);
insert into test01(name,tno) values('홍길동',1);
insert into test01(name,tno) values('임꺽정',2);
insert into test01(name,tno) values('이순신',1);  /*값 중복 오류*/
insert into test01(name) values('이순신'); /*첫번째는 int의 기본값인 0이 들어간다.*/
insert into test01(name) values('이순신'); /*두번째도 0이 들어가기 때문에 중복으로 오류발생*/

6. 값을 입력하지 않으면 지정한 값으로 자동으로 넣는 방법
=> default 옵션을 사용한다.

create table test01(
    tno int unique not null,
    name char(5) default '홍길동'
);

insert into test01(tno) values(3);

7.unique 중에서 data를 구분할 때 사용할 컬럼은 값이 없어서는 안된다. 
=> unique 에 not null 을 추가하라.
drop table test01;
create table test01(
    tno int unique,
    name char(5) default '홍길동',
    email char(20) unique
);

insert into test01(name,tno) values('홍길동',1);
insert into test01(name,tno) values('임꺽정',2);
insert into test01(name,email) values('이순신','lee@'); 
insert into test01(name,email) values('강감찬','kang@'); 
insert into test01(name,tno) values('임꺽정',2);
insert into test01(name,email) values('임꺽정','leem@');
insert into test01(name,email) values('강감찬','kang@0');
insert into test01(name,tno) values('강감찬',3);
insert into test01(name) values('강감찬');
/*이름이 같기 때문에 강감찬 중에 한개만 골라서 삭제할 때 어렵다.*/

=> 레코드(테이블에 들어 있는 값)를 구분하기 위한 조건
1) 해당 컬럼의 값이 중복되어서는 안된다.
2) null 허용해서는 안된다 => null을 허용하면 구분할 수가 없다.
예) 회원 번호를 레코드 구분 컬럼으로 사용한다면 다음과 같이 선언하라!

drop table test01;
create table test01(
    tno int unique not null,
    name char(5) default '홍길동',
    email char(20) unique
);

insert into test01(name,tno) values('홍길동',1);
insert into test01(name,tno) values('임꺽정',2);
insert into test01(name,email) values('이순신','lee@');    /* tno 는 0이 됨*/
insert into test01(name,email) values('강감찬','kang@');    /* tno 는 0이 됨*/
insert into test01(tno,name,email) values(3,'이순정','lee@');

=> 결론 :
1) 값이 중복되어서는 안되는 컬럼은 unique로 선언한다.
2) 레코드를 구분할 때 사용할 컬럼은 unique + not null 로 선언하라!


8. 레코드를 식별하는 컬럼에 대해 unique not null 대신 단축 문법
=> primary key -> 어느 컬럼이 식별자로 사용되는지 빠르게 알 수 있다.
=> unique not null 과 같다.
drop table test01;
create table test01(
    tno int primary key,
    name char(5) default '홍길동',
    email char(20) unique
);
insert into test01(name,email) values('이순신','lee@');    /* tno 는 0이 됨*/
insert into test01(name,email) values('강감찬','kang@');    /* tno 는 0이 됨*/
insert into test01(tno,name,email) values(3,'이순정','leem@');