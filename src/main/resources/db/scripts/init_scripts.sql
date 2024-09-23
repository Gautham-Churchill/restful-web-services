-- drop tables
drop table if exists student;
drop table if exists employee;

-- drop sequences
drop sequence if exists "student_seq";
drop sequence if exists "employee_seq";

--- create tables
create table student (
	id int primary key ,
	first_name varchar(50) default null,
	last_name varchar(50) default null,
	email varchar(100) default null
);

create table employee (
    id int primary key,
    first_name varchar(50) default null,
	last_name varchar(50) default null,
	email varchar(100) default null
);

-- create sequences
create sequence "student_seq" increment 1 start 1;
create sequence "employee_seq" increment 1 start 1;


