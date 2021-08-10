DROP DATABASE IF EXISTS heroes;
CREATE DATABASE heroes;
USE heroes;

CREATE TABLE abilities
(
    id   INT AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE heroes
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(50) UNIQUE NOT NULL,
    identity   VARCHAR(100),
    age        INT,
    gender     VARCHAR(10)        NOT NULL,
    ability_id INT                NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ability_id) REFERENCES abilities (id)
);

INSERT INTO abilities (name)
VALUES ('Полёт');
INSERT INTO abilities (name)
VALUES ('Сверхсила');
INSERT INTO abilities (name)
VALUES ('Телепатия');
INSERT INTO abilities (name)
VALUES ('Невидимость');
INSERT INTO abilities (name)
VALUES ('Регенерация');
INSERT INTO abilities (name)
VALUES ('Управление стихией');
INSERT INTO abilities (name)
VALUES ('Сверхскорость');
INSERT INTO abilities (name)
VALUES ('Богатство');

INSERT INTO heroes (name, identity, age, gender, ability_id)
VALUES ('Супермэн', 'Кларк Кент', 40, 'MALE', 1);
INSERT INTO heroes (name, identity, age, gender, ability_id)
VALUES ('Женщина-невидимка', 'Сьюзан Шторм', 30, 'FEMALE', 4);

SELECT *
FROM heroes;
