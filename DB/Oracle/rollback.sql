create table subject (
title varchar2(100),
price number
);

insert into subject values('jsp',5000);
insert into subject values('html',15000);
commit;
select * from subject;
rollback;   -- commit 이후 상태만 실행취소
select*from subject;

delete from subject where title = 'jsp';
rollback;

create table abc(userid varchar2(100));
rollback;

select * from subject;
insert into subject values('a1',1000);
savepoint sp1;
insert into subject values('a2',2000);
savepoint sp2;
rollback to sp1;

alter table subject modify title varchar2(200);
alter table subject add name varchar2(50);
alter table subject drop column name;
alter table subject rename column price to price100;

truncate table subject;
drop table subject;
