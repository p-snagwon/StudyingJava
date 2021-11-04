SHOW TABLES;
	
DESC usertbl;

USE employees;

DESC employees;

SELECT userID, Name FROM usertbl WHERE birthYear >= 1970 AND height >= 182;

SELECT name, height FROM usertbl WHERE height > (SELECT height FROM usertbl WHERE name = '김경호');

SELECT name, height FROM usertbl
	WHERE height >= ANY (SELECT height FROM usertbl WHERE addr = '경남');
    
SELECT name, mDate FROM usertbl ORDER BY mDate;
SELECT name, mDate FROM usertbl ORDER BY mDate DESC;

SELECT name, height FROM usertbl ORDER BY height DESC, name ASC;

SELECT DISTINCT addr FROM usertbl;

SELECT emp_no, hire_date FROM employees
	ORDER BY hire_date ASC
    LIMIT 5;
    
USE sqldb;

CREATE TABLE buytbl2 (SELECT * FROM buytbl);
SELECT * FROM buytbl2;

CREATE TABLE buytbl3 (SELECT userID, prodName FROM buytbl);
SELECT * FROM buytbl3;
DROP TABLE buytbl2;

SELECT userID, SUM(amount) FROM buytbl GROUP BY userID;

SELECT userID AS '사용자 아이디', SUM(amount) AS '총 구매 개수' 
	FROM buytbl GROUP BY userID;
    
SELECT userID AS '사용자 아이디', SUM(price*amount) AS '총 구매액'
	FROM buytbl GROUP BY userID;
    
SELECT AVG(amount) AS '평균 구매 개수' FROM buytbl;

SELECT userID AS '사용자', AVG(amount) FROM buytbl GROUP BY userID;

SELECT name, MAX(height), Min(height) FROM usertbl;

SELECT name, height
	FROM usertbl
    WHERE height = (SELECT MAX(height) FROM usertbl)
    OR height = (SELECT MIN(height) FROM usertbl)
    ORDER BY height DESC;
    
SELECT COUNT(*) FROM usertbl;

SELECT COUNT(mobile1) AS '휴대폰이 있는 사용자' FROM usertbl;

SELECT userID AS '사용자', SUM(price*amount) AS '총 구매액'
	FROM buytbl
    GROUP BY userID
    HAVING SUM(price *amount) > 1000;
    
CREATE TABLE testTbl1 (id int, userName char(3), age int);
INSERT INTO testTbl1 VALUES (1, '홍길동', 25);

INSERT INTO testTbl1(id, username) VALUES (2, '설현');

SELECT * FROM testTbl1;

CREATE TABLE testTbl2
	(id int AUTO_INCREMENT PRIMARY KEY,
	 userName char(3),
     age int);
INSERT INTO testTbl2 VALUES(NULL, '지민', 25);
INSERT INTO testTbl2 VALUES(NULL, '유나', 22);
INSERT INTO testTbl2 VALUES(NULL,'유경', 21);

SELECT * FROM testTbl2;
ALTER TABLE testTbl2 AUTO_INCREMENT=100;
INSERT INTO testTbl2 VALUES(NULL,'훈', 21);

CREATE TABLE testTbl3
	(id int AUTO_INCREMENT PRIMARY KEY,
     username char(3),
     age int );
ALTER TABLE testTbl3 AUTO_INCREMENT = 1000;
SET @@auto_increment_increment = 3;
INSERT INTO testTbl3 VALUES(NULL, '나연', 20), (NULL, '정연', 20), (NULL, '모모', 30);
SELECT * FROM testTbl3;

CREATE TABLE testTbl4 (id int, Fname varchar(50), Lname varchar(50));
INSERT INTO testTbl4
	SELECT emp_no, first_name, last_name
		from employees.employees;
SELECT * FROM testTbl4;

CREATE TABLE testTbl5
	(SELECT emp_no, first_name, last_name FROM employees.employees);
    
SELECT * FROM testTbl5;

UPDATE testTbl4
	SET Lname = '없음'
    WHERE Fname = 'Kyoichi';
    
SELECT * FROM testTbl4;

UPDATE buytbl SET price = price * 1.5;

SELECT * FROM buytbl;

DELETE FROM testTbl4 WHERE Fname = 'Aamer' LIMIT 5;

DELETE FROM testTbl4 WHERE Fname = 'Aamer';

CREATE TABLE bigTbl1 (SELECT * FROM employees.employees);
CREATE TABLE bigTbl2 (SELECT * FROM employees.employees);
CREATE TABLE bigTbl3 (SELECT * FROM employees.employees);

DELETE FROM bigTbl1;
DROP TABLE bigTbl2;
TRUNCATE TABLE bigTbl3;

CREATE TABLE memberTBL (SELECT userID, name, addr FROM usertbl LIMIT 3);

ALTER TABLE memberTBL
	ADD CONSTRAINT pk_memberTBL PRIMARY KEY (userID);
    
SELECT * FROM memberTBL;

INSERT INTO memberTBL VALUES('BBK', '바비코', '미국');
INSERT INTO memberTBL VALUES('SJH', '서장훈', '경기');
INSERT INTO memberTBL VALUES('HYJ', '현주엽', '미국');

INSERT IGNORE INTO memberTBL VALUES('BBK', '바비코', '미국');
INSERT IGNORE INTO memberTBL VALUES('SJH', '서장훈', '경기');
INSERT IGNORE INTO memberTBL VALUES('HYJ', '현주엽', '미국');

INSERT INTO memberTBL VALUES('BBK', '비비코', '미국')
	ON DUPLICATE KEY UPDATE name = '바비코', addr = '미국';

WITH abc(userId, total)
AS 
(SELECT userid, SUM(price*amount)
	FROM buytbl GROUP BY userID)
SELECT * FROM abc ORDER BY total DESC;

WITH cte_usertbl (addr, maxHeight)
AS
	(SELECT addr, MAX(height) FROM usertbl GROUP BY addr)
SELECT AVG(maxHeight * 1.0) AS '각지역별 최고키의 평균' FROM cte_usertbl;

SET @myVar1 = 5;
SET @myVar2 = 3;
SET @myVar3 = 4.25;
SET @myVar4 = '가수 이름 -->';

SELECT @myVar1;
SELECT @myVar2 + @myVar3;

SELECT @myVar4, Name FROM usertbl WHERE height > 180;

SET @myVar1 = 3;
PREPARE myQuery
	FROM 'SELECT Name, height FROM usertbl ORDER BY height LIMIT ?';
EXECUTE myQuery USING @myVar1;

SELECT CAST(AVG(amount) AS SIGNED INTEGER) AS '평균 구매 개수' FROM buytbl;
SELECT CONVERT(AVG(amount), SIGNED INTEGER) AS '평균 구매 개수' FROM buytbl;

SELECT num, CONCAT(CAST(price AS CHAR(10)), 'X', CAST(amount AS CHAR(4)), '=') AS
'단가X수량',
price*amount AS '구매액'
FROM buytbl;

SELECT IF (100>200, '참이다', '거짓이다');

SELECT CASE 10
			WHEN 1 THEN '일'
            WHEN 5 THEN '오'
            WHEN 10 THEN '십'
            ELSE '모름'
		END AS 'CASE연습';
        
SELECT ASCII('A') , CHAR(65);

SELECT DAYOFWEEK(CURDATE());

SELECT LAST_DAY('2025-02-02');

SELECT VERSION();