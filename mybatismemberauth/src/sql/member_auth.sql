create table member_auth(
	member_no number not null,
	auth varchar(50) not null
);

alter table member_auth add constraint fk_member_auth_member_no
foreign key(member_no) references jspmember(member_no);