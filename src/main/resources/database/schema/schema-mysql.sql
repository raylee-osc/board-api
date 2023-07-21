DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS engine;

CREATE TABLE IF NOT EXISTS car(
    car_id BIGINT NOT NULL AUTO_INCREMENT,
    car_name VARCHAR(100) NOT NULL,
    car_engine VARCHAR(100) NOT NULL,

    PRIMARY KEY (car_id)
);

CREATE TABLE IF NOT EXISTS engine(
    engine_id BIGINT NOT NULL AUTO_INCREMENT,
    engine_name VARCHAR(100) NOT NULL,
    engine_type VARCHAR(100) NOT NULL,

    PRIMARY KEY (engine_name),
    UNIQUE KEY (engine_id)
);

ALTER TABLE car
ADD CONSTRAINT FK_CarEngine
FOREIGN KEY (car_engine) REFERENCES engine (engine_name);