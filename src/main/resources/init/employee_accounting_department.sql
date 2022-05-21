create table department
(
    id   int auto_increment
        primary key,
    name varchar(50) null
);

INSERT INTO employee_accounting.department (id, name) VALUES (1, 'Руководители');
INSERT INTO employee_accounting.department (id, name) VALUES (2, 'Инженеры');
INSERT INTO employee_accounting.department (id, name) VALUES (3, 'Бухгалтерия');
INSERT INTO employee_accounting.department (id, name) VALUES (4, 'ОТК');
