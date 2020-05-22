-- practice 06 마당서점
select * from book;
select * from customer;
select * from orders;

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
select count(publisher) from book 
where bookid in (select bookid from orders o join customer c using(custid) where name='박지성');

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select bookname, abs(price-saleprice) Pricegap 
from orders o join book b 
using(bookid) 
where o.custid = (select custid from customer where name='박지성');

--(7) 박지성이구매하지않은도서의이름
select bookname from book 
where bookid not in (select bookid from orders o, customer c where o.custid=c.custid and c.name='박지성');


--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
select name from customer where custid not in (select distinct custid from orders);

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice) Total, avg(saleprice) AvgSalePrice from orders;

--(10) 고객의이름과고객별구매액
select name, sum(saleprice) from orders o join customer c using(custid) group by name;

--(11) 고객의이름과고객이구매한도서목록 
select name, bookname 
from (select * from orders o, customer c, book b where o.custid=c.custid and o.bookid = b.bookid) 
order by name;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select * from orders o join book b on o.bookid=b.bookid 
where abs(price-saleprice)>= all(
    select abs(price-saleprice) 
    from (select * from orders o, customer c, book b where o.custid=c.custid and o.bookid = b.bookid));

--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
select name 
from customer c join orders o 
on c.custid= o.custid 
group by name
having avg(saleprice) > (select avg(price) from book b, orders o where b.bookid=o.bookid);
  
--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name from orders o, customer c, book b where o.custid=c.custid and o.bookid = b.bookid
and publisher in (
    select publisher 
    from orders o natural join book b 
    where custid = (select custid from customer where name='박지성'))
and name != '박지성';

--(2)***** 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name from orders o, customer c, book b where o.custid=c.custid and o.bookid = b.bookid
group by name
having count(distinct publisher)>=2;



select o.custid, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by o.custid
order by o.custid
;













