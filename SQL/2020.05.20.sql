-- 2020.05.20

----------------------------------
-- 함수
----------------------------------

-- 숫자함수

select mod(10,2)
from dual;

select abs(sal)
from emp;

select  trunc(1234533.141592, -2)
from dual;

select trunc(sal, -2)
from emp;

select round(3.141592, 2)
from dual ;

select round(1987463.141592, -2)
from dual ;

select sysdate
from dual;

-- TO_CHAR
-- date -> varchar2
select sysdate, to_char(sysdate, 'YYYY-MM-DD')
from dual;

select sysdate, to_char(sysdate, 'YYYY.MM.DD')
from dual;

select ename, to_char(hiredate, 'YYYY.MM.DD') as hiredate
from emp;

select sysdate, to_char(sysdate, 'HH24:MI:SS')
from dual;

-- 2020.05.20. 11:26
-- 2020.05.20. 11:39
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI')
from dual;


-- to_char
-- number -> varchar2
select to_char(12500, '000,000')
from dual;

select to_char(12500, '0,000,000')
from dual;
select to_char(12500, '0,000')
from dual;


select to_char(12500, '99,999,999')
from dual;


select to_char(12500, 'L999,999')
from dual;


select to_char(3.14, '000,000.000')
from dual;

select to_char(3.141592, '999,999.99')
from dual;

select sal, to_char(sal*1000, 'L999,999,999'), 
to_char( sal*1000*12+nvl(comm,0), 'L999,999,999' ) as Income
from emp
order by income desc
;

-- TO_DATE
-- TO_DATE(원본, 패턴)
-- str -> date

select to_date('19810220', 'YYYYMMDD')
from dual;
select to_date('1981/02/14', 'YYYY/MM/DD')
from dual;

select ename, hiredate
from emp
where hiredate = TO_DATE('1981/02/20', 'YYYY/MM/DD')
;

select sysdate, to_DATE('20201225', 'YYYYMMDD'),
trunc(to_date('20201225', 'YYYYMMDD')-sysdate)
from dual;

select sysdate, trunc(sysdate-to_date('20120517', 'YYYYMMDD'))
from dual;


-- TO_NUMBER
-- TO_NUMBER(원본, '패턴')
-- str -> number : 산술, 관계 연산을 목적으로 변환

select to_number('20,000', '999,999')-to_number('9,000','999,999')
from dual;

-- DECODE 함수 : if switch 구문과 유사
select ename, deptno,
decode(deptno, 
            10, 'ACCOUNTING',
            20, 'RESEARCH',
            30, 'SALES',
            40, 'OPERATING'
) AS deptName
from emp;

-- 직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANALYST'인 사원은 5%, 
-- 'SALESMAN'인 사원은 10%, 
-- 'MANAGER'인 사원은 15%, 
-- 'CLERK'인 사원은 20%인 인상한다.

select ename, job, sal,
decode(job,
            'ANALYST', sal+sal*0.05, -- sal*1.05
            'SALESMAN', sal+sal*0.1, -- sal*1.1
            'MANAGER', sal+sal*0.15, -- sal*1.15 
            'CLERK', sal+sal*0.2
) as UPSAL
from emp;


select ename, deptno,
case
    when deptno=10 then 'ACCOUNTING'
    when deptno=20 then 'RESEARCH'
    WHEN deptno=30 then 'SALES'
    when deptno=40 then 'OPERATING'
    else 'no name'
end as deptName


from emp;

select sal from emp;


------------------------------------
-- 그룹함수 ( 집합함수 )
------------------------------------
-- sum, avg, count, max, min

-- sum(컬럼이름) : 해당 컬럼의 데이터들의 합 반환
-- 매월 지급되는 급여의 총 합
select sum(sal) as totalSal
from emp;

select to_char(sum(sal)*1000, 'L999,999,999') as totalSal
from emp;

select sum(comm)
from emp;

-- avg(컬럼명) : 해당 컬럼의 데이터들의 평균값을 반환
select trunc(avg(sal) )
from emp;

select 29025/14 from dual;

select sum(comm) from emp;

select avg(comm)
from emp;

select * from emp order by comm;



-- MAX, MIN : 해당 컬럼의 데이터중에서 최대값, 최소값을 반환
select max(sal), min(sal), max(comm), min(comm)
from emp;


-- count(컬럼명 or *) : 행 ( row )의 개수를 반환
select count(*)
from emp;

select count(comm)  -- null 을 포함하는 행은 개수로 포함하지 않는다.
from emp;

select count(job)
from emp;

select job from emp order by job;

select count(distinct job) from emp order by job;


-- groub by 절 : 특정 컬럼으로 그룹핑을 해준다.

select deptno
from emp
group by deptno
;

select  job
from emp
group by job
;

-- 소속 부서별 
-- 평균 급여 구하는 예제입니다.
select deptno, round(avg(sal),0)
from emp
group by deptno
;









