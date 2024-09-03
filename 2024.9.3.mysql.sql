-- 查询

SELECT sex,AVG(salary) FROM emp GROUP BY sex;

SELECT depart,SUM(salary) FROM emp GROUP BY depart LIMIT 1 OFFSET 1;

SELECT * FROM emp WHERE name IN (SELECT DISTINCT name FROM emp);


SELECT depart,AVG(salary) FROM emp WHERE salary>10000 AND sex='男' GROUP BY depart;


CREATE TABLE A(
	name VARCHAR(32),
	grade INT
);

CREATE TABLE B(
	name VARCHAR(32),
	age INT
);

INSERT INTO A VALUES ('zhangsan',80),('lisi',60),('wangwu',84);
INSERT INTO B VALUES ('zhangsan',26),('lisi',24),('wangwu',26),('wutian',26);

SELECT A.`name`,grade,age FROM A RIGHT JOIN B ON A.`name` = B.`name`;

DROP TABLE A;
DROP TABLE B;

SELECT d.name,SUM(sa.salary) FROM depart d,staff st,salary sa WHERE d.depart_id = st.depart_id AND st.staff_id = sa.staff_id AND month = '2016-09' GROUP BY d.name;

SELECT d.name,COUNT(*) FROM depart d JOIN staff s ON d.depart_id = s.depart_id GROUP BY d.`name`; 

SELECT d.name,sa.month,SUM(salary) FROM depart d,staff st,salary sa WHERE d.depart_id = st.depart_id AND st.staff_id = sa.staff_id GROUP BY depart d.name,sa.month;































































































