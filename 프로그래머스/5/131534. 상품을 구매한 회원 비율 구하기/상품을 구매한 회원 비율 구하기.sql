WITH TOTAL_SALE AS (
    SELECT 
        YEAR(OS.SALES_DATE) AS YEAR,
        MONTH(OS.SALES_DATE) AS MONTH,
        COUNT(DISTINCT OS.USER_ID) AS PURCHASED_USERS
    FROM 
        ONLINE_SALE OS
    JOIN
        USER_INFO UI
    ON 
        UI.USER_ID = OS.USER_ID AND
        UI.JOINED LIKE '2021%'
    GROUP BY
        MONTH(OS.SALES_DATE)
), 
TOTAL_USER AS (
    SELECT
        COUNT(*) AS TOTAL_COUNT
    FROM
        USER_INFO UI
    WHERE
        UI.JOINED LIKE '2021%'
)
SELECT 
    TS.YEAR,
    TS.MONTH,
    TS.PURCHASED_USERS,
    ROUND(TS.PURCHASED_USERS / TU.TOTAL_COUNT, 1) AS PUCHASED_RATIO
FROM 
    TOTAL_SALE TS
CROSS JOIN
    TOTAL_USER TU
ORDER BY 
    TS.YEAR, 
    TS.MONTH;