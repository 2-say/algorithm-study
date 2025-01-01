-- 코드를 작성해주세요

SELECT
    ID,
    CASE
        WHEN rs.RANKING / rs.len  <= 0.25 THEN 'CRITICAL'
        WHEN rs.RANKING / rs.len  <= 0.5 THEN 'HIGH'
        WHEN rs.RANKING / rs.len  <= 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
     END AS COLONY_NAME
FROM 
    (SELECT
        *,
        RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS RANKING, 
        (SELECT COUNT(*) FROM ECOLI_DATA) as len
    FROM ECOLI_DATA) rs
ORDER BY ID
;