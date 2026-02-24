select version() as 'MySQL 버전';

select now() as '현재 시각';

select user() as '접속 계정';
select current_user() as '인증 계정';

select database() as '현재 DB';

-- 문자셋 확인
-- select variables like 'character_set%';

-- 스토리지 엔진 확인 
show engines;

SELECT 1;

show tables;
