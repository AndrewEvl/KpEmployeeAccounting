create table position
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

INSERT INTO employee_accounting.position (id, name) VALUES (1, 'Директор');
INSERT INTO employee_accounting.position (id, name) VALUES (2, 'Инженер');
INSERT INTO employee_accounting.position (id, name) VALUES (3, 'Бухгалтер');
INSERT INTO employee_accounting.position (id, name) VALUES (4, 'Гл. бухгалтер');
INSERT INTO employee_accounting.position (id, name) VALUES (5, 'Кадровик');
