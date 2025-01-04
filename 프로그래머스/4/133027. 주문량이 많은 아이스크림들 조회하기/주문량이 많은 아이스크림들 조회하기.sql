WITH TOTAL_ORDER AS (
    SELECT
        FH.FLAVOR,
        SUM(J.TOTAL_ORDER + FH.TOTAL_ORDER) AS TOTAL
    FROM 
        FIRST_HALF FH
    JOIN 
        JULY J
    ON
        FH.FLAVOR = J.FLAVOR
    GROUP BY
        FH.FLAVOR
    ORDER BY
        TOTAL DESC
    LIMIT 3
)
SELECT
    TTO.FLAVOR
FROM
    TOTAL_ORDER TTO

# SELECT
#     FH.*,
#     J.*
# FROM 
#     FIRST_HALF FH
# JOIN 
#     JULY J
# ON
#     FH.SHIPMENT_ID = J.SHIPMENT_ID