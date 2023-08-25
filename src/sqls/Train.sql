insert into students
values (1, 1, '张三')
     , (2, 2, '李四')
     , (3, 3, '王五')
     , (4, 1, '赵六')
     , (5, 2, '孙琪')
     , (6, 4, '钱巴')
     , (7, 1, '黄飞')
     , (8, 2, '刘明明')
     , (9, 3, '张婷婷')
     , (10, 4, '曲婉婷')
     , (11, 4, '媚儿');


insert into grades
values (1, '数学', 80),
       (1, '语文', 88),
       (1, '英语', 95),
       (2, '数学', 70),
       (2, '语文', 68),
       (2, '英语', 85),
       (3, '数学', 84),
       (3, '语文', 68),
       (3, '英语', 65),
       (4, '数学', 70),
       (4, '语文', 77),
       (4, '英语', 79),
       (5, '数学', 84),
       (5, '语文', 66),
       (5, '英语', 99),
       (6, '数学', 81),
       (6, '语文', 58),
       (6, '英语', 65);

create table class
(
    cid   int primary key comment '班级id',
    cname varchar(20) not null comment '班级名称'
);

insert into class
values (1, '一班'),
       (2, '二班'),
       (3, '三班'),
       (4, '四班'),
       (5, '五班'),
       (6, '六班'),
       (7, '七班');

# 先求出每个学生的总成绩从高到低排序
select sid, sum(score) tscore
from grades
group by sid
order by tscore desc;


# 按班级分组，求出每个班级的最高成绩
select students.sid, cid, sname, ts.tscore
from students
         inner join (select sid, sum(score) tscore
                     from grades
                     group by sid
                     order by tscore desc) as ts
                    on students.sid = ts.sid
group by cid;

# 使用联合查询
select students.sid, cid, sname, ts.tscore
from students,
     (select sid, sum(score) tscore
      from grades
      group by sid
      order by tscore desc) ts
where students.sid = ts.sid
group by cid;


# 查询每个班级第一名的总成绩及学生信息
select class.cname, a.sid, a.sname, a.tscore
from (select students.sid, cid, sname, ts.tscore
      from students
               inner join (select sid, sum(score) tscore
                           from grades
                           group by sid
                           order by tscore desc) as ts on students.sid = ts.sid
      group by cid) as a
         inner join class on class.cid = a.cid;