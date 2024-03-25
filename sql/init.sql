\c docflow

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    username   TEXT      NOT NULL UNIQUE,
    role       INT       NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);
INSERT INTO role (id, name)
VALUES (1, 'USER'),
       (2, 'ADMIN');

CREATE TABLE document
(
    id         UUID PRIMARY KEY,
    creator    INT       NOT NULL,
    content_id UUID       NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);