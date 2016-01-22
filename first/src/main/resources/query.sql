create database Shares;

-- ���� ���̺�
create table Shares.user (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '����ȣ',
	id				varchar(30) 	COMMENT '���̵�',
	password		varchar(100) 	COMMENT '��й�ȣ',
	name			varchar(20) 	COMMENT '�̹�',
	email			varchar(100) 	COMMENT '�̸���',
	phon			varchar(11) 	COMMENT '�޴���',
	gender			char(1) 		COMMENT '����',
	birthday		char(8) 		COMMENT '�������',
	hobby			varchar(30) 	COMMENT '���',
	forte			varchar(30) 	COMMENT 'Ư��',
	zipcode			char(5) 		COMMENT '�����ȣ',
	addr11			varchar(50) 	COMMENT '�ּ�',
	addr12			varchar(100) 	COMMENT '���ּ�',
	authority		char(4) 		COMMENT '����',
	status			char(1) 		COMMENT '������� Y : N',
	lat				varchar(100) 	COMMENT '�浵',
	lan				varchar(100) 	COMMENT '����'
);
ALTER TABLE Shares.user COMMENT ='���� ���̺�';

-- �ý��� �ڵ� ���̺�
create table shares.systemCode (
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '�ý����ڵ��ȣ',
    code			varchar(30) 	COMMENT '�ڵ��',
    title			varchar(30) 	COMMENT '�ڵ��̸�',
    memo			varchar(30) 	COMMENT '�ڵ弳��',
    status			char(1) 		COMMENT '������� Y : N'
);
 ALTER TABLE Shares.systemCode COMMENT ='�ý��� �ڵ� ���̺�';


drop table shares.systemValue;
-- �ý��� �ڵ� �� ���̺�
create table shares.systemValue(
	no 				int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '�ý����ڵ��ȣ',
    systemCode		varchar(30) 	COMMENT '�ý����ڵ� �ڵ尪',
    code			varchar(30) 	COMMENT '�ڵ��',
    title			varchar(30) 	COMMENT '�ڵ��̸�',
    memo			varchar(30) 	COMMENT '�ڵ弳��',
    sort			int 			COMMENT '���ļ���',
    status			char(1) 		COMMENT '������� Y : N'
);
ALTER TABLE Shares.systemValue COMMENT ='�ý��� �ڵ� �� ���̺�';

-- �ý��� �ڵ� �� ���̺�
select
	distinct b.table_name,b.table_comment, a.column_name, a.column_comment
from
	information_schema.columns a , information_schema.tables b
where
	a.table_schema = 'shares' and b.table_schema = 'shares';
