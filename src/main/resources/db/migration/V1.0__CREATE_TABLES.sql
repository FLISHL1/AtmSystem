CREATE TABLE banks
(
    id    serial PRIMARY KEY,
    title varchar(60)
);

CREATE TABLE users
(
    id              bigserial PRIMARY KEY,
    first_name      varchar(60),
    last_name       varchar(60),
    second_name     varchar(60),
    snils           varchar(155),
    number_passport varchar(155),
    series_passport varchar(155),
    UNIQUE (series_passport, number_passport)
);

CREATE TABLE accounts
(
    id        bigserial PRIMARY KEY,
    title     varchar(60),
    balance   numeric(38,2),
    holder_id bigint,
    pin       varchar(260),
    bank_id   int DEFAULT 1,
    FOREIGN KEY (bank_id) REFERENCES banks (id),
    FOREIGN KEY (holder_id) REFERENCES users (id)
);
CREATE TABLE transactions
(
    id     bigserial PRIMARY KEY,
    title  varchar(60),
    amount real
);


CREATE TABLE account_transactions
(
    id             bigserial PRIMARY KEY,
    account_id     bigint NOT NULL,
    transaction_id bigint NOT NULL,
    create_at      timestamp,
    FOREIGN KEY (account_id) REFERENCES accounts (id),
    FOREIGN KEY (transaction_id) REFERENCES transactions (id)
);



