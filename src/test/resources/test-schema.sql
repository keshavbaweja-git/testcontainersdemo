create table employee (
    id serial primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    dept_id int not null
);

create table department (
    id serial primary key,
    name varchar(100) not null
);

insert into department (name) values ('board');
insert into department (name) values ('department-1');
insert into department (name) values ('department-2');
insert into department (name) values ('department-3');