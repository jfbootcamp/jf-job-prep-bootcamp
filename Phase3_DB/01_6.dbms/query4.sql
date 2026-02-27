-- sakila db 탐색 
-- 목적 : sakila 데이터베이스 구조와 데이터를 직접 확인 

use sakila;

show tables;

-- 테이블 상세 정보 조회 
show table status;

-- 고객 테이블 
desc customer;

-- 영화 테이블 
desc film;

SELECT FIRST_NAME FROM CUSTOMER;

SELECT FIRST_NAME, LAST_NAME FROM CUSTOMER;

SELECT * FROM CUSTOMER;

SHOW columns FROM sakila.customer;

-- WHERE 문
SELECT * FROM customer 
WHERE first_name = 'MARIA';

SELECT * FROM customer 
WHERE address_id = 200;

SELECT * FROM customer 
WHERE address_id < 200;

select * FROM payment
WHERE payment_date between '2005-06-17' AND '2005-07-19';

-- select * (모든 컬럼 조회) 구조 파악이나 빠른 확인에만 사용.
select * from film limit 5;   -- limit으로 5건만 확인

-- 테이블 컬럼 구조 확인 
show columns from sakila.customer;
describe film;
desc film;

-- AS 별칭(Alias) 
-- AS : 컬럼명이나 테이블명에 임시 이름을 붙임 
-- AS 키워드는 생략 가능하지만 가독성을 위해 쓰는 것 권장 

select film_id,
		title					AS 영화제목,
        length					AS 상영시간_분,
        length / 60.0			AS 상영시간_시간,
        rental_rate				AS 일일요금,
        rental_rate * 7 		AS 일주일요금,
        rental_rate * 30 		AS 한달요금
from film
limit 10;

-- OR
select * 
from customer
where first_name = 'MARIA' or first_name = 'LINDA' or first_name = 'NANCY';

-- IN을 활용한 데이터 조회 
select * 
from customer
where first_name IN ('MARIA', 'LINDA', 'NANCY');

-- NULL 데이터 조회
select *
FROM address
where address2 is null;

select *
FROM address
where address2 is not null;
