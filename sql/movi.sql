select * from review where review_movie_no = 3;

select * from movie;

delete movie where movie_no = 3;
commit;


alter table review drop constraint review_movie;

alter table review
add constraint review_movie
foreign key(review_movie_no)
references movie(movie_no) on delete cascade ;




--검색일때 목록
select * from(
				select rownum rn, TMP.* from(
				select 
				 R.review_no, R.review_movie_no, R.review_writer_no, R.review_title, R.review_content, R.review_date, R.review_read, M.member_nick, MO.movie_name, REP.reply_parent, count(REP.reply_origin) reply_count 
				 from review R 
                    inner join member M on R.review_writer_no = M.member_no 
                    left outer join Reply REP on R.review_no = REP.reply_origin and REP.reply_parent >=0
                    inner join movie MO on R.review_movie_no = MO.movie_no
                 where reply_writer_no = 5  
				 group by R.review_no, R.review_movie_no, R.review_writer_no, R.review_title, R.review_content, R.review_date, R.review_read, M.member_nick, MO.movie_name, REP.reply_parent  
				 order by review_no desc  
				)TMP 
				) where rn between 1 and 10;
                
                
                
                
                
--검색아닐때 목록                
select * from( 
    select rownum rn, TMP.* from(
        select 
            R.review_no, R.review_movie_no, R.review_writer_no, 
            R.review_title, R.review_content, R.review_date, 
            R.review_read, M.member_nick, MO.movie_name, count(REP.reply_origin) reply_count
        from review R 
            inner join member M on R.review_writer_no = M.member_no 
            left outer join Reply REP on REP.reply_origin = R.review_no and REP.reply_parent >=0
            inner join Movie MO on R.review_movie_no = MO.movie_no and MO.movie_no= 8
        group by 
            R.review_no, R.review_movie_no, 
            R.review_writer_no, R.review_title, 
            R.review_content, R.review_date, R.review_read, M.member_nick, MO.movie_name
        order by review_no desc
    )TMP 
) where rn between 11 and 20;                
                
                
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



--댓글수정
update reply set reply_content = '댓글달기 딱 좋은 날씨라고', reply_time = sysdate where reply_no = 1;
commit;


select R.*, M.member_nick 
				from reply R inner join member M on R.reply_writer_no = M.member_no 
				where reply_origin = 1297 
				order by reply_root, reply_no, reply_time;
                
select * from reply where reply_no = 136;                
--댓글삭제

delete reply where reply_no=91;
commit;

select reply_seq.nextval from dual;
insert into reply values(149, 1297, 2, 149, -1, 0, '몰라', sysdate);

update reply set reply_parent = -1, reply_content = '삭제된 댓글입니다.' where reply_no =149;
select * from reply order by reply_no desc;
commit;

delete review where review_no = 1296;
commit;
select count(*) from reply where reply_origin = 1295 and reply_parent >=0;

select * from movie where movie_no = 8;
select count(*) from review where review_movie_no = 8;
select * from review order by review_no desc;
select * from movie;

select * from movie where movie_name= 'ㅁㄴㅇ';

select * from movie where instr(movie_name,'범죄') > 0; 

alter table movie add(movie_poster varchar2(256) unique);

select * from review where instr(review_title, '꿀') > 0;
select count(*) from review R inner join member M on R.review_writer_no = M.member_no and instr(member_nick, '관')>0;
select count(*) from member where instr(member_nick, '관') > 0;

select * from review where review_writer_no = 3;

--검색일때 게시글 총 개수 count -> 제목, 내용, 글작성자
select count(*) 
    from review R 
     inner join member M on R.review_writer_no = M.member_no and instr(review_content , '승운') > 0;
      
--검색일때 게시글 총 개수 -> 댓글내용
select count(*) from review R inner join reply REP on R.review_no = REP.reply_origin and instr(reply_writer_no, '승') > 0;

--검색일때 게시글 총 개수 -> 영화명
select count(*) from review R inner join Movie M on R.review_movie_no = M.movie_no and instr(movie_name, '어') > 0;

--검색일때 게시글 총 개수 -> 댓글작성자 distinct해서 중복없애줘야함
select count(distinct reply_origin) from review R inner join reply REP on R.review_no = REP.reply_origin and reply_writer_no = 5;





insert into movie values (movie_seq.nextval, 1, '어바웃타임', 8, 124, '12세이상관람가', '해외', sysdate, '김감독', '로맨스영화이다.', 3000000, 'movie15');
update movie set movie_poster = 'movie19' where movie_no  = 19;
commit;
select member_no from member where member_nick = '승운';



--장르 불러오기
select genre_name from genre where genre_no = 2;

select * from reply where reply_origin = 1281;
delete reply where reply_root = 16;
commit;

--

select count(*) from review;
delete review where review_movie_no is null;

truncate table review;

---------------------------------------
select * from reply order by reply_no desc;
update reply set reply_parent = -1, reply_content = '삭제된 댓글입니다.' where reply_no = 189;
rollback;


insert into event values(event_seq.nextval,'뽑기이벤트', sysdate, '2021-12-30', '페이지 개설 기념! 참여하시고 영화 예매권 받아가세요~');
insert into event values(event_seq.nextval,'사다리타기 이벤트', sysdate, '2020-10-10', '페이지 개설 기념! 참여하시고 영화 예매권 받아가세요~');
commit;

create sequence actor_seq;
select * from movie;
delete from actor where actor_no between 1 and 30;
delete from actor where actor_no = 1;
commit;



---------------------------------------------------------------------------------
insert into coupon values(coupon_seq.nextval,1, '꽝',sysdate, sysdate+100); 
insert into coupon values(coupon_seq.nextval,1, '영화예매권',sysdate, sysdate+100); 
insert into coupon values(coupon_seq.nextval,1, 'CGV10%할인',sysdate, sysdate+100); 
insert into coupon values(coupon_seq.nextval,1, '바나나우유',sysdate, sysdate+100); 
insert into coupon values(coupon_seq.nextval,1, '비타500',sysdate, sysdate+100); 
insert into coupon values(coupon_seq.nextval,1, 'abc초콜릿',sysdate, sysdate+100); 
commit;

insert into member values(member_seq.nextval, 'tmddns678', 'tmddns678', '영화광', '010-2222-3333', sysdate, '일반');
commit;
select count(*) from review;



select * from member;
delete member where member_no = 9;
commit;
