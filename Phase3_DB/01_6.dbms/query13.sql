-- 문제 1. 매장별로 활성/비활성 고객 수를 한 행에 출력하시오.
select
		store_id,										-- 매장 번호 
        count(*)				as total_customers,		-- 매장 전체 고객 수
        sum(CASE WHEN active = 1 THEN 1 ELSE 0 END)  as active_customers, -- 활성 고객 수 
        -- CASE WHEN active = 1: 활성이면 1, 아니면 0 --> sum하면 활성 고객수 
        sum(CASE WHEN active = 0 THEN 1 ELSE 0 END)  as inactive_customers,  -- 비활성 고객 수
		-- CASE WHEN active = 0: 비활성이면 1, 아니면 0 --> sum하면 비활성 고객수	        
        round(
			sum(CASE WHEN active = 1 THEN 1 ELSE 0 END) / COUNT(*) * 100  
			, 1	)                                   as active_rate   -- 활성 고객 비율(%)-- CASE WHEN active = 1: 활성이면 1, 아니면 0 --> sum하면 활성 고객수 
from customer
group by store_id
;

-- 문제 2. 직원별 월별 매출을 열(컬럼)로 피벗형식으로 출력하시오.
-- month(payment_date): 결재일에서 월 숫자만 추출 (1~12)
select
		staff_id,
        sum(CASE WHEN month(payment_date) = 5 THEN amount ELSE 0 END) AS may_sales,
        sum(CASE WHEN month(payment_date) = 6 THEN amount ELSE 0 END) AS jun_sales,
        sum(CASE WHEN month(payment_date) = 7 THEN amount ELSE 0 END) AS jul_sales,
        sum(CASE WHEN month(payment_date) = 8 THEN amount ELSE 0 END) AS aug_sales,
        sum(amount)													  AS total_sales
FROM payment
GROUP BY staff_id;

-- 문제 3. 고개 종합 리포트 (지표)
-- datediff(나중날짜, 이전날짜) = 두 날짜 사이의 일수 
select
		c.customer_id,
        concat(c.first_name, ' ', c.last_name) AS full_name,
        count(p.payment_id)					  AS total_payments,	 -- 이 고객의 총 결재 수
        round(sum(p.amount),2)                AS total_spent,        -- 이 고객이 지금까지 낸 총 금액
        round(avg(p.amount),2)                AS avg_per_payment,    -- 1회 평균 결재액 (마케팅에서 자주 쓰는 지표) 
		round(min(p.amount), 2)	              AS min_payment,        -- 가장 적게 낸 1건의 금액 
        round(max(p.amount), 2)	              AS max_payment,        -- 가장 많이 낸 1건의 금액 
		min(p.payment_date)					  AS first_payment,		 -- 가장 이른 날짜 = 첫 결재일
        max(p.payment_date)                   AS last_payment,       -- 가장 최근 날짜 = 마지막 결재일
        datediff(max(p.payment_date), min(p.payment_date))     AS active_days   -- 두 날짜 사이의 일수 = 이 고객의 활동일
        
from customer c 
join payment p on c.customer_id = p.customer_id
group by c.customer_id, full_name
order by total_spent desc
limit 10
;


-- 문제 4:   대여 건수 TOP 10 영화 (가장 많이 대여된 영화는? + 대여된 총 횟수)
select 
		f.film_id,
        f.title, 
        count(r.rental_id)  AS rental_count 		--  이 영화가 대여된 총 횟수 
from film f
join inventory i on f.film_id = i.film_id
join rental r on i.inventory_id = r.inventory_id
group by f.film_id, f.title			-- 영화별로 묶어서 대여 횟수 집계
order by rental_count desc 			-- 많이 대여된 순 
LIMIT 10;


-- 문제 5: 카테고리별 대여 건수 TOP 5 (가장 인기 있는 장르는?)
select
		c.name				as category_name,
        count(r.rental_id)  as rental_count,
        round(sum(p.amount), 2) as total_revenue
from category c 
join film_category fc on c.category_id = fc.category_id		-- 카테고리 --> 영화-카테고리 매핑
join film f			  on fc.film_id    = f.film_id			-- 매핑 -> 영화 
join inventory i	  on f.film_id = i.film_id				-- 영화 -> 재고
join rental r		  on i.inventory_id = r.inventory_id    -- 재고 -> 대여 
join payment p		  on r.rental_id = p.rental_id 			-- 대여 -> 결재 	
group by c.category_id, c.name
order by rental_count desc 
limit 5;




