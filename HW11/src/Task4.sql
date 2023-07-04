 create table orders (
     id serial primary key,
     data date,
     product varchar(100),
     type varchar(50));

select * from orders where data = '2023-06-29';
select * from orders where data between '2023-06-27' and '2023-06-29';
select count(*) as dessert_orders from orders where data = '2023-06-29' and type = 'десерт';
select count(*) as drinks_orders from orders where data = '2023-06-29' and type = 'напиток';
