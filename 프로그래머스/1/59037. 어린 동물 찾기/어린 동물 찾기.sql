-- 코드를 입력하세요
SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AI
WHERE AI.INTAKE_CONDITION != 'Aged'
ORDER BY AI.ANIMAL_ID
