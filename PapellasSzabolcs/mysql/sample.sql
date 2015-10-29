drop database if exists mysql_homework;

create database mysql_homework;

use mysql_homework;

drop table if exists sample;

create table sample(

customer_name text not null,
city text not null,
street text not null,
house_number text,
floor_number text,
door_number text,
bell_name text,
company_name text,
tel_number1 text not null,
tel_number2 text,
tel_number3	text,
comment text,
discount_percent text,
banned varchar(1) not null,
premium varchar(1)	not null,
number_of_orders bigint not null

);

LOAD DATA LOCAL INFILE 'd:/GitRepo/training/homework/sql/sample.csv' 
INTO TABLE sample 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

alter table sample add column id bigint primary key auto_increment;

drop table if exists phones;
create table phones (
id bigint primary key auto_increment,
tel_number1 varchar(15) not null,
tel_number2 varchar(15),
tel_number3 varchar(15)

);

insert into phones (tel_number1, tel_number2, tel_number3) select tel_number1, tel_number2, tel_number3 from sample;
alter table sample add column phone_id bigint;
update sample s set phone_id = (select p.id from phones p where p.tel_number1 = s.tel_number1);
alter table sample change phone_id phone_id bigint not null,
add foreign key (phone_id) references phones(id);
alter table sample drop column tel_number1, drop column tel_number2, drop column tel_number3;

drop table if exists addresses;

create table addresses(

id bigint primary key auto_increment,
city text not null,
street text not null,
house_number text,
floor_number text,
door_number text,
bell_name text

);

insert into addresses (city, street, house_number, floor_number, door_number, bell_name) select distinct city, street, house_number, floor_number, door_number, bell_name from sample;
alter table sample add column address_id bigint;
update sample s set address_id = (select a.id from addresses a where a.city = s.city and a.street = s.street and a.house_number = s.house_number and a.floor_number = s.floor_number and a.door_number = s.door_number and a.bell_name = s.bell_name);
alter table sample change address_id address_id bigint not null,
add foreign key (address_id) references addresses(id);
alter table sample drop column city, drop column street, drop column house_number, drop column floor_number, drop column door_number, drop column bell_name;

drop table if exists services;

create table services(

id bigint primary key auto_increment,
discount_percent text,
banned varchar(1) not null,
premium varchar(1)	not null,
number_of_orders bigint not null

);

insert into services (discount_percent,	banned,	premium, number_of_orders) select discount_percent, banned, premium, number_of_orders from sample;
alter table sample add column service_id bigint;
update sample s set service_id = (select se.id from services se where s.id = se.id);
alter table sample change service_id service_id bigint not null,
add foreign key (service_id) references services(id);
alter table sample drop column discount_percent, drop column banned, drop column premium, drop column number_of_orders;

select s.id, s.customer_name, adr.city, adr.street, adr.house_number, adr.floor_number, adr.door_number, adr.bell_name, p.tel_number1,
p.tel_number2,	p.tel_number3, s.comment, se.discount_percent, se.banned, se.premium, se.number_of_orders from sample s, phones p, addresses adr, services se where s.phone_id = p.id and s.address_id = adr.id and s.service_id = se.id;