-- 2020.05.27

----------------------------------------------------------
-- VIEW
----------------------------------------------------------
-- 논리적인 가상 테이블 : 테이블과 같이 사용 가능, 제약은 존재
-- 물리적인 테이블 기반으로 만든다 : select 서브쿼리를 이용해서 만든다.

-- create [or replace] view view이름 as 서브쿼리

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 
-- 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다.

create view emp_view_deptno30
as
select empno, ename, deptno from emp where deptno=30
;

select * from emp_view_deptno30;

desc user_views;
select view_name, text from user_views;

drop view emp_view_deptno30;

-- 인라인 뷰를 사용해서 입사일이 빠른 사람 5명만을 얻어오기로 합시다. 

-- 1. view 객체 생성

create or replace view emp_hir_view
as
select empno, ename, hiredate
from emp
order by hiredate asc
;
select * from emp_hir_view;
select rownum, empno, ename, hiredate from emp_hir_view where rownum <=5;
select rownum, empno, ename, hiredate from emp order by hiredate;



----------------------------------------------------------------
-- sequence : 번호 자동 생성기
----------------------------------------------------------------

-- create sequence 시퀀스이름 
-- start with 시작값  0 시작
-- increment by 증가값 1
-- maxvalue 최대값
-- minvalue 최소값
-- cycle | nocycle 반복 여부
-- cache | nocache

-- 부서번호 deptno 의 sequence 생성
create sequence dept_deptno_seq01;

select dept_deptno_seq01.nextval
from dual;

select dept_deptno_seq01.currval
from dual;











