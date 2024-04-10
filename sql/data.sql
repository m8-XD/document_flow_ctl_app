INSERT INTO users (id, username, password, role, created_at)
VALUES (
    '501f6f75-4e6a-4b4c-be5b-fa8155a01f84',                          -- id
    'admin',                                                         -- username
    '$2a$04$rmuBBeii21V3fq4FbzByYOc6iaft4dWYk9/pdndt4KG/uDWpBblyW',  -- password
    'ADMIN',                                                         -- role
    NOW()                                                            -- created_at
);
