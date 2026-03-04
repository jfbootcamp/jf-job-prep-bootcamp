-- Join을 왜 쓰는가? 
-- customer 테이블에는 고객 이름, 이메일 등 기본 정보가 있지만 "실제 주소"는 없음 
-- 주소 정보는 address 테이블에 따로 저장되어 있음
-- customer 테이블에는 address_id(주소 번호)만 들어 있어서,
-- 이 번호를 열쇠 삼아 address 테이블과 연결(join)해야 실제 주소를 볼수 있음.

-- INNER JOIN = 양쪽 테이블 모두에 매칭되는 데이터만 가져옴 
-- ON a.address_id = b.address_id --> 이 조건으로 두 테이블을 연결 

-- 질의 : 이름이 ROSA인 고객의 기본 정보 (이름, 이메일 등)와 상세 주소 (주소, 지역, 우편번호, 전화번호)를 한번에 조회하시오.
select a.customer_id, a.store_id, a.first_name, a.last_name, a.email, a.address_id as a_address_id,
	b.address_id as b_address_id, b.address, b.district, b.city_id, b.postal_code, b.phone, b.location
from customer as a inner join address as b on a.address_id = b.address_id
where  a.first_name = 'ROSA';   

-- 
-- | 구분 			| 조인 조건 추가 (ON에 AND)               | 조인 테이블 추가 (INNER JOIN 추가)
-- | 목적            | 같은 두 테이블 사이에서 매칭을 더 엄격하게 됨 | 원하는 정보가 없어서 다른 테이블을 추가로 연결함
-- | 테이블 수        | 변화 없음 (2개 --> 2개)                |증가 (2개 --> 3개 --> ...)
-- | 결과            | 행이 줄어듦 (조건이 까다로워짐)            | 열이 늘어남 (새 테이블의 컬럼을 가져옴)


-- 질의 : 이름이 ROSA인 고객 중 고객 생성일과 주소 최종 수정일이 같은 경우의 고객 정보와 주소를 조회하시오. 
select a.customer_id, a.first_name, a.last_name,
	b.address_id, b.address, b.district, b.postal_code
FROM customer as a join address as b on a.address_id = b.address_id and a.create_date = b.last_update
where a.first_name = 'ROSA';

-- 테이블을 3개 이상 연결(join)할 수 있음.
-- customer -> address -> city 순서로 체인처럼 연결됨 
-- customer에는 address_id만 있고, address에는 city_id만 있음
-- 실제 도시 이름(city)은 city 테이블에 있으므로, 3개를 모두 연결해야 조회할 수 있음 
-- 첫번째 join: customer <--> address (address_id로 연결)
-- 두번째 join: address <--> city (city_id로 연결)

-- 질의 : 이름이 ROSA인 고객의 기본 정보, 주소, 그리고 도시 이름까지 한 번에 조회하시오. 
select a.customer_id, a.first_name, a.last_name,
	b.address_id, b.address, b.district, b.postal_code,
    c.city_id, c.city
from customer as a
	inner join address as b on a.address_id = b.address_id
    inner join city as c on b.city_id = c.city_id
where a.first_name = 'ROSA';


-- LEFT OUTER JOIN이란?
-- INNER JOIN은 양쪽 테이블 모두에 매칭되는 데이터만 가져옴 
-- LEFT OUTER JOIN은 왼쪽 테이블(address)의 데이터는 "전부" 가져오고, 
-- 오른쪽 테이블(store)에 매칭되는 게 없으면 NULL로 채움 
-- address는 603개 행, store는 2개 행 --> 대부분의 주소에는 매장이 없으므로 NULL이 많이 나옴  

-- 질의 : 모든 주소 목록을 조회하되, 해당 주소에 매장(store)이 있으면 매장 정보도 함께 출력하시오. 
select a.address, a.address_id as a_address_id,
		b.address_id as b_address_id, b.store_id
FROM address as a left outer join store as b on a.address_id = b.address_id;


-- LEFT OUTER JOIN + WHERE NULL로 "매칭 안되는 것만" 조회하기 
-- 매장이 없는 주소는 store쪽이 NULL임 
-- WHERE b.address_id is null을 추가하면 "매장이 없는 주소만" 조회가능
-- 핵심: LEFT JOIN + WHERE IS NULL 은 실무에서 자주 쓰는 패턴임 
-- "A에는 있는데 B에는 없는 데이터"를 찾을때 사용됨 
-- 예) 주문 내역이 없는 고객, 담당자가 배정 안된 프로젝트 등   

-- 질의 : 매장(store)이 없는 주소만 조회하시오.
select a.address, a.address_id as a_address_id,
		b.address_id as b_address_id, b.store_id
FROM address as a left outer join store as b on a.address_id = b.address_id
where b.address_id is null;



-- RIGHT OUTER JOIN이란?
-- LEFT OUTER JOIN의 반대 방향임 
-- LEFT는 왼쪽 테이블을 전부 살렸다면, RIGHT는 오른쪽 테이블을 전부 살림 
-- 오른쪽인 store(매장) 테이블의 데이터를 전부 가져오고, 
-- 왼쪽인 address에 매칭되는 게 없으면 NULL로 채움 
-- 실무에서는 대부분 LEFT JOIN만 쓰고, RIGHT JOIN은 잘 안씀 

-- 질의 : 모든 매장(store) 목록을 조회하되, 해당 매장의 주소 정보도 함께 조회 하시오  
select a.address, a.address_id as a_address_id,
		b.address_id as b_address_id, b.store_id
from address as a right outer join store as b on a.address_id = b.address_id;


-- RIGHT OUTER JOIN + WHERE NULL로 "매칭 안되는 것만" 골라냄 
-- LEFT JOIN + WHERE IS NULL과 같은 원리, 방향만 반대임 
-- RIGHT JOIN이므로 오른쪽 테이블(address)은 전부 나오고, 왼쪽 테이블(store)에 매칭 안되는 것은 NULL이 됨 
-- 여기에 WHERE a.address_id IS NULL을 추가하면 "매장이 없는 주소만" 조회할수 있음  

-- 질의 : 매장(store)이 배정되지 않은 주소만 조회하시오. 
select a.address_id as a_address_id,
		b.address, b.address_id as b_address_id
FROM store as a right outer join address as b on a.address_id = b.address_id
where a.address_id is null;


-- 샘플 데이터 생성
create TABLE doit_cross1(num int);
create TABLE doit_cross2(name varchar(10));

insert into doit_cross1 values(1),(2),(3);
insert into doit_cross2 values('Do'),('It'),('SQL');

-- cross join
-- on 조건없이, 왼쪽의 모든 행 * 오른쪽의 모든 행을 조합함 
-- doit_cross1에 3개(1,2,3), doit_cross2에 3개(Do, It, SQL) --> 결과는 3 * 3 = 9행 
-- 비유: 상의 3벌(빨강, 파랑, 검정)과 하의 3벌(청바지, 슬랙스, 반바지)의 모든 조합을 만드는 것 --> 3 * 3 = 9가지 코디가 나옴
select a.num, b.name
from doit_cross1 as a cross join doit_cross2 as b
order by a.num;


select a.num, b.name
from doit_cross1 as a cross join doit_cross2 as b
where a.num = 1;


-- self join이란
-- 지금까지는 서로 다른 테이블끼리 join함 
-- customer as a, customer as b  --> 같은 테이블이지만 별칭을 다르게 줘서 마치 2개인 처럼 사용 

-- 질의 : customer 테이블을 2장 복사 (a, b)해서 같은 고객 번호 끼리 연결하고, 
-- 양쪽 고객 번호를 나란히 보여주시오. 
-- 결국 자기 자신과 매칭됨 
select a.customer_id as a_cutomer_id, b.customer_id as b_customer_id
from customer as a  inner join customer as b on a.customer_id = b.customer_id;  

-- 질의 : 모든 결재 내역에 대해, 현재 금액과 바로 다음 결재 금액, 그리고 금액 차이를 조회하시오.
-- 금액 변화량 = 다음 결재 금액 - 현재 결재 금액 
select a.payment_id, a.amount, b.payment_id, b.amount, b.amount - a.amount as profit_amount
from payment as a left outer join payment as b on a.payment_id = b.payment_id - 1; 














