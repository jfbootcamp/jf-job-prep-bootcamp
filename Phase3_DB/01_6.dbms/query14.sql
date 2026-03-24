-- 1. 데이터 베이스 생성
drop database if exists sboot;
create database sboot
	character set utf8mb4			-- 이모지 포함 다국어 저장 (4바이트 유니코드)
    collate utf8mb4_unicode_ci;		-- 대소문자 구분 없는 유니코드 정렬 규칙 

use sboot;

-- 2. book 테이블 생성
drop table if exists book;
create table book (
	id		bigint	auto_increment primary key,
    title	varchar(200)	not null,
    price	int				not null,
    author	varchar(100)	not null,
    page 	int				not null,
	created_at	datetime	default now()
);


INSERT INTO sboot.book
(title, price, author, page, created_at)
VALUES('AI와 함께', 30000, '이순신', 2000, CURRENT_TIMESTAMP);

INSERT INTO sboot.book
(title, price, author, page, created_at)
VALUES('Agent와 AI', 20000, '김순신', 1000, CURRENT_TIMESTAMP);

INSERT INTO sboot.book
(title, price, author, page, created_at)
VALUES('스프링과 함께', 40000, '박순신', 5000, CURRENT_TIMESTAMP);

select * from book;

select * from book where id = 3;

UPDATE sboot.book
SET title='AI와 춤을', price=25000, author='최순신', page=2300, created_at=CURRENT_TIMESTAMP
WHERE id=1;


INSERT INTO sboot.book
(title, price, author, page, created_at)
VALUES('AI와 LLM', 30000, '단종', 3000, now());

DELETE FROM sboot.book
WHERE id=1;

create database if not exists helloboot default character set utf8mb4 collate utf8mb4_unicode_ci;







