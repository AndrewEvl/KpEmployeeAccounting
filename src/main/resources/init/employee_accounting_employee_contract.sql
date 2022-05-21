create table employee_contract
(
    id          int auto_increment
        primary key,
    number      varchar(15) null,
    start_date  date        null,
    end_date    date        null,
    salary      double      null,
    employee_id int         null,
    constraint employee_contract_ibfk_1
        foreign key (employee_id) references employee (id)
);

create index employee_id
    on employee_contract (employee_id);

INSERT INTO employee_accounting.employee_contract (id, number, start_date, end_date, salary, employee_id) VALUES (1, '123A', '2019-01-05', '2021-01-04', 1000, 1);
INSERT INTO employee_accounting.employee_contract (id, number, start_date, end_date, salary, employee_id) VALUES (2, '1235G', '2018-04-05', '2021-03-04', 1500, 2);
INSERT INTO employee_accounting.employee_contract (id, number, start_date, end_date, salary, employee_id) VALUES (3, '12351G', '2021-06-08', '2023-08-07', 1800, 3);
INSERT INTO employee_accounting.employee_contract (id, number, start_date, end_date, salary, employee_id) VALUES (4, '21351G', '2021-05-10', '2023-09-07', 2000, 4);
INSERT INTO employee_accounting.employee_contract (id, number, start_date, end_date, salary, employee_id) VALUES (5, '123dsaas', '2020-07-08', '2024-10-09', 2200, 5);
