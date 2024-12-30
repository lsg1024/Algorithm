SELECT
    CASE 
        WHEN GROUP_CONCAT(S.NAME) LIKE ('%Python%') AND GROUP_CONCAT(S.CATEGORY) LIKE ("%Front%") THEN "A"
        WHEN GROUP_CONCAT(S.NAME) LIKE ('%C#%') THEN "B"
        WHEN GROUP_CONCAT(S.CATEGORY) LIKE ('%Front%') THEN "C"
        END AS GRADE,
    D.ID,
    D.EMAIL
FROM 
    DEVELOPERS AS D
JOIN 
    SKILLCODES AS S
ON 
    (D.SKILL_CODE & S.CODE = S.CODE)
GROUP BY
    D.ID,
    D.EMAIL
HAVING
    GRADE IS NOT NULL
ORDER BY
    GRADE ASC,
    D.ID ASC;


    

    