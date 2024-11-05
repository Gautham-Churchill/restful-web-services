-- drop tables
drop table if exists student;
drop table if exists employee;
drop table if exist users;
drop table if exist authorities;

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
-- created users table based on Spring security spec
create table users (
    username varchar(100) primary key,
    password varchar(70) not null,
    enabled smallint not null
);
-- created roles table based on Spring security spec
create table authorities (
    username varchar(100) not null,
    authority varchar(100) not null,
    constraint authorities_fk_1 foreign key(username) references users(username),
    constraint authorities_uk_1 unique(username, authority)
);

-- created custom users table for Spring security
create table members (
    user_id varchar(100) primary key,
    pw varchar(70) not null,
    active smallint not null
);

-- created custom roles table for Spring security
create table roles (
    user_id varchar(100) not null,
    role varchar(50) not null,
    constraint roles_fk_1 foreign key(user_id) references members(user_id),
    constraint role_uk_1 unique(user_id, role)
);

-- create sequences
create sequence "student_seq" increment 1 start 1;
create sequence "employee_seq" increment 1 start 1;


