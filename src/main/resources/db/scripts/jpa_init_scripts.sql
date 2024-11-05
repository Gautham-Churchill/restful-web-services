--------------------------------------------------
-- drop tables
--------------------------------------------------
drop table if exists instructor;
drop table if exists instructor_detail;

--------------------------------------------------
-- drop sequence
--------------------------------------------------
drop sequence if exists instructor_seq;
drop sequence if exists instructor_detail_seq;

--------------------------------------------------
-- create tables
--------------------------------------------------
create table instructor (
  id int primary key,
  first_name varchar(45) default null,
  last_name varchar(45) default null,
  email varchar(80) default null,
  created_on timestamp default current_timestamp,
  updated_on timestamp default current_timestamp
);

create table instructor_detail (
  id int primary key,
  youtube_channel varchar(128) default null,
  hobby varchar(45) default null,
  instructor_id int not null,
  created_on timestamp default current_timestamp,
  updated_on timestamp default current_timestamp,
  constraint instructor_fk_1 foreign key (instructor_id) references instructor (id) on delete no action on update no action
);

create table course (
    id serial primary key,
    title varchar(128) default null,
    instructor_id int default null,
    unique(title),
    constraint instructor_fk_1 foreign key (instructor_id) references instructor (id) on delete no action on update no action
);

--------------------------------------------------
-- create sequences
--------------------------------------------------
create sequence "instructor_seq" increment 1 start 1;
create sequence "instructor_detail_seq" increment 1 start 1;
