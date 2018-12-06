주제: SELECT

1. DISTINCT
=> 중복 값 제거.
SELECT LNO FROM LEC_APPL; /*중복 제거 전*/
SELECT DISTINCT LNO FROM LEC_APPL;/*중복 제거 후*/
SELECT ALL LNO FROM LEC_APPL;/*중복 제거 안함 => 안적으면 기본 == 중복제거 전*/

2.ORDER BY
=> 결과를 정렬
=> 실행 순서 : FROM ==> WHERE ==> ORDER BY ==> SELECT
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNO ASC;
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNO;        /*기본이 ASC 오름차순 (A->Z, ㄱ->ㅎ)*/
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNO DESC;   /*NO 내림차순 */
SELECT MNM, EMAIL FROM MEMBS ORDER BY MNM DESC;   /*NAME 내림차순 */

SELECT * FROM LEC_APPL ORDER BY LNO DESC,MNO DESC;
/*LNO 내림차순 후, MNO 내림차순*/
SELECT * FROM LEC_APPL ORDER BY LNO ASC,MNO DESC;
/*LNO 오름차순 후, MNO 내림차순*/

3.AS
=> 출력 컬럼에 별명 부여
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') FROM MEMBS;
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') AS memberInfo FROM MEMBS;
/*별명을 부여*/
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') memberInfo FROM MEMBS;
/*AS 생략 가능*/
SELECT MNO, CONCAT(MNM,'(',EMAIL,')') memberInfo FROM MEMBS ORDER BY memberInfo;

4.UNION
=> 두 결과의 합집합
SELECT MNM, '학생' FROM MEMBS
UNION
SELECT TNM, '강사' FROM TEACHS;
/*컬럼의 개수가 일치하면 두 결과의 합집합을 출력*/

SELECT MNM, '학생' FROM MEMBS
UNION
SELECT TNM, '강사', EMAIL FROM TEACHS;
/*오류 ! 컬럼의 개수가 일치하지 않음*/

SELECT LNO, '수강신청' FROM LEC_APPL;
SELECT LNO, '강의과목' FROM TEA_ASSIGN;

SELECT LNO FROM LEC_APPL
UNION
SELECT LNO FROM TEA_ASSIGN;
/*집합은 중복 데이터를 허용하지 않는다. (자동 중복제거)*/

4-2. UNION ALL
=> 중복 데이터 제거 안함.
SELECT LNO FROM LEC_APPL
UNION ALL
SELECT LNO FROM TEA_ASSIGN;

5. projection(결과 컬럼 선택)/selection(조건으로 선택)
=>selection : 전체 데이터에서 해당 조건에 맞는 데이터를 선택한다는 의미.
SELECT * from MEMBS WHERE WORK='N';

=>projection : selection 데이터에서 출력 결과 컬럼을 선택한다는 의미.
SELECT MNO,MNM from MEMBS WHERE WORK='N';























