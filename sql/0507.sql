show databases;
create database Vince_0507;
use Vince_0507;
create table goods(
    goods_id int,
    goods_name varchar(50),
    unitprice decimal(6,2) ,
    catagory varchar(20) ,
    provider varchar(10)
);
desc goods;
create table customer(
    customer_id int,
    name varchar(20),
    address varchar(256),
    email varchar(64),
    sex varchar(2),
    card_id varchar(18)
);
desc customer;
create table purchase(
    order_id int,
    customer_id int,
    goods_id int,
    nums int
);
desc purchase;
create table student(
    id int,
    sn int,
    name varchar(20),
    qq_mail varchar(20)
);
insert into student values(1,10000,'tangsanzang',null);
insert into student(id,sn,name) values
(2,10001,'caocao'),
(3,10002,'sunquan');
create table exam_result(
    id int,
    name varchar(20),
    chinese decimal(3,1),
    math decimal(3,1),
    english decimal(3,1)
);
insert into exam_result values
(1,'tangsanzang',67,98,56),
(2,'sunwukong',87.5,78,77),
(3,'zhubajie',88,98.5,90),
(4,'caocao',82,84,67),
(5,'liubei',55.5,85,45),
(6,'sunquan',70,73,78.5),
(7,'songjiang',75,65,30);
select * from exam_result;
select id,name,chinese,math from exam_result;
select id,name,10 from exam_result;
select id,name,math + 10 from exam_result;
select id,name,chinese + math + english from exam_result;
select id,name,chinese + math +english as total from exam_result;
select math from exam_result;
select distinct math from exam_result;
select id,name,math from exam_result order by math desc;
select id,name,math from exam_result order by math;
select id,name,chinese + math + english as total from exam_result order by total desc;
select id,name,math,chinese,english from exam_result order by math desc;
select name,chinese from exam_result where chinese < 60;
select name,chinese,math from exam_result where chinese > math;
select name,chinese + math + english as total from exam_result where chinese + math + english < 200; 
select * from exam_result where chinese > 80 and math > 80;
select * from exam_result where chinese > 80 or math > 80;
select * from exam_result where chinese > 80 or math > 70 and english > 70;
select * from exam_result where (chinese > 80 or math > 70) and english > 70;
select name,chinese from exam_result where chinese between 80 and 90;
select name,chinese from exam_result where chinese >= 80 and chinese <= 90;
select name,math from exam_result where math in (58,59,98,99);
select name,math from exam_result where math = 58 or math = 59 or math = 98 or math = 99;
select math from exam_result where math like '8%';
select math from exam_result where math like '8_';
select math from exam_result where math is not null;
select id,name,chinese,math,english from exam_result order by id limit 3;
select id,name,chinese,math,english from exam_result order by id limit 3 offset 3;
select id,name,chinese,math,english from exam_result order by id limit 3 offset 6;--从第六条开始,筛选三个