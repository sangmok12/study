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
values(1,'oracle����','1234','ȫ�浿','�ù�11',sysdate);

insert into board1(unq,title,pass,name,content,rdate)
values(2,'java����','1424','�޴�','�ù�22',sysdate);
insert into board1(unq,title,pass,name,content,rdate)
values(3,'html����','1212','�轼','�ù�333',sysdate);




select title,name,content from board1 where unq = '1';
select * from board1 where name = '���׳�';
select unq||':'||title||':'||name  as title from board1;
select title||'('||length(content)||')' as title from board1;
update board1 set hit='1000';
update board1 set hit='1500' where unq='2';
update board1 set hit='2000' where unq='3';
commit;
select * from board1 order by unq desc;
select * from board1 order by hit desc;

-- LIKE �˻�   --> '%':���ڿ�   ,  '.':�����Ѱ� �ݵ��
-- '%java%'   : java ��� �ܾ� �յڷ� ��� ���ڿ��� �͵�(�ȿ͵�) ����.
-- 'java%'    : java ��� �ܾ�� �����ϴ� ���ڿ�
-- '.body%'   : body��� �ܾ� �տ� �����Ѱ��� �ݵ�� �־���ϰ�, �ڿ� ��� ���ڿ��� �͵� ����.

select * from board1 where title like '%java%';
update board1 set hit=hit+100 where unq='3';

