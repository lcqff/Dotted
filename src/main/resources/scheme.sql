drop table if exists dotted.user;
drop table if exists dotted.group;
drop table if exists dotted.friend;
drop table if exists dotted.schedule;
drop table if exists dotted.schedule_item;
drop table if exists dotted.feed;

create table user
(
    id          bigint auto_increment primary key,
    name        varchar(255) not null,
    social_id   bigint       not null,
    social_type varchar(255) not null,
    email       varchar(255),
    image_url   varchar(255) not null,
    is_deleted  boolean      not null,
    created_at  datetime(6),
    updated_at  datetime(6)
);

create table group_
(
    id         bigint auto_increment primary key,
    name       varchar(255) not null,
    is_deleted boolean      not null,
    created_at datetime(6),
    updated_at datetime(6)
);

create table friend
(
    id             bigint auto_increment primary key,
    user_id        bigint  not null,
    friend_user_id bigint  not null,
    is_friend      boolean not null,
    is_deleted     boolean not null,
    created_at     datetime(6),
    updated_at     datetime(6)
);

create table schedule
(
    id         bigint auto_increment primary key,
    user_id    bigint       not null,
    title      varchar(255) not null,
    color      varchar(255) not null,
    is_deleted boolean      not null,
    created_at datetime(6),
    updated_at datetime(6)
);

create table schedule_item
(
    id          bigint auto_increment primary key,
    schedule_id bigint       not null,
    day_of_week VARCHAR(50)  not null,
    is_checked  varchar(255) not null,
    created_at  datetime(6),
    updated_at  datetime(6)
);

create table feed
(
    id               bigint auto_increment primary key,
    schedule_item_id bigint       not null,
    image_url        varchar(255) not null,
    is_deleted       boolean      not null,
    created_at       datetime(6),
    updated_at       datetime(6)
);
