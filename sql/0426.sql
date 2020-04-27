-- 在以上创建的商品表中插入一条数据：名称为“学生书包”、价格18.91、库存101、描述为空
create database practice_0426;
use practice_0426;
create table goods(
    goods_name varchar(20),
    goods_price decimal(6,2),
    goods_repertory int,
    goods_discription varchar(256)
);
insert into goods values('xueshengshubao',18.91,101,'null');


--在图书表中新增一条记录：Java核心技术、作者“Cay S. Horstman”，价格56.43，分类为“计算机技术”
create table book(
    book_name varchar(20),
    book_author varchar(32),
    book_price decimal(6,2),
    book_type varchar(64)
);
insert into book values('Javahexinjishu','Cay S.Horstman',56.43,'jisuanjijishu');

--student学生表中，字段有姓名name，年龄age，要求查询姓张，并且年龄在18到25岁之间的学生
create table student(
    name varchar(20),
    age int
);
select name,age from student where name like 'zhnag%' and name between 18 and 25;

--查询article文章表中，发表日期create_date在2019年1月1日上午10点30分至2019年11月10日下午4点2分的文章
select * from article where create_date between '2019-1-1-10:30 am' and '2019-11-10-4:2 pm';

--查询article文章表中，文章标题title为空，或者满足发表日期create_date在2019年1月1日之后
select * from article where title is null or create_date > '2019-1-1-00:00';

create table emp(id int,name varchar(20),role varchar(20),salary int);

insert into emp values(1,'mayun','fuwuyuan',10);
insert into emp values(1,'mayun1','fuwuyuan',10);
insert into emp values(1,'mayun2','laoshi',15);
insert into emp values(1,'mayun3','laoshi',15);
insert into emp values(1,'mayun4','zongcai',20);
insert into emp values(1,'mayun5','zongcai',20);
select role,max(salary),min(salary),avg(salary) from emp group by role;
马云