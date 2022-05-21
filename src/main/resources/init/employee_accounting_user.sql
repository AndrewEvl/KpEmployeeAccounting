create table user
(
    id       bigint auto_increment
        primary key,
    login    varchar(255) not null,
    password varchar(255) not null
);

INSERT INTO employee_accounting.user (id, login, password) VALUES (1, 'test', '$2a$10$EQMfxV3XloEg4vVvfebwG.O5UlDRyOvDXirD8f151B07P2ByrAylO');
