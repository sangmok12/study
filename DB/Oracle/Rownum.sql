select rownum, empno, ename, job from emp;
desc emp;
select rownum, deptno, dname from dept;
select empno, ename, job from emp where rownum < 6;
select rownum empno, ename, job from emp where rownum >= 6;  --실행안됨
select a.* from(select rownum as rn, empno, ename, job from emp)a
where rn >= 3 and rn <=7 ;
select a.* from(select rownum as rn, empno, ename, job from emp)a
where rn >= 11 and rn <=15 ;   -- rownum rn으로 따로 컬럼명 설정해줘야함

  -- order by 컬럼명(asc 또는 desc  ,   asc는 생략 가능)
select rownum, empno, ename, job from emp order by empno asc;
  -- rownum 포함 출력후   , order by 를 정렬함,  해서 rownum 순서가 뒤섞임.
  
select b.* from
(select rownum as rn,a.* from
(select empno, ename, job from emp order by empno asc)a)b
where rn<=5;


  -- 급여기준 1~5, 6~10 등 사원번호, 사원이름, 업무, 급여
select b.* from(
select rownum as rn,a.* from(
select empno, ename, job, sal from emp order by sal desc)a)b
where rn <=5;

select b.* from(
select rownum as rn,a.* from(
select empno, ename, job, sal from emp order by sal desc)a)b
where rn between 6 and 10;

  -- IN 함수  (OR 기능과 동일)
  
  select empno, ename, deptno from emp where deptno =10 or deptno = 20;
  select empno, ename, deptno from emp where deptno in(10,20);
  select empno, ename, deptno, job from emp where job = 'CLERK' or 
                                                  job = 'ANALYST' or
                                                  job = 'PRESIDENT';
  select empno, ename, deptno, job from emp where job in('CLERK','ANALYST','PRESIDENT');
                                                