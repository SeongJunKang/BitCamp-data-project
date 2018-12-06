주제: SELECT

1. DISTINCT
=> 중복 값 제거
SELECT LNO FROM LEC_APPL; /* 중복 제거 전*/
SELECT DISTINCT LNO FROM LEC_APPL; /* 중복 제거 후*/
SELECT ALL LNO FROM LEC_APPL; /* 중복 제거 안함 => 기본이다.*/

2. ORDER BY
=> 결과를 정렬
=> 실행순서: FROM ==> WHERE ==> GROUP BY ==> HAVING ==> SELECT ==> ORDER BY
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNO ASC; /* 오름 차순(A->Z, ㄱ->ㅎ). ascendent*/
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNO;  /* 기본이 ASC */
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNO DESC; /* 내림차순. descendent*/
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNM DESC;

SELECT * FROM LEC_APPL ORDER BY LNO DESC, MNO DESC;
SELECT * FROM LEC_APPL ORDER BY LNO ASC, MNO DESC;

3. AS
=> 출력 컬럼에 별명 부여 
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') FROM MEMBS;
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') AS memberInfo FROM MEMBS;
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') memberInfo FROM MEMBS; /* AS 생략 가능 */
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') memberInfo FROM MEMBS ORDER BY memberInfo;

4. UNION
=> 두 결과의 합집합. 중복 데이터는 제거된다.
=> 두 결과의 컬럼 개수가 일치해야 한다.
SELECT MNM, '학생' FROM MEMBS
UNION
SELECT TNM, '강사' FROM TEACHS;

/* 중복 데이터 제거 확인하라! */
SELECT LNO FROM LEC_APPL
UNION
SELECT LNO FROM TEA_ASSIGN;

4. UNION ALL
=> 중복 데이터 제거 안함.
SELECT LNO FROM LEC_APPL
UNION ALL
SELECT LNO FROM TEA_ASSIGN;

5. projection(결과 컬럼 선택)/selection(조건으로 선택)
=> selection: 전체 데이터에서 해당 조건에 맞는 데이터를 선택한다는 의미.
SELECT * FROM MEMBS WHERE WORK='N';

=> projection: selection 데이터에서 출력 결과 컬럼을 선택한다는 의미.
SELECT MNO,MNM FROM MEMBS WHERE WORK='N';






