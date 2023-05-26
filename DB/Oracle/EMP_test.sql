CREATE TABLE  DEPT
(
  DEPTNO  NUMBER(2),     -- 부서번호
  DNAME   VARCHAR2(14),  -- 부서이름
  LOC     VARCHAR2(13)    -- 부서위치
);

insert into dept values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept values(20, 'RESEARCH', 'DALLAS');
insert into dept values(30, 'SALES', 'CHICAGO');
insert into dept values(40, 'OPERATIONS', 'BOSTON');
  

CREATE TABLE  EMP
(
  EMPNO     NUMBER(4),      -- 사원번호
  ENAME     VARCHAR2(10),   -- 사원이름 
  JOB       VARCHAR2(9),     -- 업무 
  MGR       NUMBER(4),      -- 매니저
  HIREDATE  DATE,           -- 입사일
  SAL       NUMBER(7,2),     -- 급여
  COMM      NUMBER(7,2),    -- 추가급여
  DEPTNO    NUMBER(2)      -- 부서번호
);

insert into emp values( 7839, 'KING', 'PRESIDENT', null, to_date('1996-11-17','yyyy-mm-dd'), 5000, null, 10);
insert into emp values( 7698, 'BLAKE', 'MANAGER', 7839, to_date('1991-1-05','yyyy-mm-dd'), 2850, null, 30);
insert into emp values( 7782, 'CLARK', 'MANAGER', 7839, to_date('1999-9-06','yyyy-mm-dd'), 2450, null, 10);
insert into emp values( 7566, 'JONES', 'MANAGER', 7839, to_date('2001-02-04','yyyy-mm-dd'), 2975, null, 20);
insert into emp values( 7788, 'SCOTT', 'ANALYST', 7566, to_date('2003-06-17','yyyy-mm-dd'), 3000, null, 20);
insert into emp values( 7902, 'FORD', 'ANALYST', 7566, to_date('1981-03-12','yyyy-mm-dd'), 3000, null, 20);
insert into emp values( 7369, 'SMITH', 'CLERK', 7902, to_date('2007-12-1','yyyy-mm-dd'), 800, null, 20);
insert into emp values( 7499, 'ALLEN', 'SALESMAN', 7698, to_date('20-2-1981','dd-mm-yyyy'), 1600, 300, 30);
insert into emp values( 7521, 'WARD', 'SALESMAN', 7698, to_date('22-2-1981','dd-mm-yyyy'), 1250, 500, 30);
insert into emp values( 7654, 'MARTIN', 'SALESMAN', 7698, to_date('28-9-1981','dd-mm-yyyy'), 1250, 1400, 30);
insert into emp values( 7844, 'TURNER', 'SALESMAN', 7698, to_date('8-9-1981','mm-dd-yyyy'), 1500, 0, 30);
insert into emp values( 7876, 'ADAMS', 'CLERK', 7788, to_date('13-7-87', 'dd-mm-yy') - 51, 1100, null, 20);
insert into emp values( 7900, 'JAMES', 'CLERK', 7698, to_date('3-12-1981','mm-dd-yyyy'), 950, null, 30);
insert into emp values( 7934, 'MILLER', 'CLERK', 7782, to_date('2003-1-23','yyyy-mm-dd'), 1300, null, 10);
  
CREATE TABLE salgrade (
grade number,    -- 등급
losal number,     -- 최저급여
hisal number );   -- 최고급여

insert into salgrade values (1, 700, 1200);
insert into salgrade values (2, 1201, 1400);
insert into salgrade values (3, 1401, 2000);
insert into salgrade values (4, 2001, 3000);
insert into salgrade values (5, 3001, 9999);


desc dept;
desc emp;
desc salgrade;

select * from dept;
select * from emp;
select * from salgrade;
select * from emp where deptno = '10';
select * from emp where sal >=1500;
select '1500은 '||grade||'등급입니다.' as str from salgrade where hisal>=1500 and losal<=1500;
select * from emp where job != upper('president') and mgr is null;
select * from emp where job = upper('president');   -- 객체값은 대/소문자 구분함

-- substr (문자열,시작번호,출력개수)
select substr(ename,1,2)||'**' from emp;
-- rpad (문자열 ,출력길이, 나머지채우는 문자)
select rpad(substr(ename,1,2),length(ename),'*') from emp;

select rownum,empno,ename from emp where rownum < 6;
select rownum,emp.* from emp where rownum < 10;
select * from emp where rownum < 5;

select max(sal) from emp;
select min(sal) from emp;
select sum(sal) from emp;
select avg(sal) from emp;
select round(avg(sal)) from emp;         -- 정수형태
select round(avg(sal),2) from emp;       -- 소수점 뒷 2자리까지.
select ceil(avg(sal)) from emp;          -- 올림
select floor(avg(sal)) from emp;         -- 내림
select sum(comm) from emp;
select avg(comm) from emp;
select count(*) from emp;
select distinct(job) from emp;

select ename,sal from emp where deptno = '10' and sal=(select max(sal) from emp where deptno='10');
select * from emp where sal >= 1000 and sal <= 2000;
select * from emp where deptno = 10 or deptno = 20;
select count(*) from emp where mgr = '7566';
select count(*) from emp where job = upper('analyst');



select ename,hiredate from emp;
select ename,substr(hiredate,1,2)||'-'||substr(hiredate,4,2)||'-'||
substr(hiredate,7,2) from emp;
select ename,to_char(hiredate,'yyyy-mm-dd') as hiredate from emp;

--2000이후 입사한 사원의 사원번호, 사원명 ,입사일(0000-00-00) 출력
select empno,ename,to_char(hiredate,'yyyy-mm-dd') as hiredate from emp where to_char(hiredate,'yyyy') >= 2000;

--SMITH의 부서명 출력
select (select dname from dept where deptno=emp.deptno)from emp where ename = upper('smith');
-- 내가한거 select dname from dept where deptno=(select deptno from emp where ename='SMITH');

--전체 출력 사원번호, 사원명, 부서명
select empno,ename,(select dname from dept where deptno=emp.deptno) as dname from emp;


--SMITH 와 같은 부서 사람들 출력

select * from emp where deptno=(select deptno from emp where ename='SMITH');
-- SMITH 가 동명이인일때 에러가 나니 한명의 결과만이라도 내려면 and rownum=1
select * from emp where deptno=(select deptno from emp where ename='SMITH' and rownum=1);

-- 내가한것, DEPTNO 바로 안쓰고 DEPT 테이블에서 부서명을 가져와서 찾으려니 돌아감
select * from(
select ename,(
select dname from dept where deptno=emp.deptno) as dname from emp)
where dname=(select dname from dept where deptno=(select deptno from emp where ename='SMITH'));


--SMITH가 속해 있는 부서의 평균 급여를 출력
select round(avg(sal)) from emp where deptno=(select deptno from emp where ename='SMITH');

--내가한것
select round(avg(sal),2) as avg from(
select sal,ename,(
select dname from dept where deptno=emp.deptno) as dname from emp)
where dname=(select dname from dept where deptno=(select deptno from emp where ename='SMITH'));



--SMITH보다 급여를 많이 받는 직원들을 급여순으로 출력
select empno,ename,sal,deptno from emp where sal >= (select sal from emp where ename='SMITH') order by sal desc;

-- 전체 평균 급여보다 많이 받는 직원들을 출력 (평균과 함께)
select empno,ename,sal,deptno,(select avg(sal) from emp) as avg 
from emp where sal > (select avg(sal) from emp) order by sal desc;

-- 전체 평균 급여보다 많이 받는 직원들을 출력 (그 사람들의 평균)
select empno,ename,sal,deptno,avg(sal) over() as avg 
from emp where sal > (select avg(sal) from emp) order by sal desc;


--급여를 가장 많이 받는 사원의 정보(사원번호,사원명,급여)를 출력
select empno,ename,sal from emp where sal = (select max(sal) from emp);
-- KING 빼고
select empno,ename,sal from emp where sal = (select max(sal) from emp where ename!='KING');












