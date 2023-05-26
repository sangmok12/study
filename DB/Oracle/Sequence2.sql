create table nboard (
 unq number not null primary key,
 title varchar2(100) not null,
 name varchar2(20)
 );
 
 -- 시퀀스는  생성때  괄호 없음
 create sequence nboard_seq 
 increment by 1
 start with 1 
 maxvalue 99999;
 
-- 1. 현재 시퀀스 값   nboard_seq.currval
-- 2. 다음 시퀀스 값   nboard_seq.nextval
-- nextval 조회 출력해도  카운팅 됨.
select nboard_seq.nextval from dual;
select nboard_seq.currval from dual;


insert into nboard values(nboard_seq.nextval,'111','aaa');
insert into nboard values(nboard_seq.nextval,'222','bbb');

select * from nboard;