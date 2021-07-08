
-- 테이블 생성 및 데이터 입력
create table member(
member_no number,
member_id varchar2(255),
member_pw varchar2(255),
member_nick varchar2(255),
member_point number,
join_date date
);

create sequence member_seq;

insert into member values(member_seq.nextval, 'tester', 'test1234', '테스트유저', 500, '2019-05-01');
insert into member values(memver_seq.nextval, 'admin', 'admin1234', '관리자', 999999, '2019-01-01');
insert into member values(member_seq.nextval, 'student', 'student', '학생', 1000, '2020-03-01');
insert into member values(member_seq.nextval, 'master', 'master', '사장', 50000, '2020-05-05');
commit;

-- 조회 연습
select * from member;

-- 1. 포인트가 1000점 이하인 회원 조회
select * from member where member_point <= 1000;

-- 2. 포인트가 1000점 이상 2000점 이하인 회원 조회
select * from member where member_point between 1000 and 2000;

-- 3. 아이디가 admin인 회원 조회
select * from member where member_id = 'admin';

-- 4. 닉네임에 "관리"라는 글자가 포함된 회원 조회
select * from member where instr(member_nick, '관리') > 0;

-- 5. 포인트가 가장 많은 회원의 모든 정보를 조회
select * from member where member_point = (select max(member_point) from member);

-- 6. 회원을 최근에 가입한 순으로 정렬하여 조회
select * from member order by join_date desc;

-- 7. 회원을 포인트가 많은 순으로 정렬하여 조회
select * from member order by member_point desc;
연도
-- 8. 연도별 회원의 보유 포인트 합계를 조회
select extract(year from join_date) "연도", sum(member_point) "포인트 합계" 
from member 
group by extract(year from join_date);

-- 9. 모든 회원에게 포인트 50점 부여
update member set member_point = member_point + 50;
select * from member;
commit;

-- 10. 2019년에 가입한 회원에게 포인트 500점 부여
update member set member_point = member_point + 500 where extract(year from join_date) = 2019;

-- 11. student 계정 삭제
drop table member;



