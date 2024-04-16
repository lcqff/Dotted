create table user
(
    id         bigint auto_increment primary key,
    name       varchar(255) not null,
    email      varchar(255) not null,
    image_url  varchar(255) not null,
    is_deleted boolean      not null,
    created_at datetime(6),
    updated_at datetime(6)
)

create table group
(
    id         bigint auto_increment primary key,
    name       varchar(255) not null,
    is_deleted boolean      not null,
    created_at datetime(6),
    updated_at datetime(6)
)

create table friend
(
    id                bigint auto_increment primary key,
    user_id           bigint       not null,
    friend_user_id    bigint       not null,
    is_friend         boolean      not null,
    is_deleted boolean      not null,
    created_at datetime(6),
    updated_at datetime(6)
)

create table schedule
(
    id         bigint auto_increment primary key,
    user_id    bigint       not null,
    title      varchar(255) not null,
    color      varchar(255) not null,
    is_deleted boolean      not null,
    created_at datetime(6),
    updated_at datetime(6)
)

create table schedule_item
(
    id              bigint auto_increment primary key,
    schedule_id     bigint       not null,
    day_of_week     VARCHAR(50)  not null,
    is_checked      varchar(255) not null,
    is_deleted      boolean      not null,
    created_at      datetime(6),
    updated_at      datetime(6)
)

create table feed
(
    id                  bigint auto_increment primary key,
    schedule_item_id    bigint       not null,
    image_url           varchar(255) not null,
    is_deleted          boolean      not null,
    created_at          datetime(6),
    updated_at          datetime(6)
)