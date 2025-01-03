SELECT CONCAT('/home/grep/src/' , u.BOARD_ID ,'/', f.FILE_ID , f.FILE_NAME , f.FILE_EXT) as FILE_PATH
FROM USED_GOODS_BOARD u
JOIN USED_GOODS_FILE f ON f.BOARD_ID = u.BOARD_ID
WHERE (
    SELECT VIEWS
    FROM USED_GOODS_BOARD u1 
    ORDER BY VIEWS DESC
    LIMIT 1
) = u.VIEWS
ORDER BY f.FILE_ID DESC;