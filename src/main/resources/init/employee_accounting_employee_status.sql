create table employee_status
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

INSERT INTO employee_accounting.employee_status (id, name) VALUES (1, 'Уволен');
INSERT INTO employee_accounting.employee_status (id, name) VALUES (2, 'Отпуск');
INSERT INTO employee_accounting.employee_status (id, name) VALUES (3, 'Работает');
INSERT INTO employee_accounting.employee_status (id, name) VALUES (4, 'Пенсия');
INSERT INTO employee_accounting.employee_status (id, name) VALUES (5, 'Декрет');
