SELECT CH.CAR_ID, 
    CASE 
        WHEN MAX(CH.START_DATE <= '2022-10-16' AND CH.END_DATE >= '2022-10-16') THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CH
GROUP BY CH.CAR_ID
ORDER BY CH.CAR_ID DESC;