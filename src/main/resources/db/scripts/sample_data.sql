insert into "employee" values
    (nextval('employee_seq'),'Leslie','Andrews','leslie@email.com'),
	(nextval('employee_seq'),'Emma','Baumgarten','emma@email.com'),
	(nextval('employee_seq'),'Avani','Gupta','avani@email.com'),
	(nextval('employee_seq'),'Yuri','Petrov','yuri@email.com'),
	(nextval('employee_seq'),'Juan','Vega','juan@email.com');

insert into "members" values
    ('John', '{bcrypt}$2a$12$.SpUTCd.KgN4DM2Xg5mlbel0f7hYLVbElxsBkD5h7g.S3TawsFgQ.', 1),
    ('Mary', '{bcrypt}$2a$12$.SpUTCd.KgN4DM2Xg5mlbel0f7hYLVbElxsBkD5h7g.S3TawsFgQ.', 1),
    ('Susan', '{bcrypt}$2a$12$.SpUTCd.KgN4DM2Xg5mlbel0f7hYLVbElxsBkD5h7g.S3TawsFgQ.', 1);

update users set password = '{bcrypt}$2a$12$.SpUTCd.KgN4DM2Xg5mlbel0f7hYLVbElxsBkD5h7g.S3TawsFgQ.';

insert into "roles" values
    ('John', 'ROLE_EMPLOYEE'),
    ('Mary', 'ROLE_EMPLOYEE'),
    ('Mary', 'ROLE_MANAGER'),
    ('Susan', 'ROLE_EMPLOYEE'),
    ('Susan', 'ROLE_MANAGER'),
    ('Susan', 'ROLE_ADMIN');

select * from members;
select * from roles;