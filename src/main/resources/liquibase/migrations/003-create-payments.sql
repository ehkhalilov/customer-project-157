--changeset Elnur-Khalilov:5

create table payments
(
    amount integer,
    id     serial
        primary key,
    date   date
);
