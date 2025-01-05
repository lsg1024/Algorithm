SELECT
    AI.ANIMAL_ID,
    AI.ANIMAL_TYPE,
    AI.NAME
FROM
    ANIMAL_INS AI
JOIN
    ANIMAL_OUTS AO
ON
    AI.ANIMAL_ID = AO.ANIMAL_ID AND 
    AI.SEX_UPON_INTAKE IN ('Intact Male', 'Intact Female') AND
    AO.SEX_UPON_OUTCOME IN ('Neutered Male', 'Spayed Female')
    