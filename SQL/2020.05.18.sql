-- 2020.05.18

select * from emp order by sal desc;

select * from dept;

-- 로그인한 계정이 소유한 테이블 확인
SELECT * from tab;

-- emp : 사원정보
-- dept : 부서정보
-- bonus : 임시테이블 
-- salgrade : 급여 테이블

-- 테이블의 구조 확인 : desc 테이블이름
desc emp;
desc dept;
desc salgrade;

select * from emp;
select * from dept;

-- 데이터 검색 질의
select ename, sal, deptno, empno  -- 컬럼 이름
from emp -- 테이블 이름 
;

select * from dept;

select deptno, dname from dept;


-- select 의 결과는 새로운 테이블이다.
-- 컬럼의 산술 연산이 가능하다. +, -, *, /, mod함수 이용

select * from emp;
select ename, sal, sal + comm
from emp;

select ename, sal, sal+500
from emp;

select ename, sal, sal-100
from emp;

select ename, sal, sal*12
from emp;

select ename, sal, sal/2
from emp;

-- null 값의 확인
select ename, job, sal, comm, SAL*12, SAL*12+COMM
from emp
;

-- null 값 치환 함수 : nvl(컬럼명, 기본값)
-- 기본값은 컬럼의 도메인의 자료형과 같아야 한다.

select ename, job, sal, nvl(comm, 100), sal*12 as sal, 
       sal*12+nvl(comm,100) as total
from emp;

-- 데이터베이스의 문자열 표현 -> 작은 따움표를 이용
-- '문자열'
-- 문자열을 붙여서 출력하는 연산 -> ||

select ename || ' is a ' || job as msg
from emp;

select ename, job from emp;

-- 출력 컬럼의 중복을 제거하고 하나씩만 출력 : distinct
select deptno from emp;

select distinct deptno from emp;

select deptno, job from emp order by deptno;
select distinct deptno, job from emp order by deptno;

 




