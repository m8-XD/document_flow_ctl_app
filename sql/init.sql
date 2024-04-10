\c docflow

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    username   TEXT      NOT NULL UNIQUE,
    password   TEXT      NOT NULL,
    role       TEXT       NOT NULL,
    created_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

CREATE TABLE document
(
    id         UUID PRIMARY KEY,
    creator    UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);
