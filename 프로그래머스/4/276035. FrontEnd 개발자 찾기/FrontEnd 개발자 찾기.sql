WITH FE AS (
    SELECT
        *
    FROM
        SKILLCODES
    WHERE
        CATEGORY = 'Front End'
)

SELECT
    DISTINCT ID
    , EMAIL
    , FIRST_NAME
    , LAST_NAME
FROM
    DEVELOPERS A
    INNER JOIN FE B
        ON A.SKILL_CODE & B.CODE
ORDER BY
    ID

    