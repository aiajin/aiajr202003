-- 2020.05.21

-------------------------------------
-- JOIN
-------------------------------------

select * from emp;
select * from dept;


-- cross join
select *
from emp, dept
;

select *
from emp cross join dept
;




select ename, dname
from emp, dept
where emp.deptno = dept.deptno
;

select ename, dname
from emp em inner join dept de
on em.deptno=de.deptno
;

select ename, dname
from emp inner join dept
using(deptno)
;




select ename, dname, e.deptno, d.deptno
from emp e, dept d
where e.deptno = d.deptno
;

-- book, customer, orders
select * from orders;
select * from book;
select * from customer;

-- cross JOIN
select *
from orders o, book b, customer c
;

select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
;

select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and name='박지성'
;


select * from emp;
select * from salgrade;

select ename, sal, grade
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between losal and hisal
;


-- 관리자의 이름을 알아보자
select * from emp;

select *--e.ename || '의 상사는 ' || m.ename || '입니다.'
from emp e, emp m
where e.mgr = m.empno
;

select e.ename || '의 상사는 ' || m.ename || '입니다.'
from emp e, emp m
where e.mgr = m.empno(+)
;



select e.ename, e.empno, e.sal, e.comm, nvl(m.ename,'관리자 없음')
from emp e, emp m
where e.mgr = m.empno(+)
;

select *
from emp e left outer join emp m
on e.mgr=m.empno
;


select ename, dname
from emp natural join dept
;








