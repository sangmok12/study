
--  as(��������)�� �÷��� ������������

--  Equi Join �����

select e.empno  empno,
       e.ename  ename,
       d.dname  dname,
       e.deptno deptno
from emp e,dept d
where e.deptno = d.deptno;


-- Non-equal Join ������
-- e.sal��   s.loasl �� s.hisal �����ΰ� ���
select e.empno,
       e.ename,
       e.sal,
       s.grade ||'���' as grade
    from emp e, salgrade s
        where e.sal between s.losal and s.hisal;
        
-- Outer Join
--  ��ġ�� �ʾ� ��µ��� ���� �ڷ��� �ݴ��ʿ�?(+) �ϸ� ��µ�.
select e.empno  empno,
       e.ename  ename,
       d.dname  dname,
       e.deptno deptno
from emp e,dept d
where e.deptno(+) = d.deptno;


-- Self Join
-- �����ȣ, ����̸�, �Ŵ�����ȣ, �Ŵ����̸�
-- ���� ���̺� ������,   a �Ŵ��� = b �����ȣ
select a.empno,
       a.ename,
       a.mgr,
       b.ename,
       b.empno,
       b.job
    from emp a, emp b
        where a.mgr = b.empno;
        