-- 1. 대륙 이름과 나라 이름을 출력
select 
    region_name 대륙명 , country_name 국가
from 
    countries C inner join regions R on C.region_id = R.region_id
order by 대륙명, 국가;
    
-- 2. 대륙별 나라 개수를 출력
select 
    region_name 대륙명, count(*) "국가 수"
from 
    regions R inner join countries C on R.region_id = C.region_id
group by region_name
order by 대륙명;

-- 3. 나라별 지역 개수를 출력
select
    country_name 국가, count(*) "지역 수"
from
    countries C inner join Locations L on C.country_id = L.country_id
group by country_name
order by 국가;

-- outer join : 지역이 없는 나라도 조회
-- count는 null을 세지않음
select C.country_name, count(L.location_id) CNT  --count안에 어떤 항목을 적어도 상관없으나 일반적으로 primary key 항목을 적음
from countries C left outer join locations L on C.country_id = L.country_id
group by C.country_name
order by CNT desc;


-- 4. 대륙별 지역 개수를 출력
select
    R.region_name, count(L.location_id) CNT
from
    regions R 
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
group by R.region_name
order by R.region_name asc;

-- 5. 각 지역에서 가장 많은 급여를 받는 노동자의 급여액을 출력
select
    L.city 지역, nvl(max(E.salary), 0) "최대 급여액"
from Locations L
        left outer join departments D on L.location_id = D.location_id
        left outer join employees E on D.department_id = E.department_id
group by L.city
order by "최대 급여액" desc;

-- 6. 각 지역별 노동자 급여의 평균을 출력
select
    L.city 지역, floor(avg(E.salary)) "급여 평균"
from departments D
        inner join Locations L on D.location_id = L.location_id
        inner join employees E on D.department_id = E.department_id
group by L.city;    

-- 7. EMPLOYEES 테이블에서 MANAGER_ID는 상사의 EMPLOYEE_ID를 말합니다.
-- 부하직원이 많은 순으로 출력하세요
select
    manager_id, "부하직원 수"
from 
    (select manager_id, count(*) "부하직원 수" from employees group by manager_id)
where manager_id is not null
order by "부하직원 수" desc;

--8. JOB_HISTORY는 고용 이력을 말합니다. 
--가장 최근까지 고용되었던 사람의 이름과 급여, 근무기간을 일단위로 구해서 출력하세요
select
    E.first_name 이름,
    E.last_name 성,
    E.salary 급여,
    to_char((H.end_Date-H.start_date)+1, '9,990')||'일' 근무기간
from employees E
        inner join job_history H on E.employee_id = H.employee_id
where end_date = (select max(end_date) from job_history);

-- 9. 직업들을 최고 급여액과 최소 급여액의 차이가 가장 적은 것부터 출력해보세요(직업명, 급여액 차이, 평균 급여액)        
select
    J.job_title 직업명, J.max_salary-J.min_salary "급여액 차이", avg(E.salary) "평균 급여액" 
from jobs J
        inner join employees E on J.job_id = E.job_id 
group by J.job_title, J.max_salary-J.min_salary      
order by "급여액 차이";

--10. 지역별로 MANAGER가 없는 부서의 수를 구하여 출력하세요
select
    L.city 지역, count(*) "부서의 수"
from locations L
        inner join departments D on L.location_id = D.location_id
where manager_id is null
group by L.city 
order by 지역;

--11. 전체 노동자들을 고용 연도로 분류하여 급여 평균액, 최대 급여액, 최소 급여액을 출력하세요
select
    extract(year from hire_date) "고용 연도",
    floor(avg(salary)) "급여 평균액",
    max(salary) "최대 급여액",
    min(salary) "최소 급여액"
from employees 
group by extract(year from hire_Date)
order by "고용 연도";

----------------------------------------------------------------------------------
-- 각 문제 당 rank(), dense_rank, top n query 3종류 다 사용해서 풀기
--1. 가장 급여를 많이 받는 작업자(Employee) Top 5 출력
--rank
select * from (
select E.*, rank() over(order by salary desc) "순위"
from employees E 
)where "순위" between 1 and 5;

-- dense_rank
select * from (
    select E.*, dense_rank() over(order by salary desc) "순위" from employees E
)
where "순위" between 1 and 5;

--top n query
select * from (
    select rownum rn, a.* from (
     select * from employees order by salary desc
    ) a 
)where rn between 1 and 5;

--2. 사업부(Department)가 가장 많은 대륙(Region) Top 3 출력
--rank
select * from (
select 
    R.region_name "대륙", 
    count(D.department_id) "부서의 수",
    rank() over(order by count(D.department_id) desc) "순위"
from regions R
    left outer join countries C on R.region_id = C.region_id
    left outer join locations L on C.country_id = L.country_id
    left outer join departments D on L.location_id = D.location_id
group by R.region_name
)
where 순위 between 1 and 3;

-- dense_rank
select * from (
select 
    R.region_name 대륙,
    count(D.department_id) "부서의 수",
    dense_rank() over(order by count(D.department_id) desc) 순위
from regions R
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
group by R.region_name
)
where 순위 between 1 and 3;

-- top n query
select * from (
select rownum rn, a.* from (
    select 
        R.region_name "대륙",
        count(D.department_id) "부서수"    
    from regions R
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
    group by R.region_name
    order by 부서수 desc
) a
)where rn between 1 and 3;

--3. 평균 급여가 가장 높은 직종 Top 3 출력
--rank
select * from (
select 
    J.*, 
    (J.min_salary+J.max_salary)/2 "평균급여", 
    rank() over(order by (J.min_salary+J.max_salary)/2 desc) "순위"
from jobs J 
) where 순위 between 1 and 3;

--dense_rank
select * from (
select 
    J.*,
    (J.min_salary+J.max_salary)/2 "평균급여",
    dense_rank() over(order by (J.min_salary+J.max_salary)/2 desc) "순위"
from jobs J
)where 순위 between 1 and 3;

--top n query
select * from (
    select rownum rn, a.* from (
        select
            J.*, (J.min_salary+J.max_salary)/2 "평균급여"
        from jobs J
        order by "평균급여" desc
    ) a
) 
where rn between 1 and 3;









-- 선생님 풀이
--1. 가장 급여를 많이 받는 작업자(Employee) Top 5 출력
--rank
select * from (
    select E.*, rank() over(order by salary desc) rnk from employees E
) where rnk between 1 and 5;
--dense_rank
select * from (
    select E.*, dense_rank() over(order by salary desc) rnk from employees E
) where rnk between 1 and 5;
--top N
select * from(
    select rownum rn, TMP.* from (
        select * from employees order by salary desc
    )TMP
) where rn between 1 and 5;

--2. 사업부(Department)가 가장 많은 대륙(Region) Top 3 출력
--rank
select * from (
    select 
        R.region_name, 
        count(D.department_id) "부서개수",
        rank() over(order by count(D.department_id) desc) "순위"
    from 
    regions R 
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
    group by R.region_name
) where 순위 between 1 and 3;
--dense_rank
select * from (
    select 
        R.region_name, 
        count(D.department_id) "부서개수",
        dense_rank() over(order by count(D.department_id) desc) "순위"
    from 
    regions R 
        left outer join countries C on R.region_id = C.region_id
        left outer join locations L on C.country_id = L.country_id
        left outer join departments D on L.location_id = D.location_id
    group by R.region_name
) where 순위 between 1 and 3;
--topN
select * from (
    select rownum rn, TMP.* from (
        select 
            R.region_name, 
            count(D.department_id) "부서개수"
        from 
        regions R 
            left outer join countries C on R.region_id = C.region_id
            left outer join locations L on C.country_id = L.country_id
            left outer join departments D on L.location_id = D.location_id
        group by R.region_name
        order by "부서개수" desc
    )TMP
) where rn between 1 and 3;
--3. 평균 급여가 가장 높은 직종 Top 3 출력
select * from (
    select 
        J.*, 
        (J.min_salary+J.max_salary)/2 "평균급여",
        rank() over(order by (J.min_salary+J.max_salary)/2 desc) "순위"
    from jobs J
) where 순위 between 1 and 3;

select * from (
    select 
        J.*, 
        (J.min_salary+J.max_salary)/2 "평균급여",
        dense_rank() over(order by (J.min_salary+J.max_salary)/2 desc) "순위"
    from jobs J
) where 순위 between 1 and 3;

select * from(
    select rownum rn, TMP.* from(
        select 
            J.*, 
            (J.min_salary+J.max_salary)/2 "평균급여"
        from jobs J
        order by "평균급여" desc
    )TMP
) where rn between 1 and 3;
        