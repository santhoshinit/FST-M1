REM   Script: Activity1
REM   Create Table

select * from scott.dept;

select * from scott.dept;

select * from scott.emp;

select * from scott.dept;

select * from scott.emp;

CREATE TABLE Customers ( 
    CustomerID int, 
    CustomerName varchar2(52), 
    ContactName varchar2(32), 
    Address varchar2(255), 
    City varchar2(50), 
    PostalCode varchar2(20), 
    Country varchar2(20) 
);

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

drop table salesman;

CREATE TABLE salesman ( 
    salesman_id int NOT NULL, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

