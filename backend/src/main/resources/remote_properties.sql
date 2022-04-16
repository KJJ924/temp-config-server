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

INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (1, 'jaejoon', 'local', 'test', 'name', 'jaejoon', '2022-04-17 02:09:44', '2022-04-17 02:09:47');
INSERT INTO config_server.remote_properties (id, application, profile, label, prop_key, prop_value, created_at, modified_at) VALUES (2, 'jaejoon', 'local', 'test', 'location', 'seoul', '2022-04-17 02:09:44', '2022-04-17 02:09:47');