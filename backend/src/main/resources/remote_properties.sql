create table remote_properties
(
    id          integer not null auto_increment,
    application varchar(255),
    profile     varchar(255),
    label       varchar(255),
    prop_key    varchar(255),
    prop_value  varchar(255),
    created_at  datetime(6) default now(6),
    modified_at datetime(6) default now(6),
    primary key (id)
) engine=InnoDB;

#

INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (1, 'jaejoon', 'local', 'test', 'jaejoon.name', 'jaejoon', '2022-04-17 02:09:44', '2022-04-17 02:09:47');
INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (2, 'jaejoon', 'local', 'test', 'jaejoon.location', 'seoul', '2022-04-17 02:09:44', '2022-04-17 02:09:47');
INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (3, 'jaejoon', 'local', 'test', 'application.persons[0].name', 'jaejoon', '2022-04-19 20:51:19', '2022-04-19 20:51:18');
INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (4, 'jaejoon', 'local', 'test', 'application.persons[0].location', 'seoul', '2022-04-19 20:51:15', '2022-04-19 20:51:20');
INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (5, 'jaejoon', 'local', 'test', 'application.persons[1].name', 'KJJ', '2022-04-19 20:51:15', '2022-04-19 20:51:15');
INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (6, 'jaejoon', 'local', 'test', 'application.persons[1].location', 'seoul', '2022-04-19 20:51:15', '2022-04-19 20:51:15');
