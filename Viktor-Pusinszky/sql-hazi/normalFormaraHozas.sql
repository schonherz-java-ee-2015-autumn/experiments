DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS company;

CREATE TABLE orders (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    city_id BIGINT,
    street varchar(100),
    house_number varchar(10),
    floor_number varchar(10),
    door_number varchar(10),
	discount_percentage varchar(3),
    comments varchar(100)
);
CREATE TABLE customer (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    company_id BIGINT,
	customer_name varchar(8),
	tel_number1 varchar (15),
    tel_number2 varchar (15),
    tel_number3 varchar (15),
    number_of_orders int,
    banned varchar(2),
    premium varchar(2)
);
CREATE TABLE company (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    company_name varchar(100)
);
CREATE TABLE city (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    city_name varchar(100)
);
insert company(company_name) select distinct company_name from importcsv;
insert into city(city_name) select distinct city from importcsv;

insert into customer(
	customer_name,tel_number1,tel_number2,tel_number3,company_id,number_of_orders,banned,premium) 
    SELECT 
    customer_name,tel_number1,tel_number2,tel_number3,id,number_of_orders,banned,premium 
    FROM importcsv 
    INNER JOIN company ON company.company_name = importcsv.company_name ;
    
insert into orders(
		customer_id,city_id,street,house_number,floor_number,door_number,discount_percentage,comments)
        SELECT 
        c.id,ct.id,i.street,i.house_number,i.floor_number,i.door_number,i.discount_percentage,i.`comment`
        FROM  importcsv i 
		INNER JOIN customer c ON i.tel_number1 = c.tel_number1 
		INNER JOIN city ct ON i.city = ct.city_name;