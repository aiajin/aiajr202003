-- phonebook DDL
-- ===== 전화번호 부( Contact )

-- 대리키 : 일련번호 -> pbIdx ==> PK 기본키로 만들기 위한 목적

-- 이름, 전화번호, 주소, 이메일 <- 기본정보
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임
drop table phonebook;
-- 테이블 레벨 제약 정의
create table phonebook(
    pbidx number(4),                -- 기본키, 대리키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null,   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50),    -- 닉네임
    
    constraint pb_pbidx_pk PRIMARY KEY (pbidx),
    CONSTRAINT pb_type_ck check (pbtype in ('univ', 'com', 'cafe') ),
    constraint pb_grade_ck check (pbgrade between 1 and 4)
);

-- 컬럼 레벨 제약 정의
create table phonebook(
    pbidx number(4) constraint pb_pbidx_pk PRIMARY KEY,                -- 기본키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null 
    CONSTRAINT pb_type_ck 
        check (pbtype in ('univ', 'com', 'cafe') ),   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1) 
    constraint pb_grade_ck 
    check (pbgrade between 1 and 4),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50)    -- 닉네임    
    
);

-----------------------------------------------------------------

-- 사용자 정의 제약조건을 저장하는 딕셔너리 테이블
desc user_constraints;
select CONSTRAINT_NAME from user_constraints;

-----------------------------------------------------------------







