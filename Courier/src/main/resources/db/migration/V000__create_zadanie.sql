CREATE TABLE IF NOT EXISTS zadanie
(
    id BIGSERIAL PRIMARY KEY,
    number Integer,
    date_time timestamp NOT NULL,
    status TEXT
);
CREATE TABLE IF NOT EXISTS couriers
(
    id BIGSERIAL PRIMARY KEY,
    courier TEXT,
    number Integer,
    date_time timestamp NOT NULL,
    status TEXT
);
CREATE TABLE IF NOT EXISTS phone
(
    id BIGSERIAL PRIMARY KEY,
    zadanie_id INTEGER,
    status TEXT,
    comment TEXT
);