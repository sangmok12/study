create table memberTest (
unq number not null,
id varchar2(30) not null,
pwd varchar2(100) not null,
name varchar2(30),
gender char(1),       -- 'M','F'
rdate timestamp,


-- constraint 테이블명_컬럼명_제약조건명
-- primary key  : 고유값 보장, 검색(index) 테이블 올림 조건식에 많이 사용할 컬럼을 보통 올림
-- unique       : 고유값 보장
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
    
    
    
    
-- constraint 안쓰고 테이블 생성때 직접
create table memberTest2 (
unq number not null primary key,
id varchar2(30) not null unique,
pwd varchar2(100) not null,
name varchar2(30),
gender char(1)  check(gender in('M','F')),   
rdate timestamp);


-- unique  여러컬럼에 (가능) , primary key  여러 컬럼에 (불가능)
create table memberTest3 (
unq number            primary key,
id varchar2(30)       unique,
pwd varchar2(100) not null,
name varchar2(30)     unique,
gender char(1)    check(gender in ('M','F')),      
rdate timestamp);


-- primary  두개 테스트  id,name 둘다 겹칠때 에러남, 둘중 하나 다르면 인정
create table memberTest5 (
id varchar2(30) not null,   --primary key(id,name) 이런식으로 안됨
pwd varchar2(100) not null,
name varchar2(30) not null,
gender char(1),    
rdate timestamp,
constraint mm_gender_ck1 check(gender in('M','F')),
constraint mm_id_pk1 primary key(id,name)   --가능 id and name 둘다겹치지않게
);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a1','1234','호돌이','M',sysdate);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a2','2234','호순이','F',sysdate);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a3','3234','호돌이','M',sysdate);

insert into memberTest5(id,pwd,name,gender,rdate)
values('a1','1234','호찬이','M',sysdate);


-- comment 생성
comment on table memberTest is '회원 테이블';
comment on column memberTest.unq is '고유번호';
comment on column memberTest.id is '아이디';

select * from user_col_comments where table_name='MEMBERTEST';
select * from user_tab_comments where table_name='membertest';
    