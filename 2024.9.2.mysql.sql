-- 对表的增删改查
-- 插入数据
show tables;

SELECT * FROM exam;

DESC exam;

SELECT * FROM exam;

INSERT INTO exam VALUES (8,'zhangsan',90,80,77);

-- 删除数据
DELETE FROM exam WHERE name = 'zhangsan';

SELECT * FROM exam;

INSERT INTO exam VALUES (8,'zhangsan',90,80,77);

SELECT * FROM exam;

-- 修改数据
UPDATE exam SET math = 99 WHERE name = 'zhangsan';

-- 数据库约束

CREATE TABLE stu(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	age INT NOT NULL
);

SELECT * FROM stu;

-- 约束类型 ：NOT NULL \ UNIQUE \ DEFAULT \ PRIMARY KEY \ FOREIGN KEY \ CHECK;

DROP TABLE stu;


CREATE TABLE stu(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	age INT NOT NULL,
	class INT NOT NULL
);


CREATE TABLE class2(
	id BIGINT PRIMARY KEY auto_increment,
	className VARCHAR(10)
);

INSERT INTO class2 VALUES (1,'java111'),(2,'java112'),(3,'java113');

INSERT INTO stu VALUES (1,'zhangsan',18,1);

DROP TABLE class2;

CREATE TABLE stu(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	age INT NOT NULL,
	class INT NOT NULL
);

CREATE TABLE class2(
	id BIGINT PRIMARY KEY auto_increment,
	className VARCHAR(10),
	FOREIGN KEY (id) REFERENCES stu(id);
);
-- 外键

SHOW tables;

CREATE TABLE test01(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	sex VARCHAR(10),
);

DESC test01;

INSERT INTO test01 VALUES (1,'zhangsan','男');

DROP TABLE test01;

-- 表的设计
-- 一对一 + 一对多 + 多对多

CREATE TABLE test01(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	sex VARCHAR(10)
);

SELECT * FROM test01;
DROP TABLE test01;

INSERT INTO test01(id,name,sex) SELECT id,name,chinese FROM exam;

-- 插入查询数据
INSERT INTO test01 (id,name) SELECT id,name FROM exam;

-- 聚合查询
SELECT * FROM exam;

SELECT COUNT(*) FROM exam WHERE name LIKE '孙%';

SELECT SUM(chinese) FROM exam;

SELECT AVG(math) FROM exam;

SELECT MAX(english) FROM exam;

SELECT MIN(english) FROM exam;

-- 分组查询 GROUP BY 
SELECT role,ROUND(AVG(salary),2) FROM emp GROUP BY role HAVING AVG(salary)>10000;

-- ROUND(X) 函数

-- 联合查询
SELECT * FROM student;

SELECT * FROM class;

-- 内连接
SELECT * FROM student,class;

SELECT * FROM student,class WHERE student.class_id = class.class_id;

SELECT * FROM student JOIN class ON student.class_id = class.class_id;

SELECT student.student_id,sn,name,score FROM student JOIN score ON student.student_id = score.student_id WHERE name = '许仙';

SELECT name,ROUND(SUM(score),2) FROM student,score WHERE student.student_id = score.student_id GROUP BY name ORDER BY ROUND(SUM(score),2) ASC;

-- 外连接
SELECT * FROM student,score WHERE student.student_id = score.student_id;

SELECT * FROM student RIGHT JOIN score ON student.student_id = score.student_id;

-- 左外连接 + 右外连接处理null

-- 自链接 - 比较同列数据

SELECT * FROM score s1,score s2 WHERE s1.student_id = s2.student_id AND s1.course_id=1 AND s2.course_id = 3 AND s2.score>s1.score;

-- 查找tellme的同班同学
SELECT * FROM student WHERE class_id = (SELECT class_id FROM student WHERE name = 'tellme');

SELECT * from score WHERE course_id not IN (SELECT course_id FROM course WHERE name = '语文' OR name = '英文');


-- 合并查询
SELECT * from course WHERE name = 'java' UNION SELECT * FROM course WHERE name = '中国传统文化';

SELECT name from course WHERE name = 'java' UNION SELECT score FROM score WHERE score = 70.5;






























































































