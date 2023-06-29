CREATE DATABASE coffee_house;

-- Создание таблицы "Кофейни"
CREATE TABLE coffee_houses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(100),
    phone VARCHAR(20)
);

-- Создание таблицы "Ассортимент"
CREATE TABLE assortment (
    id SERIAL PRIMARY KEY,
    coffee_house_id INT,
    drink_name VARCHAR(100),
    description TEXT,
    FOREIGN KEY (coffee_house_id) REFERENCES coffee_houses(id)
);

-- Создание таблицы "Цены"
CREATE TABLE prices (
    id SERIAL PRIMARY KEY,
    coffee_house_id INT,
    drink_id INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (coffee_house_id) REFERENCES coffee_houses(id),
    FOREIGN KEY (drink_id) REFERENCES assortment(id)
);

-- Вставка данных в таблицу "Кофейни"
INSERT INTO coffee_houses (name, address, phone)
VALUES
    ('Кофейня 1', 'Адрес 1', 'Телефон 1'),
    ('Кофейня 2', 'Адрес 2', 'Телефон 2'),
    ('Кофейня 3', 'Адрес 3', 'Телефон 3');

-- Вставка данных в таблицу "Ассортимент"
INSERT INTO assortment (coffee_house_id, drink_name, description)
VALUES
    (1, 'Эспрессо', 'Классический кофейный напиток'),
    (1, 'Капучино', 'Кофе с молоком и взбитыми сливками'),
    (2, 'Латте', 'Кофе с большим количеством молока');

-- Вставка данных в таблицу "Цены"
INSERT INTO prices (coffee_house_id, drink_id, price)
VALUES
    (1, 1, 2.50),
    (1, 2, 3.00),
    (2, 3, 3.50);
