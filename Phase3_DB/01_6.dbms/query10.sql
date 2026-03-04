-- 질의 : rental_RATE가 전체 평균보다 비싼 영화를 조회하시오.
SELECT avg(rental_RATE)
FROM FILM;

SELECT title, rental_rate
FROM FILM
where rental_rate > (SELECT avg(rental_RATE) FROM FILM);

-- 질의 : 결재 기록이 있는 고객의 first_name을 조회하시오. 
select distinct customer_id from payment;

select first_name, customer_id from customer
where customer_id in (select distinct customer_id from payment);


-- 질의 : film_id가 1번인 영화와 대여료(rental_rate)와 상영시간(lenth)이 모두 같은 영화의 
-- 제목을 조회하시오.
select rental_rate, length
from film 
where film_id = 1;

select rental_rate, length from film  where film_id = 1;

select title from film
where (rental_rate, length) = (select rental_rate, length from film  where film_id = 1);

-- 질의 : 영화 등급(rating)별 영화 수를 구하여, 영화 수가 많은 순서대로 상위 3개 등급과 그 영화 수를 조회하시오.
-- 1단계 : 서브쿼리 
select rating, count(*) as cnt
from film 
group by rating;

select rating, count(*) as cnt from film group by rating;

-- 2단계 : 가상 테이블 t 생성 
select rating, cnt from t;

-- 3단계: 메인 쿼리 실행
select rating, cnt
from (select rating, count(*) as cnt from film group by rating) as t
order by cnt desc limit 3;

-- 질의1 : 전체 결재 금액의 평균보다 높은 결재 내역을 모두 조회하시오.
-- 질의2 : 전체 결재 금액의 평균보다 높은 결재 내역의 건수를 조회하시오.












