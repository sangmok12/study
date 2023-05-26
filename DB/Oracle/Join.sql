
--  as(생략가능)로 컬럼명 새로지정해줌

--  Equi Join 등가조인

select e.empno  empno,
       e.ename  ename,
       d.dname  dname,
       e.deptno deptno
from emp e,dept d
where e.deptno = d.deptno;


-- Non-equal Join 비등가조인
-- e.sal이   s.loasl 과 s.hisal 사이인것 출력
select e.empno,
       e.ename,
       e.sal,
       s.grade ||'등급' as grade
    from emp e, salgrade s
        where e.sal between s.losal and s.hisal;
        
-- Outer Join
--  겹치지 않아 출력되지 않은 자료의 반대쪽에?(+) 하면 출력됨.
select e.empno  empno,
       e.ename  ename,
       d.dname  dname,
       e.deptno deptno
from emp e,dept d
where e.deptno(+) = d.deptno;


-- Self Join
-- 사원번호, 사원이름, 매니저번호, 매니저이름
-- 같은 테이블 내에서,   a 매니저 = b 사원번호
select a.empno,
       a.ename,
       a.mgr,
       b.ename,
       b.empno,
       b.job
    from emp a, emp b
        where a.mgr = b.empno;
        