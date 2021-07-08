drop table member;
--멤버 테이블 변경
create table member (
member_no number primary key,
member_id varchar2(100) unique not null,
member_pw varchar2(20),
member_nick varchar2(30) unique not null,
member_phone varchar2(20) unique,
member_date date default sysdate not null,
member_auth varchar2(9) check(member_auth in ('일반', '관리자' , '강사')),
member_token varchar2(256),
member_auth_num number unique,
member_status varchar2(2) check(member_status in('y', 'n')),
member_agreement1 varchar2(2) check(member_agreement1 in('y', 'n')),
member_agreement2 varchar2(2) check(member_agreement2 in('y', 'n')),
member_by varchar2(2) not null
);

--이거 원하는대로 커스텀해서 사용하시면 돼요(토큰은 null로)
insert into member values(member_seq.nextval, 'vio123', 'vio123', '이지혁', null, '2021-04-25', '일반', null, null, 'y', 'y', 'y', 'n');
insert into member values(member_seq.nextval, 'test16', 'test16', 'test16', null, '2021-04-25', '일반', null, null, 'y', 'y', 'y', 'n');
commit;

insert into creator values(creator_seq.nextval, '우리은행 1000-123-456789', '안녕하세요. 도자기 장인 김민수에요! 잘 부탁합니다~', 194); 
update offclass set class_start = '2020-12-01' where class_no = 73;
delete from offclass where class_no = 51;

delete from creator where creator_no = 21;

--관리자 계정 생성
insert into member values(member_seq.nextval, 'admin', 'admin', 'admin', null, sysdate, '관리자', null, null, 'y', 'y', 'y', 'n');

create sequence member_seq;
create sequence member_auth_num;

alter table member drop constraint SYS_C008272; 
--"MEMBER_PW" IS NOT NULL인 제약조건 이름을 제거해주세요
alter table member drop constraint SYS_C008274;
--"MEMBER_PHONE" IS NOT NULL인 제약조건 이름을 제거해주세요

alter table member drop column member_access_token;
alter table member drop column member_refresh_token;

alter table member add member_token varchar2(256);
alter table member add member_auth_num number unique;
alter table member add member_status varchar2(2) check(member_status in('y', 'n'));
alter table member add member_agreement1 varchar2(2) check(member_agreement1 in('y', 'n'));
alter table member add member_agreement2 varchar2(2) check(member_agreement2 in('y', 'n'));
alter table member add member_by varchar2(2);



create table classcategory(
    category_no number primary key,
    category_big varchar2(12) not null,
    category_small  varchar2(15) not null 
);
alter table classcategory modify category_big varchar(30);
alter table classcategory modify category_small varchar(30);

create sequence classcategory_seq
start with 1
increment by 1
nocycle;

delete from classcategory where category_no = 50; 
--카테고리 데이터 입력 테스트
insert into classcategory values(classcategory_seq.nextval, '공예','도자기');
insert into classcategory values(classcategory_seq.nextval, '공예','가죽');
insert into classcategory values(classcategory_seq.nextval, '공예','액세서리');
insert into classcategory values(classcategory_seq.nextval, '운동','축구');
insert into classcategory values(classcategory_seq.nextval, '운동','농구');
insert into classcategory values(classcategory_seq.nextval, '운동','골프');
insert into classcategory values(classcategory_seq.nextval, '드로잉','한국화');
insert into classcategory values(classcategory_seq.nextval, '드로잉','서양화');
insert into classcategory values(classcategory_seq.nextval, '드로잉','유화');
insert into classcategory values(classcategory_seq.nextval, '음악','실용음악');
insert into classcategory values(classcategory_seq.nextval, '음악','피아노');
insert into classcategory values(classcategory_seq.nextval,
'음악','바이올린');
insert into classcategory values(classcategory_seq.nextval, '요리','한식');
insert into classcategory values(classcategory_seq.nextval, '요리','양식');
insert into classcategory values(classcategory_seq.nextval, '요리','일식');
insert into classcategory values(classcategory_seq.nextval, '스터디','토익');
insert into classcategory values(classcategory_seq.nextval, '스터디','토플');
insert into classcategory values(classcategory_seq.nextval, '스터디','자바');
commit;
rollback;


--강의 테이블 생성
alter table offclass modify class_end default '2099-12-31';
drop table offclass;
create table offclass(create table offclass(
class_no number primary key,
class_name varchar2(150) not null unique,
class_info varchar2(2000),
class_price number(8) default 0 not null,
class_check varchar2(15) default '검수대기' not null check(class_check in ('검수대기','검수완료','반려')),
class_end_check varchar2(6) default '종료' not null check(class_end_check in ('진행','종료')),
class_start Date,
class_end Date default date '2099-12-31' not null,
class_regdate Date default sysdate,
class_place varchar2(300) not null,
class_member_set number (4) not null,
class_talk varchar2(300) not null,
category_no number,
creator_no number
);

create sequence offclass_seq;

-- 강의 이미지 저장 테이블 생성
create table class_image(
fullname varchar2(150) not null,
class_no number not null,
regdate timestamp default sysdate,
primary key(fullname)
);

alter table class_image add constraint fk_class_image
foreign key (class_no)
references offclass (class_no) on delete cascade;

-- 크리에이터 테이블, 시퀀스 생성
create table creator(
creator_no number primary key,
creator_account varchar2(30),
creator_info varchar2(2000),
member_no number
);

create sequence creator_seq;

-- 크리에이터 테이블에 멤버 외래키 설정 추가
-- 주의 : 맴버 테이블 먼저 생성되어야 함
alter table creator add constraint fk_member
foreign key (member_no)
references member(member_no) on delete cascade;

-- 강의 테이블에 카테고리 외래키 설정 추가
-- 주의 : 카테고리 테이블 먼저 생성되어야 함
alter table offclass add constraint fk_category
foreign key (category_no)
references classcategory(category_no) on delete cascade;

-- 강의 테이블에 크리에이터 외래키 설정 추가
alter table offclass add constraint fk_creator
foreign key (creator_no)
references creator(creator_no) on delete set null;

-- 강의 찜 테이블, 시퀀스 생성
-- 주의 : 클래스 테이블, 멤버 테이블 먼저 생성되어야 함
create table classlike(
    classlike_no number primary key,
    class_no number not null references offclass(class_no) on delete cascade,
    member_no number not null references member(member_no) on delete cascade
);

create sequence classlike_seq
start with 1
increment by 1
nocycle;

-- 장바구니 테이블, 시퀀스 생성
-- 주의 : 클래스 테이블, 멤버 테이블 먼저 생성되어야 함

create table basket(
    basket_no number primary key,
    class_no number not null references offclass(class_no) on delete cascade,
    member_no number not null references member(member_no) on delete cascade
);

create sequence basket_seq
start with 1
increment by 1
nocycle;

--프로필
create table profile(
    profile_no number primary key,
    profile_member_no number unique not null,
	fullname varchar(150) not null,
	regdate Date default sysdate
);
create sequence profile_seq
start with 1
increment by 1
nocycle;


alter table profile add constraint fk_profile
foreign key (profile_member_no)
references member (member_no);

--강의 질문
create table classquestion(
classq_no number primary key,
class_no number,
member_no number,
class_Q varchar(256) not null,
class_A varchar(256)
);

create sequence classq_seq;
alter table classquestion add constraint fk_classq_no
foreign key (class_no) references offclass(class_no) on delete set null;
alter table classquestion add constraint fk_memberq_no
foreign key (member_no) references member(member_no) on delete cascade;

--2021.04.07수정 -> class_no, member_no에서  not null 뺌
--주문 테이블
drop table classorder;
drop sequence order_seq;
create table classorder(
   order_no number primary key,
   class_no number ,
   member_no number,
   order_name varchar2(20) not null,
   order_price number not null,
   order_date Date default sysdate not null,
   order_ok varchar2(20) default '입금대기' not null check(order_ok in ('입금대기','입금완료')),
   order_calc varchar2(20) default '정산대기' not null check(order_calc in('정산대기', '정산완료'))
);
create sequence order_seq;

alter table classorder add constraint fk_class_order_no
foreign key (class_no) references offclass(class_no) on delete set null;
alter table classorder add constraint fk_member_order_no
foreign key (member_no) references member(member_no) on delete set null;

--리뷰
--반드시 작성할 때 한 사람당 강의에 대한 하나의 리뷰만 작성 가능하다 !!
create table review(
    review_no number primary key,
    member_no number not null,
    class_no number not null,
    review_context varchar2(256) ,
    review_date Date default sysdate not null,
    review_ok varchar(256)
);
create sequence review_seq;

alter table review add constraint fk_class_review_no
foreign key (class_no) references offclass(class_no) on delete set null;
alter table review add constraint fk_member_member_no
foreign key (member_no) references member(member_no) on delete set null;

--이벤트
create table event (
    event_no number primary key,
    event_title varchar2(300) not null,
    event_start date not null,
    event_end date not null,
    event_content varchar2(4000) not null
);

create sequence event_seq;

alter table event add event_file_name varchar2(256);
alter table coupon add coupon_file_name varchar2(256);

--이벤트 테이블 테스트
insert into event values(event_seq.nextval, '친구추천이벤트2020', to_date('2020-05-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), to_date('2020-07-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS') , '친구추천이벤트 테스트');
commit;

--쿠폰
create table coupon(
    coupon_no number primary key,
    coupon_name varchar2(90) not null,
    coupon_start date not null,
    coupon_end date not null,
    coupon_discount number not null,
    event_no number
);
create sequence coupon_seq;


alter table coupon add 
constraint fk_event_no foreign key (event_no)
references event(event_no) on delete set null;

--쿠폰 테이블 테스트
insert into coupon values(coupon_seq.nextval, '전 클래스 10% 할인쿠폰', '2021-04-01', '2021-12-31', 0.9, 1);
commit;



--멤버 쿠폰
create table member_coupon(
	member_no number,
	coupon_no number
);
alter table member_coupon add 
constraint fk_member_no foreign key (member_no)
references member(member_no) on delete cascade;

alter table member_coupon add 
constraint fk_coupon_no foreign key (coupon_no)
references coupon(coupon_no) on delete cascade;

--커뮤니티 1:1문의
Create table question (
    question_no number primary key, 
    member_no number, 
    question_title varchar2(150), 
    question_q varchar2(3000), 
    question_a varchar2(3000), 
    question_date date default sysdate,
    question_ok varchar2(20)default '답변 대기' not null check(question_ok in ('답변 대기','답변 완료'))
);
create sequence question_seq;
alter table question add constraint fk_member_member_no
foreign key (member_no) references member(member_no) on delete set null;

--커뮤니티 FAQ
drop table faq;
  create table faq(
	faq_no number primary key,
	member_no number,
	faq_title varchar2(150),
	faq_content varchar2(3000),
	faq_date date default sysdate
);
create sequence faq_seq;







-------------------테스트------------------------------

--강의 추가 테스트
insert into offclass values(offclass_seq.nextval, '테스트강의', '테스트', 30000, '검수완료', '진행', '2021-04-16', '2099-12-31', '2021-04-12', '서울', 5, '테스트', 42, 3);
update offclass set class_check = '검수완료', class_end_check = '진행', class_start = '2021-04-10' where class_no = 1;

insert into offclass values(offclass_seq.nextval, '국수만드는법', '테스트', 50000, '검수완료', '진행', '2021-03-05', '2021-04-05', '2021-03-02', '서울', 5, '테스트', 52, 1);

commit;
rollback;


--크리에이터 추가 테스트
insert into creator values(creator_seq.nextval, '테스트', '테스트', 142);
commit;

--회원 추가 테스트
insert into member values(member_seq.nextval, 'aaa123', 'aaa123', '스무디', '010-1654-3414', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test132', 'test132', 'test132', '030-4544-5566', to_date('2021-04-01 17:30:30', 'YYYY-MM-DD HH24:MI:SS'), '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test133', 'test133', 'test133', '010-2455-5678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test134', 'test134', 'test134', '010-2244-5678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test135', 'test135', 'test135', '010-2224-5678', sysdate, '일반', 'x', 'x');

insert into member values(member_seq.nextval, 'test73', 'test73', 'test73', '020-1434-5478', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test74', 'test74', 'test74', '020-1234-5671', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test75', 'test75', 'test75', '032-1334-5678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test76', 'test76', 'test76', '020-1434-5678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test77', 'test77', 'test77', '021-1245-3678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test78', 'test78', 'test78', '030-2231-5433', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test79', 'test79', 'test79', '022-2221-5678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test80', 'test80', 'test80', '040-3222-5448', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test81', 'test81', 'test81', '025-2544-5678', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test82', 'test82', 'test82', '020-2224-5222', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test83', 'test83', 'test83', '030-4354-5658', sysdate, '일반', 'x', 'x');
insert into member values(member_seq.nextval, 'test84', 'test84', 'test84', '040-2534-5675', sysdate, '일반', 'x', 'x');
commit;


--주문테이블 테스트
insert into classorder values(order_seq.nextval, 5, 126, '김지수', 50000, to_date('2021-04-18 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), '입금완료', '정산대기');

commit;


 
 
 
      


           
        

----------------------------sql쿼리 구문---------------------------------------------      
        
----------회원 리스트 + 구매내역-------------
select * from (
    select rownum rn, TMP.* from(
      select 
         M.member_no, M.member_id, M.member_Nick, M.member_phone, 
         M.member_date, M.member_auth, count(O.member_no) order_count
     from member M left outer join classorder O on M.member_no = O.member_no and O.order_ok = '입금완료'
     group by M.member_no, M.member_id, M.member_nick, M.member_phone, M.member_date, M.member_auth
     order by M.member_no desc
    )TMP
) where rn between 1 and 15;;

------------검색 + 회원리스트 + 구매내역--------------
select * from (
    select rownum rn, TMP.* from(
      select 
         M.member_no, M.member_id, M.member_Nick, M.member_phone, 
         M.member_date, M.member_auth, count(O.member_no) order_count
     from member M left outer join classorder O on M.member_no = O.member_no and O.order_ok = '입금완료'
     where instr(member_nick, 'j') > 0
     group by M.member_no, M.member_id, M.member_nick, M.member_phone, M.member_date, M.member_auth
     order by M.member_no desc
    )TMP
) where rn between 1 and 15;

------------회원번호로 검색할때!! + 회원리스트 + 구매내역--------------
select * from (
      select 
         M.member_no, M.member_id, M.member_Nick, M.member_phone, 
         M.member_date, M.member_auth, count(O.member_no) order_count
     from member M left outer join classorder O on M.member_no = O.member_no and O.order_ok = '입금완료'
     group by M.member_no, M.member_id, M.member_nick, M.member_phone, M.member_date, M.member_auth
     order by M.member_no desc
) where member_no = '126';




---------------------------------검색시 회원 수-------------------------------
select count(*) from member where instr(member_nick, 'j') > 0;









------------------------주문한 회원목록------------------------

--검색이 아닐때 주문한 회원 목록(+날짜계산)
select * from (
    select rownum rn, TMP.* from (
        select 
            C.order_no, C.class_no, C.member_no, C.order_name, 
            C.order_price, C.order_date, C.order_ok, O.class_name 
        from 
            classorder C
                inner join offclass O on C.class_no = O.class_no
        where 
            order_date between to_date('2021-04-16' || '00:00:00', 'YYYY-MM-DD HH24:MI:SS') and  to_date('2021-04-14' || '23:59:59', 'YYYY-MM-DD HH24:MI:SS')      
        order by 
            order_date desc
    ) TMP
) where rn between 1 and 15;


--검색이 아닐때 주문한 회원 수
select count(*) from classorder;


--검색시 주문한 회원 목록(+날짜 계산)
select * from (
    select rownum rn, TMP.* from (
        select 
            C.order_no, C.class_no, C.member_no, C.order_name, 
            C.order_price, C.order_date, C.order_ok, O.class_name 
        from 
            classorder C
                inner join offclass O on C.class_no = O.class_no         
        where
            member_no = 129
             and
            order_date 
            between to_date('2021-04-18' || '00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
            and  to_date('2021-04-18' || '23:59:59', 'YYYY-MM-DD HH24:MI:SS')
            
        order by 
            order_date desc, class_no
    ) TMP
) where rn between 1 and 15;


--검색시 주문한 회원 수(+날짜계산)
select 
    count(*) 
from classorder 
where 
    member_no = 129
    and order_date
    between  to_date('2021-04-18' || '00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
    and to_date('2021-04-18' || '23:59:59', 'YYYY-MM-DD HH24:MI:SS'); 
     
    

----------테스트
insert into classorder values(order_seq.nextval, 6, 130, '김승운', 30000, to_date('2021-04-16 18:19:30','YYYY-MM-DD HH24:MI:SS'), '입금대기');

update classorder set order_ok = '입금완료' where order_no = 17;
rollback;
commit; 





-----------------관리자 메인 매출액 T0P10----------
--dense_rank를 통해 예를들어 10위가 2개라도 2개 다 출력되도록
	select * from (
   			select rownum rn, TMP.* from (
        		select 
                    M.member_nick,
            		OC.class_name,
            		sum(CO.order_price) sales,
            		dense_rank() over(order by sum(CO.order_price) desc) rank
        		from classorder CO 
                		inner join offclass OC on CO.class_no = OC.class_no and CO.order_ok = '입금완료'
                        inner join creator C on OC.creator_no = C.creator_no
                        inner join member M on C.member_no = M.member_no
        		group by M.member_nick, OC.class_name
    		)TMP
		) where rank between 1 and 10;
        
        
-------------------- 관리자 메인 판매수 Top10-----------------------
select * from (
   			select rownum rn, TMP.* from(
        		select 
		            M.member_nick creator,
		            OC.class_name, 
		            count(OC.class_name) count,
		            dense_rank() over(order by count(OC.class_name) desc) rank
        		from
                    classorder CO
		                inner join offclass OC on CO.class_no = OC.class_no and CO.order_ok = '입금완료'
		                inner join creator C on OC.creator_no = C.creator_no
                        inner join member M on C.member_no = M.member_no
        		group by M.member_nick, OC.class_name
    		)TMP
		) where rank between 1 and 10;

-------------------------------------------------------------

----------------관리자 홈화면 총 회원수--------------------
--------------이번달 + 최근 6개월 총 회원 수-------------------------------------------

--지금이 4월이라면 3월까지의 회원 수
select count(*) count1ago from member where member_date < trunc(add_months(sysdate, 0), 'mm');
--지금이 4월이라면 2월까지의 회원 수
select count(*) count2ago from member where member_date < trunc(add_months(sysdate, -1), 'mm');
--지금이 4월이라면 1월까지의 회원 수
select count(*) count3ago from member where member_date < trunc(add_months(sysdate, -2), 'mm');
--지금이 4월이라면 작년12월까지의 회원 수
select count(*) count4ago from member where member_date < trunc(add_months(sysdate, -3), 'mm');
--지금이 4월이라면 작년11월까지의 회원 수
select count(*) count5ago from member where member_date < trunc(add_months(sysdate, -4), 'mm');
--지금이 4월이라면 작년10월까지의 회원 수
select count(*) count6ago from member where member_date < trunc(add_months(sysdate, -5), 'mm');
--현재 달의 회원수
select count(*) countnow from member;

------------------관리자 일별 회원가입 수-------------------
--테스트 
select sysdate -6 from dual;

--오늘 회원가입 수--
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate, 'YYYYMMDD');
--하루 전 회원가입 수--
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate-1, 'YYYYMMDD');
--이틀 전 회원가입 수--
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate-2, 'YYYYMMDD');
--3일전 회원가입 수
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate-3, 'YYYYMMDD');
--4일전 회원가입 수
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate-4, 'YYYYMMDD');
--5일전 회원가입 수
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate-5, 'YYYYMMDD');
--6일전 회원가입 수
select count(*) from member where to_char(member_date, 'YYYYMMDD') = to_char(sysdate-6, 'YYYYMMDD');



-----------------관리자 홈 화면 월매출---------------

--테스트(해당 월의 첫날과 마지막날)
select to_char(trunc(add_months(sysdate, 1), 'mm'), 'YYYY-MM-DD HH24:MI:SS') from dual;

--이번달 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, 0), 'mm') and order_date < trunc(add_months(sysdate, 1), 'mm') and order_ok='입금완료';
--저번달 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, -1), 'mm') and order_date < trunc(add_months(sysdate, 0), 'mm')  and order_ok='입금완료';
--2개월 전 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, -2), 'mm') and order_date < trunc(add_months(sysdate, -1), 'mm') and order_ok='입금완료';
--3개월 전 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, -3), 'mm') and order_date < trunc(add_months(sysdate, -2), 'mm') and order_ok='입금완료';
--4개월 전 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, -4), 'mm') and order_date < trunc(add_months(sysdate, -3), 'mm') and order_ok='입금완료';
--5개월 전 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, -5), 'mm') and order_date < trunc(add_months(sysdate, -4), 'mm') and order_ok='입금완료';
--6개월 전 매출액
select nvl(sum(order_price), 0) sales from classorder where order_date >= trunc(add_months(sysdate, -6), 'mm') and order_date < trunc(add_months(sysdate, -5), 'mm') and order_ok='입금완료';

---------관리자 홈화면 일매출---------
--6일 전 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate-6, 'YYYYMMDD') and order_ok='입금완료';
--5일 전 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate-5, 'YYYYMMDD') and order_ok='입금완료';
--4일 전 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate-4, 'YYYYMMDD') and order_ok='입금완료';
--3일 전 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate-3, 'YYYYMMDD') and order_ok='입금완료';
--2일 전 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate-2, 'YYYYMMDD') and order_ok='입금완료';
--1일 전 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate-1, 'YYYYMMDD') and order_ok='입금완료';
-- 오늘 매출액
select nvl(sum(order_price), 0) sales from classorder where to_char(order_date, 'YYYYMMDD') = to_char(sysdate, 'YYYYMMDD') and order_ok='입금완료';

------------------크리에이터 클래스 오픈 검수 리스트 불러오기------------
select * from (
    select rownum rn, TMP.* from (
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, O.class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_id, M.member_nick
        from 
            offclass O
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        order by class_regdate desc
    )TMP
)where rn between 1 and 15;

---------------크리에이터 클래스 검수 리스트 개수-----------------
select count(*) count from offclass;

------------검색 시 크리에이터 클래스 검수 리스트 불러오기----------------------
select * from(
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, O.class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_id, M.member_nick
        from 
            offclass O
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        where instr(member_nick, 'h') > 0
        order by class_regdate desc
    )TMP
)where rn between 1 and 2; 


-------------검색 시 크리에이터 클래스 검수 리스트 개수-------------
select 
    count(*) count 
from 
    offclass O
        inner join creator C on O.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where instr(member_id, 'h') > 0;

--클래스 검수 승인
update offclass set class_check = '검수대기' where class_no = 41;
update offclass set class_end_check = '종료' where class_no = 41;

update offclass set class_end_check = '진행' where class_no = 44;
rollback;
commit;

delete from offclass where class_no = 41;
commit;
-----------진행중인 클래스----------
select * from (
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31') class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick, CI.fullname, count(CO.class_no) count
        from offclass O
                left outer join classorder CO on O.class_no = CO.class_no
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
                left outer join class_image CI on O.class_no = CI.class_no
        where 
            class_check = '검수완료' and class_end_check = '진행' 
            and class_start is not null and class_start <= sysdate
            and (class_end is null or to_char(class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD'))
        group by 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31'),
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick, CI.fullname
        order by 
            class_start desc
    )TMP
) where rn between 1 and 15;

------진행중인 클래스 개수---------
select 
    count(*) 
from 
    offclass 
where 
    class_check = '검수완료' and class_end_check = '진행' 
    and class_start is not null and class_start <= sysdate
    and (class_end is null or to_char(class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD'));
    
 --------검색 시 진행중인 클래스 목록------------
 select * from (
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31') class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick, count(CO.class_no) count
        from offclass O
                left outer join classorder CO on O.class_no = CO.class_no 
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        where 
            class_check = '검수완료' and class_end_check = '진행' 
            and class_start is not null and class_start <= sysdate
            and (class_end is null or to_char(class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD'))
        group by 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31'),
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick
        order by 
            class_start desc
    )TMP
) where instr(class_name, '자') > 0 and rn between 1 and 15;

-----------검색 시 진행중인 클래스 리스트 개수----------
select 
    count(*) count 
from 
    offclass O
        inner join creator C on O.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where
    instr(class_name, '자') > 0 and
    class_check = '검수완료' and class_end_check = '진행' 
    and class_start is not null and class_start <= sysdate
    and (class_end is null or to_char(class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD'));


   
    
    
    
---------------오픈 예정 클래스-------------------
select * from (
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31') class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick
        from offclass O
                left outer join classorder CO on O.class_no = CO.class_no
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        where class_check = '검수완료' and class_end_check = '진행' and class_start is not null and class_start > sysdate
        order by class_start asc
    )TMP
) where rn between 1 and 15;

-------------오픈 예정 클래스 리스트 개수 -------------
select 
    count(*) 
from 
    offclass 
where 
    class_check = '검수완료' and class_end_check = '진행' and class_start is not null and class_start > sysdate;

----------검색 시 오픈 예정 클래스 목록-----------------
select * from (
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31') class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick
        from offclass O
                left outer join classorder CO on O.class_no = CO.class_no
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        where class_check = '검수완료' and class_end_check = '진행' and class_start is not null and class_start > sysdate
        order by class_start asc
    )TMP
) where instr(member_nick, 's') > 0 and rn between 1 and 15;

--------검색 시 오픈 예정 클래스 목록 개수------------
select 
    count(*) count 
from 
    offclass O
        inner join creator C on O.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where
    instr(member_nick, 's') > 0 and
    class_check = '검수완료' and class_end_check = '진행' and class_start is not null and class_start > sysdate;


---------------------종료된 클래스 목록---------------------
select * from (
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31') class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick, count(CO.class_no) count
        from offclass O
                left outer join classorder CO on O.class_no = CO.class_no
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        where 
            class_check = '검수완료' and class_start is not null and to_char(class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD')
        group by
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31'),
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick
        order by 
            class_end desc
    )TMP
) where rn between 1 and 15;

---------- 종료된 클래스 목록 개수------------------
select 
    count(*) 
from 
    offclass 
where 
    class_check = '검수완료' and class_start is not null and to_char(class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD');   


----------검색 시 종료된 클래스 목록 개수--------------------
    
    select * from (
    select rownum rn, TMP.* from(
        select 
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31') class_end,
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick, count(CO.class_no) count
        from offclass O
                left outer join classorder CO on O.class_no = CO.class_no
                inner join creator C on O.creator_no = C.creator_no
                inner join member M on C.member_no = M.member_no
        where 
            class_check = '검수완료' and class_start is not null and to_char(class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD')
        group by
            O.class_no, O.class_name, O.class_info, O.class_price,
            O.class_check, O.class_end_check, O.class_start, nvl(O.class_end, '2099-12-31'),
            O.class_regdate, O.class_place, O.class_member_set, O.class_talk,
            O.category_no, O.creator_no,
            M.member_nick
        order by 
            class_end desc
    )TMP
) where instr(class_name, '국') > 0 and rn between 1 and 15;

-----------------검색 시 종료된 클래스 목록 개수--------------------
select 
    count(*) count 
from 
    offclass O
        inner join creator C on O.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where
    instr(class_name, '백') > 0 and
    class_check = '검수완료' and class_start is not null and to_char(class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD');
   
   
--테스트 -------------------------------------------
 
select 
        distinct(C.creator_no), M.member_nick
    from 
        creator C
            inner join member M on C.member_no = M.member_no 
            left outer join offclass O on C.creator_no = O.creator_no;    

--크리에이터 등록 테스트            
insert into creator values(creator_seq.nextval, '하나은행 1000-313-333333', '어쩌고저쩌고', 129);             
commit; 
rollback;

                    C.creator_no, M.member_nick;
----------------크리에이터 명단 아오 진짜 이거 하다 뒤질뻔...------------------------------------------------------
--검색이 아닐때 크리에이터 명단
select * from (
    select rownum rn, TMP.* from (
        select OG.creator_no, OG.member_nick creator_nick, nvl(count_ing, 0) count_ing, nvl(count_coming_soon, 0) count_coming_soon, nvl(count_end, 0) count_end from (
            select 
                distinct(C.creator_no), M.member_nick
            from 
                creator C
                    inner join member M on C.member_no = M.member_no 
                    left outer join offclass O on C.creator_no = O.creator_no
        ) OG
            left outer join(
                select 
                    C.creator_no, M.member_nick, count(*) count_ing
                from 
                    creator C
                        inner join member M on C.member_no = M.member_no 
                        inner join offclass O on C.creator_no = O.creator_no and O.class_check = '검수완료' 
                        and O.class_end_check = '진행' and  O.class_start is not null and O.class_start <= sysdate
                        and (O.class_end is null or to_char(O.class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD'))
                group by
                    C.creator_no, M.member_nick
            )ING on OG.creator_no = ING.creator_no
            left outer join (
                select 
                    C.creator_no, M.member_nick, count(*) count_coming_soon
                from 
                    creator C
                        inner join member M on C.member_no = M.member_no 
                        inner join offclass O on C.creator_no = O.creator_no and O.class_check = '검수완료' and O.class_end_check = '진행'
                        and  (O.class_start is not null and O.class_start > sysdate)
                group by
                    C.creator_no, M.member_nick
            ) COMING on OG.creator_no = COMING.creator_no 
            left outer join (
                select 
                    C.creator_no, M.member_nick, count(*) count_end
                from 
                creator C
                    inner join member M on C.member_no = M.member_no 
                    inner join offclass O on C.creator_no = O.creator_no and class_check = '검수완료'
                    and (O.class_start is not null and to_char(O.class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD'))
                group by
                    C.creator_no, M.member_nick) END on OG.creator_no = END.creator_no
        order by count_ing desc, count_coming_soon desc, count_end desc
    ) TMP
) where rn between 1 and 4;

--검색이 아닐때 크리에이터 명단 개수
select count(*) count from creator;


--검색일때 크리에이터 명단
select * from (
    select rownum rn, TMP.* from (
        select OG.creator_no, OG.member_nick creator_nick, nvl(count_ing, 0) count_ing, nvl(count_coming_soon, 0) count_coming_soon, nvl(count_end, 0) count_end from (
            select 
                distinct(C.creator_no), M.member_nick
            from 
                creator C
                    inner join member M on C.member_no = M.member_no 
                    left outer join offclass O on C.creator_no = O.creator_no
        ) OG
            left outer join(
                select 
                    C.creator_no, M.member_nick, count(*) count_ing
                from 
                    creator C
                        inner join member M on C.member_no = M.member_no 
                        inner join offclass O on C.creator_no = O.creator_no and class_check = '검수완료' and class_end_check = '진행'
                where
                    O.class_start is not null and O.class_start <= sysdate
                    and (class_end is null or to_char(class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD'))
                group by
                    C.creator_no, M.member_nick
            )ING on OG.creator_no = ING.creator_no
            left outer join (
                select 
                    C.creator_no, M.member_nick, count(*) count_coming_soon
                from 
                    creator C
                        inner join member M on C.member_no = M.member_no 
                        inner join offclass O on C.creator_no = O.creator_no and (class_check = '검수완료' and class_end_check = '진행')
                where
                     class_start is not null and class_start > sysdate
                group by
                    C.creator_no, M.member_nick
            ) COMING on OG.creator_no = COMING.creator_no 
            left outer join (
                select 
                    C.creator_no, M.member_nick, count(*) count_end
                from 
                creator C
                    inner join member M on C.member_no = M.member_no 
                    inner join offclass O on C.creator_no = O.creator_no and class_check = '검수완료'
                where
                     class_start is not null and to_char(class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD')
                group by
                    C.creator_no, M.member_nick) END on OG.creator_no = END.creator_no
        where instr(OG.member_nick, 's') > 0            
        order by count_ing desc, count_coming_soon desc, count_end desc
    ) TMP
) where rn between 1 and 4;

--검색일때 크리에이터 명단 개수
select 
    count(*) 
from 
    creator C
        inner join member M on C.member_no = M.member_no 
where instr(M.member_nick, 'h') > 0;                   
                    
    
-----------------------------------------------------------------------------    


    
select 
    C.creator_no, M.member_nick, count(*) 진행중인클래스
from 
    creator C
        inner join member M on C.member_no = M.member_no 
        inner join offclass O on C.creator_no = O.creator_no
where
    class_check = '검수완료' and class_end_check = '진행' 
    and class_start is not null and class_start <= sysdate
    and to_char(class_end, 'YYYYMMDD') >= to_char(sysdate, 'YYYYMMDD')
group by
    C.creator_no, M.member_nick;
        
    
select 
    C.creator_no, M.member_nick, count(*) 오픈예정클래스
from 
    creator C
        inner join member M on C.member_no = M.member_no 
        inner join offclass O on C.creator_no = O.creator_no
where
    class_check = '검수완료' and class_end_check = '진행' and class_start is not null and class_start > sysdate
group by
    C.creator_no, M.member_nick;
        
    
select 
    C.creator_no, M.member_nick, count(*) 종료된클래스
from 
    creator C
        inner join member M on C.member_no = M.member_no 
        inner join offclass O on C.creator_no = O.creator_no
where
    class_check = '검수완료' and class_start is not null and to_char(class_end, 'YYYYMMDD') < to_char(sysdate, 'YYYYMMDD')
group by
    C.creator_no, M.member_nick;




----------------------크리에이터 정산--------------

--검색이 아닐때 크리에이터 정산 목록
select 
    C.creator_no, M.member_nick creator_nick, OC.class_name, CO.order_date, 
    sum(order_price) class_sales, sum(order_price) * 0.9 creator_income,
    CO.order_calc
from 
    classorder CO
        inner join offclass OC on CO.class_no = OC.class_no and CO.order_ok = '입금완료'
        inner join creator C on OC.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where to_char(CO.order_date, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')  
group by C.creator_no, M.member_nick, OC.class_name, CO.order_date, CO.order_calc
order by C.creator_no, CO.order_date desc, sum(order_price) desc;


--검색일때(날짜만 있는 경우 or 날짜와 크리에이터명 또는 클래스명 있는 경우) 크리에이터 정산 목록
select 
    C.creator_no, M.member_nick creator_nick, OC.class_name, 
    sum(order_price) class_sales, sum(order_price) * 0.9 creator_income,
    CO.order_calc
from 
    classorder CO
        inner join offclass OC on CO.class_no = OC.class_no and CO.order_ok = '입금완료' 
        inner join creator C on OC.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where to_char(CO.order_date, 'YYYY-MM-DD') = '2021-04-18' and instr(member_nick, '스') > 0   
group by C.creator_no, M.member_nick, OC.class_name, CO.order_calc
order by C.creator_no, sum(order_price) desc;


--'정산완료'로 업데이트 하는 구문
update classorder set order_calc = '정산완료' where to_char(order_date, 'YYYY-MM-DD') = '2021-04-18';

rollback;


--주문테이블 테스트
insert into classorder values(order_seq.nextval, 11, 129, '신짱구', 30000, to_date('2021-04-27 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), '입금완료', '정산대기');

commit;


--검색이 아닐때 크리에이터 정산 목록 개수(페이징 안할거라 필요없음)
select count(count(*)) count 
from 
    classorder CO
        inner join offclass OC on CO.class_no = OC.class_no
        inner join creator C on OC.creator_no = C.creator_no
        inner join member M on C.member_no = M.member_no
where to_char(CO.order_date, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')
group by C.creator_no, M.member_nick, OC.class_name;    

    
    
    
    
    
----------------------전체 매출 현황----------------
select to_char(order_date, 'YYYY-MM-DD'), sum(order_price) from classorder  
where order_ok = '입금완료' and order_date between '2021-03-01' and '2021-04-30' 
group by to_char(order_date, 'YYYY-MM-DD')
order by to_char(order_date, 'YYYY-MM-DD') desc;

select to_char(order_date, 'YYYY-MM'), sum(order_price) sales from classorder where order_ok = '입금완료' and order_date between '2021-04-01' and '2021-04-30' group by to_char(order_date, 'YYYY-MM') order by to_char(order_date, 'YYYY-MM') desc;


-------년월을 입력받아 해당년월의 일매출+월매출 계산하기
select to_char(order_date, 'YYYY-MM-DD') orderdate, sum(order_price) daysales, sum(sum(order_price)) over(order by to_char(order_date, 'YYYY-MM') asc rows between unbounded preceding and current row) monthsales
from 
    classorder 
where 
    order_ok = '입금완료'
    and order_date >= to_date('2021-04' || '-01', 'YYYY-MM-DD')
    and order_date < last_day(to_date('2021-04' || '-01', 'YYYY-MM-DD'))+1
    
group by 
    to_char(order_date, 'YYYY-MM-DD'), to_char(order_date, 'YYYY-MM')
order by 
    to_char(order_date, 'YYYY-MM-DD') desc;
    
--------------검색아닐때 default로 이번달 일매출+월매출 리스트 
select
     to_char(order_date, 'YYYY-MM-DD') orderdate, 
    sum(order_price) daysales, 
    sum(sum(order_price)) over(order by to_char(order_date, 'YYYY-MM') asc rows between unbounded preceding and current row) monthsales
from classorder
where 
    order_ok = '입금완료'
    and order_date >= trunc(sysdate, 'mm')
    and order_date < trunc(add_months(sysdate, 1), 'mm')
group by 
    to_char(order_date, 'YYYY-MM-DD'), to_char(order_date, 'YYYY-MM'), to_char(order_date, 'YYYY-MM')
order by 
    to_char(order_date, 'YYYY-MM-DD') desc;

--검색이 아닐때 연매출
select to_char(order_date, 'YYYY') "year", sum(order_price) "yearsales" from classorder where order_ok = '입금완료' and extract(year from order_date) = to_char(sysdate, 'YYYY')  group by to_char(order_date, 'YYYY');
--검색시 연매출
select to_char(order_date, 'YYYY') "year", sum(order_price) "yearsales" from classorder where order_ok = '입금완료' and extract(year from order_date) = substr('2021-03', 1, 4)  group by to_char(order_date, 'YYYY');    

--검색이 아닐때 월매출
select to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" from classorder where order_ok = '입금완료' and to_char(order_date, 'YYYY-MM') = to_char(sysdate, 'YYYY-MM') group by to_char(order_date, 'YYYY-MM');
--검색일때 월매출 
select to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" from classorder where order_ok = '입금완료' and to_char(order_date, 'YYYY-MM') = '2021-01' group by to_char(order_date, 'YYYY-MM');

        
----------------------------테스트
SELECT 
   SUM(CASE WHEN to_char(order_date, 'yyyymm') LIKE '202103%' THEN order_price END), 
   SUM(CASE WHEN to_char(order_date, 'yyyy') LIKE '2021%' THEN order_price END)
FROM classorder
GROUP BY TO_CHAR(order_date, 'yyyymm'),
TO_CHAR(order_date, 'yyyy'); 
    

-------------------------------------------------------------------------------------   

------------------------------클래스별 매출현황---------------------------------

--select박스에 넣어줄 전체 클래스 목록 가져오기
select * from offclass 
where 
    class_check = '검수완료' and class_end_check = '진행' 
    and class_start is not null and to_char(class_start, 'YYYY-MM-DD') <= to_char(sysdate, 'YYYY-MM-DD')
    and to_char(class_end, 'YYYY-MM') >= to_char(sysdate, 'YYYY-MM')
order by class_no asc;


--클래스+년월 검색 매출액
select to_char(order_date, 'YYYY-MM-DD') salesdate, O.class_name, sum(order_price) daysales, sum(sum(order_price)) over(order by to_char(order_date, 'YYYY-MM') asc rows between unbounded preceding and current row) monthsales
from 
    classorder C inner join offclass O on C.class_no = O.class_no
where 
    order_ok = '입금완료'
    and order_date >= to_date('2021-04' || '-01', 'YYYY-MM-DD')
    and order_date < last_day(to_date('2021-04' || '-01', 'YYYY-MM-DD'))+1
    and C.class_no = 5
    
group by 
    to_char(order_date, 'YYYY-MM-DD'), O.class_name, to_char(order_date, 'YYYY-MM')
order by 
    to_char(order_date, 'YYYY-MM-DD') desc;
    

--검색시 해당 클래스의 연매출
select 
    to_char(order_date, 'YYYY') "year", sum(order_price) "yearsales" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and extract(year from order_date) = substr('2021-03', 1, 4)
    and class_no = 8
group by to_char(order_date, 'YYYY');    

--검색시 해당 클래스의 월매출 
select 
    to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and to_char(order_date, 'YYYY-MM') = '2021-03'
    and class_no = 6
group by to_char(order_date, 'YYYY-MM');    
    
    
--검색 아닐 시(조건에 and class_no = (select min(class_no) from offclass) 이렇게 해줘야
--셀렉박스에서 맨처음에 있는 가장 첫번째 강의의 매출을 불러올 수 있음.
select
    to_char(order_date, 'YYYY-MM-DD') salesdate,
    O.class_name,
    sum(order_price) daysales, 
    sum(sum(order_price)) over(order by to_char(order_date, 'YYYY-MM') asc rows between unbounded preceding and current row) monthsales
from classorder C inner join offclass O on C.class_no = O.class_no
where 
    order_ok = '입금완료'
    and order_date >= trunc(sysdate, 'mm')
    and order_date < trunc(add_months(sysdate, 1), 'mm')
    and C.class_no = (select min(class_no) from offclass)
group by 
    to_char(order_date, 'YYYY-MM-DD'), O.class_name, to_char(order_date, 'YYYY-MM')
order by 
    to_char(order_date, 'YYYY-MM-DD') desc;

--검색이 아닐때 셀렉박스에서 첫번째 클래스의 연매출
select 
    to_char(order_date, 'YYYY') "year", sum(order_price) "yearsales" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and extract(year from order_date) = to_char(sysdate, 'YYYY')
    and class_no = (select min(class_no) from offclass)
group by 
    to_char(order_date, 'YYYY');    
    
----검색이 아닐때 셀렉박스에서 첫번째 클래스의 월매출
select 
    to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and to_char(order_date, 'YYYY-MM') = to_char(sysdate, 'YYYY-MM')
    and class_no = (select min(class_no) from offclass)
group by 
    to_char(order_date, 'YYYY-MM');    
    
    



-----------------------------
--데이터 테스트
insert into classorder values(order_seq.nextval, 2000, 148, '테스트', 50000, sysdate, '입금완료');
commit;



    

--2021년 4월 선택시 4월의 마지막날 구한후 1일 더해서 5월첫날을 구함
select last_day(to_date('2021-04' || '-01', 'YYYY-MM-DD'))+1 from dual;


--테스트
select to_char(last_day(to_date('2021-04' || '-01', 'YYYY-MM-DD'))+1, 'YYYY-MM-DD HH24:MI:SS') from dual;
select to_char(to_date('2021-04' || '-01', 'YYYY-MM-DD'), 'YYYY-MM-DD HH24:MI:SS') from dual;

--기간검색일때 일매출
select 
    to_char(order_date, 'YYYY-MM-DD') orderdate, sum(order_price) sales  
from 
    classorder 
where 
    order_ok = '입금완료'
    and order_date between 
    to_date('2021-04-01' || ' ' || '00:00:00' , 'YYYY-MM-DD HH24:MI:SS') 
    and to_date('2021-04-30' || ' ' || '23:59:59' , 'YYYY-MM-DD HH24:MI:SS')
group by 
    to_char(order_date, 'YYYY-MM-DD') 
order by 
    to_char(order_date, 'YYYY-MM-DD') desc;

   

select to_char(order_date, 'YYYY-MM'), sum(order_price) from classorder where order_ok = '입금완료' group by to_char(order_date, 'YYYY-MM') order by to_char(order_date, 'YYYY-MM') desc; 
select to_char(order_date, 'YYYY"년"'), sum(order_price) from classorder where order_ok = '입금완료' group by to_char(order_date, 'YYYY"년"')


--일매출, 월매출, 연매출 기간 검색일때
select * from(
    select to_char(order_date, 'YYYY-MM-DD') orderdate, sum(order_price) sales from  classorder where order_ok = '입금완료' and (order_date between to_date('2020-04-01' || ' ' || '00:00:00' , 'YYYY-MM-DD HH24:MI:SS') and to_date('2021-04-30' || ' ' || '23:59:59' , 'YYYY-MM-DD HH24:MI:SS')) group by to_char(order_date, 'YYYY-MM-DD')
    union all
    select to_char(order_date, 'YYYY-MM"월"'), sum(order_price) from classorder where order_ok = '입금완료' and (extract(year from order_date) >= '2020' and extract(month from order_date) >= '4') group by to_char(order_date, 'YYYY-MM"월"') 
    union all
    select to_char(order_date, 'YYYY"년"'), sum(order_price) from classorder where order_ok = '입금완료' and extract(year from order_date) >= '2020' group by to_char(order_date, 'YYYY"년"')
) order by orderdate desc;

select trunc(sysdate, 'mm') from dual;



---------------일매출 새롭게 작성

--검색시
select to_char(order_date, 'YYYY-MM-DD') orderdate, sum(order_price) sales from  classorder where order_ok = '입금완료' and (order_date between to_date('2021-04-01' || ' ' || '00:00:00' , 'YYYY-MM-DD HH24:MI:SS') and to_date('2021-04-30' || ' ' || '23:59:59' , 'YYYY-MM-DD HH24:MI:SS')) group by to_char(order_date, 'YYYY-MM-DD') order by to_char(order_date, 'YYYY-MM-DD') desc;


select order_date, extract(week from date);














select TMP.order_date, sum(order_price) from(
    select * from classorder where order_date between '2021-04-01' and '2021-04-30' 
)TMP
group by TMP.order_date;

--월매출 보기
select to_char(order_date, 'YYYY-MM'), sum(order_price) from classorder where order_date between '2021-04-01' and '2021-04-30' group by to_char(order_date, 'YYYY-MM');


--------------------------------검색 시 전체 매출 현황--------------------------
insert into classorder values(order_seq.nextval, 1, 144, '승운', '20000', to_date('2020-12-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '입금완료');
insert into classorder values(order_seq.nextval, 8, 144, '승운', '50000', to_date('2021-04-12 23:59:59', 'YYYY-MM-DD HH24:MI:SS'), '입금완료');
insert into classorder values(order_seq.nextval, 9, 144, '승운', '50000', to_date('2021-04-12 13:10:53', 'YYYY-MM-DD HH24:MI:SS'), '입금완료');
insert into classorder values(order_seq.nextval, 7, 144, '승운', '50000', to_date('2021-04-11 23:59:59', 'YYYY-MM-DD HH24:MI:SS'), '입금완료');
insert into classorder values(order_seq.nextval, 1, 144, '승운', '50000', to_date('2021-04-13 13:20:59', 'YYYY-MM-DD HH24:MI:SS'), '입금완료');
commit;
delete from classorder where order_no = 4;

select 
    to_char(order_date, 'YYYY-MM-DD') orderdate, 
    sum(order_price) sales 
from 
    classorder 
where 
    order_date  
        between 
        to_date('2021-04-01' || ' ' || '00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
        and 
        to_date('2021-04-12' || ' ' || '23:59:59', 'YYYY-MM-DD HH24:MI:SS')
    and order_ok = '입금완료' 
group by 
    to_char(order_date, 'YYYY-MM-DD') 
order by 
     to_char(order_date, 'YYYY-MM-DD') desc;



select to_char(sysdate+1, 'YYYY-MM-DD') from dual;


-----------------이벤트 목록---------------
--검색이 아닐때 이벤트 목록
select * from event order by event_start desc;
--검색이 아닐때 진행중 이벤트 목록
select * from event where to_char(event_start, 'YYYY-MM-DD') <= to_char(sysdate, 'YYYY-MM-DD') and to_char(event_end, 'YYYY-MM-DD') >= to_char(sysdate, 'YYYY-MM-DD') order by event_start desc;
--검색이 아닐때 진행예정 이벤트 목록
select * from event where to_char(event_start, 'YYYY-MM-DD') > to_char(sysdate, 'YYYY-MM-DD') order by event_start desc;
--검색이 아닐때 진행종료 이벤트 목록
select * from event where to_char(event_end, 'YYYY-MM-DD') < to_char(sysdate, 'YYYY-MM-DD') order by event_start desc;

--검색일때 이벤트 목록
select * from event where instr(event_title, '친') > 0 order by event_start desc;
--검색일때 진행중 이벤트 목록
select * from event where instr(event_title, '친') > 0 and to_char(event_start, 'YYYY-MM-DD') <= to_char(sysdate, 'YYYY-MM-DD') and to_char(event_end, 'YYYY-MM-DD') >= to_char(sysdate, 'YYYY-MM-DD') order by event_start desc;
--검색일때 진행예정 이벤트 목록
select * from event where instr(event_title, '테') > 0 and to_char(event_start, 'YYYY-MM-DD') > to_char(sysdate, 'YYYY-MM-DD') order by event_start desc;
--검색일때 진행종료 이벤트 목록
select * from event where instr(event_title, '테') > 0 and to_char(event_end, 'YYYY-MM-DD') < to_char(sysdate, 'YYYY-MM-DD') order by event_start desc;




select to_char(sysdate+1, 'YYYY-MM-DD') from dual;









------------------카테고리 추가----------------------
insert into classcategory values(classcategory_seq.nextval, '취업','기초');

--카테고리 중복 추가 방지
select * from classcategory where category_big = '공예' and category_small = '기초';

--대분류 리스트
select distinct category_big from classcategory;
 

--소분류 리스트
select distinct(category_small) from classcategory; 


------------------카테고리 목록--------------
--검색이 아닐때 카테고리 목록---
select * from (
select rownum rn, TMP.* from (
    select * from classcategory order by category_big asc
)TMP
) where rn between 1 and 15;

---검색이 아닐때 카테고리 목록 개수----
select count(*) from classcategory;
    

----검색일때 카테고리 목록---
select * from (
select rownum rn, TMP.* from (
    select * from classcategory
    where instr(category_small, '주식') > 0
    order by category_big asc 
)TMP
) where rn between 1 and 15;

-----검색일때 카테고리 목록 개수---
select count(*) from classcategory where instr(category_big, '재') > 0;




--------------카테고리 수정---------------
--카테고리 번호로 카테고리 정보 가져오기
select * from classcategory where category_no = 39;  

-- 카테고리 수정하기
update classcategory set category_big = '재테크', category_small = '테스트' where category_no =63;

-----------------카테고리 삭제-------------
delete from classcategory where category_no = 63;


commit;














--오늘로부터 6개월 전 달의 첫번째 날짜---
select to_char(trunc(add_months(sysdate, -5), 'mm'), 'YYYY-MM-DD HH24:MI:SS') from dual;

--마지막날은 구해지는데 시간과 관련이 있는 범위를 처리할때 오류발생가능성이 높아 위험
select to_char(last_day(add_months(sysdate, -1)), 'YYYY-MM-DD HH24:MI:SS') from dual;

select to_date('2021-03-31' || ' ' || '23:59:59' , 'YYYY-MM-DD HH24:MI:SS') from dual;
----------------------------------------
select * from (
    select rownum rn, TMP.* from(
        select 
            extract(year from member_date) join_year, extract(month from member_date) join_month, count(*) count, sum(count(*)) over(order by extract(year from member_date) asc, extract(month from member_date) asc) total 
        from 
            member
        group by 
            extract(year from member_date), extract(month from member_date)
        order by 
            extract(year from member_date) desc, extract(month from member_date) desc
    )TMP
)
where rn between 1 and 7
order by rn desc;

-------------------------------------------



--이번달 첫째날 구하는쿼리--
select trunc(add_months(sysdate, -5), 'mm') from dual;


--------------------------------------------------------------------------
select 
    		extract(year from member_date) join_year, extract(month from member_date) join_month, count(*) count 
		from 
			member 
		where 
    		member_date between trunc(add_months(sysdate, -6), 'mm') and sysdate
		group by 
    		extract(year from member_date), extract(month from member_date)
		order by 
   			extract(year from member_date) asc, extract(month from member_date) asc;






----------------------------전체 매출 차트용---------------------
select 
    to_char(order_date, 'YYYY') "year", sum(order_price) "yearsales" 
from 
    classorder 
where
    order_ok = '입금완료'
    and 
    extract(year from order_date) = to_char(sysdate, 'YYYY')  
group by 
    to_char(order_date, 'YYYY');
--------------------            
select 
    to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and extract(year from order_date) = extract(year from sysdate)
group by to_char(order_date, 'YYYY-MM')
order by to_char(order_date, 'YYYY-MM') asc;


---검색일때 전체 매출현황 차트
select 
    to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and extract(year from order_date) = extract(year from to_date('2021-03', 'YYYY-MM'))
group by to_char(order_date, 'YYYY-MM')
order by to_char(order_date, 'YYYY-MM') asc;

------------------------------특정 클래스 매출 차트용--------------
--검색이 아닐때
select 
    to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and extract(year from order_date) = extract(year from sysdate)
    and class_no = (select min(class_no) from offclass)
group by 
    to_char(order_date, 'YYYY-MM')
order by 
    to_char(order_date, 'YYYY-MM') asc;    
    
--검색일때
select 
    to_char(order_date, 'YYYY-MM') "year_month", sum(order_price) "sales_for_month" 
from 
    classorder 
where 
    order_ok = '입금완료' 
    and extract(year from order_date) = extract(year from to_date('2021-03', 'YYYY-MM'))
    and class_no = 41
group by 
    to_char(order_date, 'YYYY-MM')
order by 
    to_char(order_date, 'YYYY-MM') asc;
        
     
        
--데이터 테스트
insert into classorder values(order_seq.nextval, 74, 223, '이지영', 100000, to_date('2021-04-30 14:32:10', 'YYYY-MM-DD HH24:MI:SS'), '입금완료', '정산대기');
commit;
update classorder set order_calc = '정산대기' where to_char(order_date, 'YYYY-MM-DD') =  '2021-05-01';
delete from offclass where class_no between 32 and 35;
rollback;

delete from classorder where order_no = 41;

--클래스 검수 승인
update offclass set class_start = '2020-11-01' where class_no = 47;
update offclass set class_end_check = '종료' where class_no = 41;

update offclass set class_end_check = '진행' where class_no = 45;
rollback;
commit;

commit;




insert into member values(member_seq.nextval,'love@aaa.com','love','러브','',sysdate,'일반','','','y','y','y','n');
insert into member values(member_seq.nextval,'com@aaa.com','com','컴퓨터','',sysdate,'일반','','','y','y','y','n');
insert into member values(member_seq.nextval,'wood@aaa.com','wood','나무인간','',sysdate,'일반','','','y','y','y','n');
insert into member values(member_seq.nextval,'food@bbb.com','food','배가고파','',sysdate,'일반','','','y','y','y','n');
insert into member values(member_seq.nextval,'bbb@bbb.com','bbbb','농구국대출신','',sysdate,'일반','','','y','y','y','n');
insert into member values(member_seq.nextval,'bbbb@bbb.com','bbbb','골프랭킹1위','',sysdate,'일반','','','y','y','y','n');
insert into member values(member_seq.nextval,'drawing@ccc.com','drawing','너도웹툰가능','',sysdate,'일반','','','y','y','y','n');
commit;







select 
		    C.creator_no, M.member_nick creator_nick, OC.class_name, to_char(CO.order_date, 'YYYY-MM-DD') order_date, 
		    sum(order_price) class_sales, sum(order_price) * 0.9 creator_income,
		    CO.order_calc
		from 
		    classorder CO
		        inner join offclass OC on CO.class_no = OC.class_no and CO.order_ok = '입금완료'
		        inner join creator C on OC.creator_no = C.creator_no
		        inner join member M on C.member_no = M.member_no
		where to_char(CO.order_date, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')  
		group by C.creator_no, M.member_nick, OC.class_name, to_char(CO.order_date, 'YYYY-MM-DD'), CO.order_calc
		order by C.creator_no, to_char(CO.order_date, 'YYYY-MM-DD') desc, sum(order_price) desc;

-------------------데이터 삽입-------------------------

