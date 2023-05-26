create table h_member1(
userid varchar2(20),
pass varchar2(100),
name varchar2(20),
birthday date,
phone varchar2(20)
);


insert into h_member1 values('hong','1234','홍길동','20100423','');
insert into h_member1 values('tiger','1111','호돌이','20101111','010-5555-7777');
insert into h_member1 values('linux','qwer','토발즈','20100817','010-2222-1234');
insert into h_member1 values('java','1212','고릴라','20100102','010-1111-7777');

select * from h_member1;
alter table h_member1 modify userid varchar2(20) not null primary key;
alter table h_member1 modify pass varchar2(100) not null;
alter table h_member1 modify name varchar2(20) not null;


create table h_score1(
userid varchar2(20),
eng number,
kor number
);

insert into h_score1 values('hong','90','88');
insert into h_score1 values('tiger','68','54');
insert into h_score1 values('linux','98','62');
alter table h_score1 modify userid varchar2(20) not null primary key;
alter table h_score1 modify eng number default '0';
alter table h_score1 modify kor number default '0';

create table h_grade1(
grade varchar2(1),
loscore number,
hiscore number
);

insert into h_grade1 values('A','90','100');
insert into h_grade1 values('B','80','89');
insert into h_grade1 values('C','70','79');
insert into h_grade1 values('D','60','69');
insert into h_grade1 values('F','0','59');

select * from h_grade1;




--아이디, 이름,영어점수,국어점수
select m.userid,m.name,s.eng,s.kor
    from h_member1 m,h_score1 s
        where m.userid = s.userid;
        
--아이디, 이름,영어점수,국어점수 -- 조인되지 않은 데이터 출력
select m.userid,m.name,s.eng,s.kor
    from h_member1 m,h_score1 s
        where m.userid = s.userid(+);
        
--아이디, 이름,총점,평균        -- (영어+국어),(영어+국어)/2
select m.userid,
       m.name,
       (s.eng+s.kor) as hap,
       (s.eng+s.kor)/2 as avg
    from h_member1 m,h_score1 s
        where m.userid = s.userid;
        
--아이디, 이름,영어점수(학점)
select m.userid,m.name,s.eng||'('||g.grade||')'
    from h_member1 m,h_score1 s,h_grade1 g
        where m.userid = s.userid and s.eng between g.loscore and g.hiscore;
        
select s.userid,
       (select name from h_member1 where userid=s.userid)as name,
       s.eng,
       g.grade
    from h_score1 s,h_grade1 g
    where s.eng between g.loscore and g.hiscore;   

        
--아이디, 이름,국어점수(학점)
select m.userid,m.name,s.kor||'('||g.grade||')'
    from h_member1 m,h_score1 s,h_grade1 g
        where m.userid = s.userid and s.kor between g.loscore and g.hiscore;
        
        
--아이디, 이름,영어점수(학점),국어점수(학점)
select m.userid,
       m.name,
       s.kor||'('||g1.grade||')' as kor,
       s.eng||'('||g2.grade||')' as eng
    from h_member1 m,h_score1 s,h_grade1 g1,h_grade1 g2
    where m.userid = s.userid 
        and s.kor between g1.loscore and g1.hiscore 
        and s.eng between g2.loscore and g2.hiscore;
        
--아이디, 이름,나이
select userid,name,
to_char(sysdate,'yyyy')-to_char(birthday,'yyyy')age from h_member1;

--총점합계 1등의 정보 출력   -- 꼴등정보도 출력
select a.* from(
    select m.userid,
       m.name,
       (s.eng+s.kor) as hap,
       (s.eng+s.kor)/2 as avg
    from h_member1 m,h_score1 s
        where m.userid = s.userid order by hap desc)a 
where rownum = 1;


--전화번호 없는 데이터 출력
select * from h_member1 where phone is null;
select * from h_member1 where phone is not null;


--회원이름중 홍씨성을 검색한다
select * from h_member1 where name like ('홍%');


        

        



        

        
