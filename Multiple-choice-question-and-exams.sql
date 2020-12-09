DROP DATABASE IF EXISTS multiple_choice_questions_and_exams;
CREATE DATABASE multiple_choice_questions_and_exams;
USE multiple_choice_questions_and_exams;

CREATE TABLE Account(
	id INT PRIMARY KEY,
    username VARCHAR(20),
    password VARCHAR(20),
    role VARCHAR(10)
);

CREATE TABLE Employee(
	id VARCHAR(8) PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    Email VARCHAR(50) NOT NULL,
    Phone VARCHAR(11)
);

CREATE TABLE Lecturer(
	id VARCHAR(8) PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Employee(id)
);

CREATE TABLE Manager(
	id VARCHAR(8) PRIMARY KEY,
    FOREIGN KEY(id) REFERENCES Employee(id)
);

CREATE TABLE Subject(
	id VARCHAR(6) PRIMARY KEY,
    name VARCHAR(20)
);

ALTER TABLE Lecturer
ADD subject_id VARCHAR(6),
ADD FOREIGN KEY (subject_id) REFERENCES Subject(id);

CREATE TABLE Student(
	id VARCHAR(8) PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE DescriptionContent(
	id INT UNSIGNED PRIMARY KEY
);

CREATE TABLE Question(
	id INT UNSIGNED PRIMARY KEY,
    content TEXT,
    type VARCHAR(1) CHECK (type in ('E', 'M', 'H')),
    description_id INT UNSIGNED,
    FOREIGN KEY (description_id) REFERENCES DescriptionContent(id)
);

CREATE TABLE Answer(
	id VARCHAR(1) CHECK(id IN ('A', 'B', 'C', 'D', 'E')),
    question_id INT UNSIGNED,
    content TEXT,
    is_right bool,
    description_id INT UNSIGNED,
    PRIMARY KEY(id, question_id),
    FOREIGN KEY(description_id) REFERENCES DescriptionContent(id)
);

CREATE TABLE GeneralDescription(
	id INT UNSIGNED PRIMARY KEY,
	content TEXT,
    description_id INT UNSIGNED,
    FOREIGN KEY (description_id) REFERENCES DescriptionContent(id)
);

CREATE TABLE DescriptionFile(
	id INT UNSIGNED PRIMARY KEY,
    content TEXT
);

CREATE TABLE OutputStandard(
	subject_id VARCHAR(6),
    content VARCHAR(500),
    PRIMARY KEY(subject_id, content),
    FOREIGN KEY (subject_id) REFERENCES Subject(id)
);

CREATE TABLE TakingExams(
	subject_id VARCHAR(6),
    exam_date DATE,
    PRIMARY KEY(subject_id, exam_date),
    FOREIGN KEY (subject_id) REFERENCES Subject(id)
);

CREATE TABLE exams(
	subject_id VARCHAR(6),
    exam_date DATE,
    id VARCHAR(4) CHECK (id in ('0001', '0002', '0003', '0004')),
    term INT UNSIGNED CHECK (1 <= term <= 3),
    startDate DATE,
    endDate DATE,
    CHECK (startDate < exam_date < endDate),
    PRIMARY KEY(subject_id, exam_date, id),
    FOREIGN KEY(subject_id, exam_date) REFERENCES TakingExams(subject_id, exam_date)
);

ALTER TABLE Question
ADD employee_id VARCHAR(8),
ADD modified_date DATE,
ADD FOREIGN KEY (employee_id) REFERENCES Employee(id);

ALTER TABLE Question
ADD os_content VARCHAR(500);

ALTER TABLE question
ADD FOREIGN KEY(subject_id, os_content) REFERENCES outputstandard(subject_id, content);

ALTER TABLE exams
ADD lecturer_id VARCHAR(8),
ADD made_date DATE,
ADD FOREIGN KEY (lecturer_id) REFERENCES Lecturer(id),
ADD manager_id VARCHAR(8),
ADD accepted_date DATE,
ADD FOREIGN KEY(manager_id) REFERENCES Manager(id);












