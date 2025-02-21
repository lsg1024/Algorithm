-- 코드를 작성해주세요
WITH T1 AS (
    SELECT
        SUM(CODE) AS CODE
    FROM
        SKILLCODES
    WHERE CATEGORY = 'Front End'
)

SELECT 
    T2.*
FROM (
    SELECT 
        CASE
            WHEN (SKILL_CODE & (SELECT CODE FROM T1)) > 0 AND (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')) > 0 THEN 'A'
            WHEN (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')) > 0 THEN 'B'
            WHEN (SKILL_CODE & (SELECT CODE FROM T1)) > 0 THEN 'C'
            ELSE NULL
        END AS GRADE,
        ID,
        EMAIL
    FROM 
        DEVELOPERS
    ORDER BY
        GRADE,
        ID
) T2
WHERE T2.GRADE IS NOT NULL