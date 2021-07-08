drop table member;
create table member(
member_no number primary key,
member_id varchar2(20) not null unique,
member_pw varchar2(20) not null,
member_nick varchar2(30) not null unique,
member_birth char(10) not null,
member_auth varchar2(9) not null, check(member_auth in('관리자','VIP','일반')),
member_point number default 0 not null,
member_join date default sysdate not null
);

create sequence member_seq;

select * from member;

select * from v$version; 

insert into member values(28, 'tmddns678', 'tmddns', 'awesome', '1994-12-14', '관리자', 0, sysdate);
delete member where member_no = 28;
select * from member where instr(member_auth, upper('P')) > 0;
commit;




select * from worker;

drop table board;
create table board(
board_no number primary key,
board_writer not null references member(member_id) on delete cascade,
board_header char(6) check(board_header in ('정보','공지','유머','자유')),
board_title varchar2(300) not null,
board_content varchar2(4000) not null,
board_read number default 0 not null,
board_time date default sysdate not null
);
create sequence board_seq;

drop sequence board_Seq;

select max(board_no) from board;
select * from board;
select * from worker;
select * from member;
insert into member(member_no, member_id, member_pw, member_nick, member_birth, member_auth) values(member_seq.nextval, 'aaaa', 'aaa', 'aaa', '1994-12-14', '일반');
select * from member where member_id = 'good' and member_pw = 'goods';
commit;

update member set member_nick = 'good1', member_birth = '1994-12-14'  where member_pw = 'good';
rollback;

update member set member_pw='good' where member_no=51 and member_pw='good';