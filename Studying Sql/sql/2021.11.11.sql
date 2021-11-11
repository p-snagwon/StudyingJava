SET @json = '{"usertbl" : [
								{"name":"임재범", "height": 182},
								{"name":"이승기", "height": 182},
								{"name":"성시경", "height": 186},
							]
				}';
			
SELECT JSON_VALID(@json) AS JSON_VALID;
SELECT JSON_SEARCH(@json, 'one', '성시경') AS JSON_SEARCH;
SELECT JSON_EXTRACT(@json, '$.usertbl[2].name') AS JSON_EXTRACT;
SELECT JSON_INSERT(@json, '$.usertbl[0].mDate', '2009-09-09') AS JSON_INSERT;
SELECT JSON_REPLACE(@json, '$.usertbl[0].name', '홍길동') AS JSON_REPLACE;
SELECT JSON_REMOVE(@json, '$.usertbl[0]') AS JSON_REMOVE;

-- JOIN 을 하기위해서는 두테이블의 관계가 일대다 관계가 되어야한다. --
-- 포린키는 다른테이블의 프라이머리 키와 연결되어 있다고 보면 되고 포린키는 중복될수 있다.(구매태이블의 아이디 처럼) 프라이머리키는 중복안된다.

SELECT * FROM usertbl;

SELECT buytbl.userID, name, prodName, addr, CONCAT(mobile1, mobile2) AS '연락처'
	FROM buytbl
		INNER JOIN usertbl
			ON buytbl.userID = usertbl.userID
		ORDER BY num;
        
SELECT B.userID, U.name, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
	FROM buytbl B
		INNER JOIN usertbl U
			ON B.userID = U.userID
		ORDER BY B.num;
        
        
SELECT B.userID, U.name, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
	FROM buytbl B
		INNER JOIN usertbl U
			ON B.userID = U.userID
		WHERE B.userID = 'JYP';
        
CREATE TABLE stdtbl1
( stdName VARCHAR(10) NOT NULL PRIMARY KEY,
  addr CHAR(4) NOT NULL);
  
CREATE TABLE clubtbl1
( clubName VARCHAR(10) NOT NULL PRIMARY KEY,
  roomNo   CHAR(4) NOT NULL);
  
CREATE TABLE stdclubtbl
(	num int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName VARCHAR(10) NOT NULL,
    clubName VARCHAR(10) NOT NULL,
FOREIGN KEY (stdName) REFERENCES stdtbl1(stdName),
FOREIGN KEY (clubName) REFERENCES clubtbl1(clubName));

SELECT * FROM stdclubtbl;

INSERT INTO stdtbl1 VALUES('김범수', '강남'), ('성시경', '서울'), ('조용필', '경기'), ('은지원', '경북'), ('바비킴', '서울');
INSERT INTO clubtbl1 VALUES('수영', '101호'),('바둑', '102호'),('축구', '103호'),('봉사', '104호');
INSERT INTO stdclubtbl VALUES(NULL, '김범수', '바둑'), (NULL, '김범수', '축구'),(NULL, '조용필', '축구'),(NULL, '은지원', '축구'),(NULL, '바비킴', '봉사');   

SELECT S.stdName, s.addr, SC.clubName, C.roomNo
	FROM stdtbl1 S
		INNER JOIN stdclubtbl SC
          ON S.stdName = SC.stdName
		INNER JOIN clubtbl1 C
		  ON SC.clubName = C.clubName
	ORDER BY S.stdName;
    
SELECT C.clubName, C.roomNo, S.stdName, S.addr
	FROM stdtbl1 S
		INNER JOIN stdclubtbl SC
          ON S.stdName = SC.stdName
		INNER JOIN clubtbl1 C
		  ON SC.clubName = C.clubName
	ORDER BY C.clubName;
    
SELECT S.stdName, S.addr, C.clubName, C.roomNo
	FROM stdtbl1 S
		LEFT OUTER JOIN stdclubtbl SC
			ON S.stdName = SC.stdName
		LEFT OUTER JOIN clubtbl1 C
			ON SC.clubName = C.clubName
		ORDER BY S.stdName;
        
SELECT C.clubName, C.roomNo, S.stdName, S.addr
FROM stdtbl1 S
		LEFT OUTER JOIN stdclubtbl SC
			ON S.stdName = SC.stdName
		RIGHT OUTER JOIN clubtbl1 C
			ON SC.clubName = C.clubName
		ORDER BY S.stdName;
    
     
  