use mydb3;
drop table if exists city;
create table if not exists city(
	id int primary key auto_increment,
	city_name varchar(10) not null,
	province_name varchar(10) not null
);
insert into city(city_name,province_name) values('长春','吉林省');
insert into city(city_name,province_name) values('吉林市','吉林省');
insert into city(city_name,province_name) values('松原','吉林省');
insert into city(city_name,province_name) values('通化','吉林省');

insert into city(city_name,province_name) values('沈阳','辽宁省');
insert into city(city_name,province_name) values('大连','辽宁省');
insert into city(city_name,province_name) values('鞍山','辽宁省');
insert into city(city_name,province_name) values('抚顺','辽宁省');
insert into city(city_name,province_name) values('铁岭','辽宁省');

insert into city(city_name,province_name) values('济南','山东省');
insert into city(city_name,province_name) values('青岛','山东省');
insert into city(city_name,province_name) values('威海','山东省');

insert into city(city_name,province_name) values('长沙','湖南省');
insert into city(city_name,province_name) values('株洲','湖南省');

select * from city;




