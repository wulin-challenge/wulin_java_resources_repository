create table t_person(
	personId int(12) primary key auto_increment,
	username varchar(21),
	age int(12),
	denger varchar(12),
	record varchar(21),
	weight int(12),
	height int(12)
);

insert into t_person(username,age,denger,record,weight,height) values('张三1',24,'男','硕士',170,100);
insert into t_person(username,age,denger,record,weight,height) values('张三2',21,'男','硕士',170,100);
insert into t_person(username,age,denger,record,weight,height) values('张三3',21,'男','博士',170,100);
insert into t_person(username,age,denger,record,weight,height) values('张三4',22,'男','硕士',175,100);
insert into t_person(username,age,denger,record,weight,height) values('张三5',24,'男','硕士',175,100);
insert into t_person(username,age,denger,record,weight,height) values('张三6',24,'男','博士',175,100);