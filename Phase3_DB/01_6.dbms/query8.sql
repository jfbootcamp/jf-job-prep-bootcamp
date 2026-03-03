SELECT * FROM film limit 5;

SELECT FILM_ID,
		TITLE AS 영화제목,
        rental_RATE AS 대여료,
        length AS 상영시간
FROM FILM
limit 10;

-- 중복 제거 DISTINCT
SELECT DISTINCT RATING 
FROM FILM;

SELECT COUNT(DISTINCT RATING) AS 등급수
FROM FILM;

-- special_features 열의 데이터를 그룹화 
-- DVD에 어떤 종류의 부가 영상 조합이 있는지 목록을 뽑는 쿼리 
SELECT special_features
FROM FILM
GROUP BY special_features;

-- rating 열의 데이터를 그룹화 
-- film 테이블에서 영화 등급(rating)의 고유한 값 목록을 조회
select rating
from film
group by rating;

-- special_features, rating 열 순서로 데이터를 그룹화 
-- film 테이블에서 DVD 특별 부가 영상과 영화 등급의 고유한 조합 목록을 조회하시오. 
-- DVD 제작 시 등급별로 어떤 부가 영상을 넣었는지 현황을 파악할 때 사용 
select special_features, rating
from film
group by special_features, rating;

-- select  순서는 보여주는 순서일 뿐, Group by가 같으면 결과 데이터는 동일함.
select rating, special_features
from film
group by rating, special_features;

-- 부가 영상 종류별로 영화가 각각 몇편인지 조회하시오.
select special_features, count(*) as cnt
from film
group by special_features;

-- 부가영상 + 등급 조합별로 영화가 몇 편인지를 카운팅하고 정렬하시오.
select special_features, rating, count(*) as cnt
from film 
group by special_features, rating
order by special_features, rating, cnt desc;

-- select  문과 group by 문의 열 이름을 달리할 경우 
-- 예) rating만 그룹화하면서 select에 special_featurese도 함께 조회하는 경우
select special_features, rating, count(*) as cnt
from film
group by special_features, rating;

-- rating 열에서 G인 데이터만 필터링 
-- 부가영상 + 등급 조합으로 그룹을 만든 뒤, 그 중 G등급만 골라내는 쿼리임.
select special_features, rating
from film 
group by special_features, rating
having rating = 'G';

-- special_features 열에서 데이터 개수가 70보다 큰 것만 필터링 하시오.
select special_features, count(*) as cnt
from film
group by special_features
having cnt > 70
;

-- 그룹화하지 않은 열을 having에서 필터링한 경우 (X)
select special_features, count(*) as cnt
from film
group by special_features
having rating = 'G'
;

-- 부가 영상과 등급별 영화 개수를 구하되, R 등급이면서 8편을 초과하는 그룹만 조회하시오.
select special_features, rating, count(*) as cnt
from film
group by special_features, rating
having rating = 'R'
;



