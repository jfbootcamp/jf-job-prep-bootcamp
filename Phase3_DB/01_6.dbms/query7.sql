select * 
FROM customer
where first_name like 'A%';

select * 
FROM customer
where first_name like 'AA%';

select * 
FROM customer
where first_name like '%A';

select * 
FROM customer
where first_name like '%RA';

select * 
FROM customer
where first_name like '%A%';

select * 
FROM customer
where first_name not like 'A%';

-- 특수 문자를 포함한 임의의 테이블 생성
-- with CTE (Common Table Expression) : 임시 테이블을 만들어서 바로 쓰는 것
-- 쿼리 안에서만 쓰는 임시 테이블, 쿼리가 끝나면 사라짐 
-- 연습용 데이터 3개 
-- union all : SELECT 결과를 위아래로 합치는 것 (줄 추가)
-- A%BC <--- %가 포함된 문자열, A_BC <--- =_가 포함된 문자열
-- WITH CTE (col_1) AS (...)
-- SELECT * FROM CTE

with CTE (col_1) as (
select 'A%BC' union ALL 
select 'A_BC' union ALL
SELECT 'ABC'
)
select * FROM CTE;

-- 특수 문자 %를 포함한 데이터를 조회하시오.
with CTE (col_1) as (
select 'A%BC' union ALL 
select 'A_BC' union ALL
SELECT 'ABC'
)
-- LIKE '%'는 "아무 문자열이나 다 통과"라는 뜻이므로 3개 전부 나옴. 
-- %를 특수문자가 아닌 와일드 카드로 인식하기 때문임.
select * FROM CTE WHERE col_1 like '%';

-- %는 와일드카드가 아니라 진짜 % 글자야라고 sql에게 알려줘야함 
-- #을 신호문자(ESCAPE '#')로 정함, #% --> 진짜 % 글자로 인식 
-- '%#%%' --> %(아무거나)  + #%(진짜 %)   + %(아무거나) <--- "문자열 어딘가에 %가 들어있는 데이터"

with CTE (col_1) as (
select 'A%BC' union ALL 
select 'A_BC' union ALL
SELECT 'ABC'
)
select * FROM CTE WHERE col_1 like '%#%%' escape '#';

-- escape와 !로 특수 문자 %를 포함한 데이터 조회하시오.
with CTE (col_1) as (
select 'A%BC' union ALL 
select 'A_BC' union ALL
SELECT 'ABC'
)
select * FROM CTE WHERE col_1 like '%!%%' escape '!';

-- A로 시작하면서 문자열 길이가 2인 데이터를 조회하시오.
select * FROM customer
where first_name like 'A_';

-- A로 시작하면서 문자열 길이가 3인 데이터를 조회하시오.
select * FROM customer
where first_name like 'A__';

-- A로 끝나면서 문자열 길이가 3인 데이터 조회하시오.
select * FROM customer
where first_name like '__A';

-- A로 시작하고 A로 끝나면서 문자열 길이가 4인 데이터 조회하시오.
select * FROM customer
where first_name like 'A__A';

-- 문자열 길이가 5인 데이터 조회하시오.
select * FROM customer
where first_name like '____';

-- A_R로 시작하는 문자열을 조회하시오.
select * FROM customer
where first_name like 'A_R%';

-- __R로 시작하는 문자열을 조회하시오.
select * FROM customer
where first_name like '__R%';

-- A로 시작하면서 R_로 끝나는 문자열을 조회하시오.
select * FROM customer
where first_name like 'A%R_';

-- REGEXP는 LIKE보다 강력한 패턴 검색 (정규표현식)
-- ^ = 시작, $ = 끝, | = 또는 
-- '^K|N$'
-- K로 시작하거나 N으로 끝나는 이름을 조회하시오.
select * FROM customer
where first_name REGEXP '^K|N$';

-- KL..., KM..., KN... 같은 이름이 조회되도록 작성하시오.
-- [L-N] = L, M, N 중 하나 
-- 'K[L-N]' --> 이름 어딘가에 KL, KM, KN이 포함된 이름을 찾음 
-- 주의 : REGEXP는 LIKE와 다르게 문자열 "어디든" 패턴이 있으면 매칭됨! 
select * FROM customer
where first_name regexp 'K[L-N]';

-- [^...]
-- [^L-N] = L,M,N을 제외한 글자 
-- 'K[^L-N]' --> K 다음 글자가 L, M, N이 아닌 이름을 찾음 
select * FROM customer
where first_name regexp 'K[^L-N]';

-- %와 [...]을 사용해 데이터 조회하시오 
-- LIKE와 REGEXP를 AND로 조합해서 사용함 
-- LIKE 'S%' --> S로 시작하는 이름 중에서 
-- REGEXP 'A[L-N]' --> 이름 어딘가에 AL, AM, AN이 포함된 이름을 찾기 
select * FROM customer
where first_name LIKE 'S%' AND first_name regexp 'A[L-N]';

-- 와일드카드 조합으로 데이터를 조회하시오.
-- 3가지 조건을 AND로 모두 만족하는 이름을 찾으시오.
-- LIKE '_______' -> 글자 수가 정확히 7개 (_가 7개)
-- REGEXP 'A[L-N]' -> 이름 어딘가에 AL, AM, AN이 포함된 이름을 찾기 
-- REGEXP 'O$' -> O으로 끝나는 이름 찾기  

select * FROM customer
where first_name LIKE '_______' 
AND first_name regexp 'A[L-N]'
AND first_name REGEXP 'O$';






