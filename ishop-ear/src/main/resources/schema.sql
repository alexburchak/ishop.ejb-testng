create table product (
    id numeric(19,0) identity not null,
    code varchar(40) not null unique,
    primary key (id)
);
create table purchase (
    id numeric(19,0) identity not null,
    product_id numeric(19,0) not null,
    payment_date datetime null,
    primary key (id)
);
alter table purchase
    add constraint purchase_product_fk
    foreign key (product_id)
    references product;
