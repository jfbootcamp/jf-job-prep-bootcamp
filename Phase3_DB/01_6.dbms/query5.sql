-- != 또는 <> 연산자 <--- 같지 않은 값 조회 
-- 영화(film) 중  rating이 'G'가 아닌 영화만 출력하시오. (G등급이 아닌 영화)
-- film_id, title, rating 
select film_id, title, rating
from film
where rating != 'G';

-- G 등급(전체관람가)이 아닌 영화 개수 
select count(*) as cnt_not_g
from film
where rating != 'G';

-- 현재 비활성화된 고객 목록을 조회하시오.
-- custom_id, first_name, last_name, active
select customer_id, first_name, last_name, active
from customer
where active <> 1;

select count(*) as inactive_customer_count
from customer
where active <> 1;

-- 2005년 6월 1일 이후(포함)에 발생한 결재를 조회하시오.
select payment_id, payment_date
from payment
where payment_date >= '2005-06-01';

select count(*) as payment_count_from_2006_06_01
from payment
where payment_date >= '2005-06-01';


