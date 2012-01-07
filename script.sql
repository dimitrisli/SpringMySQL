create database javaTestDB;
use javaTestDB;
CREATE USER javauser IDENTIFIED BY 'javapass'; 
grant usage on *.* to javauser@localhost identified by 'javapass'; 
grant all privileges on javaTestDB.* to javauser@localhost;

CREATE TABLE PERSON_RECORD (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(15) NOT NULL,
	SURNAME VARCHAR(15) NOT NULL,
	PRIMARY KEY (ID)
);