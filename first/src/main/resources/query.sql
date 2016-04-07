create database Shares;

-- ���� ���̺�
create table Shares.user (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '����ȣ',
	id				varchar(30) 	COMMENT '���̵�',
	password		varchar(100) 	COMMENT '��й�ȣ',
	name			varchar(20) 	COMMENT '�̸�',
	email			varchar(100) 	COMMENT '�̸���',
	nickName		varchar(30) 	COMMENT '����',
	phon			varchar(11) 	COMMENT '�޴���',
	gender			char(2) 		COMMENT '����',
	birthday		char(10) 		COMMENT '�������',
	hobby			varchar(30) 	COMMENT '���',
	forte			varchar(30) 	COMMENT 'Ư��',
	zipcode			char(5) 		COMMENT '�����ȣ',
	addr11			varchar(50) 	COMMENT '�ּ�',
	addr12			varchar(100) 	COMMENT '���ּ�',
	authority		char(8) 		COMMENT '����',
    citation		varchar(13) 	COMMENT '��й�ȣ ������ȣ',
	status			char(3) 		COMMENT '������� Y : N',
	lat				varchar(100) 	COMMENT '�浵',
	lan				varchar(100) 	COMMENT '����',
    oName			varchar(100) 	COMMENT '�������ϸ�',
    imgName			varchar(100) 	COMMENT '�̹�����'
);
ALTER TABLE Shares.user				COMMENT ='���� ���̺�';
drop table Shares.user;


insert  into Shares.user (id,password,name,nickName,email,authority,gender,birthday,status) value('admin','123123','������','������','wjd6542@gmail.com','master','����','1991-01-15','Y');
insert  into Shares.user (id,password,name,nickName,email,authority,gender,birthday,status) value('wjd6542','123456','������','������ũ','wjd6542@naver.com','user','����','1991-01-15','Y');

delete from Shares.user;

select * from Shares.user where id = 'wjd6542';

-- drop table Shares.user;

select * from Shares.user;
update  Shares.user set password='123456' where no=1;

-- �ý��� �ڵ� ���̺�
create table shares.systemCode (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '�ý����ڵ��ȣ',
    code			varchar(30) 	COMMENT '�ڵ��',
    title			varchar(30) 	COMMENT '�ڵ��̸�',
    memo			varchar(30) 	COMMENT '�ڵ弳��',
    status			char(1) 		COMMENT '������� Y : N'
);
ALTER TABLE Shares.systemCode 		COMMENT ='�ý��� ��з� ���̺�';
-- drop table Shares.systemCode;


-- �ý��� �ڵ� �� ���̺�
create table shares.systemValue(
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '�ý����ڵ��ȣ',
    systemCode		varchar(30) 	COMMENT '�ý����ڵ� �ڵ尪',
    code			varchar(30) 	COMMENT '�ڵ��',
    title			varchar(30) 	COMMENT '�ڵ��̸�',
    memo			varchar(30) 	COMMENT '�ڵ弳��',
    sort			char(1) 		COMMENT '���ļ���',
    status			char(1) 		COMMENT '������� Y : N'
);
ALTER TABLE Shares.systemValue		COMMENT ='�ý��� �ߺз� ���̺�';
-- drop table Shares.systemValue;

select * from Shares.systemValue where systemCode = 'userStatus';

-- �Խ��� ���� ���̺����̺�
create table shares.systemBorder(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '���̺� ��ȣ',
    title			varchar(30)		COMMENT '�Խ��� ��',
    type			char(3)			COMMENT '�Խ��� ����',
    authority		varchar(10)		COMMENT '�Խ��� ��� ����',
    rippleUser		char(1)			COMMENT '��� ������� Y : N',
    fileUser		char(1)			COMMENT '���� ������� Y : N',
    sort			char(2) 		COMMENT '���ļ���',
    status			char(1) 		COMMENT '������� Y : N'
);
ALTER TABLE Shares.systemBorder		COMMENT ='�Խ��� ���� ���̺�';
-- drop table Shares.systemBorder;


-- �Խ��� ���̺�
create table shares.border(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '�Խ��� ��ȣ',
    sysNo			int				COMMENT '������ȣ',
    userNo			int				COMMENT '����ȣ',
    title			varchar(50)		COMMENT '����',
    borderType		char(3)			COMMENT '�з�',
	saveDate		char(10)		COMMENT '��������',
    saveTime		char(8)			COMMENT '����ð�',
    interest		varchar(30)		COMMENT '���ɻ�',
    hitCnt			int				COMMENT '��ȸ��',
    rippleCnt		int				COMMENT '���ü�',
    goodCnt			int				COMMENT '��õ��',
    memo			text			COMMENT '�Խñ� ����',
    status			char(1) 		COMMENT '������� Y : N'
);
ALTER TABLE Shares.border COMMENT ='�Խ��� ���̺�';
drop table Shares.border;


-- ���� ���̺�
create table shares.file(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '���� ��ȣ',
    userNo			int				COMMENT '����ȣ',
    borderNo		int				COMMENT '�Խ��� ��ȣ',
    oName			varchar(100)	COMMENT '�������ϸ�',
    fileName		varchar(100)	COMMENT '�������ϸ�',
    fileSize		int				COMMENT '���ϻ�����',
    status			char(1)			COMMENT '������� Y : N'
);
ALTER TABLE Shares.file				COMMENT ='���� ���̺�';
drop table Shares.file;


-- ���ٰ��� ���̺�
create table shares.access(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '���� ��ȣ',
    path			varchar(100)	COMMENT '���ٰ��',
    type			varchar(10)		COMMENT '���ٱ���',
    ip				varchar(30)		COMMENT '���� ������',
    name			varchar(20)		COMMENT '�̸�',	
    saveDate		char(10)		COMMENT '��������',
    saveTime		char(8)			COMMENT '���ٽð�',
    status			char(1)			COMMENT '������� Y : N'
);
ALTER TABLE Shares.access			COMMENT ='���ٰ��� ���̺�';
drop table Shares.access;


-- �μ� ���̺�
create table shares.branch(
	no				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '�μ� ��ȣ',
    name			varchar(30)		COMMENT '�μ���',
	code			varchar(20)		COMMENT '�μ��ڵ�',
    sort			int				COMMENT '���ļ���',
    grupNo			int				COMMENT '�׷��ȣ',
    depthNo			int				COMMENT '������ȣ',
	status			char(1)			COMMENT '������� Y : N'
);
ALTER TABLE Shares.branch			COMMENT ='�μ����� ���̺�';
drop table Shares.branch;


