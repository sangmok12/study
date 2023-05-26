select sysdate from dual;   --��/��/��
select systimestamp from dual;    --��/��/��/ ��;��;��


-- ���伳�� : to_char 
select to_char(sysdate,'YYYYMMDD hh24miss') from dual;
-- 1�ð� ���ϱ�
select to_char(sysdate+1/24,'yyyymmdd hh24miss') from dual;
-- 30�� ���ϱ�
select to_char(sysdate+30/(24*60),'yyyymmdd hh24miss') from dual;
-- 10�� ���ϱ�
select to_char(sysdate+10/(24*60*60),'yyyymmdd hh24miss') from dual;

-- �ϼ� ���ϱ�
select sysdate, sysdate+35 from dual;
select sysdate+430, sysdate-20 from dual;
select sysdate, systimestamp -(1/24) from dual;
select to_char(sysdate+1,'yyyy/mm/dd hh24:mi:ss') from dual;

-- �� ���ϱ�
select add_months(sysdate,2) from dual;

-- ���� ���� (�ϼ��ȸ����� �Ҽ��� ����)
select months_between('2021-09-02','2021-08-02') from dual;
-- �ݿø� �Ҽ����� ���ڸ����� �� ���
select round(months_between('2021-09-02','2021-08-03'),2)  from dual;

select months_between('2023-05-23','2023-04-23') from dual;

--��¥�� ������������ ��ȯ
select to_char(sysdate,'yyyy-mm-dd day') from dual;
select to_char(sysdate,'mm') from dual;
select to_char(sysdate,'dd') from dual;

--���ڿ��� ��¥�������� ��ȯ
select to_date('20230522','yyyymmdd') from dual;

--3�ڸ��� �޸� ���,  �ڿ� ������ �Լ� �ڸ����� �� Ŀ����.
select to_char(123456,'fm999,999,999') from dual;
select to_char(123456,'fm999,999,999') as num1 from dual;


select '50'+'30' as sum from dual;

--���ڷλ��� ���ڸ� �������·� ��ȯ
select to_number('34431') as num from dual;



create table student (
userid varchar2(20) not null,
username char(10) not null,
age number,
gender char(1),   -- M,F
grade char(1) );

insert into student (userid,username,age,gender,grade) values('st101','tom','15','M','2');
insert into student (userid,username,age,gender,grade) values('st101','jane','16','f','3');
insert into student (userid,username,age,gender,grade) values('st103','yakima','14','M','1');
insert into student (userid,username,age,gender,grade) values('st104','yong','14','','1');
insert into student (userid,username,age,gender,grade) values('st105','minyo','0','f','');
insert into student (userid,username,age,gender,grade) values('st106','kang','15','','2');
insert into student (userid,username,age,gender,grade) values('st107','kim','0','M','');
insert into student (userid,username,age,gender,grade) values('st108','miranda','15','f','2');

update student set userid='st102' where username='jane';

select username as �̸�, userid as ���̵� from student;

select username,grade from student where grade = '1';
select username,age from student where age >= 15;
select userid from student where gender is null;
select username,age,grade from student where userid='st101' or userid ='st102' ;
select * from student where gender='F' and age >=15;
select userid,username from student where grade='2' and gender='M';
select avg(age) from student where gender='M' and age != '0' and age is not null ;
select * from student where gender='M' order by age asc;
update student set age='14' where userid='st105';
update student set age='15' where userid='st107';
update student set grade='1' where age='14';
update student set grade='2' where age='15';
update student set grade='3' where age='16';
update student set gender='M' where gender is null;
update student set gender='F' where gender='f';

commit;
