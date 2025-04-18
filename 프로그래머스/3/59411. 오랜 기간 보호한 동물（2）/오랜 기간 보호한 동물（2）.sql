WITH TOP_2 AS (
SELECT
    AI.ANIMAL_ID,
    AI.NAME,
    DATEDIFF(AO.DATETIME, AI.DATETIME) AS DATE
FROM 
    ANIMAL_INS AI
JOIN
    ANIMAL_OUTS AO
ON
    AI.ANIMAL_ID = AO.ANIMAL_ID
ORDER BY
    DATE DESC
LIMIT 2
)
SELECT
    T.ANIMAL_ID,
    T.NAME
FROM
    TOP_2 T
    