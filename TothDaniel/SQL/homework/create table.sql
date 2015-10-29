drop table if exists imported_customers;

create table imported_customers(
    customer_name varchar(2) not null,
    city varchar(250) not null,
    street varchar(250) not null,
    house_number varchar(50) not null,
    floor_number varchar(50),
    door_number varchar(50),
    bell_name varchar(250),
    company_name varchar(250),
    tel_number1 varchar(50) not null,
    tel_number2 varchar(50),
    tel_number3 varchar(50),
	comment varchar(250),
    discount_percent varchar(10),
    banned varchar(1),
    premium varchar(1),
    number_of_orders int
);
