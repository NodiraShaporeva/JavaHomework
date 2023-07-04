 create table clients (
     id serial primary key,
     name VARCHAR(100),
     discount decimal(10, 2));

select min(discount) as min_discount from clients;
select max(discount) as max_discount from clients;
select name, discount from clients
where discount = (select min(discount) from clients);
select name, discount from clients
where discount = (select max(discount) from clients);
select avg(discount) as avg_discount from clients;
