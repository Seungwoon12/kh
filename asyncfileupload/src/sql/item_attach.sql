create table item_attach(
	fullname varchar(150) not null,
	item_id number not null,
	regdate timestamp default sysdate,
	primary key (fullname)

);