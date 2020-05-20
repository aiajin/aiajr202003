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
select to_date('1981/02/20', 'YYYY/MM/DD')
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


