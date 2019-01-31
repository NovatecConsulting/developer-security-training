CREATE TABLE user_account
(
  USER_ID            BIGINT NOT NULL AUTO_INCREMENT,
  USER_NAME          VARCHAR(30) NOT NULL,
  ENCRYPTED_PASSWORD VARCHAR(128) NOT NULL,
  USER_ROLE          VARCHAR(15) NOT NULL,
  EMAIL              VARCHAR(36) NOT NULL,
  FIRST_NAME         VARCHAR(30) NOT NULL,
  LAST_NAME          VARCHAR(30) NOT NULL,
  PRIMARY KEY (USER_ID)
) ;

CREATE TABLE persistent_logins (
 
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
     
);

CREATE TABLE hibernate_sequences (

    sequence_name VARCHAR(64) NOT NULL,
    next_val BIGINT NOT NULL
);

INSERT INTO user_account (USER_ID, USER_NAME, ENCRYPTED_PASSWORD, USER_ROLE, EMAIL, FIRST_NAME, LAST_NAME)
VALUES (1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ADMIN', 'admin@springboot.com', 'System', 'Admin');
 
INSERT INTO user_account (USER_ID, USER_NAME, ENCRYPTED_PASSWORD, USER_ROLE, EMAIL, FIRST_NAME, LAST_NAME)
VALUES (2, 'standarduser', '$2a$10$jRwNMj5GxaArhGKkiIzaG.regJ3mTqm2kbCqY6iLzg9D7mydr1uBa', 'USER', 'john.doe@springboot.com' , 'John', 'Doe');
