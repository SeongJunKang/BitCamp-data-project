주제: 서브쿼리

1. select 절의 서브쿼리 사용
SELECT LNO,TITL,RNO FROM LECTS;

=> 서브쿼리를 이용하여 강의실 이름 출력하기
=> SELECT 각 레코드에 대해 서브쿼리를 실행하기 때문에 성능이 안좋다.
SELECT LNO,TITL,(SELECT RNM FROM ROOMS WHERE RNO=L.RNO) ROOM
FROM LECTS L;

2. from 절에 서브쿼리 사용
SELECT LNO, TITL, RNM
FROM LECTS L, (SELECT RNO, RNM FROM ROOMS WHERE RNM NOT LIKE '종로%') R
WHERE L.RNO=R.RNO;

3. where 절에 서브쿼리 사용
SELECT LNO,TITL
FROM LECTS L
WHERE L.RNO IN (SELECT RNO FROM ROOMS WHERE RNM LIKE '강남%');











