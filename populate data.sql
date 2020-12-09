INSERT INTO Account
VALUES 
	(1, 'kha.tran', '123456789', 'MANAGER'),
    (2, 'xuan.mai', 'maixuan123', 'MANAGER'),
    (3, 'gia.huy', 'dinhgiahuy', 'LECTURER'),
    (4, 'minh.tam', 'taminhtam123', 'LECTURER'),
    (5, 'bao.tran', 'qwerty', 'LECTURER'),
    (6, 'gia.bao', 'akjdhasd', 'LECTURER'),
    (7, 'minh.thuy', 'hagdjahdg', 'STUDENT'),
    (8, 'chau.tran', 'kjadhkajhdka', 'STUDENT'),
    (9, 'csdl', 'k18181', 'STUDENT'),
    (10, 'akasjdakjsd','asda', 'STUDENT'),
    (11, 'qwertyui', 'sdfghjk', 'STUDENT'),
    (12, 'khakhakhakah', 'khakahkahakha', 'STUDENT');
    
INSERT INTO Employee
VALUES
	('100', 'kha', 'tran', 'kha.tran1509@hcmut.edu.vn','0943073127'),
    ('101', 'xuan', 'mai', 'mai.xuan@hcmut.edu.vn','0123456789'),
    ('102', 'gia', 'huy', 'huy.dinh@hcmut.edu.vn','0123784545'),
    ('103', 'minh', 'tam', 'minhtam@hcmut.edu.vn','0943073348'),
    ('104', 'bao', 'tran', 'baotran@hcmut.edu.vn','0954123427'),
    ('105', 'gia', 'bao', 'baogia@hcmut.edu.vn','0510231564');
    
INSERT INTO Manager
VALUES 
	('100'),
    ('101');
    
INSERT INTO Subject
VALUES
	('AA0000', 'HCSDL'),
    ('AA0001', 'PPL'),
    ('BB0000', 'Ky thuat lap trinh');
    
INSERT INTO Lecturer
VALUES
	('102', 'AA0000'),
    ('103', 'AA0001'),
    ('104', 'BB0000'),
    ('105', 'AA0000');
    
INSERT INTO Student
VALUES
	('10000000', 'trinh', 'bao', 'bao@gmail.com'),
    ('10000001', 'chau', 'truong', 'chau@gmail.com'),
    ('10000002', 'khiem', 'dinh', 'khiem@gmail.com'),
    ('10000003', 'nam', 'huynh', 'nam@gmail.com'),
    ('10000004', 'kha', 'bao', 'khabao@gmail.com'),
    ('10000005', 'maimai', 'xuan', 'maimaixuan@gmail.com');
    
INSERT INTO descriptioncontent
VALUES 
	(1),
    (2),
    (3),
    (4),
    (5);

INSERT INTO Question
VALUES
	(1, 'Truong DHBK co bao nhieu co so: ', 'E', 1),
    (2, 'Viet Nam co bao nhieu tinh: ', 'E', 1),
    (3, 'Bac Ho sinh nam bao nhieu: ', 'M', 1),
    (4, 'Bach Khoa co bao nhieu mon hoc: ', 'M', 1),
    (5, 'CSE co bao nhieu sinh vien: ', 'H', 1),
    (6, 'DHBK co bao nhieu sinh vien: ', 'H', 1);

INSERT INTO Answer
VALUES
	('A', 1, '2',1,2),
    ('B', 1, '3',0,2),
    ('C', 1, '4',0,2),
    ('D', 1, '5',0,2),
    ('A', 2, '61',0,2),
    ('B', 2, '62',0,2),
    ('C', 2, '63',1,2),
    ('D', 2, '64',0,2),
    ('A', 3, '1980',0,2),
    ('B', 3, '1089',0,2),
    ('C', 3, '1890',1,2),
    ('D', 3, '1988',0,2),
    ('A', 4, '50',0,2),
    ('B', 4, '51',1,2),
    ('C', 4, '52',0,2),
    ('D', 4, '53',0,2),
    ('A', 5, '500',1,2),
    ('B', 5, '600',0,2),
    ('C', 5, '700',0,2),
    ('D', 5, '800',0,2),
    ('A', 6, '20 ngan',0,2),
    ('B', 6, '30 ngan',1,2),
    ('C', 6, '40 ngan',0,2),
    ('D', 6, '50 ngan',0,2);
    
INSERT INTO OutputStandard
VALUES
	('AA0000', 'Know to use MYSQL'),
    ('AA0000', 'Know to design relational database'),
    ('AA0000', 'Know to create an app using database'),
    ('AA0001', 'Know to create a language'),
    ('AA0001', 'Create BKIT'),
    ('BB0000', 'Learn C/ C++'),
    ('BB0000', 'Programing using C/C++');
    
INSERT INTO TakingExams
VALUES
	('AA0000', '2020-12-8'),
    ('AA0000', '2020-12-7'),
    ('AA0000', '2020-12-5'),
    ('AA0001', '2020-11-15'),
    ('AA0001', '2020-11-12'),
    ('AA0001', '2020-11-18'),
    ('BB0000', '2020-10-28'),
    ('BB0000', '2020-10-29');
    
INSERT INTO exams
VALUES
	('AA0000', '2020-12-8', '0001', 1, '2020-8-15', '2021-5-31'),
    ('AA0000', '2020-12-7', '0002', 1, '2020-8-15', '2021-5-31'),
    ('AA0000', '2020-12-5', '0003', 1, '2020-8-15', '2021-5-31'),
    ('AA0001', '2020-11-15', '0001', 2, '2020-8-15', '2021-5-31'),
    ('AA0001', '2020-11-12', '0002', 2, '2020-8-15', '2021-5-31'),
    ('AA0001', '2020-11-18', '0001', 3, '2020-8-15', '2021-5-31'),
    ('BB0000', '2020-10-28', '0002', 3, '2020-8-15', '2021-5-31'),
    ('BB0000', '2020-10-29', '0002', 3, '2020-8-15', '2021-5-31');
    
UPDATE question
SET employee_id = 102
WHERE id = 1;
UPDATE question
SET employee_id = 102
WHERE id = 2;
UPDATE question
SET employee_id = 103
WHERE id = 3;
UPDATE question
SET employee_id = 104
WHERE id = 4;
UPDATE question
SET employee_id = 105
WHERE id = 5;
UPDATE question
SET employee_id = 105
WHERE id = 6;

UPDATE question
SET subject_id = 'AA0000', os_content = 'Know to use MYSQL'
WHERE id = 1;
UPDATE question
SET subject_id = 'AA0000', os_content = 'Know to design relational database'
WHERE id = 2;
UPDATE question
SET subject_id = 'AA0001', os_content = 'Know to create a language'
WHERE id = 3;
UPDATE question
SET subject_id = 'AA0001', os_content = 'Create BKIT'
WHERE id = 4;
UPDATE question
SET subject_id = 'BB0000', os_content = 'Learn C/ C++'
WHERE id = 5;
UPDATE question
SET subject_id = 'BB0000', os_content = 'Programing using C/C++'
WHERE id = 6;

UPDATE exams
SET lecturer_id = 102, made_date = '2020-8-10', manager_id = 100, accepted_date = '2020-8-15'
WHERE subject_id = 'AA0000' and id = '0001';
UPDATE exams
SET lecturer_id = 103, made_date = '2020-8-09', manager_id = 100, accepted_date = '2020-8-12'
WHERE subject_id = 'AA0000' and id = '0002';
UPDATE exams
SET lecturer_id = 104, made_date = '2020-7-20', manager_id = 101, accepted_date = '2020-7-30'
WHERE subject_id = 'AA0000' and id = '0003';
UPDATE exams
SET lecturer_id = 105, made_date = '2020-8-10', manager_id = 101, accepted_date = '2020-8-15'
WHERE subject_id = 'AA0001' and id = '0002';
UPDATE exams
SET lecturer_id = 102, made_date = '2020-5-10', manager_id = 101, accepted_date = '2020-6-30'
WHERE subject_id = 'AA0001' and id = '0001' and term = 2;
UPDATE exams
SET lecturer_id = 102, made_date = '2020-5-10', manager_id = 101, accepted_date = '2020-6-30'
WHERE subject_id = 'AA0001' and id = '0001' and term = 3;
UPDATE exams
SET lecturer_id = 103, made_date = '2020-5-10', manager_id = 100, accepted_date = '2020-6-30'
WHERE subject_id = 'BB0000' and exam_date = '2020-10-28';
UPDATE exams
SET lecturer_id = 103, made_date = '2020-7-15', manager_id = 100, accepted_date = '2020-8-29'
WHERE subject_id = 'BB0000' and exam_date = '2020-10-29';

ALTER TABLE question
RENAME COLUMN employee_id TO lecturer_id;

    
    


    
    
	