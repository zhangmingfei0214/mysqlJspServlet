create database users;
use users;
create table users(
	id varchar(255) primary key,
	username varchar(255),
	password varchar(255)
)engine=innodb default charset=utf8;

insert into users values('s0001','zhangsan','123456');
insert into users values('s0002','李四','654321');

