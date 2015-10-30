LOAD DATA INFILE 'e:\\install\\training\\homework\\sql\\sample.csv' 
INTO TABLE importCSV
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
;
