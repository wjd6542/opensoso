create database Shares;

-- 유저 테이블
create table Shares.user (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고객번호',
	id				varchar(30) 	COMMENT '아이디',
	password		varchar(100) 	COMMENT '비밀번호',
	name			varchar(20) 	COMMENT '이믈',
	email			varchar(100) 	COMMENT '이메일',
	phon			varchar(11) 	COMMENT '휴대폰',
	gender			char(1) 		COMMENT '성별',
	birthday		char(8) 		COMMENT '생년월일',
	hobby			varchar(30) 	COMMENT '취미',
	forte			varchar(30) 	COMMENT '특기',
	zipcode			char(5) 		COMMENT '우편번호',
	addr11			varchar(50) 	COMMENT '주소',
	addr12			varchar(100) 	COMMENT '상세주소',
	authority		char(4) 		COMMENT '권한',
	status			char(1) 		COMMENT '저장상태 Y : N',
	lat				varchar(100) 	COMMENT '경도',
	lan				varchar(100) 	COMMENT '위도'
);
ALTER TABLE Shares.user COMMENT ='유저 테이블';

-- 시스템 코드 테이블
create table shares.systemCode (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '시스템코드번호',
    code			varchar(30) 	COMMENT '코드명',
    title			varchar(30) 	COMMENT '코드이름',
    memo			varchar(30) 	COMMENT '코드설명',
    status			char(1) 		COMMENT '저장상태 Y : N'
);
 ALTER TABLE Shares.systemCode COMMENT ='시스템 코드 테이블';


drop table shares.systemValue;
-- 시스템 코드 값 테이블
create table shares.systemValue(
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '시스템코드번호',
    systemCode		varchar(30) 	COMMENT '시스템코드 코드값',
    code			varchar(30) 	COMMENT '코드명',
    title			varchar(30) 	COMMENT '코드이름',
    memo			varchar(30) 	COMMENT '코드설명',
    sort			int 			COMMENT '정렬순서',
    status			char(1) 		COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.systemValue COMMENT ='시스템 코드 값 테이블';

-- 시스템 코드 값 테이블
select
	distinct b.table_name,b.table_comment, a.column_name, a.column_comment
from
	information_schema.columns a , information_schema.tables b
where
	a.table_schema = 'shares' and b.table_schema = 'shares';
