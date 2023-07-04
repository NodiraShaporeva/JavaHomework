alter TABLE orders
    ADD client_id INTEGER,
    ADD sum NUMERIC(10, 2);

create table baristas (
    id serial primary key,
    name varchar(100)
);

create table drinks (
    id serial primary key,
    order_id integer,
    barista_id integer,
    drink varchar(100)
);

select clients.name as client_name,
 Baristas.name as barista_name,
  drinks.drink
from clients
join orders on clients.id = orders.client_id
join drinks on orders.id = drinks.order_id
join baristas on drinks.barista_id = baristas.id
where orders.data = current_date;

select avg(sum) as avg_order_sum
from orders
where data = '2023-06-29';

select max(sum) as max_order_sum
from orders
where data = '2023-06-29';

select clients.name as client_name, orders.sum as order_price
from clients
join orders on clients.id = orders.client_id
where orders.data = '2023-06-29'
order by orders.sum desc
limit 1;
