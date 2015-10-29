drop table if exists address;
drop table if exists orders;
drop table if exists company;
drop table if exists customer;

create table customer (
	id bigint primary key auto_increment,
    company_id bigint,
	customer_name varchar(2),
	tel_number1 varchar (50),
    tel_number2 varchar (50),
    tel_number3 varchar (50),
    number_of_orders int,
    banned varchar(1),
    premium varchar(1)
);

create table orders (
	id bigint primary key auto_increment,
    customer_id bigint,
    address_id bigint,
	discount_percent varchar(10),
    comment varchar(100)
);

create table company (
	id bigint primary key auto_increment,
    company_name varchar(250)
);

drop table if exists address;
create table address (
	id bigint primary key auto_increment,
    city varchar(250),
	street varchar(250),
    house_number varchar(50),
    floor_number varchar(50),
    door_number varchar(50),
    bell_name varchar(250)
);

insert company(company_name) select distinct company_name from imported_customers;

insert into customer(
	customer_name,tel_number1,tel_number2,tel_number3,company_id,number_of_orders,banned,premium) 
    select 
    customer_name,tel_number1,tel_number2,tel_number3,id,number_of_orders,banned,premium 
    from imported_customers 
    inner join company on company.company_name = imported_customers.company_name ;
	
    
insert into address(
		city,street,house_number,floor_number,door_number,bell_name)
        select 
        i.city,i.street,i.house_number,i.floor_number,i.door_number,i.bell_name
        from  imported_customers i;
    
insert into orders(
		customer_id,address_id,discount_percent,comment)
        select 
        c.id,ad.id,i.discount_percent,i.`comment`
        from  imported_customers i 
		inner join customer c on i.tel_number1 = c.tel_number1 
		inner join address ad on i.city = ad.city;