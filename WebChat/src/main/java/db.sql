create database if not exists java_chatroom charset utf8

use java_chatroom

drop table if exists user

create table user(
    user_id int primary key auto_increment,
    user_name varchar(20) unique,
    password varchar(50)
)

insert into user values (null,"zhangsan",123456);
insert into user values (null,"lisi",123456);