-- 2020.05.25


-----------------------------------------------
-- DDL 
-----------------------------------------------

-- 테이블 생성 
-- create table 테이블의 이름 () <- 괄호 안에 컬럼을 정의
-- ( 컬럼명1 타입(사이즈) , 컬럼명2 타입(사이즈), ... )

-- ddl_test 라는 이름의 테이블을 생성
-- 컬럼1 : no, 숫자타입,  사이즈는 3
-- 컬럼2 : name, 가변 문자열 저장, 사이즈 10
-- 컬럼3 : birth, 날짜 타입, 기본값은 현재 날짜 시간

create table ddl_test (
    no number(3),
    name varchar2(10),
    birth date default sysdate
);

desc ddl_test;
select * from tab;

select * from ddl_test;

insert into ddl_test (no, name) values (1, 'scott');


-- emp 테이블 참조
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 
-- EMP01 테이블을 생성해 봅시다.
desc emp;

create table emp01(
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
);

select * from tab;
desc emp01;

-- 테이블의 복사 : 서브 쿼리 이용 
-- 스키마 복사, 행 복사, 제약조건의 복사는 되지 않는다.

create table emp02
as
select * from emp
;

select * from tab;

desc emp02;
select * from emp02;


-- emp 테이블의 empno와 ename 컬러만 복사해서 
-- 새로운 테이블 emp03 을 생성하자
create table emp03
as
select empno, ename from emp
;
select * from emp03;
desc emp03;

-- emp 테이블의 10번 부서의 데이터만 복사해서 새로운 테이블 
-- emp04 테이블을 생성하자
create table emp04
as
select * from emp where deptno=10
;
select * from emp04;

-- emp 테이블의 스키마 구조만 복사해서 새로운 테이블 emp05 생성하자
create table emp05
as
select * from emp where 1<0
;

select * from emp05;

-- 테이블에 컬럼 추가
-- alter table 테이블 이름 add (컬럼정의)

-- emp01 테이블에 직급(job) 컬럼을 추가하자
desc emp01;

alter table emp01 add(job varchar2(10));

-- 컬럼의 변경
-- alter table 테이블이름 modify (컬럼 정의)
-- 직급(JOB) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자.
alter table emp01 modify (job varchar(30) not null);
desc emp01;

-- 컬럼의 삭제
-- alter table 테이블이름 drop column 컬럼이름
alter table emp01 drop column sal;
desc emp01;


-- 테이블 객체 삭제
-- drop table 테이블 이름;
drop table emp01;
select * from tab;
desc emp01;

select * from emp02;

TRUNCATE table emp02;


-- 테이블 이름의 변경
-- rename 현재 테이블 이름 to 새로운 테이블 이름

rename emp02 to test_emp;
select * from tab;


desc dept;
insert into dept values(10, 'test', 'seoul');


-- 컬럼의 제약 정의는 컬럼 정의를 하면서 컬럼 옆에 정의 
-- 컬럼의 타입을 모두 정의하고, 아래에 제약을 정의하는 방법

-- create table emp01 (
--     empno number(4) not null
-- )

-- create table emp01 (
--    empno number(4) ,
--    primary key(empno)
--)

-- not null 제약 : 컬럼의 값에 null 값을 허용하지 않는다.
-- 컬럼 레벨에서만 정의가 가능

-- 사원 테이블(EMP02)을 
-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성하되 
-- 이번에는 사원번호와 사원명에 NOT NULL 조건을 지정하도록 합시다
drop table emp02;

create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);
desc emp02;

insert into emp02 values (null, null, 'MANAGER', 10);
insert into emp02 values (1111, null, 'MANAGER', 10);
insert into emp02 values (1111, 'SON', 'MANAGER', 10);
SELECT * FROM EMP02;

DROP TABLE EMP03;

CREATE TABLE EMP03(
    EMPNO NUMBER(4) UNIQUE,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);


CREATE TABLE EMP03(
    EMPNO NUMBER(4) UNIQUE NOT NULL,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);


DESC EMP03;
INSERT INTO EMP03 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP03 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP03 VALUES(NULL, 'TEST123', 'MANAGER', 20);
SELECT * FROM EMP03;


-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- EMP04 테이블을 생성하되 
-- 사원번호에는 유일키로 사원명은 NOT NULL 제약조건을 설정해 봅시다.
DROP TABLE EMP04;
CREATE TABLE EMP04(
    EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE CONSTRAINT EMP04_EMPNO_NN NOT NULL,
    ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);

DESC EMP04;
INSERT INTO EMP04 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP04 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP04 VALUES(NULL, 'TEST123', 'MANAGER', 20);
SELECT * FROM EMP04;

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- 테이블을 생성하되 사원번호에 기본 키 제약 조건을 설정해 봅시다.
DROP TABLE EMP05;
CREATE TABLE EMP05(
    EMPNO NUMBER(4) CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);
DESC EMP05;
INSERT INTO EMP05 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP05 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP05 VALUES(NULL, 'TEST123', 'MANAGER', 20);
SELECT * FROM EMP05;

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- 테이블을 생성하되 사원번호에 기본 키 제약 조건을 설정해 봅시다.
-- DEPTNO 외래키로 제약조건을 설정
DROP TABLE EMP06;
CREATE TABLE EMP06(
    EMPNO NUMBER(4) CONSTRAINT EMP06_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP06_ENAME_NN NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2) CONSTRAINT EMP06_DEPTNO_FK REFERENCES DEPT(DEPTNO)
);
SELECT * FROM DEPT;
DESC EMP06;
INSERT INTO EMP06 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP06 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP06 VALUES(NULL, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP06 VALUES(2222, 'TEST123', 'MANAGER', 50);
SELECT * FROM EMP06;


-- 사원번호, 사원명, 직급, 부서번호, 직급, 성별, 생일 7개의 칼럼으로 
-- 구성된 테이블을 생성하되 
-- 기본 키 제약 조건, 외래키 제약 조건은 물론 
-- CHECK 제약 조건도 설정해 봅시다.
-- DEFAULT 제약 조건으로 BIRTHDAY  SYSDATE로 입력되도록 처리
CREATE TABLE EMP07(
    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL,
    JOB VARCHAR2(10) DEFAULT 'MANAGER',
    DEPTNO NUMBER(2) CONSTRAINT EMP07_DEPTNO_FK REFERENCES DEPT(DEPTNO),
    GENDER CHAR(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER='M' OR GENDER='F'),
    SAL NUMBER(7,2) CONSTRAINT EMP07_SAL_CK CHECK (SAL BETWEEN 500 AND 5000),
    BIRTHDAY DATE DEFAULT SYSDATE
);

INSERT INTO EMP07 VALUES (1111, 'TEST', NULL, 10, 'F', 600, NULL);
INSERT INTO EMP07 VALUES (1112, 'TEST', NULL, 10, 'M', 600, NULL);

INSERT INTO EMP07 (EMPNO, ENAME, DEPTNO, GENDER, SAL) 
           VALUES (1113, 'TEST', 10, 'F', 1600);

SELECT * FROM EMP07;












