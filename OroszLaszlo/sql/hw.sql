drop table if exists csvImport;

create table csvImport(
	customer_name varchar(5),
	city varchar(20),
	street varchar(30),
	house_number varchar(10),
	floor_number varchar(5),
	door_number varchar(5),
	bell_name varchar(30),
	company_name varchar(40),
	tel_number1 varchar(10),
	tel_number2 varchar(10),
	tel_number3 varchar(10),
	comment varchar(30),
	discount_percent varchar(5),
	banned varchar(2),
	premium varchar(2),
	number_of_orders int
);

load data local infile 'C:/JavaEE/github/training/homework/sql/sample.csv' into table csvImport
	fields terminated by ',' enclosed by '"' lines terminated by '\n'
    ignore 1 rows;

drop table if exists customers;

create table customers (
	customer_name varchar(5),
    city varchar(20),
    banned varchar(2),
    premium varchar(2)
);

insert into customers (customer_name, city, banned, premium) 
	select distinct customer_name, city, banned, premium from csvimport order by customer_name;

alter table  csvimport
	drop column city,
    drop column banned,
    drop column premium;

select o.customer_name, c.city, o.street, o.house_number, o.floor_number, o.door_number, o.bell_name,
	o.company_name, o.tel_number1, o.tel_number2, o.tel_number3, o.comment, o.discount_percent, c.banned, c.premium, o.number_of_orders
	from csvimport AS o inner join customers AS c on o.customer_name = c.customer_name;