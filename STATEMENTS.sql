CREATE TABLE CATEGORY(
ID INT,
NAME VARCHAR,
DESCRIPTION VARCHAR
);

SELECT * FROM CATEGORY

DELETE TABLE CATEGORY

DROP TABLE SUPPLIER

COUNT *

create table category (id identity, name varchar(50), description varchar(255));
insert into category(name,description) values('Instruments','THis is a dummy instruments');
insert into category(name,description) values('Amplifiers&Mixers','This is a dummy amplifiers');
insert into category(name,description) values('Accessories','This is a dummy accessories');
insert into category(name,description) values('Recording','This is a dummy recording');

create table supplier(
id int,
name varchar(50),
email varchar(50),
contactNo number(10),
constraint pk_supplier_id primary key(id)
);
insert into SUPPLIER(id,name,email,contactNo) values (1,'Furtados','akshay123@gmail.com','9991815467');
insert into SUPPLIER(id,name,email,contactNo) values (2,'Resonace','sameer23@gmail.com','9998905467');


create table product(
product_id int,
category_id int,
supplier_id int,
name varchar(50),
description varchar(255),
unit_price number(10,2),
quantity int,
constraint pk_product_id primary key(product_id),
constraint fk_product_category_id foreign key (category_id) references category (id) on delete set null,
constraint fk_product_supplier_id foreign key (supplier_id) references supplier (id) on delete set null
);

insert into PRODUCT (PRODUCT_id,CATEGORY_ID,SUPPLIER_ID,name,DESCRIPTION,UNIT_PRICE,QUANTITY) values (1,1,1,'Keyboards','This is an instrument','55000',5);
insert into PRODUCT (PRODUCT_id,CATEGORY_ID,SUPPLIER_ID,name,DESCRIPTION,UNIT_PRICE,QUANTITY) values (2,1,2,'Guitars','This is an instrument','20000',2);
insert into PRODUCT (PRODUCT_id,CATEGORY_ID,SUPPLIER_ID,name,DESCRIPTION,UNIT_PRICE,QUANTITY) values (3,1,1,'Drumset','This is an instrument','25000',3);


INSERT INTO USER(USERNAME, PASSWORD, ROLE, USER_ENABLED) VALUES('gau@gmail.com', 'gauresh', 'USER', 'ENABLED');
INSERT INTO USER(USERNAME, PASSWORD, ROLE, USER_ENABLED) VALUES('xyz@gmail.com', 'xyzxyz', 'USER', 'ENABLED');
INSERT INTO USER(USERNAME, PASSWORD, ROLE, USER_ENABLED) VALUES('khoze@niit.com', 'niit', 'ADMIN', 'ENABLED')

create table user(
user_id identity,
username varchar(50),
password varchar(50),
enabled boolean default 'true' 
);

create table userrole(
username varchar(50),
user_id int,
role varchar(50),
constraint fk_userrole_user_id foreign key (user_id) references user (user_id) on delete set null,
);

insert into userrole values('gau@gmail.com', 1, 'USER')

create table cart(
cart_id int,
grand_total int,
no_of_products int,
constraint fk_cart_user_user_id foreign key (cart_id) references user (user_id) on delete set null
);

create table cartitem(
cart_item_id identity,
cart_id int,
product_id int,
quantity int,
total_price int,
constraint fk_cartitem_cart_cart_id foreign key (cart_id) references cart (cart_id) on delete set null,
constraint fk_cartitem_product_product_id foreign key (product_id) references product (product_id) on delete set null
);