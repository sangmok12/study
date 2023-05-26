--cmd> sqlplus sys/1234 as sysdba
--cmd> grant create view to c##java;
--cmd> exit;

--  View table  ����ǰ����, ī�Ǻ�,  �˻�,��ȸ�� ���� ���� �ȵ�.

create view v_emp_copy as select * from emp;
select * from v_emp_copy;


create view v_emp_sal_desc as 
select b.* from(
    select rownum rn,a.* from (
         select empno,ename,job,sal from emp
              order by sal desc)a )b ;
              
select * from v_emp_sal_desc where rn >=6 and rn <=10;

update emp set sal = 6000 where ename = 'KING';


-- �μ���ȣ, �μ��̸�, �����ȣ, ����̸�  �����ؼ� �����̺� �����
create view v_research as
select e.deptno,d.dname,e.empno,e.ename
    from emp e, dept d
        where e.deptno = d.deptno
        and d.dname = 'RESEARCH';

select * from v_research;
drop view v_research;

--null   nvl,  nvl2
-- nvl(�÷���,���ð�)   �÷��� null�ΰ�� ���ð����� ���
-- nvl2 (�÷���,���ð�1,���ð�2)  �÷��� null�� �ƴѰ�� ���ð�1, null�� ��� ���ð�2

select ename,nvl(mgr,0) as mgr from emp;
select ename,sal,(sal+nvl(comm,0)) sal2 from emp;

select empno,comm,nvl2(comm,comm+100,0)comm2 from emp;


--decode (�÷���,�񱳰�,ġȯ��1,��2,ġȯ��2...)
select deptno,
       dname,
       decode(deptno,10,'ȸ��',20,'����','�������¸���') as dname2
from dept;

select ename,
       sal,
       deptno,
       decode(deptno,10,sal*1.1,sal) �λ�޿�
from emp;



--�μ� 10 1.1   20 1.2   �������� 1.4�� �޿��λ�
select deptno,empno,sal,
       decode(deptno,10,sal*1.1,
                     20,sal*1.2,
                     sal*1.3) as sal2 from emp;

select ename,
       empno,
       job,
       decode(job,
       'ANALYST','�м���',
       'CLERK','����',
       'MANAGER','������',
       'SALESMAN','�������',
       'PRESIDENT','�����') as ��å
    from emp;
    
-- ����޿� 2000���� ������ ��, �׷��� ������ ��
-- sign : ���(1), ����(-1)
-- ù��°ĭ���� �Լ����� ���� �� ����,
-- �ι�°ĭ���� ������� �־����

select sign(1000) from dual;
select sign(-1000) from dual;

select ename,empno,sal,decode(sign(sal-2000),1,'��','��') as sal2 from emp;


--������ �޿��λ�
select ename,
       job,
       sal,
       decode(job,
       'ANALYST',sal*1.1,
       'CLERK',SAL*1.15,
       'MANAGER',SAL*1.2,
       sal
       ) �λ�޿� from emp;
       
-- 1�� ~ 6������ �⵵�� ������� �ش� ���� �Ի��� ��� ���� ����Ͻÿ�.
-- as ��  ���ڳ������� "" �ؾ���
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
                       )) "1~6��"
from emp;

select 
    count(decode(to_char(hiredate,'mm'),'01',1)) "1��",
    count(decode(to_char(hiredate,'mm'),'02',1)) "2��",
    count(decode(to_char(hiredate,'mm'),'03',1)) "3��",
    count(decode(to_char(hiredate,'mm'),'04',1)) "4��",
    count(decode(to_char(hiredate,'mm'),'05',1)) "5��",
    count(decode(to_char(hiredate,'mm'),'06',1)) "6��"
from emp;


select count(
decode( 
sign(to_char(hiredate,'mm')-7),-1,1)) "1~6��"
from emp;


-- count ������ �ߺ����� ����� �� ����
select count(*),
       count(ename),
       count(comm) from emp;
   
    