create table exam(
student_no varchar2(8),
name varchar2(51),
test varchar2(60),
subject1 number(3),
subject2 number(3),
subject3 number(3),
subject4 number(3),
subject5 number(3),
test_date date,
register_date date
);

insert into exam values('A0013452', '홍길동', '정보처리기사', 45, 50, 80, 80, 100, '2020-10-30', sysdate);
insert into exam values('A0013379', '전우치', '정보처리기사', 70, 60, 60, 60, 90, '2020-10-30', sysdate);
insert into exam values('A0013654', '장보고', '건축기사', 80, 60, 70, 20, 30, '2020-10-30', sysdate);
commit;

select * from exam;

select * from student;
insert into student values('파이리', 60);
commit;

create sequence test_seq;

-- 번호만 있는 테이블 생성
create table test(no number);

insert into test(no) values(test_seq.nextval);

select * from test;

--테이블 데이터 자르기(DDL) : 데이터를 지우는것이 아니라 테이블을 제목만 빼고 초기화시키는 것
truncate table test;

-- 시퀀스의 초기값을 지정하여 생성(1001부터 시작하게)
create sequence test2_seq start with 1001;

insert into test(no) values(test2_seq.nextval);

select * from user_sequences;

-- 1부터 5까지 회전하는 시퀀스(1,2,3,4,5,1,2,3,4,5,...)
drop sequence test3_seq;

create sequence test3_seq 
minvalue 1
maxvalue 5
increment by 1
start with 1
cycle
nocache;

truncate table test;
insert into test(no) values(test3_seq.nextval);

select * from test;

-- 캐시 설정을 한 시퀀스와 아닌 시퀀스의 차이
-- 시퀀스는 기본적으로 20의 캐시(여분) 크기를 가진다.(번호표를 한번 뽑을때 20개씩 뽑아놓는다고 생각)
-- 캐시설정을 한다는건 빨리 처리하기 위해 여유분을 설정해놓는 것임(번호표를 미리 뽑아놓는다고 생각하면됨)
create sequence test4_seq cache 20;
create sequence test5_seq nocache;

select * from user_sequences;

insert into test(no) values(test4_seq.nextval);
insert into test(no) values(test5_seq.nextval);

--변경 : alter sequence 이름 [옵션];
--삭제 : drop sequence 이름;

-- 문제
create table person(
serial_no number,
student_name varchar2(21),
score_java number(3),
score_db number(3),
gender char(6),
join_date date
);

create sequence person_seq;

insert into person values(person_seq.nextval, '김민준', 60, 70, '남자', '2020-04-01');
insert into person values(person_seq.nextval, '박서연', 80, 95, '여자', '2020-05-05');
insert into person values(person_seq.nextval, '이서준', 50, 60, '남자', '2020-06-12');
insert into person values(person_seq.nextval, '최서윤', 80, 55, '여자', '2020-08-21');
insert into person values(person_seq.nextval, '한예준', 75, 65, '남자', '2020-10-05');
insert into person values(person_seq.nextval, '송시우', 72, 70, '남자', to_date('2020-11-01', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '오하윤', 90, 80, '여자', to_date('2019-01-07', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '한지민', 95, 75, '여자', to_date('2019-01-12', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '이채원', 99, 72, '여자', to_date('2019-02-21', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '김선우', 66, 70, '남자', to_date('2019-02-28', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '양수아', 62, 50, '여자', to_date('2019-04-05', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '홍수빈', 50, 75, '여자', to_date('2019-05-01', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '황민재', 76, 71, '남자', to_date('2019-07-07', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '정현준', 80, 90, '남자', to_date('2020-11-03', 'YYYY-MM-DD'));
insert into person values(person_seq.nextval, '임소율', 75, 68, '여자', to_date('2020-07-14', 'YYYY-MM-DD'));
commit;

-- 1. 전체 조회 : 와일드카드(*)를 사용
-- select(조회) *(전부) from person(person 테이블에서)
select * from person;

-- 2. 이름만 조회
select student_name from person;

-- 3. 성별만 조회
select gender from person;

-- 4. 이름과 성별을 같이 조회
select student_name, gender from person;

-- 조건 : 필터링(filtering)을 통해 원하는 데이터만 추출
-- 형식 : select 항목 from 테이블 where 조건식

-- 5. 자바점수가 60점인 사람을 조회(주의 : 같음을 = 하나로 표현, 자바랑 다름)
select student_name from person where score_java = 60;
select student_name, score_java from person where score_java = 60;
select * from person where score_java = 60;

-- 6. DB점수가 70점 미만인 사람을 조회
select * from person where score_db < 70;
-- 7. 자바점수와 DB점수의 합계가 150점 이하인 사람을 조회
select * from person where score_java + score_db <= 150;

select student_name 이름, score_java + score_db 총점 from person 
where score_java + score_db <= 150;
-- ㄴ 실행순서는 "from person" -> "score_java + score_db <= 150" -> "student_name 이름, score_java + score_db 총점"
--    순으로 실행됨 그래서 총점이라는 별칭을 where 뒤에 못쓰는거임 컴퓨터가 못알아먹으니깐

-- 8. 이름과 평균점수를 구하여 출력 
-- 주의 : 오라클 나눗셈은 정수형이 없다.
-- 주의 : 오라클은 별칭에 띄어쓰기 하고 싶을 때 ""로 감싼다.
select student_name 이름, (score_java+score_db)/2 "평균 점수" from person;

-- 9. 이름과 평균점수를 출력하는데 평균 60점 이상인 학생만 출력
select student_name 이름, (score_java+score_db)/2 "평균 점수" from person 
where (score_java+score_db)/2 >= 60;

-- 10. 자바점수가 70점 이상 80점 이하인 사람을 조회(구간 조회)
-- 주의 : 오라클에서는 &&는 입력기호, ||는 문자열 덧셈기호(and / or 아님)
select * from person
where score_java >= 70 and score_java <= 80;

-- 11. NCS 기준을 적용시켜서 합격한 학생들의 정보를 출력
-- 각 과목 40점이상이면서 평균 60점 이상
select * from person 
where 
    score_java >= 40 
    and score_db >= 40 
    and (score_java+score_db)/2 >= 60;
    
-- 문자열 조건 : 자바는 문자열을 equals로 비교하지만 데이터베이스는 그런거 없다.

-- 12. 성별이 "여자"인 사람을 조회
select * from person where gender = '여자';
select * from person where gender = '남자';
select * from person where gender != '여자';

-- 문자열 유사 검색
-- 1) LIKE 검색 : LIKE 키워드와 문자열 내부의 %를 이용하여 특정 글자 유무 파악
-- %는 해당하는 위치에 글자가 있어도 되고 없어도 된다는 의미. ex) '김%' = 김00, '%윤' = 00윤
-- 2) INSTR 명령 : INSTR 명령은 자바의 INDEXOF와 같은 명령. 일치하는 문자의 위치를 반환
-- 오라클은 문자열이 1번부터 시작하므로 검색했을 때 결과가 0보다 크면 존재한다고 본다.
-- LIKE, INSTR 뭐가 더 좋은가? -> 상황에 따라 다르다.
-- 시작검사를 할 때는 LIKE가 빠름
-- 나머지는 INSTR이 빠름   

-- 13. "김"씨 성을 가진 사람을 조회
select * from person where student_name like '김%';
-- 14. "윤"으로 끝나는 이름을 가진 사람을 조회
select * from person where student_name like '%윤';
-- 15. "민"이 포함된 이름을 가진 사람을 조회
select * from person where student_name like '%민%';
select * from person where instr(student_name, '민') > 0;

-- 날짜 조건
-- 숫자처럼 계산이 가능 / 문자열처럼 유사검색도 가능 / 날짜 전용 명령도 존재

-- 16. 모든 사람들의 이름과 가입년도를 출력
select student_name 이름, extract(year from join_date) 가입년도 from person; 
select student_name 이름, extract(month from join_date) 가입월 from person;

-- 17. 작년에 가입한 사람들의 이름과 점수 평균을 출력
select student_name 이름, (score_java+score_db)/2 평균, join_date 가입날짜 from person 
where extract(year from join_Date) = extract(year from sysdate)-1;
-- 올해
select student_name 이름, (score_java+score_db)/2 평균, join_date 가입날짜 from person 
where extract(year from join_Date) = extract(year from sysdate);

-- 18. 여름(6,7,8월)에 가입한 사람들의 이름과 성별을 출력
select student_name 이름, gender 성별, extract(month from join_date) 가입월 from person 
where 
    extract(month from join_date) >= 6 
    and extract(month from join_date) <=8;

-- between은 ~이상 ~이하를 처리할 수 있다(구간 조회)
select student_name, gender from person
where extract(month from join_date) between 6 and 8;

-- 정렬 : 데이터를 순서대로 나열하는 것
-- 형식 : ORDER BY 항목 ASC/DESC, ...

-- 1. 모든 사람을 번호순으로 정렬(serial_no asc)
select * from person order by serial_no asc;
select * from person order by serial_no; -- 안쓰면 asc로 처리
select * from person order by serial_no desc;

-- 2. 모든 사람을 자바 성적순으로 출력
select * from person order by score_java desc;
-- extend) 모든 남자들을 자바 성적순으로 출력(조건+정렬)
select * from person where gender ='남자' order by score_java desc;

-- 3. 모든 사람을 총점순으로 출력
select * from person order by score_java+score_db desc;
-- 총점을 보이도록 조회하는법 person.*로 해주고 뒤에 score_java+score_db 별칭 작성해야함
select person.*, score_java+score_db 총점 from person
order by score_java+score_db desc;

-- 4. 모든 사람을 최근 가입한 순으로 출력
select * from person order by join_date desc;

-- 1. 
select person.*, score_java+score_db 총점 from person order by gender asc, score_java+score_db desc;

-- 2.
select student_name 이름, score_java "자바 점수" from person where score_java = (select max(score_java) from person);


--------------------------------- 3일차 ------------------------------    
-- 2번 다른 방법 풀이
select * from (
    select * from person order by score_java desc
) where rownum = 1; -- 이렇게 괄호안에 있는 걸 서브쿼리라고 함. 밖이 메인쿼리

-- 오라클 내장 함수(Function) : 오라클이 제공하는 기본 연산 기능
-- 듀얼 테이블 : 임시로 결과를 저장할 수 있는 테이블
select 1234+5678 from dual;

-- upper : 모든 글자를 대문자로 변환
select upper('Hello') "결과" from dual;

-- lower : 모든 글자를 소문자로 변환
select lower('Hello') "결과" from dual;

-- initcap : 첫 글자만 대문자로 변환
select initcap('hello oracle') "결과" from dual;

-- substr : 문자열 추출(자르기)
-- 주의! : 오라클은 순서가 1부터 시작

-- ABCDEFG를 3번째부터 볼 수 있도록 자른다!
-- cf) 프로그래밍에서는 1부터 5까지라고 하지않고 1부터 5개라고 한다.
select substr('ABCDEFG', 3) "결과" from dual;

--ABCDEFG를 3번째부터 2개만 볼 수 있도록 자른다!
select substr('ABCDEFG', 3, 2) "결과" from dual;

-- replace : 문자열 교체(치환)
select replace('이런 신발끈 개나리같은 수박씨야!!!', '신발끈', '***') from dual;
select regexp_replace('이런 신발끈 개나리같은 수박씨야!!!', '신발끈|개나리|수박씨', '***') from dual;

-- person의 데이터 중 이름을 성만 놔두고 *로 바꿔서 출력
-- 1. substr로 첫글자만 잘라낸다.
-- 2. rpad를 이용해서 *을 2글자 채운다.

select substr(student_name, 1, 1) from person;
-- ||는 문자열 더하기
select substr(student_name, 1, 1)||'**' from person;

-- cf) 한 줄 잘라내기 단축키 : ctrl+x

-- 집계 함수 : 최대, 최소, 합계, 평균, 개수

-- max : 최댓값
select max(score_java) from person;
select max(student_name) from person;
select max(join_date) from person;

-- min : 최소값
select min(score_java) from person;

-- sum : 합계
select sum(score_java) from person;

-- avg : 평균
select avg(score_java) from person;

-- count : 개수
select count(serial_no) from person; -- 번호가 몇개있나요?
select count(*) from person; -- 데이터가 몇개있나요?

-- 점검 문제
-- 1. 작년에 등록한 사람 수를 구하여 출력
select count(*) "사람 수" from person 
where extract(year from join_date) = extract(year from sysdate)-1;

-- 2. 올해 가장 먼저 등록한 사람의 가입일
select * from person where join_date = (
    select min(join_date) from person 
     where extract(year from join_date) = extract(year from sysdate)
);

-- 3. 작년에 가장 나중에 등록한 사람의 모든 정보
select * from person where join_date = (
    select max(join_date) "가입일" from person 
        where extract(year from join_date) = extract(year from sysdate)-1
);

-- 그룹 조회(GROUP BY) : 성별, 연도
-- 그룹 조회는 집계 함수를 이용하여 그룹별로 집계한 값을 확인하는 것이 목표!

select * from person;

-- 1. 성별로 조회
select gender from person;
-- 2. 그룹 설정
select distinct gender from person; -- 중복 제거
select gender from person group by gender; -- 그룹 설정 : 각종 항목을 추가할 수 있음

-- 3. 항목 추가
-- 주의! : gender로 묶었을 때는 항목 중에서는 gender만 출력 가능
select gender, count(*) from person group by gender;
select gender, count(*), max(score_java) from person group by gender;
select gender, avg(javascore), avg(dbscore) from person group by gender;

-- 문제 : 연도별로 등록한 회원들의 인원수를 구하여 출력
select 
    extract(year from regist_date) "연도", count(*) 
from person 
group by extract(year from regist_date)
order by extract(year from regist_date) asc;

-- 바로 위에 문제 서브쿼리로 간단하게 풀기 -> 서브쿼리문 먼저 만들어준거임 그럼 별칭 쓰기 가능
select 연도, count(*) from (
    select person.*, extract(year from regist_date) "연도" from person
)
group by 연도
order by 연도;

-- 문제 : 성씨별로 인원수, 전체평균 조회 후 가나다순 정렬 후 출력
select
    substr(student_name, 1, 1) || '씨', count(*), avg((score_java+score_db)/2)
from person
group by substr(student_name, 1, 1)
order by substr(student_name, 1, 1) desc;

-- 더 나은 풀이(복습 다시 하기 제대로 이해 못한듯)
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
-- 그룹조건 : 그룹이 생성되는 조건(where와는 다름) -> having
-- 그룹조건은 반드시 그룹 키워드 뒤에 나와야 한다.
-- 일반적으로 그룹 이후에 살펴볼 집계함수를 기준으로 조건을 설정
select gender, count(*) from person group by gender having count(*) > 7;

---------------------------------------------------------

-- 수정(update) : 데이터를 고쳐서 원하는 상태로 변경하는 것
-- select은 조회라 commit안함 근데 수정은 commit해야함
-- 형식 : update 테이블이름 set 수정구문 [조건];
-- 주의! : 모든 항목을 수정하는 경우는 거의 없음(조건은 반강제)

-- 1. 모든 사람의 자바점수를 60점으로 변경
update person set score_java = 60;
select * from person;
rollback;  -- 위에 60점으로 다 바꾼거 취소~~!

-- 2. 1번 학생의 자바점수를 65점으로 변경
update person set score_java = 65 where serial_no = 1;
commit;
-- 3. '한'씨 성을 가진 학생의 DB점수를 5점 증가하도록 변경
-- 주의 : 오라클 sql에는 +=, -= 와 같은 복합연산이 없다.
-- like와 substr 둘 다 푸는 거 가능
update person set score_db = score_db + 5 where student_name like '한%';
update person set score_db = score_db + 5 where substr(student_name, 1, 1) = '한';
-- 4. 올해 등록한 학생들의 점수를 10% 감점하도록 변경
update person 
set score_java = score_java*0.9, score_db = score_db*0.9
where extract(year from join_date) = extract(year from sysdate);


-----------------------------------------------------------
-- 삭제(DELETE) : 존재하는 데이터를 제거하는 것
------------------------------------------------------------
-- 형식 : delete [from] 테이블이름 [조건];

-- 1. 자바점수가 40점 미만인 학생을 삭제
delete person where score_java < 40; -- 자바 점수가 40점 미만인 사람은 없네

-- 2. DB점수가 40점 미만인 학생을 삭제
delete person where score_db < 40; -- db점수도 40점 미만인 사람이 없네

-- 3. 평균이 60점 미만인 학생을 삭제
delete person where (score_java+score_db) / 2 < 60;
select * from person; -- 3번과 11번 데이터 사라짐

-- 4. 일반적인 삭제는 "번호"를 이용해서 1개만 지우는 것
delete person where serial_no = 1;
rollback;


------------------------------------------- 
--<4일차>--


-- 날짜와 문자열에 대한 명령
select '2020-11-18' from dual;
-- YYYY-MM-DD  =  오라클 기본 형태(dd/mon/yy)
-- 문자열 '2020-11-18' -> to_date      날짜
--                    <-to_char
select to_date('2020-11-18', 'YYYY-MM-DD') from dual;       -- 많이 쓰임
select to_date('2020-11-18 16:19:20', 'YYYY-MM-DD HH24:MI:SS') from dual;   -- 많이 쓰임
select to_date('2020년 11월 18일', 'YYYY"년" MM"월" DD"일"') from dual;

-- 날짜 설정할 때 현재는 sysdate, 지정해줘야 할 때는 to_date() 사용

select join_date from person;
select to_char(join_date, 'YYYY-MM-DD') from person;
select to_char(join_date, 'YY-MM-DD') from person;
select to_char(join_date, 'YYYY-MM-DD HH24:MI:SS') from person;  -- 시간을 지정안해줘서 00:00:00로 나옴
select to_char(join_date, 'HH24:MI') from person; -- ex)중고나라 게시글 당일에 올린거는 시간만 나옴
select to_char(join_date, 'YYYY.MM.DD.') from person;  -- 네이버 표시형식

-- 2020년 11월 18일 형태로 출력
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') from dual; 
select to_char(join_date, 'YYYY"년" MM"월" DD"일"') from person; 

----------------------------------------------
-- 경우에 따라 다른 처리를 수행하는 명령(if~elseif~...)

-- DECODE : switch~case처럼 값을 기준에 따라 반환하는 명령
-- DECODE 형식 : DECODE(데이터, case1, value1, case2, value2, ..., default) cf)default는 else로 처리할 값이라고 보면 됨

-- gender가 남자면 M, 여자면 F로 출력
select person_name, gender from person;
select person_name, decode(gender, '남자', 'M', '여자', 'F', '?') "성별" from person;

-- person에 들어있는 데이터를 출력하는데 
-- 2020년 데이터는 HH24:MM 형태로 2019년 데이터는 YYYY-MM-DD 형태로 출력

select 
    student_name, 
    decode(
        extract(year from join_date)
        , 2020, to_char(join_date, 'HH24:MI')
        , 2019, to_char(join_date, 'YYYY-MM-DD'), '?'
    ) "가입일" 
from person;

-- DECODE가 길어지면 매우 힘들어진다. 해결은 어떻게?? -> CASE 구문
-- 조금 더 복잡한 처리에 활용하기가 쉽다.
-- CASE 값 
--      WHEN 비교값1 THEN 변환값1
--      WHEN 비교값2 THEN 변환값2
--          ...
--      ELSE 기타변환값
-- END
select 
    student_name,
    case extract(year from join_date)
        when 2020 then to_char(join_date, 'HH24:MI')
        when 2019 then to_char(join_date, 'YYYY-MM-DD')
        else to_char(join_date, 'YYYY-MM-DD HH24:MI:SS')
    end 가입일
from person;

-- 네이버 게시글 출력 구문처럼 오늘이면 시간, 아니면 날짜 출력
select
    student_name,
    case to_char(join_date, 'YYYY-MM-DD') -- 가입일을 따져봐서
        when to_char(sysdate, 'YYYY-MM-DD') -- 오늘이랑 날짜가 같으면
            then to_char(join_date, 'HH24:MI') -- 시간을 조회하고
        else
            to_char(join_date, 'YYYY.MM.DD.') -- 날짜를 조회하세요
    end 가입일 -- 끝!(가입일이라고 별칭을 붙여라)
from person;


----------------------------------------------------------
-- 테이블 제약조건(table constraints)
-- 목표 : 안전한 데이터(내가 원하는 데이터)만 저장할 수 있도록 조건 설정
-------------------------------------------------

-- 문제가 되는 상황
create table test1(
emp_no number, --사원번호
emp_name varchar(30), --사원명
dept varchar2(30), --부서명
salary number, --급여
position varchar2(30), --직급
enter date --입사일
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
emp_no number primary key, --대표항목(필수, 구분) cf) not null 과 unique 위치 바껴도 상관x
emp_name varchar2(30) not null, --필수
dept varchar2(30) check(dept in ('개발','영업','기획')),
salary number check(salary >= 0), --원하는 조건 설정
position varchar2(30) default '프로' not null check(position in('오너', '프로')), --필수
enter date default sysdate not null  --필수
);

--상황 1 해결
insert into test2 values(null, null, null, null, null, null); 

--상황 2 해결 : 두번은 안들어간다
insert into test2 values(
1, '홍길동', '경영지원팀', -2000000, '사장', to_date('2010-01-01', 'YYYY-MM-DD'));

--상황 3 해결
insert into test2 values(
50, '코딩왕', '개발', 5000000, '프로', sysdate);
insert into test2 values(
51, '피구왕', '홍보', 5000000, '프로', sysdate
); 
--무슨 제약 때문에 안들어가는지 궁금하면 kh -> 테이블 -> TEST2 눌러서 "제약 조건" 보면 됨

-- 기본값 설정 : 직접 설정하지 않고 해당 칸을 제외하고 추가하면 자동 적용
insert into test2(emp_no, emp_name, dept, salary, position)
values(52, '탁구왕', '영업', 2000000, '프로');
select * from test2;

insert into test2(emp_no, emp_name, dept, salary)
values(52, '탁구왕', '영업', 2000000);


-----------------------------------------------------------------
-- NULL 검사
--------------------------------------------------------------
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
select * from people where email = 'null'; --안나옴
select * from people where email = null;   --안나옴
select * from people where email ='';   --안나옴
select * from people where email is null; -- 정답
-- 상황 2 : 이메일이 있는 사람만 조회
select * from people where email is not null;

--cf)오라클은 문자열 숫자 - 숫자 알아서 처리해줌
select '2000' - 1990 from dual;

--cf) AS는 별칭 부여하는거랑 같음 
--ex) select count(*) AS 사원수 from emp;


--floor : 버림
--round : 반올림
--ceil : 올림

------------------------------------------------------------ 까지 

-- 외래키 : 테이블 제약조건 중 하나
-- 서로 다른 테이블 간의 상하(참조) 관계를 설정하는 제약조건. 1:N 관계를 구현할 수 있다.
---------------------------------------------------------------
-- 특징1 : 부모테이블에 없는값 연결 금지
-- 특징2 : 연결된 값이 있을 경우 데이터 및 테이블 삭제 금지

-- 학원 테이블
drop table academy; -- 외래키가 연결되어 있으면 학원테이블 안지워짐
create table academy(
academy_no number primary key,
academy_name varchar2(30) not null
);
-- 수강생 테이블 : 학원 번호를 반드시 알아야 한다!(소속되어 있으니 값을 알아야 한다.)
drop table junior;
create table junior(
junior_no number primary key,
junior_name varchar2(30) not null,
academy_no references academy(academy_no) -- academy테이블에 academy_no랑 똑같이 할게요! / 앞에 academy_no 이름쓴건 달라도 상관x   
);
-- 학원 등록
insert into academy values(1, 'kh강남점');
insert into academy values(2, 'kh종로점');
commit;
-- 학생 등록(5명)
insert into junior values(101, '피카츄', 1);
insert into junior values(102, '파이리', 1);
insert into junior values(103, '꼬부기', 1);
insert into junior values(104, '홍길동', 5); -- 안들어감. 있는거에만 연결시킬려고 외래키 만드는거임
insert into junior values(105, '임꺽정', 5);
commit;
select * from junior;

-- 게시글 테이블
drop table board;
create table board(
board_no number primary key,
board_title varchar2(200) not null,
board_content varchar2(4000) 
);

-- 댓글 테이블
drop table reply;
create table reply(
reply_no number primary key,
reply_content varchar(4000) not null,
--board_no references board(board_no) on delete cascade --외래키 설정, 연결된 게시글이 삭제되면 나도 삭제!
board_no references board(board_no) on delete set null --연결된 게시글이 사라지면 이 자리를 null로 설정.
);
---------- 게시글 등록
insert into board values(1, '공지사항', '악플 자제하세요!');
insert into board values(2, '오늘날씨', '아주 안좋네요');
insert into board values(3, '심심한데', '공부나 할까요?');
commit;

select * from board order by board_no desc;

--------  댓글 등록
insert into reply values(1, '네!', 1);
insert into reply values(2, '니가 뭔데!', 1);
insert into reply values(3, '싫어욧!', 1);
insert into reply values(4, '미세먼지 장난아님!', 2);
insert into reply values(5, '좋은데?', 2);
insert into reply values(6, '갑자기?', 3);
insert into reply values(7, '진짜 심심한가 보구나', 3);
commit;
select * from reply order by reply_no desc; -- 최신순으로 조회

--(Q) 게시글을 삭제하면 댓글도 지워지게 할 수 있는가?
--(A) 외래키를 만들 때 약속해두면 가능하다! (on delete cascade)
delete board where board_no = 3;

--(Q) 게시글을 삭제하면 댓글의 연결만 끊을 수 있는가?
--(A) 외래키를 만들 때 약속해두면 가능하다! (on delete set null)
-- 주의 : 외래키 설정 컬럼이 not null이면 안된다. -> 지우면 null로 되게 해놓고 not null로 설정하는게 말이안됨
delete board where board_no = 3;

select reply_no, reply_content, nvl(board_no, 0) from reply; -- null을 0으로 대체. "삭제된 댓글입니다." 이런거는 프로그래밍에서 구현

--------------------------------------------------------------------------------
-- 다대다 관계 : 중간에 연결테이블을 만들어서 1대다 관계 두 개로 분할
---------------------------------------------------------------------
-- 예) 소비자(customer) <------- 구매(purchase) --------> 상품(item)
drop table customer;
create table customer(
customer_no number primary key,
customer_name varchar2(30) not null,
customer_gender char(3) not null
);
insert into customer values(1, '한효주', '여');
insert into customer values(2, '이재훈', '남');
insert into customer values(3, '한지민', '여');

create table item(
item_no number primary key,
item_name varchar2(30) not null,
item_price number not null
);
insert into item values(11, '컴퓨터', 2000000);
insert into item values(12, '강남아파트', 2500000000);
insert into item values(13, '람보르기니', 1000000000);
commit;

-- 구매 테이블 : 구매번호(PK-기본키), 누가(FK-외래키), 무엇을(FK), 언제, 몇개
drop table purchase;
create table purchase(
purchase_no number primary key,
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete set null,
purchase_time date not null,
purchase_count number not null
);
-- 한효주가 컴퓨터를 1대 샀습니다.
insert into purchase values(1, 1, 11, sysdate, 1);
-- 이재훈이 강남아파트를 2채 샀습니다.
insert into purchase values(2, 2, 12, sysdate, 2);
-- 한효주가 람보르기니를 1대 샀습니다.
insert into purchase values(3, 1, 13, sysdate, 1);
-- 이재훈이 컴퓨터를 1대 샀습니다.
insert into purchase values(4, 2, 11, sysdate, 1);
commit;

-- 단순하게 구매(purchase) 테이블을 조회하면 정보를 알아보기가 어렵다.
-- 추가적으로 정보를 저장하려니 낭비가 너무 심하다.
-- 해결방안 : 저장은 지금처럼 번호로 하는게 효율적이니 그대로 하고 볼 때만 테이블을 합쳐서 조회
select * from purchase;

-- 조인하여 출력. join에서는 전체 출력 웬만하면 피해라(오류 가능성)
select 
    purchase_no, customer_name, purchase_time, purchase_count
from
    -- purchase와 customer를 합치는데 purchase의 customer_no랑 customer의 customer_no가 서로 연결된 항목이야~
    purchase inner join customer on purchase.customer_no = customer.customer_no; --on은 join 조건

-- 테이블에 별칭 부여가능    
select 
    p.purchase_no, c.customer_name, c.customer_gender, p.purchase_time, p.purchase_count -- 어느 테이블에서 가져왔는지 찍어주면 나중에 유지/보수 용이
from
    purchase p inner join customer c on p.customer_no = c.customer_no;
    
    
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
    
from Purchase P 
    inner join customer C on P.customer_no = C.customer_no
    inner join item I on P.item_no = I.item_no
    order by purchase_no;
    
 -----------
drop table love;
create table love(
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete cascade,
when date default sysdate not null,
primary key(customer_no, item_no) -- 기본키를 2개이상 묶는 게 복합키. 복합키로 한명이 같은상품에 좋아요 1번만 누를 수 있게. ex) 학년, 반, 번호 3개로 복합키 구성
);

insert into love(customer_no, item_no) values(1, 11);
insert into love(customer_no, item_no) values(2, 12);
insert into love(customer_no, item_no) values(1, 12);
insert into love(customer_no, item_no) values(3, 11);
insert into love(customer_no, item_no) values(3, 13);
commit;
select * from love;
-- 문제점 : 하나의 고객이 하나의 상품에 좋아요를 딱 한번만 할 수 있는데 그러한 제한이 없다.
-- 해결책 : 복합키를 구성한다(고객번호와 상품번호를 묶어서 기본키로 설정)

-- [1] 테이블을 만들면서 복합키를 지정

-- [2] 테이블 만들고 나서 제약조건 추가
drop table love;
create table love(
customer_no references customer(customer_no) on delete set null,
item_no references item(item_no) on delete cascade,
when date default sysdate not null
);
--alter table love add constraint 별칭 primary key(항목);
alter table love add constraint love_pk  primary key(customer_no, item_no); --love_pk는 별칭

-- 전체 좋아요 목록 출력 
select 
    C.customer_no 고객번호, 
    C.customer_name 고객명, 
    I.item_no 상품번호, 
    I.item_name 상품명, 
    L.when "좋아요 일시"  
from love L
        inner join customer C on L.customer_no = C.customer_no
        inner join item I on L.item_no = I.item_no; 
        

-- 한효주가 좋아요를 누른 상품의 정보를 출력
select 
    I.item_no, I.item_name, I.item_price
from 
    love L inner join item I on L.item_no = I.item_no
where 
    L.customer_no = 1;
    
    
-- 상품별 좋아요 개수 출력
select
    I.item_name, I.item_price, count(*) "개수"
from
    Love L inner join item I on L.item_no = I.item_no
group by I.item_name,I.item_price
order by 개수 desc ;

--------------------------------------------------------------
-- JOIN : 테이블을 합쳐서 조회하는 기법
-- - 내부 조인(INNER JOIN) : 커플만 조회(매칭되는 컬럼만 조회). 방향 상관 없음
-- - 외부 조인(OUTER JOIN) : 솔로도 조회(매칭되지 않아도 조회). 그냥 OUTER JOIN은 없음 무조건 방향이 있어야함.
--            LEFT OUTER JOIN / RIGHT OUTER JOIN / FULL OUTER JOIN
------------------------------------------------------------------------

select * from customer; --1, 2, 3
select * from purchase; --1, 2, 1, 2

-- customer를 기준삼아서 outer join
select * from customer C left outer join purchase P on C.customer_no = P.Customer_no;

-- purchase를 기준삼아서 outer join
select * from customer C right outer join purchase P on C.customer_no = P.customer_no;

-- 모든 고객들의 이름과 첫 구매일과 마지막 구매일을 출력
select
    C.customer_name, min(P.purchase_time), max(P.purchase_time)
from customer C 
    left outer join purchase P on C.customer_no = P.customer_no
group by C.customer_name
order by C.customer_name;


--------------------------- 7일차-----------------------------------------

---- 분석함수(analystic function)
-- 각 행에 분석 결과를 추가하도록 구현(group by 의 반대)
-----------------------------------------------------------
-- [1] group 함수 : 데이터가 묶음 처리된다(각각의 행을 볼 수 없다. 그룹by로 된거만 볼 수 있다.)
select
    gender, avg(javascore)
from person
group by gender;


--[2] 분석 함수 : 데이터를 조회하며 원하는 항목을 첨부할 수 있다.
-- over() 를 통해서 각각의 행에 결과를 첨부할 수 있도록 한다.
-- over() 내부에 원하는 기준을 작성하면 해당하는 기준에 맞게 알아서 구한다.
    -- partition by : 분류 설정
    -- order by : 순서 설정 
    
select
    person_name,
    gender,
    avg(javascore) over(partition by gender) "평균"
from person;


-- 순위 : rank, dense_rank
-- rank : 공동 등수가 발생하면 그 뒤의 등수들을 뒤로 밀어서 계산(1, 2, 2, 4, ..)
-- dense_rank : 공동 등수와 무관하게 1등부터 등수를 부여(1, 2, 2, 3, ...)
select 
    person_name, javascore, dbscore,
    javascore + dbscore "총점",
    (javascore+dbscore)/2 "평균",
    rank() over(order by javascore desc) "자바등수",
    rank() over(order by dbscore desc) "DB등수",
    rank() over(order by javascore+dbscore desc) "총등수",
    rank() over(partition by gender order by javascore desc) "성별자바등수",  
    rank() over(partition by gender order by dbscore desc) "성별DB등수",
    rank() over(partition by gender order by javascore+dbscore desc) "성별총등수"
from
    person;
    
-- 자바 6등부터 10등까지 출력(이게 top rank 방식)
select * from (
    select 
        P.*,
        rank() over(order by javascore desc) "자바등수"
    from person P
)
where "자바등수" between 1 and 5;

--Top Rank를 이용하여 총점 순으로 1, 2, 3등을 조회(ex : 금/은/동) --시험문제나옴
select * from (
    select 
        P.*, 
        javascore+dbscore "총점",
        dense_rank() over(order by javascore+dbscore desc) "순위"
    from person P
)
where 순위 between 1 and 3;


-- Top N Query : 원하는 개수만큼 분할하여 조회(ex : 페이징)  --시험문제나옴
-- Top N Query 진짜 많이 씀 완전 중요. 페이지 만들 때 다 이거. ex) 페이지 1, 2, 3 각 페이지당 게시글 15개씩 끊어서 보여주도록 만들 때 쓰임
-- 1. 원하는 형식의 데이터를 조회한다.
select * from person order by javascore+dbscore desc;
-- 2. 1번 작업 결과에 행번호(rownum)를 추가한다.
-- rownum은 무슨일이 있어도 1번부터 부여되어야 함
-- rownum을 미리 부여해두고 나중에 조건으로 사용
-- TMP는 그냥 별칭이라 의미 없음. 내가 정해도 됨.
select rownum, TMP.* from (
    select * from person order by javascore+dbscore desc
) TMP;

-- 3. 2번에서 부여한 rownum을 활용하여 원하는 구간을 조회한다.
select * from (
    select rownum rn, TMP.* from (
        select * from person order by javascore+dbscore desc
        )TMP
) where rn between 1 and 5;       
 

-- Top N Query를 사용하여 자바점수가 1등인 사람부터 5명 조회
select * from (
    select rownum rn, TMP.* from (
        select * from person order by javascore desc
    )TMP
) where rn between 1 and 5;


-- Top N Query를 사용하여 DB점수가 6번째인 사람부터 10번째까지 조회
select * from (
    select rownum rn, TMP.* from (
        select * from person order by dbscore desc
    ) TMP
) where rn between 6 and 10;

-- Top N Query를 사용하여 출석부에 작성된 명단 순서(이름 오름차순)대로 11번째부터 15번째까지 조회
select * from (
    select rownum rn, TMP.* from(
        select person.*, javascore+dbscore "총점" from person order by person_name
    )TMP
) where rn between 11 and 15;

--------------------------------------------------------------까지 7일차
--8일차

-- 뷰(view) : 가상 테이블(논리 테이블), create view 권한이 필요함
-- grant create view to kh; -> system에서 kh계정에게 create view 주는 것
-- 형식 : create [or replace] view 이름 as 구문;
-- or replace가 붙으면 존재하는 뷰가 덮어쓰기됨. 안붙으면 중복생성이 불가능

-- 여태까지 우리가 만들었던 구문은 난이도가 장난이 아니었다.
-- 계속 똑같이 어려운 구문을 만들어서 쓸 것인가? 용도별로 저장해두고 편하게 호출?

-- 1. person 테이블에서 "남자"만 조회
select * from person where gender = '남자';

-- 2. person 테이블에서 "여자"만 조회
select * from person where gender = '여자';

-- Q : 남자/여자만 조회하는 경우가 많으면? 매번 조건에 남자, 여자를 붙여서 조회?
-- A : 남자와 여자 테이블을 따로 만들어 따로 보관하면 어떨까? X (같이 사용하는 경우 처리 불가)
-- A : 남자와 여자를 조회하는 구문을 각각 뷰(VIEW)로 만들어서 보관?
create view male as select * from person where gender = '남자';

create view female as select * from person where gender='여자';

select * from male; --남자만 조회
select * from female; --여자만 조회

-- 성적 top3를 조회할 일이 아주 많다면! 뷰를 한 번 고려해보자
-- 1. 조회구문을 만들고
-- 2. 뷰를 생성하면서 as 뒤에 첨부하면 끝!
-- 3. 뷰 이름으로 편하게 호출
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
-- 한 가지만 되도록 구현하기보다는 데이터 편집이나 정렬 정도를 미리 해두는 게 좋다.
-- 아래처럼 만드는게 범용성과 확장성이 더 뛰어남. 내가 보고싶은 순위를 골라서 볼 수 있기 때문에
create view toprank as
select * from(
select 
    P.*,
    javascore+dbscore "총점",
    rank() over(order by javascore+dbscore desc) "순위"
from person P
);

select * from toprank where "순위" between 1 and 3;

-- pass라는 이름으로 자바시험과 db시험을 통과한 사람들의 정보를 뷰로 저장
--(통과라고 하면 각 과목 40이상, 평균 60이상을 말합니다.)
create or replace view pass as -- or replace 쓰면 계속 덮어쓰는 식으로 수정이 되는거임
select * from person 
where javascore>=40 and dbscore>=40 and (javascore+dbscore)/2 >= 60;

select * from pass;

-- fail이라는 이름으로 자바시험 db시험을 통과하지 못한 사람들의 정보를 뷰로 저장
create or replace view fail as
select * from person 
where javascore<40 or dbscore<40 or (javascore+dbscore)/2 <60;

select * from fail;

------------------------------------------------------
-- 인덱스(index) : 색인. 빠른 검색을 위해 항목에 설치하는 도구
-- but 우리가 인덱스를 만들 일은 거의 없음
-------------------------------------------------------------
-- primary key는 기본적으로 인덱스가 부여되도록 되어있다.
-- 다른 항목에 검색속도를 올리고 싶다면 어떻게 해야하는가?

-- Q) 둘 중에 누가 더 빠르고 뭘 써야할까?
-- A) person_no가 빠르다. Primary key이기 때문(INDEX가 자동 부여). cf)primary key에는 인덱스가 자동 부여됨

select * from person where person_no = 1;
select * from person where person_name = '김민준';

-- person name으로도 조회가 빨라질 수 있도록 index 생성
create index idx_name on person(person_name);

select * from user_indexes;

-- index가 부여된 항목이 수시로 변경될 경우 index 자체의 성능이 느려진다.
-- 트리의 깊이가 4가 넘어가면 리빌딩을 권장(정기적으로 수행)
-- tip) 애초에 인덱스 쓸 생각을 하지말고 sql문을 효율적으로 짤 생각을 해라
alter index idx_name rebuild;
select * from person;

drop index idx_name;

-- 참고 : 인덱스 트리의 깊이 파악하기. blevel이 트리의 깊이
select 
    tablespace_name, table_name, index_name, blevel
from user_indexes
where blevel >= 4;

-- 집합연산 : 서로 다른 두 집합간의 연산 수행
-- 기반 데이터 추가
drop table favorite;
create table favorite(
name varchar2(6) not null,
color varchar2(6) not null
);
-- 철수 5개, 영희 5개
insert into favorite values('철수', '빨강');
insert into favorite values('철수', '파랑');
insert into favorite values('철수', '노랑');
insert into favorite values('철수', '초록');
insert into favorite values('철수', '핑크');
insert into favorite values('영희', '검정');
insert into favorite values('영희', '빨강');
insert into favorite values('영희', '파랑');
insert into favorite values('영희', '갈색');
insert into favorite values('영희', '회색');
insert into favorite values('영수', '하늘');
insert into favorite values('영수', '주황');
insert into favorite values('영수', '검정');
insert into favorite values('영수', '빨강');
insert into favorite values('영수', '핑크');
commit;
select * from favorite;

-- 합칩합 : 철수와 영희 중 한명이라도  좋아하는 색상(union : 중복제거 / union all : 중복허용)
select distinct color from favorite where name ='철수' or name = '영희'; -- 결과는 나오지만 문제랑 의미상 맞는 건 아님

select color from favorite where name = '철수'
--union all
union   -- 집합연산
select color from favorite where name = '영희';

-- 교집합 : 철수와 영희 둘 다 좋아하는 색상
select color from favorite where name ='철수'
intersect
select color from favorite where name = '영희';

-- 차집합 : 철수만 / 영희만 좋아하는 색상 (minus)
-- 철수만
select color from favorite where name = '철수'
minus
select color from favorite where name = '영희'
minus
select color from favorite where name = '영수';

-- 영희만 
select color from favorite where name = '영희'
minus
select color from favorite where name != '영희'; -- 이게 더 효율적 덜 쓰니깐
