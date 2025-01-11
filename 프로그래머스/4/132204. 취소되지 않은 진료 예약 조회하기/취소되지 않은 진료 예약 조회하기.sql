SELECT
    A.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    A.MCDP_CD,
    D.DR_NAME,
    A.APNT_YMD
FROM (
    SELECT
        *
    FROM 
        APPOINTMENT
    WHERE
        APNT_CNCL_YN = 'N' AND
        APNT_YMD LIKE '2022-04-13%' AND
        MCDP_CD = 'CS'
) A
JOIN
    PATIENT P
ON
    P.PT_NO = A.PT_NO
JOIN
    DOCTOR D
ON
    D.DR_ID = A.MDDR_ID
ORDER BY
    A.APNT_YMD 