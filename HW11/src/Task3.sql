alter TABLE clients
    ADD age INTEGER,
    ADD date_of_birth DATE,
    ADD email VARCHAR(255);

select name, age from clients order by age asc limit 1;
select name, age from clients order by age desc limit 1;
select name, date_of_birth from clients where
extract(DAY FROM date_of_birth) =
EXTRACT(DAY FROM CURRENT_DATE) AND
EXTRACT(MONTH FROM date_of_birth) =
EXTRACT(MONTH FROM CURRENT_DATE);
select name from clients where email is null or email = '';
