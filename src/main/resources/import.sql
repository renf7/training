INSERT INTO users(id, account_non_expired, account_non_locked, credentials_non_expired, enabled, username, password) VALUES (1, TRUE, TRUE, TRUE, TRUE, 'admin', 'admin');

INSERT INTO roles(id, authority) VALUES (1, 'ROLE_ADMIN');

INSERT INTO users_authorities(user_id, authorities_id) VALUES (1, 1);