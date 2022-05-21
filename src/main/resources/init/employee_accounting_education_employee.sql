create table education_employee
(
    education_id int not null,
    employee_id  int not null,
    primary key (education_id, employee_id),
    constraint education_employee_ibfk_1
        foreign key (education_id) references education_course (id),
    constraint education_employee_ibfk_2
        foreign key (employee_id) references employee (id)
);

create index employee_id
    on education_employee (employee_id);

INSERT INTO employee_accounting.education_employee (education_id, employee_id) VALUES (1, 1);
INSERT INTO employee_accounting.education_employee (education_id, employee_id) VALUES (2, 1);
INSERT INTO employee_accounting.education_employee (education_id, employee_id) VALUES (3, 3);
INSERT INTO employee_accounting.education_employee (education_id, employee_id) VALUES (4, 4);
