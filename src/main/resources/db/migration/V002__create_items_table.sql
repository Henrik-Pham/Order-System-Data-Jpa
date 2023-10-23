create table item(
  item_id bigint not null auto_increment primary key,
  item_name varchar(200) not null,
);

create sequence item_seq;