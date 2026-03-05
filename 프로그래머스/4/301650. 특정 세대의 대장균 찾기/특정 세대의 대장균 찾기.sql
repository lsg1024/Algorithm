select
    F.ID
from ECOLI_DATA F
join ECOLI_DATA S on F.PARENT_ID = S.ID
join ECOLI_DATA A on S.PARENT_ID = A.ID
where A.PARENT_ID is null
order by F.ID 