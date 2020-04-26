create table exam_result(
id int,
name varchar(20),
chinese decimal(3,1),
math decimal(3,1),
english decimal(3,1)
);

INSERT into exam_result VALUES
(1,'tangsanzang',88,77,66),
(2,'zhubajie',54,65,45),
(3,'sunwukong',78.7,56,98),
(4,'liubei',75,76,75),
(5,'zhangfei',15,16,17),
(6,'guanyu',75,76,74),
(7,'jiabaoyu',85,65,75);

select id,name,math from exam_result;

select id,name,chinese + math + english from exam_result;
insert into exam_result values(8,'pangtong',85,65,75);
create table student(
id int not null,
name varchar(20),
mail varchar(30)
);