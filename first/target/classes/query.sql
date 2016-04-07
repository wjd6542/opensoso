create database Shares;

-- 유저 테이블
create table Shares.user (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고객번호',
	id				varchar(30) 	COMMENT '아이디',
	password		varchar(100) 	COMMENT '비밀번호',
	name			varchar(20) 	COMMENT '이름',
	email			varchar(100) 	COMMENT '이메일',
	nickName		varchar(30) 	COMMENT '별명',
	phon			varchar(11) 	COMMENT '휴대폰',
	gender			char(2) 		COMMENT '성별',
	birthday		char(10) 		COMMENT '생년월일',
	hobby			varchar(30) 	COMMENT '취미',
	forte			varchar(30) 	COMMENT '특기',
	zipcode			char(5) 		COMMENT '우편번호',
	addr11			varchar(50) 	COMMENT '주소',
	addr12			varchar(100) 	COMMENT '상세주소',
	authority		char(8) 		COMMENT '권한',
    citation		varchar(13) 	COMMENT '비밀번호 인증번호',
	status			char(3) 		COMMENT '저장상태 Y : N',
	lat				varchar(100) 	COMMENT '경도',
	lan				varchar(100) 	COMMENT '위도',
    oName			varchar(100) 	COMMENT '원본파일명',
    imgName			varchar(100) 	COMMENT '이미지명'
);
ALTER TABLE Shares.user				COMMENT ='유저 테이블';
drop table Shares.user;


insert  into Shares.user (id,password,name,nickName,email,authority,gender,birthday,status) value('admin','123123','관리자','관리자','wjd6542@gmail.com','master','남자','1991-01-15','Y');
insert  into Shares.user (id,password,name,nickName,email,authority,gender,birthday,status) value('wjd6542','123456','강정권','르베르크','wjd6542@naver.com','user','남자','1991-01-15','Y');

delete from Shares.user;

select * from Shares.user where id = 'wjd6542';

-- drop table Shares.user;

select * from Shares.user;
update  Shares.user set password='123456' where no=1;

-- 시스템 코드 테이블
create table shares.systemCode (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '시스템코드번호',
    code			varchar(30) 	COMMENT '코드명',
    title			varchar(30) 	COMMENT '코드이름',
    memo			varchar(30) 	COMMENT '코드설명',
    status			char(1) 		COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.systemCode 		COMMENT ='시스템 대분류 테이블';
-- drop table Shares.systemCode;


-- 시스템 코드 값 테이블
create table shares.systemValue(
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '시스템코드번호',
    systemCode		varchar(30) 	COMMENT '시스템코드 코드값',
    code			varchar(30) 	COMMENT '코드명',
    title			varchar(30) 	COMMENT '코드이름',
    memo			varchar(30) 	COMMENT '코드설명',
    sort			char(1) 		COMMENT '정렬순서',
    status			char(1) 		COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.systemValue		COMMENT ='시스템 중분류 테이블';
-- drop table Shares.systemValue;

select * from Shares.systemValue where systemCode = 'userStatus';

-- 게시판 관리 테이블테이블
create table shares.systemBorder(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '테이블 번호',
    title			varchar(30)		COMMENT '게시판 명',
    type			char(3)			COMMENT '게시판 구분',
    authority		varchar(10)		COMMENT '게시판 사용 권한',
    rippleUser		char(1)			COMMENT '댓글 사용유무 Y : N',
    fileUser		char(1)			COMMENT '파일 사용유무 Y : N',
    sort			char(2) 		COMMENT '정렬순서',
    status			char(1) 		COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.systemBorder		COMMENT ='게시판 관리 테이블';
-- drop table Shares.systemBorder;


-- 게시판 테이블
create table shares.border(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 번호',
    sysNo			int				COMMENT '설정번호',
    userNo			int				COMMENT '고객번호',
    title			varchar(50)		COMMENT '제목',
    borderType		char(3)			COMMENT '분류',
	saveDate		char(10)		COMMENT '저장일자',
    saveTime		char(8)			COMMENT '저장시간',
    interest		varchar(30)		COMMENT '관심사',
    hitCnt			int				COMMENT '조회수',
    rippleCnt		int				COMMENT '리플수',
    goodCnt			int				COMMENT '추천수',
    memo			text			COMMENT '게시글 내용',
    status			char(1) 		COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.border COMMENT ='게시판 테이블';
drop table Shares.border;


-- 파일 테이블
create table shares.file(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '파일 번호',
    userNo			int				COMMENT '고객번호',
    borderNo		int				COMMENT '게시판 번호',
    oName			varchar(100)	COMMENT '원본파일명',
    fileName		varchar(100)	COMMENT '저장파일명',
    fileSize		int				COMMENT '파일사이즈',
    status			char(1)			COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.file				COMMENT ='파일 테이블';
drop table Shares.file;


-- 접근관리 테이블
create table shares.access(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '파일 번호',
    path			varchar(100)	COMMENT '접근경로',
    type			varchar(10)		COMMENT '접근구분',
    ip				varchar(30)		COMMENT '접근 아이피',
    name			varchar(20)		COMMENT '이름',	
    saveDate		char(10)		COMMENT '접근일자',
    saveTime		char(8)			COMMENT '접근시간',
    status			char(1)			COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.access			COMMENT ='접근관리 테이블';
drop table Shares.access;


-- 부서 테이블
create table shares.branch(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '부서 번호',
    name			varchar(30)		COMMENT '부서명',
	code			varchar(20)		COMMENT '부서코드',
    sort			int				COMMENT '정렬순서',
    grupNo			int				COMMENT '그룹번호',
    depthNo			int				COMMENT '하위번호',
	status			char(1)			COMMENT '저장상태 Y : N'
);
ALTER TABLE Shares.branch			COMMENT ='부서관리 테이블';
drop table Shares.branch;


