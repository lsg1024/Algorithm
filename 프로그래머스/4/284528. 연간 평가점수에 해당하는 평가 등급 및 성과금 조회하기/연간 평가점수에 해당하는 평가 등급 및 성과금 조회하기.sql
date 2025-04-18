WITH TOTAL_SCORE AS (
    SELECT 
        HG.EMP_NO, 
        AVG(HG.SCORE) AS SCORE
    FROM HR_GRADE HG
    GROUP BY HG.EMP_NO
),
EMP_GRADE AS (
    SELECT
        TS.EMP_NO,
        CASE 
            WHEN TS.SCORE >= 96 THEN 'S'
            WHEN TS.SCORE >= 90 THEN 'A'
            WHEN TS.SCORE >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM TOTAL_SCORE TS
)
SELECT 
    HE.EMP_NO,
    HE.EMP_NAME,
    G.GRADE,
    CASE
        WHEN G.GRADE = 'S' THEN HE.SAL * 0.2
        WHEN G.GRADE = 'A' THEN HE.SAL * 0.15
        WHEN G.GRADE = 'B' THEN HE.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM EMP_GRADE G
JOIN HR_EMPLOYEES HE
    ON HE.EMP_NO = G.EMP_NO
ORDER BY
    EMP_NO ASC