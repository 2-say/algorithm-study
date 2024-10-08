SELECT 
    C.CAR_ID, 
    C.CAR_TYPE, 
    FLOOR(C.DAILY_FEE * 30 * (1 - pl.DISCOUNT_RATE / 100)) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR c
LEFT JOIN 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY hi ON hi.CAR_ID = c.CAR_ID
    AND hi.END_DATE >= '2022-11-01'
JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN pl ON pl.CAR_TYPE = c.CAR_TYPE
    AND pl.DURATION_TYPE ='30일 이상'
WHERE
    c.CAR_TYPE IN ('세단', 'SUV')
    AND hi.HISTORY_ID IS NULL
HAVING 
    FEE >= 500000 AND FEE < 2000000
ORDER BY 
    FEE DESC, 
    c.CAR_TYPE ASC, 
    c.CAR_ID DESC;

