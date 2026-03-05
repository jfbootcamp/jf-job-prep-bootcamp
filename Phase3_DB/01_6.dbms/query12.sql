-- 
select count(*) from customer;    -- 테이블 전체 행 수 반환 (null 포함)

-- store_id별 묶어서 각 매장에 고객이 몇 명인지 집계 
-- group by는 집계함수와 세트로 사용함 
select  store_id, count(*)
from customer
group by store_id;

-- 매장별 + 활성여부별 조합으로 묶어서 각 조합에 해당하는 고객 수를 집계 하시오.
select store_id, active, count(*)
from customer
group by store_id, active;

-- 담당직원별, 월별 매출이 얼마야?
-- month(payment_date) : 날짜 정보에서 월 숫자만 추출함 
select staff_id, month(payment_date) as month, sum(amount) as total
from payment
group by staff_id, month(payment_date)  -- 직원별로 묶고, 그 안에서 월 숫자(1~12)별로 다시 묶음
order by staff_id, month;	-- 담당직원별 월별 매출 합계를 집계 

-- null을 제외한 집계 확인
select count(*) as all_cnt, count(address2) as ex_null
from address;

select count(*), count(store_id), count(distinct store_id)
from customer;

-- 문제 1: 결재 횟수가 35회 이상인 고객만 조회하시오. <--- 자주 오는 단골 고객은 누구인가? 
select 
	customer_id,
    count(*) as payment_count 	-- 고객별 결제 횟수 
from payment
group by customer_id 
having count(*) >= 35		--  집계결과에 조건 --> having 으로만 가능
order by payment_count desc;		-- 많이 결재한 순서대로 

-- 문제 2: "2005년 7월에 결제한 고객 중, 총 결제액이 100달러 이상인 고객은 누구인가? "
-- 결론 : "다음 달 1일 미만(<)" 패턴이 가장 안전
-- payment_date < '2005-08-01 00:00:00'
-- payment_date <= '2005-07-31 00:00:00' (시간을 생략시 자정으로 채워짐)

select 
	customer_id,
    sum(amount) 		as total_paid,		-- 해당 기간 내 총 결제액
    count(*)			as payment_count	-- 해당 기간 내 결제 횟수 
from payment
where payment_date >= '2005-07-01' and payment_date < '2005-08-01'
group by customer_id 
having sum(amount) >= 100
order by total_paid desc;







