create table student20 (
userid varchar2(20) not null primary key,
name varchar2(20)
);

-- �ڽķ���
create table jumsu20 (
userid varchar2(20) not null,
kor number default 0,
eng number default 0,
constraint jumsu_fk 
foreign key(userid)  -- �������̺��� �÷�
references student20(userid)   -- ���۷��� ���̺��� �÷�
);

insert into student20 values('a1','ȫ�浿');
insert into student20 values('a2','��û��');
insert into student20 values('a3','�����');
insert into jumsu20 values('a1','100','90');
insert into jumsu20 values('a2','90','70');
insert into jumsu20 values('a5','88','68');   -- ����
-- a5 �θ�Ű�� ��� �Է¾ȵ�.


-- �ڽ� ���ڵ尡 �־ ����  ����
delete from student20 where userid ='a1';

alter table jumsu20 drop constraint jumsu_fk;   --���ǻ���
delete from student20 where userid='a1';


create table jumsu22 (
userid varchar2(20) not null,
kor number default 0,
eng number default 0,
constraint jumsu22_fk 
foreign key(userid)  -- �������̺��� �÷�
references student20(userid)   -- ���۷��� ���̺��� �÷�
on delete cascade
);

alter table jumsu22 drop constraint jumsu22_fk;  --���ǻ����غ�
insert into jumsu22 values('a1','100','90');    -- �Է� ����
insert into jumsu22 values('a2','90','70');     -- �Է� ����


alter table jumsu22 add constraint jumsu22_fk1
foreign key(userid) 
references student20(userid);    -- jumsu22 �� student20 �� ���� ���̵� ��ġ���� �ʾ� �ȵ�.
insert into jumsu22 values('a3','90','70');
insert into student20 values('a2','�ɺ���');
insert into student20 values('a1','ȣ����');
alter table jumsu22 add constraint jumsu22_fk1
foreign key(userid) 
references student20(userid);
--  jumsu22  a1,a2,a3 ����  student20  a1,a2,a3 ���� ������ �¾��� �ٽ� �ܷ�Ű �߰���


delete from jumsu22 where userid='a1';
-- �θ����̺� �־ �ڽ����̺��� ������ ������ ����
delete from student20 where userid='a2';
-- �ڽķ��ڵ忡 �־  a2�� ���� ���� (���� jumsu22 �� a2,a3 ����
delete from student20 where userid='a1';
-- jumsu22 �� a1 �����͸� ���� �߱⿡  ��������