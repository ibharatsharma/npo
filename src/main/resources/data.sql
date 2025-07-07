select * from site_user;

INSERT INTO npo.site_user (password,username) VALUES
	 ('$2a$12$yo5SscRITQJhI93XSrSb.e2FhuGPfvM0Q0inV3242z0S7DpAhPWJK','ibharatsharma@gmail.com'),
	 ('$2a$12$yo5SscRITQJhI93XSrSb.e2FhuGPfvM0Q0inV3242z0S7DpAhPWJK','vijayatidke@gmail.com');

SELECT * FROM AUTHORITY;
-- delete from authority where id < 10;
insert into authority (id, name) values
(1, 'SUPER_ADMIN'),
(2, 'ADMIN'),
(3, 'LEADERSHIP'),
(4, 'LEAD'),
(5, 'COORDINATOR'),
(6, 'WORKER'),
(7, 'COMMS');


insert into user_authorities values(1,2);

select * from site_user;
