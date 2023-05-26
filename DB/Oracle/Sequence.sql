create table h_member2(
unq number  primary key,
userid varchar2(20),
pass varchar2(100),
name varchar2(20),
birthday date,
phone varchar2(20)
);

create sequence h_member1_unq_seq
increment by 1
start with 1
maxvalue 9999;

insert into h_member2(unq,userid,pass,name,birthday,phone) values(h_member1_unq_seq.nextval,'hong','1234','홍길동','20100423','');
insert into h_member2(unq,userid,pass,name,birthday,phone) values(h_member1_unq_seq.nextval,'tiger','1111','호돌이','20101111','010-5555-7777');
insert into h_member2(unq,userid,pass,name,birthday,phone) values(h_member1_unq_seq.nextval,'linux','qwer','토발즈','20100817','010-2222-1234');
insert into h_member2(unq,userid,pass,name,birthday,phone) values(h_member1_unq_seq.nextval,'java','1212','고릴라','20100102','010-1111-7777');
insert into h_member2(unq,userid,pass,name,birthday,phone) values(h_member1_unq_seq.nextval,'jvvj','1232','킹콩','20100102','010-1111-7777');
insert into h_member2(unq,userid,pass,name,birthday,phone) values(h_member1_unq_seq.nextval,'jffj','1132','무궁화','20100102','010-1111-7777');

create table a100(
unq number not null primary key,
title varchar2(20));

insert into a100 values(h_member1_unq_seq.nextval,'aaa');
insert into a100 values(h_member1_unq_seq.nextval,'bbb');

delete from h_member2 where unq='2';

select h_member1_unq_seq.currval from dual;