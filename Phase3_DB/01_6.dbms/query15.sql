INSERT INTO helloboot.`member` (password, `role`, username)
VALUES('1234', 'user', '이순신');
INSERT INTO helloboot.`member` (password, `role`, username)
VALUES('1234', 'user', '신사임당');


drop database if exists bookdb;
create database bookdb
	character set utf8mb4			-- 이모지 포함 다국어 저장 (4바이트 유니코드)
    collate utf8mb4_unicode_ci;		-- 대소문자 구분 없는 유니코드 정렬 규칙 
    
drop database if exists onepassdb;
create database onepassdb
	character set utf8mb4			-- 이모지 포함 다국어 저장 (4바이트 유니코드)
    collate utf8mb4_unicode_ci;		-- 대소문자 구분 없는 유니코드 정렬 규칙     
    
drop database if exists bookjpa;
create database bookjpa
	character set utf8mb4			-- 이모지 포함 다국어 저장 (4바이트 유니코드)
    collate utf8mb4_unicode_ci;		-- 대소문자 구분 없는 유니코드 정렬 규칙     
    
select user, host from mysql.user;

SELECT user, host FROM mysql.user WHERE user='onepass';

    
CREATE USER 'onepass'@'%' IDENTIFIED BY 'hometop402';
GRANT ALL PRIVILEGES ON *.* TO 'onepass'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;    

SHOW GRANTS FOR 'onepass'@'%';


GRANT CREATE, DROP ON *.* TO 'onepass'@'%';
FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON *.* TO 'onepass'@'%' WITH GRANT OPTION;


GRANT ALL PRIVILEGES ON onepassdb.* TO 'onepass'@'%';
FLUSH PRIVILEGES;





