create table jsp_board(
	no number not null primary key,
	name varchar2(12) not null,
	passwd varchar2(12) not null,
	title varchar2(50) not null,
	email varchar2(40) not null,
	regdate date default sysdate,
	content varchar2(4000) not null
);