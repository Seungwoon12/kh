-- 모든 테이블 목록을 조회
select * from tab;

-- student 테이블에 name에 피카츄 score에 50을 집어넣어라!
insert into student(name, score) values('피카츄', 50);

-- 확정 저장(commit) / 확정 취소(rollback) / 저장지점 생성(savepoint)
commit;

select * from student;

create table product(
product_no number primary key,
product_name varchar2(90),
product_company varchar2(30),
product_price number,
product_discount number(3, 1),
product_quantity number,
product_regist date,
product_made date
);
insert into product values(1, '포카칩', '해태', 2000, 0.5, 1, '2020-11-01', '2020-10-01');
insert into product values(2, '홈런볼', '해태', 2500, 10, 1, '2020-11-01', '2020-10-01');
insert into product values(3, '맛동산', '해태', 3000, 5, 1, '2020-11-01', '2020-10-01');
commit;

-- product 테이블에 데이터 추가
-- 데이터 순서를 지정하지 않으면 테이블 형태와 똑같이 넣어야 한다(어기면 에러!)
-- 지금 시간이 필요하면 sysdate 라는 값을 사용할 수 있다(오라클에서 제공)
insert into product values(1, '포카칩', '해태', 2000, 0.5, 10, '2020-11-13', '2020-11-01');
insert into product values(2, '홈런볼', '롯데', 2500, 0.0, 15, sysdate, '2020-11-01');
commit;
truncate table product;
select * from product;

update product
set product_quantity=product_quantity+1
where product_no=1;
commit;

-- exam 테이블
DROP TABLE EXAM;
CREATE TABLE EXAM(
STUDENT_CODE CHAR(8),
STUDENT_NAME VARCHAR2(21),
EXAM_SUBJECT VARCHAR2(18),
SUBJECT_NO1 NUMBER(3),
SUBJECT_NO2 NUMBER(3),
SUBJECT_NO3 NUMBER(3),
SUBJECT_NO4 NUMBER(3),
SUBJECT_NO5 NUMBER(3),
EXAM_DATE DATE,
REGIST_DATE DATE
);

-- 데이터 추가(DML)
INSERT INTO EXAM(
STUDENT_CODE, STUDENT_NAME, EXAM_SUBJECT, SUBJECT_NO1, SUBJECT_NO2, SUBJECT_NO3, 
SUBJECT_NO4, SUBJECT_NO5, EXAM_DATE, REGIST_DATE)
VALUES('A0013452', '홍길동', '정보처리기사', 45, 50, 80, 80, 100, '2020-10-30', sysdate);

INSERT INTO EXAM(
STUDENT_CODE, STUDENT_NAME, EXAM_SUBJECT, SUBJECT_NO1, SUBJECT_NO2, SUBJECT_NO3, 
SUBJECT_NO4, SUBJECT_NO5, EXAM_DATE, REGIST_DATE)
VALUES('A0013379', '전우치', '정보처리기사', 70, 60, 60, 60, 90, '2020-10-30', sysdate);

INSERT INTO EXAM(
STUDENT_CODE, STUDENT_NAME, EXAM_SUBJECT, SUBJECT_NO1, SUBJECT_NO2, SUBJECT_NO3, 
SUBJECT_NO4, SUBJECT_NO5, EXAM_DATE, REGIST_DATE)
VALUES('A0013654', '장보고', '건축기사', 80, 60, 70, 20, 30, '2020-10-30', sysdate);

COMMIT;

select * from exam;

select * from student;

insert into student(name, score) values('피카츄', 60);
commit;

------------------------------------------------
-- 시퀀스 : 번호를 자동으로 부여하기 위한 도구
------------------------------------------------
-- 생성 : create sequence 이름 [옵션];
-- 조회 : select * from user_sequences;
-- 변경 : alter sequence 이름 [옵션];
-- 삭제 : drop sequence 이름;
-- 번호발급 : 이름.nextval

-- 1. 아무런 옵션이 없는 시퀀스를 생성
create sequence test_seq;

-- 2. 번호만 있는 테이블 생성
create table test(no number);
-- insert into test(no) values(1);-- 번호를 내가 직접 부여
insert into test(no) values(test_seq.nextval);--번호를 시퀀스를 통해 부여

select * from test;

-- 테이블 데이터 자르기(DDL) : 데이터를 지우는것이 아니라 테이블을 제목만 빼고 초기화시키는 것
truncate table test;

-- 3.시퀀스의 초기값을 지정하여 생성(1001부터)
create sequence test2_seq start with 1001;
insert into test(no) values(test2_seq.nextval);

-- 4.시퀀스 상태 조회
select * from user_sequences;

-- 5. 1부터 5까지 회전하는 시퀀스(1,2,3,4,5,1,2,3,4,5,...)
drop sequence test3_seq;
create sequence test3_seq 
minvalue 1 
maxvalue 5 
increment by 1 
start with 1
cycle
nocache;

truncate table test;
insert into test(no) values(test3_seq.nextval);--6번이상 실행
select * from test;

-- 6. 캐시 설정을 한 시퀀스와 아닌 시퀀스의 차이
-- 시퀀스는 기본적으로 20의 캐시(여분) 크기를 가진다
create sequence test4_seq cache 20;
create sequence test5_seq nocache;

select * from user_sequences;

insert into test(no) values(test4_seq.nextval);
insert into test(no) values(test5_seq.nextval);
select * from test;

---------------------------------------------------------
-- person 테이블 생성 및 실습용 데이터 추가
---------------------------------------------------------

-- 테이블 및 시퀀스 생성
create table person(
person_no number,
person_name varchar2(21),
javascore number(3),
dbscore number(3),
gender char(6),
regist_date date
);
create sequence person_seq;

-- 데이터 추가(to_date는 맥에서는 자동으로 date타입으로 변환안돼서 쓰는거 윈도우는 '2021-04-02'이런식으로 써도됨)

insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '김민준', 60, 70, '남자', to_date('2020-04-01', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '박서연', 80, 95, '여자', to_date('2020-05-05', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '이서준', 50, 60, '남자', to_date('2020-06-12', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '최서윤', 80, 55, '여자', to_date('2020-08-21', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '한예준', 75, 65, '남자', to_date('2020-10-05', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '송시우', 72, 70, '남자', to_date('2020-11-01', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '오하윤', 90, 80, '여자', to_date('2019-01-07', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '한지민', 95, 75, '여자', to_date('2019-01-12', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '이채원', 99, 72, '여자', to_date('2019-02-21', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '김선우', 66, 70, '남자', to_date('2019-02-28', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '양수아', 62, 50, '여자', to_date('2019-04-05', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '홍수빈', 50, 75, '여자', to_date('2019-05-01', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '황민재', 76, 71, '남자', to_date('2019-07-07', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '정현준', 80, 90, '남자', to_date('2020-11-03', 'YYYY-MM-DD'));
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '임소율', 75, 68, '여자', to_date('2020-07-14', 'YYYY-MM-DD'));
commit;
insert into person(person_no, person_name, javascore, dbscore, gender, regist_date)
values(person_seq.nextval, '임소율2', 75, 68, '여자', '2021-04-02');

-------------------------------------------------------
-- 데이터 조회(SELECT) : 데이터베이스에서 가장 많이 하는 작업
-------------------------------------------------------

-- 1. 전체 조회 : 와일드카드(*)를 사용
-- select(조회) *(전부) from person(person 테이블에서)
select * from person;
select person_no, person_name, javascore, dbscore, gender, regist_date from person;

-- 2. 이름만 조회
select person_name from person;

-- 3. 성별만 조회
select gender from person;

-- 4. 이름과 성별을 조회
select person_name, gender from person;

---------------------------------------------------
-- 조건 : 필터링(filtering)을 통해 원하는 데이터만 추출
-- 형식 : select 항목 from 테이블 where 조건식
---------------------------------------------------

-- 숫자 조건

-- 5. 자바점수가 60점인 사람을 조회(주의 : 같음을 =로 표현)
select person_name from person where javascore = 60;
select person_name, javascore from person where javascore = 60;
select * from person where javascore = 60;

-- 6. DB점수가 70점 미만인 사람을 조회
select * from person where dbscore < 70;

-- 7. 자바점수와 DB점수의 합계가 150점 이하인 사람을 조회
select * from person where (javascore + dbscore) <= 150;

select person_name, javascore + dbscore from person;

select person_name 이름, javascore + dbscore 총점 from person 
where (javascore + dbscore) <= 150;

-- 8. 이름과 평균점수를 구하여 출력
-- 주의 : 오라클 나눗셈은 정수형이 없다
-- 주의 : 오라클은 별칭에 띄어쓰기 하고 싶을 때 ""로 감싼다
select person_name "이름", (javascore + dbscore) / 2 "평균 점수" from person;

-- 9. 이름과 평균점수를 출력하는데 평균 60점 이상인 사람만 출력
select person_name "이름", (javascore + dbscore) / 2 "평균 점수" from person
where (javascore + dbscore) / 2 >= 60;

-- 10. 자바점수가 70점 이상 80점 이하인 사람을 조회(구간조회)
-- 주의 : 오라클에서는 &&는 입력기호, ||은 문자열 덧셈기호(and/or이 아님)
select * from person where javascore >= 70 and javascore <= 80;

-- 11. NCS 기준을 적용시켜서 합격한 학생들의 정보를 출력
-- 각과목 40점이상이면서 평균 60점 이상
select * from person 
where 
    javascore >= 40 
    and dbscore >= 40 
    and (javascore + dbscore) / 2 >= 60;

-- 문자열 조건 : 자바는 문자열을 equals로 비교하지만 데이터베이스는 그런거 없다

-- 12. 성별이 "여자"인 사람을 조회
select * from person where gender = '여자';
select * from person where gender = '남자';

-- 문자열 유사 검색
-- 1) LIKE 검색 : LIKE 키워드와 문자열 내부의 %를 이용하여 특정 글자 유무를 파악
-- %는 해당하는 위치에 글자가 있어도 되고 없어도 된다는 의미. ex) '김%' = 김oo , '%윤' = oo윤
-- 2) INSTR 명령 : INSTR 명령은 자바의 INDEXOF와 같은 명령. 일치하는 문자의 위치를 반환
-- 오라클은 문자열이 1번부터 시작하므로 검색했을 때 결과가 0보다 크면 존재한다고 본다.
-- 뭐가 더 좋은가? 
-- 시작검사를 할 때는 LIKE가 빠름
-- 나머지는 INSTR이 빠름

-- 13. "김"씨 성을 가진 사람을 조회
select * from person where person_name like '김%';

-- 14. "윤"으로 끝나는 이름을 가진 사람을 조회
select * from person where person_name like '%윤';

-- 15. "민"이 포함된 이름을 가진 사람을 조회
select * from person where person_name like '%민%';
select * from person where instr(person_name, '민') > 0;

-- 날짜 조건
-- 숫자처럼 계산이 가능 / 문자열처럼 유사검색도 가능 / 날짜 전용 명령도 존재

-- 16. 모든 사람들의 이름과 가입년도를 출력
-- extract(추출할항목 from 대상컬럼)
select person_name 이름, extract(year from regist_date) 가입년도 from person;
select person_name 이름, extract(month from regist_date) 가입월 from person;

-- 17. 작년에 가입한 사람들의 이름과 점수 평균을 출력
select person_name 이름, (javascore+dbscore)/2 평균 from person 
where extract(year from regist_date) = extract(year from sysdate)-1;

-- 올해
select person_name 이름, (javascore+dbscore)/2 평균 from person 
where extract(year from regist_date) = extract(year from sysdate);

-- 18. 여름(6,7,8월)에 가입한 사람들의 이름과 성별을 출력
select person_name, gender from person
where 
    extract(month from regist_date) = 6
    or extract(month from regist_date) = 7
    or extract(month from regist_date) = 8;
    
select person_name, gender from person
where 
    extract(month from regist_date) >= 6
    and extract(month from regist_date) <= 8;
    
-- between은 ~ 이상 ~ 이하를 처리할 수 있다(구간 조회)
select person_name, gender from person
where extract(month from regist_date) between 6 and 8;

---------------------------------------------------
-- 정렬 : 데이터를 순서대로 나열하는 것
-- 형식 : ORDER BY 항목 ASC/DESC, ...
---------------------------------------------------

-- 1. 모든 사람을 번호순으로 정렬(person_no asc)
select * from person order by person_no asc;
select * from person order by person_no;--안쓰면 asc로 처리
select * from person order by person_no desc;

-- 2. 모든 사람을 자바 성적순으로 출력(javascore desc)
select * from person order by javascore desc;

-- extend) 모든 남자들을 자바 성적순으로 출력(조건+정렬)
select * from person where gender='남자' order by javascore desc;

-- 3. 모든 사람을 총점순으로 출력( javascore+dbscore desc )
select * from person order by javascore+dbscore desc;

select person.*, javascore+dbscore 총점 from person 
order by javascore+dbscore desc;

-- 4. 모든 사람을 최근 가입한 순으로 출력( regist_date desc )


-- 5. 성별순으로 정렬
select person.*, javascore+dbscore 총점 from person 
order by gender asc , javascore+dbscore desc;

-- 응용문제 : 가장 자바점수가 높은 사람의 이름을 출력
-- 1. 가장 높은 자바 점수를 찾아라 : max(javascore)
-- 2. 1번에서 찾은 점수에 해당하는 사람을 찾아라
select max(javascore) from person;
select * from person where javascore = 99;

-- select * from person where javascore = max(javascore);
select * from person where javascore = (select max(javascore) from person);

-- 1. 자바 점수가 높은 순으로 정렬
-- 2. 첫 번째 항목을 조회
select * from person order by javascore desc;
-- select * from person order by javascore desc where rownum = 1;
select * from (
    select * from person order by javascore desc
) where rownum = 1;

----------------------------------------------------------
-- 오라클 내장 함수(Function) : 오라클이 제공하는 기본 연산 기능
----------------------------------------------------------
-- 듀얼 테이블 : 임시로 결과를 저장할 수 있는 테이블
select 1234+5678 from dual;

-- upper : 모든 글자를 대문자로 변환
select upper('Hello') "결과" from dual;

-- lower : 모든 글자를 소문자로 변환
select lower('Hello') "결과" from dual;

-- initcap : 첫 글자만 대문자로 변환
select initcap('hello oracle') "결과" from dual;

-- substr : 문자열 추출(자르기)
-- 주의! 오라클은 순서가 1부터 시작

-- ABCDEFG를 3번째부터 볼 수 있도록 자른다!
select substr('ABCDEFG', 3) "결과" from dual;
-- ABCDEFG를 3번째부터 2개만 볼 수 있도록 자른다!
select substr('ABCDEFG', 3, 2) "결과" from dual;

-- replace : 문자열 교체(치환)
select replace('이런 신발끈 개나리같은 수박씨야!!!', '신발끈', '***') from dual;
select regexp_replace('이런 신발끈 개나리같은 수박씨야!!!', '신발끈|개나리|수박씨', '***') from dual;

-- person의 데이터 중 이름을 성만 놔두고 *로 바꿔서 출력
-- 1. substr로 첫글자만 잘라낸다
-- 2. '**'과 더해서 붙여준다.

select substr(person_name, 1, 1) from person;
select substr(person_name, 1, 1)||'**' from person;

-- 집계 함수 : 최대, 최소, 합계, 평균, 개수

-- max : 최대값
select max(javascore) from person;

-- min : 최소값
select min(javascore) from person;

-- sum : 합계
select sum(javascore) from person;
select sum(javascore)/15 from person;

-- avg : 평균
select avg(javascore) from person;

-- count : 개수
select count(person_no) from person;--번호가 몇개있나요?
select count(*) from person;--데이터가 몇개있나요?(비어있는것 포함)

-- 점검 문제
-- [1] 작년에 등록한 사람 수를 구하여 출력
select count(*) "사람수" from person 
where extract(year from regist_date) = extract(year from sysdate)-1;

-- [2] 올해 가장 먼저 등록한 사람의 가입일
select * from person where regist_date = (
    select min(regist_date) "가입일" from person
    where extract(year from regist_date) = extract(year from sysdate)
);

-- [3] 작년에 가장 나중에 등록한 사람의 모든 정보
-- 2가지 작업 필요 : 날짜조회 + 정보확인 (서브쿼리)
select * from person where regist_date = (
    select max(regist_date) "가입일" from person 
        where extract(year from regist_date) = extract(year from sysdate) - 1
);

--------------------------------------------------------------------
-- 그룹 조회(GROUP BY) : 성별, 연도
-- 그룹 조회는 집계 함수를 이용하여 그룹별로 집계한 값을 확인하는 것이 목표!
--------------------------------------------------------------------
select * from person;

-- 1. 성별로 조회
select gender from person;
-- 2. 그룹 설정
select distinct gender from person;--중복제거
select gender from person group by gender;--그룹설정 : 각종 항목을 추가할 수 있음

-- 3. 항목 추가
-- 주의사항 : gender로 묶었을 때는 항목 중에선 gender만 출력 가능
select gender, count(*) from person group by gender;
select gender, count(*), max(javascore) from person group by gender;
select gender, avg(javascore), avg(dbscore) from person group by gender;

-- 문제 : 연도별로 등록한 회원들의 인원수를 구하여 출력
select 
    extract(year from regist_date), count(*) 
from person 
group by extract(year from regist_date)
order by extract(year from regist_date) asc;

select 연도, count(*) from (
    select person.*, extract(year from regist_date) 연도 from person
)
group by 연도
order by 연도;

-- 문제 : 성씨별로 인원수, 성씨별 전체평균 조회 후 가나다순 정렬 후 출력
select 
    substr(person_name, 1, 1) || '씨', count(*), avg((javascore+dbscore)/2)
from person 
group by substr(person_name, 1, 1)
order by substr(person_name, 1, 1) desc;

select 성씨, count(*), avg(총점) from (
    select 
        person.*, 
        substr(person_name, 1, 1) "성씨",
        (javascore+dbscore)/2 "총점"
    from person
)
group by 성씨
order by 성씨;

-- 추가 : 성별 인원수 출력(인원이 8명 이상인 경우만)
-- 그룹조건 : 그룹이 생성되는 조건(where와는 다름)
-- 그룹조건은 반드시 그룹 키워드 뒤에 나와야 한다.
-- 그룹 이후에 살펴볼 집계함수를 기준으로 조건을 설정
select gender, count(*) from person group by gender having count(*) > 7;

--------------------------------------------------------------------------
-- 수정(Update) : 데이터를 고쳐서 원하는 상태로 변경하는 것
--------------------------------------------------------------------------
-- 형식 : update 테이블이름 set 수정구문 [조건];
-- 주의 : 모든 항목을 수정하는 경우는 거의 없음(조건은 반강제)

-- 1. 모든 사람의 자바점수를 60점으로 변경
update person set javascore = 60;
select * from person;
rollback;

-- 2. 1번 학생의 자바점수를 65점으로 변경
update person set javascore = 65 where person_no = 1;
commit;

-- 3. '한'씨 성을 가진 학생의 DB점수를 5점 증가하도록 변경
-- 주의 : 오라클 SQL에는 += , -= 와 같은 복합연산이 없다.
update person set dbscore = dbscore + 5 where person_name like '한%';
update person set dbscore = dbscore + 5 where substr(person_name, 1, 1) = '한';

-- 4. 올해 등록한 학생들의 점수를 10% 감점하도록 변경
update person 
set javascore = javascore * 0.9 , dbscore = dbscore * 0.9
where extract(year from regist_date) = extract(year from sysdate);
rollback;

--------------------------------------------------------------------
-- 삭제(DELETE) : 존재하는 데이터를 제거하는 것
--------------------------------------------------------------------
-- 형식 : delete [from] 테이블이름 [조건];

-- 1. 자바점수가 40점 미만인 학생을 삭제
delete person where javascore < 40;

-- 2. DB점수가 40점 미만인 학생을 삭제
delete person where dbscore < 40;

-- 3. 평균이 60점 미만인 학생을 삭제
delete person where (javascore + dbscore) / 2 < 60;
select * from person;

-- 4. 일반적인 삭제는 "번호"를 이용해서 1개만 지우는 것
delete person where person_no = 1;
rollback;

------------------------------------------------------
-- 날짜와 문자열에 대한 명령 : 형식을 알려줘야한다
------------------------------------------------------
select '2020-11-18' from dual;
select to_date('2020-11-18', 'YYYY-MM-DD') from dual;
select to_date('2020-11-18 16:19:20', 'YYYY-MM-DD HH24:MI:SS') from dual;
select to_date('2020년 11월 18일', 'YYYY"년" MM"월" DD"일"') from dual;

select regist_date from person;
select to_char(regist_date, 'YYYY-MM-DD') from person;
select to_char(regist_date, 'YYYY-MM-DD HH24:MI:SS') from person;
select to_char(regist_date, 'HH24:MI') from person;
select to_char(regist_date, 'YYYY.MM.DD.') from person;
-- 2020년 11월 18일 형태로 출력
select to_char(regist_date, 'YYYY"년" MM"월" DD"일"') from person;
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') from dual;

---------------------------------------------------------------
-- 경우에 따라 다른 처리를 수행하는 명령(if~elseif~...)
---------------------------------------------------------------
-- DECODE : switch~case처럼 값을 기준에 따라 변환하는 명령
-- DECODE(데이터, case1, value1, case2, value2, ..., default)

-- gender가 남자면 M , 여자면 F 로 출력
select person_name, gender from person;
select person_name, decode(gender, '남자', 'M', '여자', 'F', '?') "성별" from person;

-- person에 들어있는 데이터를 출력하는데 
-- 2020년 데이터는 HH24:MI 형태로, 2019년 데이터는 YYYY-MM-DD 형태로 출력
-- select 이름, DECODE(가입년도, 2020, HH24:MI , 2019, YYYY-MM-DD) from person;
select 
    person_name, 
    decode(
        extract(year from regist_date)--가입년도
        ,2020,to_char(regist_date, 'HH24:MI')
        ,2019,to_char(regist_date, 'YYYY-MM-DD')
    ) 가입일 
from person;

-- DECODE가 길어지면 매우 힘들어진다. 해결은 어떻게? CASE 구문
-- 조금 더 복잡한 처리에 활용하기가 쉽다
--  CASE 값 
--      WHEN 비교값1 THEN 변환값1 
--      WHEN 비교값2 THEN 변환값2 
--        ... 
--      ELSE 기타변환값 
--  END
select 
    person_name,
    case extract(year from regist_date)
        when 2020 then to_char(regist_date, 'HH24:MI')
        when 2019 then to_char(regist_date, 'YYYY-MM-DD')
        else to_char(regist_date, 'YYYY-MM-DD HH24:MI:SS')
    end 가입일
from person;


select 
    person_name,
    case to_char(regist_date, 'YYYY')
        when '2020' then to_char(regist_date, 'HH24:MI')
        when '2019' then to_char(regist_date, 'YYYY-MM-DD')
        else to_char(regist_date, 'YYYY-MM-DD HH24:MI:SS')
    end 가입일
from person;

-- 네이버 게시글 출력 구문처럼 오늘이면 시간, 아니면 날짜 출력
select 
    person_name,
    case to_char(regist_date, 'YYYY-MM-DD')--가입일을 따져봐서
        when to_char(sysdate, 'YYYY-MM-DD')--오늘이랑 날짜가 같으면
            then to_char(regist_date, 'HH24:MI')--시간을 조회하고
        else--아니면
            to_char(regist_date, 'YYYY.MM.DD.')--날짜를 조회하세요
    end 가입일--끝!(가입일이라고 별칭을 붙여라)
from person;

----------------------------------------------------------------
-- 테이블 제약조건(table constraint)
-- 목표 : 안전한 데이터(내가 원하는 데이터)만 저장할 수 있도록 조건 설정
----------------------------------------------------------------

-- 문제가 되는 상황
create table test1(
emp_no number,--사원번호
emp_name varchar2(30),--사원명
dept varchar2(30),--부서명
salary number,--급여
position varchar2(30),--직급
enter date--입사일
);
-- 상황1 : 비어있는 데이터(오라클은 '' 과 null 모두 비어있다라고 생각)
insert into test1 values(null, null, null, null, null, null);
select * from test1;

-- 상황2 : 똑같은 데이터(중복 데이터)
truncate table test1;
insert into test1 values(
    1, '홍길동', '경영지원팀', 2000000, '사장', to_date('2010-01-01', 'YYYY-MM-DD'));
select * from test1;

-- 상황3 : 지정하지 않은 데이터의 추가

-- 테이블에 조건을 추가하여 문제 상황을 개선!
-- NOT NULL : 필수항목 설정
-- UNIQUE : 중복불가 설정
-- PRIMARY KEY : 대표항목(NOT NULL + UNIQUE)
-- CHECK : 값 지정
-- DEFAULT : 기본값 설정(반드시 가장 먼저 쓰여야 함)
drop table test2;
create table test2(
emp_no number primary key,--대표항목(필수, 구분)
emp_name varchar2(30) not null,--필수
dept varchar2(30) check(dept in ('개발','영업','기획')),
salary number check(salary >= 0),--원하는 조건 설정
position varchar2(30) default '프로' not null check(position in ('오너','프로')),--필수
enter date default sysdate not null--필수
);
-- 상황1 해결
insert into test2 values(null, null, null, null, null, null);
-- 상황2 해결 : 두번은 안들어간다
insert into test2 values(
    1, '홍길동', '영업', 2000000, '오너', to_date('2010-01-01', 'YYYY-MM-DD'));
-- 상황3 해결
insert into test2 values(
    50, '코딩왕', '개발', 5000000, '프로', sysdate);
insert into test2 values(
    51, '피구왕', '홍보', 5000000, '프로', sysdate
);
-- 기본값 설정 : 직접 설정하지 않고 해당 칸을 제외하고 추가하면 자동 적용
insert into test2(emp_no, emp_name, dept, salary, position) 
values(52, '탁구왕', '영업', 2000000, '프로');
select * from test2;

insert into test2(emp_no, emp_name, dept, salary) 
values(55, '축구왕', '개발', 3000000);


------------------------------------------------------------
-- NULL 검사
------------------------------------------------------------
create table people(
name varchar2(30) not null,
email varchar2(100)
);

insert into people values('테스트1', 'test@kh.com');
insert into people values('테스트2', null);
insert into people(name) values('테스트3');
commit;
select * from people;

-- 상황 1 : 이메일이 없는 사람만 조회
select * from people where email = 'null';
select * from people where email = null;
select * from people where email = '';
select * from people where email is null;--정답
-- 상황 2 : 이메일이 있는 사람만 조회
select * from people where email is not null;

----------------------------------------------------------------
-- 외래키 : 테이블 제약조건 중 하나
-- 서로 다른 테이블 간의 상하(참조) 관계를 설정하는 제약조건. 1:N 관계를 구현할 수 있다
----------------------------------------------------------------
-- 특징1. 부모테이블에 없는값 연결 금지
-- 특징2. 연결된 값이 있을 경우 데이터 및 테이블 삭제 금지

-- 학원 테이블
drop table academy;
create table academy(
academy_no number primary key,
academy_name varchar2(30) not null
);
-- 수강생 테이블 : 학원 번호를 알아야 한다! (소속되어있으니 값을 알아야 한다)
drop table junior;
create table junior(
junior_no number primary key,
junior_name varchar2(30) not null,
academy_no references academy(academy_no)--academy테이블에 academy_no랑 똑같이 할게요!
);
-- 학원 등록
insert into academy values(1, 'KH강남점');
insert into academy values(2, 'KH종로점');
commit;
-- 학생 등록(5명)
insert into junior values(101, '피카츄', 1);
insert into junior values(102, '파이리', 1);
insert into junior values(103, '꼬부기', 1);
insert into junior values(104, '홍길동', 2);
insert into junior values(105, '임꺽정', 2);
commit;



--table board 와 table reply 라는 테이블을 만들어 게시글과 댓글을 저장하려고 합니다
--다음 데이터를 저장할 수 있도록 구조를 구현하고 데이터를 저장하세요.
--(예습 : 게시글이 지워지면 댓글이 자동으로 지워지게 설정할 수 있습니다)
--
--1번 게시글 / 제목 : 공지사항 / 내용 : 악플 자제하세요!
--           1번 댓글 / 네!
--           2번 댓글 / 니가 뭔데!
--           3번 댓글 / 싫어요!
--2번 게시글 / 제목 : 오늘날씨 / 내용 : 아주 안좋네요
--           4번 댓글 / 미세먼지 장난아님!
--           5번 댓글 / 좋은데?
--3번 게시글 / 제목 : 심심한데 / 내용 : 공부나 할까요?
--           6번 댓글 / 갑자기?
--           7번 댓글 / 진짜 심심한가 보구나

create table board(
board_no number primary key,
board_title varchar2(200) not null,
board_content varchar2(4000) not null
);
drop table reply;
create table reply(
reply_no number primary key,
reply_content varchar2(4000) not null,
-- 외래키 설정
-- board_no references board(board_no) -- 아무 설정을 하지 않으면 아무런 효과가 없다
-- board_no references board(board_no) on delete cascade --연결된 게시글이 삭제되면 나도 삭제!
board_no references board(board_no) on delete set null -- 연결된 게시글이 사라지면 이 자리를 null로 설정
);

-- 게시글 등록
insert into board values(1, '공지사항', '악플 자제하세요!');
insert into board values(2, '오늘날씨', '아주 안좋네요');
insert into board values(3, '심심한데', '공부나 할까요?');
commit;
select * from board order by board_no desc;

--댓글 등록
insert into reply(reply_no, reply_content, board_no) values(1, '네!', 1);
insert into reply(reply_no, reply_content, board_no) values(2, '니가 뭔데!', 1);
insert into reply(reply_no, reply_content, board_no) values(3, '싫어요!', 1);
insert into reply(reply_no, reply_content, board_no) values(4, '미세먼지 장난아님!', 2);
insert into reply(reply_no, reply_content, board_no) values(5, '좋은데?', 2);
insert into reply(reply_no, reply_content, board_no) values(6, '갑자기?', 3);
insert into reply(reply_no, reply_content, board_no) values(7, '진짜 심심한가 보네!', 3);
commit;
select * from reply;

-- (Q) 게시글을 삭제하면 댓글도 지워지게 할 수 있는가?
-- (A) 외래키를 만들 때 약속해두면 가능하다! (on delete cascade)
delete board where board_no = 3;

-- (Q) 게시글을 삭제하면 댓글의 연결만 끊을 수 있는가?
-- (A) 외래키를 만들 때 약속해두면 가능하다! (on delete set null)
-- 주의 : 외래키 설정 컬럼이 not null이면 안된다
delete board where board_no = 3;
select * from reply;
select reply_no, reply_content, board_no from reply;
select reply_no, reply_content, nvl(board_no, 0) from reply;

--------------------------------------------------------------
-- 다대다 관계 : 중간에 연결테이블을 만들어서 1대다 관계 두 개로 분할
--------------------------------------------------------------
-- 예)  소비자(customer) <------- 구매(purchase) ------> 상품(item)
create table customer(
customer_no number primary key,
customer_name varchar2(30) not null
);
insert into customer values(1, '한효주');
insert into customer values(2, '이재훈');
insert into customer values(3, '한지민');

create table item(
item_no number primary key,
item_name varchar2(30) not null,
item_price number not null
);
insert into item values(11, '컴퓨터', 2000000);
insert into item values(12, '강남아파트', 2500000000);
insert into item values(13, '람보르기니', 1000000000);
commit;

-- 구매 테이블 : 구매번호(PK), 누가(FK), 무엇을(FK), 언제, 몇개
create table purchase(
purchase_no number primary key,
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete set null,
purchase_time date not null,
purchase_count number not null
);
-- 한효주가 컴퓨터를 1대 샀습니다
insert into purchase values(1, 1, 11, sysdate, 1);
-- 이재훈이 강남아파트를 2채 샀습니다
insert into purchase values(2, 2, 12, sysdate, 2);
-- 한효주가 람보르기니를 1대 샀습니다.
insert into purchase values(3, 1, 13, sysdate, 1);
-- 이재훈이 컴퓨터를 1대 샀습니다.
insert into purchase values(4, 2, 11, sysdate, 1);
commit;

-- 단순하게 구매(purchase)테이블을 조회하면 정보를 알아보기가 어렵다
-- 추가적으로 정보를 저장하려니 낭비가 너무 심하다
-- 해결방안 : 저장은 지금처럼 번호로 하는게 효율적이니 그대로 하고 볼 때만 테이블을 합쳐서 조회
select * from purchase;

-- 조인하여 출력
select 
    P.purchase_no, C.customer_name, P.purchase_time, P.purchase_count, P.customer_no
from
    -- purchase와 customer를 합치는데 purchase의 customer_no랑 customer의 customer_no가 서로 연결된 항목이야~
    purchase P inner join customer C on P.customer_no = C.customer_no;

-- purchase와 item을 합쳐서 상품 이름과 가격이 같이 나오도록 조회하는 구문을 생성
select
    P.purchase_no, P.customer_no, P.item_no, P.purchase_count, P.purchase_time, 
    I.item_name, I.item_price
from
    purchase P inner join item I on P.item_no = I.item_no;
    
-- 세개 다 합쳐서 출력
select 
    P.purchase_no, 
    C.customer_name,
    I.item_name, 
    I.item_price,
    P.purchase_time, 
    P.purchase_count, 
    I.item_price * P.purchase_count "total"
from
    purchase P 
        inner join customer C on P.customer_no = C.customer_no
        inner join item I on P.item_no = I.item_no;

--문제 : 다음 프로세스를 구현하세요
--
--좋아요 테이블을 만드세요(table love)
--다음 데이터를 저장하시고 조회해보세요
--
--- 한효주님이 컴퓨터 상품을 좋아요 합니다.
--- 이재훈님이 강남아파트를 좋아요 합니다.
--- 한효주님이 강남아파트를 좋아요 합니다.
--- 한지민님이 컴퓨터를 좋아요 합니다.
--- 한지민님이 람보르기니를 좋아요 합니다.
--
--조회할 때는 
--고객번호, 고객명, 상품번호 상품명, 좋아요 일시가 
--출력되도록 조인해서 출력하세요

-- 좋아요 테이블
drop table love;
create table love(
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete cascade,
when date default sysdate not null
);

insert into love(customer_no, item_no) values(1, 11);
insert into love(customer_no, item_no) values(2, 12);
insert into love(customer_no, item_no) values(1, 12);
insert into love(customer_no, item_no) values(3, 11);
insert into love(customer_no, item_no) values(3, 12);
insert into love(customer_no, item_no) values(3, 13);
commit;

-- 문제점 : 하나의 고객이 하나의 상품에 좋아요를 딱 한번만 할 수 있는데 그러한 제한이 없다
-- 해결책 : 복합키를 구성한다(고객번호와 상품번호를 묶어서 기본키로 설정)

-- [1] 테이블을 만들면서 복합키를 지정
drop table love;
create table love(
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete cascade,
when date default sysdate not null,
primary key(customer_no, item_no) -- 복합키 설정
);

-- [2] 테이블 만들고 나서 제약조건 추가
drop table love;
create table love(
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete cascade,
when date default sysdate not null
);
-- alter table love add constraint 별칭 primary key(항목);
alter table love add constraint love_pk primary key(customer_no, item_no);
-- 전체 좋아요 목록 출력
select 
    C.customer_no, C.customer_name, I.item_no, I.item_name, L.when
from
    love L
        inner join item I on L.item_no = I.item_no
        inner join customer C on L.customer_no = C.customer_no;
        
-- 한효주가 좋아요를 누른 상품의 정보를 출력
select
    I.item_no, I.item_name, I.item_price
from
    love L inner join item I on L.item_no = I.item_no
where
    L.customer_no = 1;
    
-- 상품별 좋아요 개수 출력
select item_no, count(*) from love group by item_no order by item_no;

select
    I.item_name, I.item_price, count(*) "개수"
from
    love L inner join item I on L.item_no = I.item_no
group by I.item_name, I.item_price
order by 개수 desc;

---------------------------------------------------------------------
-- JOIN : 테이블을 합쳐서 조회하는 기법
-- - 내부 조인(INNER JOIN) : 커플만 조회(매칭되는 컬럼만 조회)
-- - 외부 조인(OUTER JOIN) : 솔로도 조회(매칭되지 않아도 조회)
--      LEFT OUTER JOIN / RIGHT OUTER JOIN / FULL OUTER JOIN
---------------------------------------------------------------------

select * from customer;--1,2,3
select * from purchase;--1,2,1,2

-- customer를 기준삼아서 outer join
select * from customer C left outer join purchase P on C.customer_no = P.customer_no;

-- purchase를 기준삼아서 outer join : inner join과 차이가 없음
select * from customer C right outer join purchase P on C.customer_no = P.customer_no;

-- 모든 고객들의 이름과 첫 구매일과 마지막 구매일을 출력
-- select 이름, 첫구매일, 마지막구매일 from customer <- purchase group by 이름 order by 이름;
select 
    C.customer_name, min(P.purchase_time), max(P.purchase_time)
from customer C 
    left outer join purchase P on C.customer_no = P.customer_no
group by C.customer_name
order by C.customer_name;



select 
    I.item_name,
    I.item_price
from
    love L
    inner join Item I on L.item_no = I.item_no
where L.customer_no = 1;

---------------------------------------------------------------------------------
-- 분석함수(analystic function)
-- 각 행에 분석 결과를 추가하도록 구현(group by 의 반대)
---------------------------------------------------------------------------------

--[1] group 함수 : 데이터가 묶음 처리된다(각각의 행을 볼 수 없다)
select 
    gender, avg(javascore)
from person
group by gender;

--[2] 분석 함수 : 데이터를 조회하며 원하는 항목을 첨부할 수 있다.
-- over() 를 통해서 각각의 행에 결과를 첨부할 수 있도록 한다.
-- over() 내부에 원하는 기준을 작성하면 해당하는 기준에 맞게 알아서 구한다 
    -- partition by : 분류 설정
    -- order by : 순서 설정
select
    person_name, 
    gender,
--    avg(javascore) over() "평균"
    avg(javascore) over(partition by gender) "평균"
from person;

-- 순위 : rank , dense_rank
-- rank : 공동 등수가 발생하면 그 뒤의 등수들을 뒤로 밀어서 계산(1, 2, 2, 4, ..)
-- dense_rank : 공동 등수와 무관하게 1등부터 등수를 부여(1, 2, 2, 3, ...)
select
    person_name, javascore, dbscore,
    javascore + dbscore "총점",
    (javascore + dbscore)/2 "평균",
    rank() over(order by javascore desc) "자바등수",
    rank() over(order by dbscore desc) "DB등수",
    rank() over(order by javascore+dbscore desc) "총등수",
    rank() over(partition by gender order by javascore) "성별자바등수",
    rank() over(partition by gender order by dbscore) "성별DB등수",
    rank() over(partition by gender order by javascore+dbscore desc) "성별총등수"
from person
order by 총점 desc;

---------------------------------------------------------------------------
-- 자바 6등부터 10등까지 출력 (2/3 페이지)
---------------------------------------------------------------------------
-- 조회를 하면서 붙인 별칭은 조건에서 사용이 안됨(조건이 조회보다 먼저 해석됨)
-- 한 번에 불가능하기 때문에 서브쿼리를 통한 순차적인 실행을 해야함

-- Top Rank 쿼리
select * from (
    select
        P.*,
        rank() over(order by javascore desc) 등수
    from person P
)
-- where 등수 >= 5 and 등수 <= 10;--5이상 10이하
where 등수 between 5 and 10;--5부터 10까지

-- Top Rank 를 이용하여 총점 순으로 1,2,3등을 조회(ex : 금/은/동)

select * from (
    select 
        P.*, 
        javascore+dbscore "총점",
        dense_rank() over(order by javascore+dbscore desc) "순위"
    from person P
)
where 순위 between 1 and 3;

-------------------------------------------------------------
-- Top N Query : 원하는 개수만큼 분할하여 조회(ex : 페이징)
-------------------------------------------------------------
-- 1. 원하는 형식의 데이터를 조회한다.
select * from person order by javascore+dbscore desc;
-- 2. 1번 작업 결과에 행번호(rownum)를 추가한다.
-- rownum은 무슨일이 있어도 1번부터 부여되어야 함
-- rownum을 미리 부여해두고 나중에 조건으로 사용
select rownum rn, TMP.* from (
    select * from person order by javascore+dbscore desc
)TMP;
-- 3. 2번에서 부여한 rownum을 활용하여 원하는 구간을 조회한다
select * from (
    select rownum rn, TMP.* from (
        select * from person order by javascore+dbscore desc
    )TMP
) where rn between 1 and 5;

-- Top N Query를 사용하여 자바점수가 1등인 사람부터 5명 조회
-- 조회 -> rownum 부여 -> 조건으로 구분
select * from (
    select rownum rn, A.* from (
        select * from person order by javascore desc
    ) A
) where rn between 1 and 5;

-- Top N Query를 사용하여 DB점수가 6번째인 사람부터 10번째까지 조회
-- 조회 -> rownum 부여 -> 조건으로 구분
select * from (
    select rownum rn, TEST.* from (
        select * from person order by dbscore desc
    )TEST
) where rn between 6 and 10;

-- Top N Query를 사용하여 출석부에 작성된 명단 순서(이름 오름차순)대로 11번째부터 15번째까지 조회
-- 조회 -> rownum 부여 -> 조건으로 구분

select * from (
    select rownum rn, B.* from (
        select * from person order by person_name asc
    )B
) where rn between 11 and 15;

-----------------------------------------------------------------
-- 뷰(View) : 가상 테이블(논리 테이블), create view 권한이 필요함
-----------------------------------------------------------------
-- 여태까지 우리가 만들었던 구문은 난이도가 장난이 아니었다
-- 계속 똑같이 어려운 구문을 만들어서 쓸 것인가? 용도별로 저장해두고 편하게 호출?
-- 형식 : create [or replace] view 이름 as 구문;
-- or replace가 붙으면 존재하는 뷰가 덮어쓰기됨, 안붙으면 중복생성이 불가능

-- 1. person 테이블에서 "남자"만 조회
select * from person where gender = '남자';

-- 2. person 테이블에서 "여자"만 조회
select * from person where gender = '여자';

-- Q : 남자/여자만 조회하는 경우가 많으면? 매번 조건에 남자 여자를 붙여서 조회?
-- A : 남자와 여자 테이블을 따로 만들어 따로 보관하면 어떨까? (같이 사용하는 경우 처리 불가)
-- A : 남자와 여자를 조회하는 구문을 각각 뷰(View)로 만들어서 보관? (권한 필요 : create view)
create view male as select * from person where gender='남자';
create view female as select * from person where gender='여자';

select * from male;
select * from female;

-- 성적 top 3를 조회할 일이 아주 많다면! 뷰를 한 번 고려해보자
-- 1.조회구문을 만들고
-- 2.뷰를 생성하면서 as 뒤에 첨부하면 끝!
-- 3.뷰 이름으로 편하게 호출
create view top3 as
select * from(
    select 
        P.*, 
        javascore+dbscore "총점",
        rank() over(order by javascore+dbscore desc) "순위"
    from person P
) where "순위" between 1 and 3;

select * from top3;

-- 뷰를 만들때는 "범용성"과 "확장성"을 고려하여 만들어야 한다.
-- 한 가지만 되도록 구현하기보다는 데이터 편집이나 정렬 정도를 미리 해두는 게 좋다
create view toprank as
select * from(
    select 
        P.*, 
        javascore+dbscore "총점",
        rank() over(order by javascore+dbscore desc) "순위"
    from person P
);

select * from toprank where 순위 between 1 and 3;

-- pass라는 이름으로 자바시험과 DB시험을 통과한 사람들의 정보를 뷰로 저장
-- (통과라 함은 각과목 40이상, 평균 60이상을 말합니다)
create or replace view pass as
select * from person 
where javascore >= 40 and dbscore >= 40 and (javascore+dbscore)/2 >= 60;

select * from pass;

-- fail이라는 이름으로 자바시험과 DB시험을 통과하지 못한 사람들의 정보를 뷰로 저장
create or replace view fail as
select * from person
where javascore < 40 or dbscore < 40 or (javascore+dbscore)/2 < 60;

select * from fail;

-------------------------------------------------------------------
-- 인덱스(index) : 색인. 빠른 검색을 위해 항목에 설치하는 도구
-------------------------------------------------------------------
-- primary key는 기본적으로 인덱스가 부여되도록 되어 있다.
-- 다른 항목에 검색속도를 올리고 싶다면 어떻게 해야하는가?

-- Q) 둘 중에 누가 더 빠르고 뭘 써야할까?
-- A) person_no가 빠르다. Primary key이기 때문(INDEX가 자동 부여)
select * from person where person_no = 1;
select * from person where person_name = '김민준';

-- person_name으로도 조회가 빨라질 수 있도록 index 생성
create index idx_name on person(person_name);

select * from user_indexes;

-- index가 부여된 항목이 수시로 변경될 경우 index 자체의 성능이 느려진다.
-- 트리의 깊이가 4가 넘어가면 리빌딩을 권장(정기적으로 수행)
alter index idx_name rebuild;
select * from person;

drop index idx_name;

-- 참고 : 인덱스 트리의 깊이 파악하기
select 
    tablespace_name, table_name, index_name, blevel
from user_indexes
where blevel >= 4;

-- 집합연산 : 서로 다른 두 집합간의 연산 수행

-- 기반 데이터 추가
create table favorite(
name varchar2(6) not null,
color varchar2(6) not null
);
-- 철수 5개, 영희 5개
insert into favorite values('철수', '빨강');
insert into favorite values('철수', '파랑');
insert into favorite values('철수', '초록');
insert into favorite values('철수', '노랑');
insert into favorite values('철수', '보라');
insert into favorite values('영희', '검정');
insert into favorite values('영희', '보라');
insert into favorite values('영희', '노랑');
insert into favorite values('영희', '파랑');
insert into favorite values('영희', '분홍');
insert into favorite values('영수', '하늘');
insert into favorite values('영수', '분홍');
insert into favorite values('영수', '보라');
insert into favorite values('영수', '주황');
insert into favorite values('영수', '검정');
commit;

select * from favorite;

-- 합집합 : 철수와 영희 중 한명이라도 좋아하는 색상(union : 중복제거 / union all : 중복허용)
-- select distinct color from favorite where name = '철수' or name = '영희';

select color from favorite where name = '철수'
union all
--union
select color from favorite where name = '영희';

-- 교집합 : 철수와 영희 둘 다 좋아하는 색상 (intersect)
-- select color from favorite group by color having count(*) = 2;
select color from favorite where name = '철수'
intersect
select color from favorite where name = '영희';

-- 차집합 : 철수만 / 영희만 좋아하는 색상 (minus)
select color from favorite where name = '철수'
minus
select color from favorite where name = '영희';

select color from favorite where name = '영희'
minus
select color from favorite where name = '철수';

-- 철수만
select color from favorite where name = '철수'
minus
select color from favorite where name != '철수';

-- 시퀀스 : Primary key 생성기
-- rownum : 조회 결과에 붙이는 순서

-- 이름이 명확하면 이름.* 가 된다.
select person.* from person;
select A.* from (select * from person order by person_no desc) A;
-- 추가적으로 조회하고 싶은 항목이 있다면 무조건 이름.*을 사용해야 한다.

select person.*, javascore+dbscore from person;
-- person 테이블에서 다, 자바점수+DB점수 조회해라
select person.*, javascore+dbscore from person;
-- person 테이블에서 person 전체, 자바점수+DB점수 조회해라

-- person 테이블에 데이터 등록
-- 번호 : 시퀀스부여, 이름 : 자바왕, 자바점수:100, DB점수:99, 성별:여자, 등록일 : 현재시각
insert into person values(person_seq.nextval, '자바왕', 100, 99, '여자', sysdate);
rollback;

select * from person;

insert into person values(person_seq.nextval, '테'스'트', 100, 99, '여자', sysdate);

select person_name from person where dbscore=(select max(dbscore) from person) and rownum = 1;

insert into person values(person_seq.nextval, '테스트', '5', '99', '여자', sysdate);
rollback;

select gender, count(*) CNT from person group by gender;

select count(*) from person;
select count(*) from academy;
select count(*) from customer;
select count(*) from exam;
select count(*) from favorite;
select count(*) from item;
select count(*) from music;

select * from music;

select * from (
    select person.*, rank() over(order by javascore+dbscore desc) rank from person
) where rank between 11 and 15;

select * from (
    select rownum rn, TMP.* from (
        select * from person order by javascore+dbscore desc
    )TMP
) where rn between 11 and 15;