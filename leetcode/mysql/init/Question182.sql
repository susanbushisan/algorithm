
create table person
(
    id    int auto_increment
        primary key,
    email varchar(200) null
);

INSERT INTO person (id, email) VALUES (1, 'a@b.com');
INSERT INTO person (id, email) VALUES (2, 'c@d.com');
INSERT INTO person (id, email) VALUES (3, 'a@b.com');