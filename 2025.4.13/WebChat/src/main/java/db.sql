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

drop table if exists friend

create table friend(
    user_id int,
    friend_id int
)

insert into friend values (1,2);
insert into friend values (2,1);
insert into friend values (1,3);
insert into friend values (3,1);

insert into friend values (2,3);
insert into friend values (3,2);