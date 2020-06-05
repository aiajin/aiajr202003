-- phonebook 테이블명세서 DDL : 2020.05.26

drop table phoneInfo_basic;
drop table phoneInfo_univ;
drop table phoneInfo_com;


-- 왜래키 설정시 부모의 행이 삭제 될 때 설정
-- REFERENCES phoneInfo_basic(idx) on delete 설정 옵션
-- no action : 모두 삭제 불가
-- cascade : 참조를 하고 있는 자식 테이블의 모든 행도 삭제
-- set null : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null 로 변경
-- set default : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값 로 변경

drop table phoneInfo_basic;
drop table phoneInfo_univ;
drop table phoneInfo_com;

create table phoneInfo_basic (
    idx number(6),
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address VARCHAR2(20),
    fr_regdate date default sysdate,    
    constraint pb_idx_pk primary key(idx)    
);
 
 
create table phoneInfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default 1 not null,
    fr_ref number(6),
    constraint pu_idx_pk primary key(idx),
    constraint pu_fr_u_year_ck check (fr_u_year between 1 and 4),
    constraint pu_fr_ref_fk 
    foreign key(fr_ref) REFERENCES phoneInfo_basic(idx) on delete cascade   
);
 
create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6),
    constraint pc_idx_pk primary key(idx),
    constraint pc_fr_ref_fk 
    foreign key(fr_ref) REFERENCES phoneInfo_basic(idx) on delete cascade
);

---------------------------------------------------------------------------------
-- 입력 DML
---------------------------------------------------------------------------------
-- 학교 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 학교 친구 정보 테이블 데이터 입력
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (1, '박지성', '010-9999-0000', 'park@gmail.com', 'London')
;
insert into phoneinfo_univ 
values (1, 'computer', 1, 1)
;

insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (PB_BASIC_IDX_SEQ.nextval, '박지성', '010-9999-0000', 'park@gmail.com', 'London')
;
insert into phoneinfo_univ 
values (PB_UNIV_IDX_SEQ.nextval, 'computer', 1, pb_basic_idx_seq.currval)
;

-- 회사 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 회사 친구 정보 테이블 데이터 입력
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (2, '손흥민', '010-7777-5555', 'son@gmail.com', 'London')
;
insert into phoneinfo_com 
values (1, 'NAVER', 2)
;

insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (PB_BASIC_IDX_SEQ.nextval, '손흥민', '010-7777-5555', 'son@gmail.com', 'London')
;
insert into phoneinfo_com 
values (PB_COM_IDX_SEQ.nextval, 'NAVER', PB_BASIC_IDX_SEQ.currval)
;


---------------------------------------------------------------------------------
-- 친구 정보 출력 질의
---------------------------------------------------------------------------------
-- 1. 전체 친구 목록 출력 : 테이블 3개 JOIN
select * 
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
--where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;

-- 2. 학교 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

select * from phoneinfo_univ;

-- 3. 회사 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;


---------------------------------------------------
-- 수정을 위한 SQL
---------------------------------------------------
--1. 회사 친구의 정보 변경
--   기본 정보 + 회사정보 수정
-- 기본 정보 수정
-- 회사 정보 수정

update phoneinfo_basic
set fr_name='SCOTT', 
    fr_phonenumber='010-0000-0000', 
    fr_address='SEOUL', 
    fr_email='scott@gmail.com'
where idx=2
;
update phoneinfo_com
set fr_c_company='KAKAO'
where fr_ref=2
;


--2. 학교 친구의 정보 변경 
-- 기본정보 + 학교정보 수정
-- 기본 정보 수정
-- 학교 정보 수정


update phoneinfo_basic
set fr_name='KING', 
    fr_phonenumber='010-0000-0000', 
    fr_address='SEOUL', 
    fr_email='KING@gmail.com'
where idx=1
;

update phoneinfo_univ
set fr_u_major='DATA', fr_u_year=3
where fr_ref=1
;




---------------------------------------------------
-- 삭제를 위한 sql
---------------------------------------------------
--1. 회사 친구 정보를 삭제
delete from phoneinfo_com where fr_ref=2;
delete from phoneinfo_univ where fr_ref=2;

delete from phoneinfo_basic where idx=2;

--2. 학교 친구 정보를 삭제
delete from phoneinfo_com where fr_ref=1;
delete from phoneinfo_univ where fr_ref=1;

delete from phoneinfo_basic where idx=1;


-----------------------------------------------------------
-- VIEW 생성
-----------------------------------------------------------

-- 1. 전체 친구 목록 출력 : 테이블 3개 JOIN
select * 
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;

-- VIEW : pb_all_view
create or replace view pb_all_view
(name, phonenumber, address, email, major, grade, company, regdate)
as
select pb.fr_name, 
       pb.fr_phonenumber, 
       pb.fr_address, 
       pb.fr_email,
       pu.fr_u_major,
       pu.fr_u_year,
       pc.fr_c_company,
       pb.fr_regdate
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;

-- select view 
select * from pb_all_view where name='박지성';


-- 2. 학교 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

-- view : pb_univ_view

create or replace view pb_univ_view 
(name, phonenumber, address, email, major, grade, regdate)
as
select pb.fr_name, 
       pb.fr_phonenumber, 
       pb.fr_address, 
       pb.fr_email,
       pu.fr_u_major,
       pu.fr_u_year
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

select * from pb_univ_view;

-- 3. 회사 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;

-- view : pb_com_view
create or replace view pb_com_view
(name, phonenumber, address, email, company, regdate)
as
select pb.fr_name, 
       pb.fr_phonenumber, 
       pb.fr_address, 
       pb.fr_email,
       pc.fr_c_company,
       pb.fr_regdate
from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;

select * from pb_com_view;



---------------------------------------------------------
-- sequence 생성
---------------------------------------------------------
-- 1. basic 테이블 seq
create sequence pb_basic_idx_seq
start with 0
MINVALUE 0
;

-- 2. com 테이블 seq
create sequence pb_com_idx_seq start with 0 MINVALUE 0;

-- 3. univ 테이블 seq
create sequence pb_univ_idx_seq start with 0 MINVALUE 0;














