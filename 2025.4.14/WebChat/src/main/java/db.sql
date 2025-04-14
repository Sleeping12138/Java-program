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

drop table if exists message_session;
create table message_session(
    session_id int primary key auto_increment,
    last_time datetime
)

insert into message_session values (1,'2025-04-14 00:00:00')
insert into message_session values (2,'2025-04-13 00:00:00')
insert into message_session values (3,'2025-04-12 00:00:00')

drop table if exists message_session_user
create table message_session_user(
    session_id int,
    user_id int
)

insert into message_session_user values (1,1),(1,2);
insert into message_session_user values (2,1),(2,3);
