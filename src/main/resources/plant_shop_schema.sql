DROP DATABASE plants;
create database if not exists plants;
use plants;

CREATE TABLE category
(
    id            INT AUTO_INCREMENT primary key,
    category_name VARCHAR(20)
);
CREATE TABLE plants
(
    id            INT AUTO_INCREMENT primary key,
    plant_name    VARCHAR(40),
    pot_dimension INT,
    category_id   INT,
    price         INT
);
ALTER TABLE plants
    ADD FOREIGN KEY (category_id) REFERENCES category (id);

CREATE TABLE clients
(
    id               INT AUTO_INCREMENT primary key,
    client_name      VARCHAR(20),
    date_account     date default (NOW()),
    client_mail      VARCHAR(320),
    delivery_address VARCHAR(400)
);
CREATE TABLE orders
(
    order_NO  INT AUTO_INCREMENT primary key,
    order_date     date default (NOW()),
    delivery_date  date DEFAULT (order_date+INTERVAL 1 DAY ),
    client_id INT
);
ALTER TABLE orders
    ADD FOREIGN KEY (client_id) REFERENCES clients (id);

CREATE TABLE orders_with_plants
(
    nr_crt  INT AUTO_INCREMENT primary key,
    order_id  INT,
    plant_id  INT,
    plant_number INT
);
ALTER TABLE orders_with_plants
    ADD FOREIGN KEY (order_id) REFERENCES orders (order_NO);
ALTER TABLE orders_with_plants
    ADD FOREIGN KEY (plant_id) REFERENCES plants (id);

INSERT INTO category
VALUES (1, 'COMMON GREEN PLANTS'),
       (2, 'FLOWERING PLANTS');
INSERT INTO plants
VALUES (DEFAULT, 'MONSTERA DELICIOSA', 08, 1, 50),
       (default, 'MONSTERA DELICIOSA', 10, 1, 80),
       (default, 'MONSTERA ADANSONI', 5, 1, 40),
       (default, 'RAPHIDOPHORA TETRASPERMA', 7, 1, 50),
       (default, 'CALATHEA WHITE STAR', 10, 1, 80),
       (default, 'MONSTERA ALBO VERIEGATA', 7, 1, 400),
       (default, 'CALATHEA MAKOYANA', 5, 1, 20),
       (default, 'FICUS ELASTICA', 12, 1, 100),
       (default, 'FICUS ELASTICA RUBY', 12, 1, 150),
       (default, 'CALATHEA ORBIFOLIA', 8, 1, 70),
       (default, 'MARBLE QUEEN POTHOS', 8, 1, 40),
       (default, 'BEGONIA MACULATA', 8, 2, 40),
       (default, 'SCINDAPSUS PICTUS', 8, 1, 50),
       (default, 'BEGONIA REX', 6, 2, 40),
       (default, 'HOYA KERRY', 7, 2, 30);

INSERT INTO clients
VALUES (1, 'ANDREEA MANA', '2020-11-05', 'andreeamana@yahoo.com', 'Str. Fagarasului ,nr. 36, Brasov'),
       (default, 'CLAUDIU ANDREI', '2020-05-05', 'claudiuandrei@yahoo.com', 'Str. Cartierului ,nr. 22, Oradea'),
       (default, 'EMANUEL FRINCU', '2020-05-05', 'emanuelfrincu@yahoo.com', 'Str. Salcamului ,nr. 15, Ghimbav'),
       (default, 'GEORGETA LUPU', '2020-05-20', 'georgetalupu@gmail.com', 'Str. Victoriei ,nr. 1, Bucuresti'),
       (default, 'DANIEL STANGA', '2020-12-01', 'dan.stanga@yahoo.com', 'Str. Lacurilor ,nr. 1, Brasov'),
       (default, 'GHEORGHE MARCU', '2020-06-02', 'gheorghe_marcu@gmail.com', 'Str. Macesilor ,nr. 55, Sibiu');
INSERT INTO orders
VALUES (1, DEFAULT, DEFAULT, 1),
       (DEFAULT, DEFAULT, DEFAULT, 2),
       (DEFAULT, '2020-06-02', DEFAULT, 2),
       (DEFAULT, '2020-06-02', DEFAULT, 2);
INSERT INTO orders_with_plants
VALUES (1, 1, 1, 2 ),
       (DEFAULT, 1, 4, 1 ),
       (DEFAULT, 2, 10,1 ),
       (DEFAULT, 2, 12,1 ),
       (DEFAULT, 4, 3 ,1 ),
       (DEFAULT, 3, 14 ,1 );