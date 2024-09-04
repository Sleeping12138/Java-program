CREATE TABLE temp(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10)
);

INSERT INTO temp VALUES (1,'zhangsan');

SELECT * FROM temp LIMIT 1 OFFSET 1;

SELECT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1;

SELECT * FROM T1 UNION SELECT * FROM T2;

DROP TABLE temp;

CREATE TABLE staff(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	age INT,
	ready bool
);

CREATE TABLE clockingIn(
	readyId bool PRIMARY KEY COMMENT '是否到底编号',
	name VARCHAR(10) COMMENT '注释'
);


INSERT INTO staff VALUES (1,'zhangsan',26,1);

INSERT INTO clockingIn VALUES (0,'未到'),(1,'到了');

SELECT * FROM staff;
SELECT * FROM clockingIn;

SELECT * FROM stu;

DROP TABLE stu;

CREATE TABLE stu(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	room_id BIGINT
);

CREATE TABLE room(
	room_id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10)
);

CREATE TABLE record(
	record_day date,
	room_id BIGINT,
	isRecord bool
);

DROP TABLE stu;
DROP TABLE room;
DROP TABLE record;

CREATE TABLE user1(
	id BIGINT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	car_id BIGINT
);

CREATE TABLE car(
	car_id BIGINT PRIMARY KEY auto_increment;
	name VARCHAR(10),
	user_id BIGINT
);

CREATE TABLE information(
	info VARCHAR(50) COMMENT '违章信息',
	user_id BIGINT,
	car_id BIGINT
);


CREATE TABLE user1 (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10)
);

CREATE TABLE car (
    car_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user1(id)
);

CREATE TABLE information (
    info VARCHAR(50) COMMENT '违章信息',
    user_id BIGINT,
    car_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user1(id),
    FOREIGN KEY (car_id) REFERENCES car(car_id)
);

CREATE TABLE canteen (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,  
    name VARCHAR(50) NOT NULL,                             
);

-- 创建食堂仓库表
CREATE TABLE canteen_storage (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, 
    canteen_id BIGINT,                    
    name VARCHAR(50),                                   
    FOREIGN KEY (canteen_id) REFERENCES canteen(id) 
);

-- 创建仓库收费记录表
CREATE TABLE storage_fee_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, 
    canteen_id BIGINT,                    
    amount DECIMAL(10),            
    record_date DATE,                    
    FOREIGN KEY (canteen_id) REFERENCES canteen(id)  
);






































































































