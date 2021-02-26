create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now(),
                       author text
);

create table subpost (
    id serial primary key,
    header varchar(2000),
    content varchar(2000),
    created timestamp without time zone not null default now(),
    posts_id int references posts(id),
    author text
);