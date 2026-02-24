-- Oracle 에만 있는 가상 테이블 DUAL (MYSQL에는 없음)
SELECT 1 FROM DUAL;
SELECT 'Hello Oracle' FROM dual;

-- 현재 접속 계정 확인
SELECT USER FROM dual;

-- 현재 날짜/시간 
SELECT sysdate FROM dual;
SELECT systimestamp FROM dual;

-- 내 계정 소유 테이블 목록 (MySQL의 show tables 대신)
SELECT table_name FROM user_tables;

-- 내 계정 소유 시퀀스 목록 (Oracle은 AUTO_INCREMENT 대신 시퀀스 사용)
SELECT sequence_name FROM user_sequences;

-- 오라클 버전 확인
SELECT * FROM v$version WHERE banner LIKE 'Oracle%';

-- 문자열 연결 (MySQL은 concat(), Oracle은 ||)
SELECT 'Hello' || ' ' || USER FROM dual;

-- 현재 날짜에서 7일 후
SELECT sysdate + 7 FROM dual;

-- NULL 처리 (MySQL의 ISNULL 대신 NVL)
SELECT NVL(NULL, '기본값') FROM dual; 













