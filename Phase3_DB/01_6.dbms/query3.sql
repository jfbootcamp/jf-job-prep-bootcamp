-- DDL 
-- 온라인 쇼핑몰 데이터베이스를 DDL로 구축하세요 

-- 1. 데이터베이스 생성
drop table if exists shop_db;
create database shop_db			-- 데이터베이스 이름
	character set utf8mb4		-- 한글,이모지 포함 유니코드 문자셋
    collate utf8mb4_unicode_ci; -- 유니코드 기반 대소문자 무시 정렬 규칙 
    
use shop_db; 

-- 2. 카테고리 테이블 (부모 테이블)
create table categories (
	id					bigint	auto_increment  primary key,
    name				varchar(50)  not null unique comment '카테고리명',
    description			varchar(200) default null comment '설명',
    created_at			timestamp default current_timestamp -- 생성시간 (INSERT 시 DB 서버 현재 시각 자동 기록)
) engine=InnoDB default charset=utf8mb4			-- 트랜잭션, FK지원, 한글 문자셋 
  comment='상품 카테고리';

-- 3. 회원 테이블 
create table members (
	id			bigint  auto_increment primary key,
    username	varchar(50)	not null unique comment '아이디',
    email		varchar(100) not null unique comment '이메일',
    password	varchar(255) not null comment '비밀번호 (해시)',
    name		varchar(50) not null comment '이름',
    phone		varchar(20) default null comment '전화번호',
    city		varchar(50) default null comment '도시',
    status		enum('ACTIVE', 'DORMANT', 'WITHDRAWN') NOT NULL DEFAULT 'ACTIVE' comment '회원 상태',
			-- 정상 이용 중 / 장기 미로그인 휴면 / 탈퇴 완료; 허용된 3가지 값만 저장, 신규 가입 시 'ACTIVE' 자동 설정
    created_at	timestamp default current_timestamp, 	-- 가입 시각; INSERT 시 DB 서버 현재 시각 자동 기록
    updated_at  timestamp default current_timestamp on update current_timestamp -- 수정 시각; INSERT 시 현재시각 기록 + on update --> 행이 update 될때 마다 자동 갱신 
)engine=InnoDB default charset=utf8mb4			-- 트랜잭션, FK지원, 한글 문자셋 
  comment='회원 정보';

-- 4. 상품 테이블 
create table products(
	id			bigint	auto_increment primary key,   -- 상품 고유 식별자, insert 시 1씩 자동 증가 
    name		varchar(100) not null comment '상품명', 
	price		decimal(10,2) not null check (price >= 0) comment '가격', -- 최대 10자리,소수점 2자리   / 음수 불가 	
);










   