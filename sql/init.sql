\c docflow

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    username   TEXT      NOT NULL UNIQUE,
    password   TEXT      NOT NULL,
    role       TEXT       NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE document
(
    id         UUID PRIMARY KEY,
    creator    INT       NOT NULL,
    content_id UUID      NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);