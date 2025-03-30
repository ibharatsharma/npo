select * from site_user;

INSERT INTO npo.site_user (password,username) VALUES
	 ('$2a$12$yo5SscRITQJhI93XSrSb.e2FhuGPfvM0Q0inV3242z0S7DpAhPWJK','ibharatsharma@gmail.com'),
	 ('$2a$12$yo5SscRITQJhI93XSrSb.e2FhuGPfvM0Q0inV3242z0S7DpAhPWJK','vijayatidke@gmail.com');

SELECT * FROM AUTHORITY;

DELETE FROM AUTHORITY where ID < 10;

insert into authority (id, name) values
(1, 'ADMIN'),
(2, 'LEADERSHIP'),
(3, 'LEAD'),
(4, 'COORDINATOR'),
(5, 'WORKER'),
(6, 'COMMS');
