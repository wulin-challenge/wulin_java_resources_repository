CREATE TABLE person(
	id int primary key auto_increment,
	username varchar(21),
	password varchar(21),
	gender char(2),
	happy varchar(50),
	city char(2),
	introduce varchar(100),
	registerDate Date
);