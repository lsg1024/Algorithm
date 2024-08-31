-- 코드를 입력하세요
SELECT os.USER_ID, os.PRODUCT_ID
FROM ONLINE_SALE os
group by os.user_id, os.PRODUCT_ID
having count(*) > 1
order by os.USER_ID ASC, os.PRODUCT_ID DESC