create table s_emp (
	id number not null primary key,
	name varchar(25) not null,
	start_date date,
	title varchar(25),
	dept_name varchar(25),
	salary decimal(11, 2)
);