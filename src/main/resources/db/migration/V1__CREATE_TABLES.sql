create table hibernate_sequence (
    next_val bigint
) engine=myISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password varchar(64) NOT NULL,
    username varchar(64) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE todo (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      title varchar(64) NOT NULL,
                      completed BOOLEAN NOT NULL,
                      PRIMARY KEY (id)
) engine=myISAM;


