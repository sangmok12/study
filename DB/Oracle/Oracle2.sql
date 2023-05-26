create table bookinfo (
code varchar2(20),
title varchar2(50),
country varchar2(30));

insert into bookinfo (code,title,country) values ('j02','jsp','');
insert into bookinfo (code,title) values ('j03','oracle');
insert into bookinfo (code,title,country) values ('j04','mysql','usa');
insert into bookinfo (code) values ('j05');
insert into bookinfo values('j06','linux','korea');

select*from bookinfo;

select count(*) from bookinfo;
select count(code) from bookinfo;
select count(title) from bookinfo;
select count(country) from bookinfo;

select * from bookinfo where title='linux';
select * from bookinfo where country is not null;
update bookinfo set country='korea' where code='j02';
update bookinfo set country='korea' where country is null;

update sports set name='¾ß±¸' where code='102';

create table member1 (
id varchar2(30),
name varchar2(20),
age number(3),
birth date,
rdate timestamp 
);

insert into member1 values('aa1','bb1','22','1996-05-05',sysdate);

alter table member1 add kor number(3);
alter table member1 modify name varchar2(50);
alter table member1 drop column kor;
select * from member1;
insert into member1 values('aa2','bb2','25','1996-05-06',sysdate);
insert into member1 values('aa3','bb3','23','1996-05-07',sysdate);
savepoint sp1;