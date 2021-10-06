CREATE TABLE IF NOT EXISTS zadanie
(
    id BIGSERIAL PRIMARY KEY,
    number Integer,
    date_time timestamp NOT NULL,
    status TEXT
);
COMMENT ON TABLE zadanie IS 'Задание курьера';
COMMENT ON COLUMN zadanie.id IS 'Идентификатор задания';
COMMENT ON COLUMN zadanie.number IS 'Номер задания';
COMMENT ON COLUMN zadanie.date_time IS 'Дата и время добавления задания';
COMMENT ON COLUMN zadanie.status IS 'Статус задания';

CREATE TABLE IF NOT EXISTS couriers
(
    id BIGSERIAL PRIMARY KEY,
    courier TEXT,
    number Integer,
    date_time timestamp NOT NULL,
    status TEXT
);
COMMENT ON TABLE couriers IS 'Курьеры';
COMMENT ON COLUMN couriers.id IS 'Идентификатор курьера';
COMMENT ON COLUMN couriers.courier IS 'Курьер';
COMMENT ON COLUMN couriers.number IS 'Номер задания';
COMMENT ON COLUMN couriers.date_time IS 'Дата и время добавления задания';
COMMENT ON COLUMN couriers.status IS 'Статус задания';

CREATE TABLE IF NOT EXISTS phone
(
    id BIGSERIAL PRIMARY KEY,
    zadanie_id INTEGER,
    status TEXT,
    comment TEXT
);
COMMENT ON TABLE phone IS 'Результат прозвона клиентов';
COMMENT ON COLUMN phone.id IS 'Идентификатор записи';
COMMENT ON COLUMN phone.zadanie_id IS 'Идентификатор задания';
COMMENT ON COLUMN phone.status IS 'Статус задания';
COMMENT ON COLUMN phone.comment IS 'Комментарий к заданию';