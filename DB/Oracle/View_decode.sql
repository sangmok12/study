--cmd> sqlplus sys/1234 as sysdba
--cmd> grant create view to c##java;
--cmd> exit;

--  View table  복제품같은, 카피본,  검색,조회만 가능 수정 안됨.

create view v_emp_copy as select * from emp;
select * from v_emp_copy;


create view v_emp_sal_desc as 
select b.* from(
    select rownum rn,a.* from (
         select empno,ename,job,sal from emp
              order by sal desc)a )b ;
              
select * from v_emp_sal_desc where rn >=6 and rn <=10;

update emp set sal = 6000 where ename = 'KING';


-- 부서번호, 부서이름, 사원번호, 사원이름  조인해서 뷰테이블 만들기
create view v_research as
select e.deptno,d.dname,e.empno,e.ename
    from emp e, dept d
        where e.deptno = d.deptno
        and d.dname = 'RESEARCH';

select * from v_research;
drop view v_research;

--null   nvl,  nvl2
-- nvl(컬럼값,세팅값)   컬럼이 null인경우 세팅값으로 출력
-- nvl2 (컬럼값,세팅값1,세팅값2)  컬럼이 null이 아닌경우 세팅값1, null인 경우 세팅값2

select ename,nvl(mgr,0) as mgr from emp;
select ename,sal,(sal+nvl(comm,0)) sal2 from emp;

select empno,comm,nvl2(comm,comm+100,0)comm2 from emp;


--decode (컬럼명,비교값,치환값1,비교2,치환값2...)
select deptno,
       dname,
       decode(deptno,10,'회계',20,'조사','나머지는몰라') as dname2
from dept;

select ename,
       sal,
       deptno,
       decode(deptno,10,sal*1.1,sal) 인상급여
from emp;



--부서 10 1.1   20 1.2   나머지는 1.4로 급여인상
select deptno,empno,sal,
       decode(deptno,10,sal*1.1,
                     20,sal*1.2,
                     sal*1.3) as sal2 from emp;

select ename,
       empno,
       job,
       decode(job,
       'ANALYST','분석가',
       'CLERK','점원',
       'MANAGER','관리자',
       'SALESMAN','영업사원',
       'PRESIDENT','사장님') as 직책
    from emp;
    
-- 사원급여 2000보다 많으면 상, 그렇지 않으면 하
-- sign : 양수(1), 음수(-1)
-- 첫번째칸에는 함수등을 넣을 수 있음,
-- 두번째칸에는 결과값을 넣어야함

select sign(1000) from dual;
select sign(-1000) from dual;

select ename,empno,sal,decode(sign(sal-2000),1,'상','하') as sal2 from emp;


--업무별 급여인상
select ename,
       job,
       sal,
       decode(job,
       'ANALYST',sal*1.1,
       'CLERK',SAL*1.15,
       'MANAGER',SAL*1.2,
       sal
       ) 인상급여 from emp;
       
-- 1월 ~ 6월까지 년도와 상관없이 해당 월에 입사한 사람 수를 출력하시오.
-- as 에  숫자넣으려면 "" 해야함
select count(1) from emp
    where to_char(hiredate,'mm') = '01';

select count(
decode( 
to_char(hiredate,'mm'),'01','1',
                       '02','1',
                       '03','1',
                       '04','1',
                       '05','1',
                       '06','1'
                       )) "1~6월"
from emp;

select 
    count(decode(to_char(hiredate,'mm'),'01',1)) "1월",
    count(decode(to_char(hiredate,'mm'),'02',1)) "2월",
    count(decode(to_char(hiredate,'mm'),'03',1)) "3월",
    count(decode(to_char(hiredate,'mm'),'04',1)) "4월",
    count(decode(to_char(hiredate,'mm'),'05',1)) "5월",
    count(decode(to_char(hiredate,'mm'),'06',1)) "6월"
from emp;


select count(
decode( 
sign(to_char(hiredate,'mm')-7),-1,1)) "1~6월"
from emp;


-- count 여러개 중복으로 출력할 수 있음
select count(*),
       count(ename),
       count(comm) from emp;
   
    