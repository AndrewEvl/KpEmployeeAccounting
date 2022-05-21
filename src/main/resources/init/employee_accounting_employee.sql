create table employee
(
    id            int auto_increment
        primary key,
    first_name    varchar(20) null,
    last_name     varchar(20) null,
    surname       varchar(20) null,
    birthday      date        null,
    department_id int         null,
    position_id   int         null,
    status_id     int         null,
    constraint employee_ibfk_1
        foreign key (department_id) references department (id),
    constraint employee_ibfk_2
        foreign key (position_id) references position (id),
    constraint employee_ibfk_3
        foreign key (status_id) references employee_status (id)
);

create index department_id
    on employee (department_id);

create index position_id
    on employee (position_id);

create index status_id
    on employee (status_id);

INSERT INTO employee_accounting.employee (id, first_name, last_name, surname, birthday, department_id, position_id, status_id) VALUES (1, 'Иванов', 'Иван', 'Иванович', '1991-01-03', 1, 1, 1);
INSERT INTO employee_accounting.employee (id, first_name, last_name, surname, birthday, department_id, position_id, status_id) VALUES (2, 'Перов', 'Петр', 'Петрович', '1991-02-05', 2, 2, 2);
INSERT INTO employee_accounting.employee (id, first_name, last_name, surname, birthday, department_id, position_id, status_id) VALUES (3, 'Савушкин', 'Максим', 'Семенович', '1986-10-09', 3, 3, 3);
INSERT INTO employee_accounting.employee (id, first_name, last_name, surname, birthday, department_id, position_id, status_id) VALUES (4, 'Перов', 'Иван', 'Семенович', '1989-06-08', 2, 2, 3);
INSERT INTO employee_accounting.employee (id, first_name, last_name, surname, birthday, department_id, position_id, status_id) VALUES (5, 'Лавров', 'Сергей', 'Анатольевич', '1983-03-06', 2, 2, 1);
