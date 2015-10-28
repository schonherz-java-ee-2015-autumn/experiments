DROP TABLE if exists importCSV;
CREATE TABLE importCSV(
    customer_name varchar(8),
    city varchar(100),
    street varchar(50),
    house_number varchar(10),
    floor_number varchar(10),
    door_number varchar(10),
    bell_name varchar(30),
    company_name varchar(100),
    tel_number1 varchar (15),
    tel_number2 varchar (15),
    tel_number3 varchar (15),
    comment varchar(100),
    discount_percentage varchar(3),
    banned varchar(2),
    premium varchar(2),
    number_of_orders int
);