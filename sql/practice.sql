drop table emp;
truncate table emp;
create table emp(
empid number,
empname varchar2(30),
deptcode varchar2(30),
sal number
);

insert into emp values(1, 'a', '부서1', 200);
insert into emp values(2, 'b', '부서1', 250);
insert into emp values(3, 'c', '부서1', 150);
insert into emp values(4, 'd', '부서2', 200);
insert into emp values(5, 'e', '부서2', 300);
insert into emp values(6, 'f', '부서2', 100);
insert into emp values(7, 'g', '부서3', 500);
insert into emp(empid, empname, sal) values(8, 'h', 200);
insert into emp(empid, empname, sal) values(9, 'i', 300);
commit;

select * from emp;

select deptcode, max(sal) from emp group by deptcode;

SELECT EMPID, EMPNAME, DEPTCODE, SAL
FROM EMP
WHERE (nvl(DEPTCODE, '이해가 안가는디'), SAL) IN (SELECT nvl(DEPTCODE, '이해가 안가는디'), MAX(SAL)
FROM EMP
GROUP BY DEPTCODE)
ORDER BY DEPTCODE;