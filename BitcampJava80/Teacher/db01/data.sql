/* 강사 데이터 */
insert into TEACHS(TNM,TEL,EMAIL) values('김강사', '111-1111', 'kim@test.com');
insert into TEACHS(TNM,TEL,EMAIL) values('이강사', '111-1112', 'lee@test.com');
insert into TEACHS(TNM,TEL,EMAIL) values('박강사', '111-1113', 'park@test.com');
insert into TEACHS(TNM,TEL,EMAIL) values('명강사', '111-1114', 'myeung@test.com');
insert into TEACHS(TNM,TEL,EMAIL) values('송강사', '111-1115', 'song@test.com');

/* 과정 데이터 */
insert into LECTS(TITL,DESCT,ST_DT,EN_DT,DAY_HR,TOT_HR,FI_DT)
values('자바프로그래밍','80기','2016-1-1','2016-5-30',8,960,'2015-12-20');
insert into LECTS(TITL,DESCT,ST_DT,EN_DT,DAY_HR,TOT_HR,FI_DT)
values('자바프로그래밍2','81기','2016-2-1','2016-6-30',8,960,'2016-1-20');
insert into LECTS(TITL,DESCT,ST_DT,EN_DT,DAY_HR,TOT_HR,FI_DT)
values('윈도프로그래밍','45기','2016-1-20','2016-6-19',8,960,'2016-1-10');
insert into LECTS(TITL,DESCT,ST_DT,EN_DT,DAY_HR,TOT_HR,FI_DT)
values('IoT프로그래밍','3기','2016-3-5','2016-8-2',8,960,'2016-2-20');

/* 강사 배정 데이터 */
insert into TEA_ASSIGN(LNO,TNO) values(1,2);
insert into TEA_ASSIGN(LNO,TNO) values(1,3);
insert into TEA_ASSIGN(LNO,TNO) values(2,1);
insert into TEA_ASSIGN(LNO,TNO) values(3,4);
insert into TEA_ASSIGN(LNO,TNO) values(3,5);

/* 강의실 데이터 */
insert into ROOMS(RNO,RNM) values('K301', '강남 301호'); 
insert into ROOMS(RNO,RNM) values('K303', '강남 303호'); 
insert into ROOMS(RNO,RNM) values('K401', '강남 401호'); 
insert into ROOMS(RNO,RNM) values('K501', '강남 501호'); 
insert into ROOMS(RNO,RNM) values('J801', '종로 801호'); 
insert into ROOMS(RNO,RNM) values('J802', '종로 802호'); 

/* 과정에 강의장 배정 */
update LECTS set RNO='K301' where LNO=1;
update LECTS set RNO='K303' where LNO=3;
update LECTS set RNO='J801' where LNO=4;

/* 회원 데이터 */
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('홍길동','222-2221','hong@test.com','N');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('임꺽정','222-2222','leem@test.com','N');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('이순신','222-2223','lss@test.com','N');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('강감찬','222-2224','kkch@test.com','N');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('권율','222-2225','kwon@test.com','N');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('이율곡','222-2226','llk@test.com','Y');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('유관순','222-2227','yoo@test.com','Y');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('김구','222-2228','kk@test.com','Y');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('윤봉길','222-2229','ybk@test.com','Y');
insert into MEMBS(MNM,TEL,EMAIL,WORK) values('안중근','222-2220','ajk@test.com','Y');

/* 수강신청 데이터 */
insert into LEC_APPL(LNO,MNO,AP_TYP,CR_DT) values(1,1,'취업성공','2015-12-10');
insert into LEC_APPL(LNO,MNO,AP_TYP,CR_DT) values(1,2,'취업성공','2015-12-11');
insert into LEC_APPL(LNO,MNO,AP_TYP,CR_DT) values(1,6,'일반','2015-12-12');
insert into LEC_APPL(LNO,MNO,AP_TYP,CR_DT) values(3,3,'취업성공','2016-1-5');
insert into LEC_APPL(LNO,MNO,AP_TYP,CR_DT) values(4,4,'일반','2016-1-13');
insert into LEC_APPL(LNO,MNO,AP_TYP,CR_DT) values(4,7,'일반','2016-1-14');





