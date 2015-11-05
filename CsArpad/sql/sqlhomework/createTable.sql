DROP TABLE IF EXISTS loadfromcsv;

CREATE TABLE loadfromcsv(
	customer_name varchar(10),
    city varchar(40),
    street varchar(60),
    house_number int,
    floor_number int,
    door_number int,
    bell_name varchar(10),
    company_name varchar(50),
    tel_number1 int,
    tel_number2 int,
    tel_number3 int,
    comment varchar(100),
    discount_percent varchar(10),
    banned varchar(5),
    premium varchar(5),
    number_of_orders int
);