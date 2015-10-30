load data infile 'e:\\Java EE training\\training\\homework\\sql\\sample.csv' 
into table imported_customers
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 rows
;