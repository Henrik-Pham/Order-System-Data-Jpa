create table address(
    address_id    bigint       not null auto_increment primary key,
    customer_name varchar(200) not null
)

create sequence address_seq;