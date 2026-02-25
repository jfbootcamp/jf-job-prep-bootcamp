-- 1. 데이터 베이스 생성
drop database if exists library_db;
create database library_db
	character set utf8mb4			-- 이모지 포함 다국어 저장 (4바이트 유니코드)
    collate utf8mb4_unicode_ci;		-- 대소문자 구분 없는 유니코드 정렬 규칙 

use library_db;

-- 2. 회원 테이블 (Entity: 회원)
create table members (
	id			bigint   auto_increment	primary key,				-- 자동 증가 기본키 (1, 2, 3....)
    name		varchar(50)		not null comment '회원 이름',			-- 가변 문자열 최대 50자, NULL 불허 
	email		varchar(100)	not null unique comment '이메일 (고유)',	-- unique: 중복 이메일 방지
    phone		varchar(20)		default null comment '전화번호',			-- default null : 선택 입력 항목
    address		varchar(200)	default null comment '주소',				-- 선택 입력 항목
    join_date	date			not null default (curdate()) comment '가입일',	-- curdate(): 오늘 날짜 자동 입력
    created_at	timestamp		default current_timestamp,				-- 행 생성 시각 자동 기록: Insert 시 자동으로 현재 시각으로 갱신 (언제 만들어졌나)
    updated_at  timestamp		default current_timestamp on update current_timestamp  -- 행 수정 시각 자동 갱신, Update 시 자동으로 현재 시각으로 갱신 (마지막으로 언제 수정했냐) 
) engine=InnoDB default charset=utf8mb4
  comment='도서관 회원';


-- 3. 도서 테이블 (Entity: 도서)
CREATE TABLE books (
	id				bigint			auto_increment primary key,
    isbn			varchar(20)		not null unique comment 'ISBN 번호',
	title			varchar(200)	not null comment '도서 제목',
    author			varchar(100)	not null comment '저자',
    publisher		varchar(100)	default null comment '출판사',
	pub_year		year			default null comment '출판 연도',
    category		varchar(50)		default null comment '분류 (소설, 기술, 과학 등)',
    quantity		int				not null default 1 check(quantity >= 0)  comment '보유 수량',		-- check: 음수 방지, 기본값 1
    created_at	timestamp		default current_timestamp,				-- 행 생성 시각 자동 기록: Insert 시 자동으로 현재 시각으로 갱신 (언제 만들어졌나)
    updated_at  timestamp		default current_timestamp on update current_timestamp  -- 행 수정 시각 자동 갱신, Update 시 자동으로 현재 시각으로 갱신 (마지막으로 언제 수정했냐)     
)engine=InnoDB default charset=utf8mb4
  comment='도서 정보';

-- 4. 대출 테이블 (Entity : 대출)
-- 관계  
-- 회원(1) : 대출(N)                                          
-- 도서(1) : 대출(N)

create table loans (
	id			bigint			auto_increment	primary key,
    member_id	bigint			not null comment '대출 회원 (FK)',  -- FK: members 테이블 참조 
    book_id		bigint			not null comment '대출 도서(FK)',   -- FK: books  테이블 참조 
    load_date	date			not null default (curdate()) comment '대출일', -- curdate(): 오늘 날자 자동 입력
    due_date	date 			not null comment '반납 예정일',   -- 반납 기한 (필수 입력)
    return_date	date 			default null comment '실제 반납일 (null = 미반납)', -- null이면 아직 미반납 상태
    status		enum('대출중', '반납완료', '연체')		not null default '대출중',	-- ENUM : 허용된 값만 입력 가능
    created_at	timestamp		default current_timestamp,				-- 행 생성 시각 자동 기록: Insert 시 자동으로 현재 시각으로 갱신 (언제 만들어졌나)
    
    -- 외래키 제약조건 (ERD의 관계선을 SQL로 구현)
    constraint fk_loan_member foreign key(member_id)			-- member_id --> members.id 연결
		references members(id) on delete restrict on update cascade, 	-- restrict: 대출 있으면 회원 삭제 불가, cascade: PK 변경시 FK도 자동 변경
    constraint fk_loan_book foreign key(book_id)			    -- book_id --> books.id 연결
		references books(id) on delete restrict on update cascade												
)engine=InnoDB default charset=utf8mb4
  comment='대출 기록';










