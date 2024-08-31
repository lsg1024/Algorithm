-- 코드를 입력하세요
SELECT dr.DR_NAME, dr.DR_ID, dr.MCDP_CD, DATE_FORMAT(dr.HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
from DOCTOR dr
where MCDP_CD IN ('CS', 'GS')
order by HIRE_YMD DESC, DR_NAME ASC