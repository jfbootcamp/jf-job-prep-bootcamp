select *
from country
where country_id in (86, 103);

-- and는 or보다 우선순위가 높음 (곱셈이 덧셈보다 먼저인 것과 같음)
-- 해석 과정
-- 1단계: SQL이 AND를 먼저 계산함 --> 한국이면서 도시가 Cheju인 행만 통과
-- 2단계: 그 결과를 OR로 합침 --> 미국이면서 도시 이름 조건 없이 무조건 통과  
-- 질문 : 미국(103) 또는 한국(86)의 도시 중 Cheju, Sunnyvale, Dallas를 조회하시오.
select *
from city
where country_id = 103 or 
country_id = 86 and city in ('Cheju', 'Sunnyvale', 'Dallas')
;

--
select * 
from city 
where country_id = 86 or
country_id = 103 and city in ('Cheju', 'Sunnyvale', 'Dallas')
;
-- 괄호 ()를 쓰면 해결됨.
select *
from city
where (country_id = 103 or country_id = 86) 
and city in ('Cheju', 'Sunnyvale', 'Dallas');

-- in을 쓰면 같은 결과를 얻을 수 있음 
select *
from city
where country_id in (103, 86) 
and city in ('Cheju', 'Sunnyvale', 'Dallas');


-- ORDER BY 
select *
FROM customer
order by first_name;

select *
FROM customer
order by last_name;

select *
FROM customer
order by store_id, first_name, last_name;

select *
FROM customer
order by first_name, store_id;

select *
FROM customer
order by first_name desc;

-- store_id는 큰 번호부터, first_name은 알파펫 순으로 정렬하시오.
select *
FROM customer
order by store_id desc, first_name asc;

-- LIMIT으로 상위 10개의 데이터 조회하시오 
select *
FROM customer
order by store_id desc, first_name asc 
limit 10;

-- LIMIT으로 101번째부터 10개의 데이터를 조회하시오.
-- limit 뒤의 숫자 2개: LIMIT 건너뛸 수, 가져올 수
-- limit 100, 10 --> 앞의 100개를 건너띄고, 그 다음 10개를 가져옴 (101~110번째)
select *
FROM customer
order by customer_id asc limit 100, 10;

-- 데이터 100개를 건너띄고 데이터 10개 조회 
select *
FROM customer
order by customer_id asc limit 10 offset 100;





