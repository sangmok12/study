create table memberTest (
unq number not null,
id varchar2(30) not null,
pwd varchar2(100) not null,
name varchar2(30),
gender char(1),       -- 'M','F'
rdate timestamp,


-- constraint ���̺��_�÷���_�������Ǹ�
-- primary key  : ������ ����, �˻�(index) ���̺� �ø� ���ǽĿ� ���� ����� �÷��� ���� �ø�
-- unique       : ������ ����
constraint mm_gender_ck check(gender in('M','F')),
constraint mm_unq_pk primary key(unq),
constraint mm_id_un unique(id)
);


create sequence memberTest_seq
increment by 1
start with 1
maxvalue 99999;

select * from membertest;
insert into memberTest(unq,id,pwd,name,gender,rdate)
    values (memberTest_seq.nextval,'test1','1234','test1','M',sysdate);
insert into memberTest(unq,id,pwd,name,gender,rdate)
    values (memberTest_seq.nextval,'test2','1221','test2','F',sysdate);
insert into memberTest(unq,id,pwd,name,gender,rdate)
    values (memberTest_seq.nextval,'test2','2234','test3','M',sysdate);
    
    
    
    
-- constraint �Ⱦ��� ���̺� ������ ����
create table memberTest2 (
unq number not null primary key,
id varchar2(30) not null unique,
pwd varchar2(100) not null,
name varchar2(30),
gender char(1)  check(gender in('M','F')),   
rdate timestamp);


-- unique  �����÷��� (����) , primary key  ���� �÷��� (�Ұ���)
create table memberTest3 (
unq number            primary key,
id varchar2(30)       unique,
pwd varchar2(100) not null,
name varchar2(30)     unique,
gender char(1)    check(gender in ('M','F')),      
rdate timestamp);


-- primary  �ΰ� �׽�Ʈ  id,name �Ѵ� ��ĥ�� ������, ���� �ϳ� �ٸ��� ����
create table memberTest5 (
id varchar2(30) not null,   --primary key(id,name) �̷������� �ȵ�
pwd varchar2(100) not null,
name varchar2(30) not null,
gender char(1),    
rdate timestamp,
constraint mm_gender_ck1 check(gender in('M','F')),
constraint mm_id_pk1 primary key(id,name)   --���� id and name �Ѵٰ�ġ���ʰ�
);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a1','1234','ȣ����','M',sysdate);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a2','2234','ȣ����','F',sysdate);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a3','3234','ȣ����','M',sysdate);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a1','1234','ȣ����','M',sysdate);


-- comment ����
comment on table memberTest is 'ȸ�� ���̺�';
comment on column memberTest.unq is '������ȣ';
comment on column memberTest.id is '���̵�';

select * from user_col_comments where table_name='MEMBERTEST';
select * from user_tab_comments where table_name='membertest';
    