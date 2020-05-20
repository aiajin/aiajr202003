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



