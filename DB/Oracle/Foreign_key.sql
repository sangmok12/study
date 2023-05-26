create table student20 (
userid varchar2(20) not null primary key,
name varchar2(20)
);

-- 자식레벨
create table jumsu20 (
userid varchar2(20) not null,
kor number default 0,
eng number default 0,
constraint jumsu_fk 
foreign key(userid)  -- 현재테이블의 컬럼
references student20(userid)   -- 레퍼런스 테이블의 컬럼
);

insert into student20 values('a1','홍길동');
insert into student20 values('a2','심청이');
insert into student20 values('a3','연놀부');
insert into jumsu20 values('a1','100','90');
insert into jumsu20 values('a2','90','70');
insert into jumsu20 values('a5','88','68');   -- 에러
-- a5 부모키가 없어서 입력안됨.


-- 자식 레코드가 있어서 삭제  못함
delete from student20 where userid ='a1';

alter table jumsu20 drop constraint jumsu_fk;   --조건삭제
delete from student20 where userid='a1';


create table jumsu22 (
userid varchar2(20) not null,
kor number default 0,
eng number default 0,
constraint jumsu22_fk 
foreign key(userid)  -- 현재테이블의 컬럼
references student20(userid)   -- 레퍼런스 테이블의 컬럼
on delete cascade
);

alter table jumsu22 drop constraint jumsu22_fk;  --조건삭제해봄
insert into jumsu22 values('a1','100','90');    -- 입력 가능
insert into jumsu22 values('a2','90','70');     -- 입력 가능


alter table jumsu22 add constraint jumsu22_fk1
foreign key(userid) 
references student20(userid);    -- jumsu22 와 student20 이 가진 아이디가 일치하지 않아 안됨.
insert into jumsu22 values('a3','90','70');
insert into student20 values('a2','심봉사');
insert into student20 values('a1','호돌이');
alter table jumsu22 add constraint jumsu22_fk1
foreign key(userid) 
references student20(userid);
--  jumsu22  a1,a2,a3 갯수  student20  a1,a2,a3 갯수 조건이 맞아져 다시 외래키 추가함


delete from jumsu22 where userid='a1';
-- 부모테이블에 있어도 자식테이블의 데이터 삭제는 가능
delete from student20 where userid='a2';
-- 자식레코드에 있어서  a2를 삭제 못함 (현재 jumsu22 에 a2,a3 있음
delete from student20 where userid='a1';
-- jumsu22 에 a1 데이터를 삭제 했기에  삭제가능