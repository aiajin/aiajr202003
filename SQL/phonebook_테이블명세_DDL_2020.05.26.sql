-- phonebook 테이블명세서 DDL : 2020.05.26

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
    constraint pu_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)    
);
 
create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6),
    constraint pc_idx_pk primary key(idx),
    constraint pc_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)  
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

-- 회사 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 회사 친구 정보 테이블 데이터 입력
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (2, '손흥민', '010-7777-5555', 'son@gmail.com', 'London')
;
insert into phoneinfo_com 
values (1, 'NAVER', 2)
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
-- 3. 회사 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;





