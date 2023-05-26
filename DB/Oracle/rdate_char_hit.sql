create table board1 (
unq number not null primary key,
title varchar2(100) not null,
pass varchar2(100) not null,
name varchar2(30),
content varchar2(4000),
rdate timestamp
);


alter table board1 add hit number default 0;

insert into board1(unq,title,pass,name,content,rdate)
values(1,'oracle수업','1234','홍길동','냉무11',sysdate);

insert into board1(unq,title,pass,name,content,rdate)
values(2,'java수업','1424','메니','냉무22',sysdate);
insert into board1(unq,title,pass,name,content,rdate)
values(3,'html수업','1212','톰슨','냉무333',sysdate);




select title,name,content from board1 where unq = '1';
select * from board1 where name = '나그네';
select unq||':'||title||':'||name  as title from board1;
select title||'('||length(content)||')' as title from board1;
update board1 set hit='1000';
update board1 set hit='1500' where unq='2';
update board1 set hit='2000' where unq='3';
commit;
select * from board1 order by unq desc;
select * from board1 order by hit desc;

-- LIKE 검색   --> '%':문자열   ,  '.':문자한개 반드시
-- '%java%'   : java 라는 단어 앞뒤로 어떠한 문자열이 와도(안와도) 좋다.
-- 'java%'    : java 라는 단어로 시작하는 문자열
-- '.body%'   : body라는 단어 앞에 문자한개가 반드시 있어야하고, 뒤에 어떠한 문자열이 와도 좋다.

select * from board1 where title like '%java%';
update board1 set hit=hit+100 where unq='3';

