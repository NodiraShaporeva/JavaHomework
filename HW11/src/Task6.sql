create table schedule (
    id serial primary key,
    barista_id integer,
    week_day varchar(20),
    work_beginning time,
    work_end time
);

select * from schedule where barista_id = 1; //идентификатор (id) конкретного баристы
select * from schedule;
select baristas.name, schedule.week_day, schedule.work_beginning, schedule.work_end
from baristas
join schedule on baristas.id = schedule.barista_id;
