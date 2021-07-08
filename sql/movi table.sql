--movi 테이블

drop table mygenre;
create table mygenre(
mygenre_member_no references member(member_no) on delete cascade,
mygenre_genre_no references genre(genre_no) on delete cascade,
primary key(mygenre_member_no, mygenre_genre_no)
);

drop table love;
create table love(
love_movie_no references movie(movie_no) on delete cascade,
love_member_no references member(member_no) on delete set null,
love_date date default sysdate not null,
primary key(love_movie_no, love_member_no)
);


drop table actor;
drop sequence actor_seq;
create sequence actor_seq;

create table actor(
actor_no number primary key,
actor_name varchar2(60) not null
);
create table actor_con(
con_movie_no references movie(movie_no) on delete cascade,
con_actor_no references actor(actor_no) on delete cascade,
con_actor_role char(6) not null check(con_actor_role in ('주연','조연')),
primary key(con_movie_no, con_actor_no)
);

alter table member drop(member_event_no);

create sequence event_seq;

drop table event;

create table event(
event_no number primary key,
event_name varchar2(200) not null,
event_start date not null,
event_end date,
event_content varchar2(4000) not null
);

create table coupon(
coupon_no number primary key,
coupon_event_no number,
coupon_name varchar2(30) not null check(coupon_name in('꽝','CGV10%할인','영화예매권','바나나우유','비타500','abc초콜릿')),
coupon_start date default sysdate not null,
coupon_end date
);
alter table coupon
add constraint event_coupon
foreign key(coupon_event_no)
references event(event_no) on delete set null;

create table member_coupon(
event_member_no references member(member_no) on delete cascade,
member_coupon_no references coupon(coupon_no) on delete set null,
member_event_no references event(event_no) on delete set null,
primary key(event_member_no,member_coupon_no,member_event_no)
);

alter table coupon modify coupon_end default sysdate+30;
alter table coupon modify coupon_end not null;
alter table coupon modify coupon_event_no not null;

create table profile(
profile_no number primary key,
profile_upload_name varchar2(256) not null,
profile_save_name varchar2(256) not null unique , 
profile_size number default 0, 
profile_type varchar2(256),
profile_member_no number references member(member_no) on delete cascade
);
create sequence profile_seq;


alter table movie add(movie_poster varchar2(256) unique);

------------------------------

--승운 리뷰 관리자 테이블
drop table notice;
create table notice(
notice_no number primary key,
notice_header char(6) not null check(notice_header in ('공지','필독')),
notice_title varchar2(200) not null,
notice_content varchar2(4000) not null,
notice_date date default sysdate,
notice_read number default 0,
notice_auth_no references member(member_no) on delete cascade
);
create sequence notice_seq;

--관리자 리뷰 테이블
drop table notice_reply;
create table notice_reply(
reply_no number primary key,
reply_origin references notice(notice_no) on delete cascade,
reply_writer_no references member(member_no) on delete cascade,
reply_root number not null,
reply_parent number default 0 not null,
reply_depth number default 0 not null,
reply_content varchar2(3000) not null,
reply_time date default sysdate not null
);
create sequence notice_reply_seq;


insert into review_admin values(review_admin_seq.nextval, '공지', '공지사항 꼭 읽어주세요', '테스트', sysdate, 0, 3);
commit;

select * from review_admin order by admin_no;


select A.*, M.member_nick admin_nick from review_admin A inner join member M on A.admin_auth_no = M.member_no order by admin_no;  

select N.*, M.member_nick admin_nick, count(reply_origin) reply_count 
    from notice N 
        inner join member M on N.notice_auth_no = M.member_no
        left outer join notice_Reply NR on N.notice_no = NR.reply_origin
        group by N.notice_no, N.notice_header, N.notice_title, N.notice_content, N.notice_date, N.notice_read, N.notice_auth_no, M.member_nick 
        order by notice_no;