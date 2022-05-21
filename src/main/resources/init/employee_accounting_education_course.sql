create table education_course
(
    id          int auto_increment
        primary key,
    name        varchar(50) null,
    start_date  date        null,
    finish_date date        null
);

INSERT INTO employee_accounting.education_course (id, name, start_date, finish_date) VALUES (1, 'БГУ', '2020-01-03', '2020-02-01');
INSERT INTO employee_accounting.education_course (id, name, start_date, finish_date) VALUES (2, 'БГУИР', '2020-04-05', '2020-06-01');
INSERT INTO employee_accounting.education_course (id, name, start_date, finish_date) VALUES (3, 'IT Academy', '2020-02-03', '2020-06-07');
INSERT INTO employee_accounting.education_course (id, name, start_date, finish_date) VALUES (4, 'JAVA', '2020-02-03', '2020-04-09');
INSERT INTO employee_accounting.education_course (id, name, start_date, finish_date) VALUES (5, 'STEP ACADEMY', '2020-01-03', '2020-02-01');
