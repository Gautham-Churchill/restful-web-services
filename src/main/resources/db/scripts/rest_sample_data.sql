insert into "employee" values
    (nextval('employee_seq'),'Leslie','Andrews','leslie@email.com'),
	(nextval('employee_seq'),'Emma','Baumgarten','emma@email.com'),
	(nextval('employee_seq'),'Avani','Gupta','avani@email.com'),
	(nextval('employee_seq'),'Yuri','Petrov','yuri@email.com'),
	(nextval('employee_seq'),'Juan','Vega','juan@email.com');

insert into "members" values
    ('john', '{bcrypt}$2a$12$IW.TGTbzch4z7mVv3wZVTOlcjABrfD/Hx/3jGlFMLndIRE.pnwkyG', 1),
    ('mary', '{bcrypt}$2a$12$IW.TGTbzch4z7mVv3wZVTOlcjABrfD/Hx/3jGlFMLndIRE.pnwkyG', 1),
    ('susan', '{bcrypt}$2a$12$IW.TGTbzch4z7mVv3wZVTOlcjABrfD/Hx/3jGlFMLndIRE.pnwkyG', 1);

update users set password = '{bcrypt}$2a$12$.SpUTCd.KgN4DM2Xg5mlbel0f7hYLVbElxsBkD5h7g.S3TawsFgQ.';

insert into "roles" values
    ('john', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_MANAGER'),
    ('susan', 'ROLE_EMPLOYEE'),
    ('susan', 'ROLE_MANAGER'),
    ('susan', 'ROLE_ADMIN');

select * from members;
select * from roles;