-- subquery 문제
select * from emp;

-- 43.사원 번호가 7788인 사원과 담당 업무가 같은 
--    사원을 표시(사원 이름과 담당업무)하시오.

select job from emp where empno=7788;

select ename, job
from emp
where job= (select job from emp where empno=7788) --'ANALYST' --() -- 7788 사원의 업무
;





-- 44. 사원번호가 7499인 사원보다 
--     급여가 많은 
--     사원을 표시하시오. 사원이름과 담당 업무

select sal from emp where empno=7499;

select ename, job
from emp
where sal>(select sal from emp where empno=7499)
;





-- 45. 최소급여를 받는 
--     사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)

select min(sal) from emp;


select ename, job, sal
from emp
where sal = (select min(sal) from emp)
;

select ename,job, sal
from emp
where sal <= all (select sal from emp)
;





-- 46. 평균급여가 가장 적은 직급의 
--     직급 이름과 직급의 평균을 구하시오.

select job, avg(sal)
from emp
group by job
having avg(sal) <= all (
    select avg(sal)
    from emp
    group by job)
;

-- 부서별 평균의 최소 평균 값

select avg(sal)
from emp
group by job
;

select min(avg)
from (
    select avg(sal) as avg
    from emp
    group by job
)
;

select job, avg(sal)
from emp
group by job
having avg(sal) = (
    select min(avg)
from (
    select avg(sal) as avg
    from emp
    group by job
)
    
    
    )
;








-- 47. 각 부서의 최소 급여를 받는 
--     사원의 이름, 급여, 부서번호를 표시하시오.

select deptno, min(sal)
from emp
group by deptno
;
select *
from emp e1
where sal in (
    select min(sal)
    from emp e2
    where e1.deptno = e2.deptno
    group by deptno
)
;






-- 48. 담당업무가 ANALYST 인 사원보다 
--     급여가 적으면서
--     업무가 ANALYST가 아닌 
--     사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.

select distinct sal from emp where job='ANALYST';

select empno, ename, job, sal
from emp
where sal < all (select distinct sal from emp where job='ANALYST')
and job != 'ANALYST'
;






-- 49. 부하직원이 없는 사원의 이름을 표시하시오.

select distinct mgr from emp where mgr is not null;


select ename, mgr
from emp
where empno not in (select distinct mgr from emp where mgr is not null)
;





-- 50. 부하직원이 있는 사원의 이름을 표시하시오.

select ename, mgr
from emp
where empno in (select distinct mgr from emp where mgr is not null)
;




-- 51. BLAKE와 동일한 부서에 속한 
--     사원의 이름과 입사일을 표시하는 질의를 작성하시오.
--     ( 단 BLAKE는 제외 )




-- 52. 급여가 평균 급여보다 많은 
--     사원들의 사원 번호와 이름을 표시하되 
--     결과를 급여에 대해서 오름차순으로 정렬하시오.

SELECT AVG(SAL) FROM EMP;


select empno, ename, SAL
from emp
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
order by sal asc
;




-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 
--     사원의 사원 번호와 이름을 표시하시오.

SELECT DISTINCT DEPTNO FROM EMP WHERE ENAME LIKE '%K%';


SELECT EMPNO, ENAME, DEPTNO 
FROM EMP
WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP WHERE ENAME LIKE '%K%')
;





-- 54. 부서위치가 DALLAS인 
--     사원의 이름과 부서번호 및 담당업무를 표시하시오.

DESC DEPT;
SELECT * FROM DEPT;
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS';


SELECT ENAME, DEPTNO, JOB
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS') 
;




-- 55. KING에게 보고하는 -- MGR -> KING의 사원번호
--     사원의 이름과 급여를 표시하시오.

SELECT EMPNO FROM EMP WHERE ENAME='KING';

SELECT ENAME, SAL, JOB
FROM EMP
WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING')
;





-- 56. RESEARCH 부서의 사원에 대한 
--     부서번호, 사원이름 및 담당 업무를 표시하시오.

SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH';

SELECT DEPTNO, ENAME, JOB
FROM EMP
WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH')
;

SELECT E.DEPTNO, EMPNO, JOB
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO
AND DNAME='RESEARCH'
;





-- 57. 평균 월급보다 많은 급여를 받고 
--     이름에 M이 포함된 사원과 같은 부서에서 근무하는 
--     사원의 사원 번호, 이름, 급여를 표시하시오.
-- 평균월급
SELECT AVG(SAL) FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP WHERE ENAME LIKE '%M%';

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP WHERE ENAME LIKE '%M%')
;




-- 58. 평균급여가 가장 적은 업무를 찾으시오.

SELECT JOB
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) <= ALL (
    SELECT AVG(SAL)
    FROM EMP
    GROUP BY JOB
)
;








-- 59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 
--    사원을 표시하시오.

SELECT DISTINCT DEPTNO FROM EMP WHERE JOB='MANAGER';

SELECT *
FROM EMP
WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP WHERE JOB='MANAGER')
;







