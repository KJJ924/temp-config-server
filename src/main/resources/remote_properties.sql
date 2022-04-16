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