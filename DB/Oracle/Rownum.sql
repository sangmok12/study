select rownum, empno, ename, job from emp;
desc emp;
select rownum, deptno, dname from dept;
select empno, ename, job from emp where rownum < 6;
select rownum empno, ename, job from emp where rownum >= 6;  --����ȵ�
select a.* from(select rownum as rn, empno, ename, job from emp)a
where rn >= 3 and rn <=7 ;
select a.* from(select rownum as rn, empno, ename, job from emp)a
where rn >= 11 and rn <=15 ;   -- rownum rn���� ���� �÷��� �����������

  -- order by �÷���(asc �Ǵ� desc  ,   asc�� ���� ����)
select rownum, empno, ename, job from emp order by empno asc;
  -- rownum ���� �����   , order by �� ������,  �ؼ� rownum ������ �ڼ���.
  
select b.* from
(select rownum as rn,a.* from
(select empno, ename, job from emp order by empno asc)a)b
where rn<=5;


  -- �޿����� 1~5, 6~10 �� �����ȣ, ����̸�, ����, �޿�
select b.* from(
select rownum as rn,a.* from(
select empno, ename, job, sal from emp order by sal desc)a)b
where rn <=5;

select b.* from(
select rownum as rn,a.* from(
select empno, ename, job, sal from emp order by sal desc)a)b
where rn between 6 and 10;

  -- IN �Լ�  (OR ��ɰ� ����)
  
  select empno, ename, deptno from emp where deptno =10 or deptno = 20;
  select empno, ename, deptno from emp where deptno in(10,20);
  select empno, ename, deptno, job from emp where job = 'CLERK' or 
                                                  job = 'ANALYST' or
                                                  job = 'PRESIDENT';
  select empno, ename, deptno, job from emp where job in('CLERK','ANALYST','PRESIDENT');
                                                