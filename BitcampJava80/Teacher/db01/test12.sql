주제: GROUP BY

1. COUNT(*)
SELECT COUNT(*) FROM MEMBS;

2. 특정 컬럼에 대해 같은 값을 갖는 레코드를 묶어서 개수를 센다.
SELECT WORK, COUNT(*) FROM MEMBS GROUP BY WORK;



