CREATE TABLE user( firstName VARCHAR(255),
 lastName VARCHAR(255),
 userId VARCHAR(36),
 userName VARCHAR(255),
 password VARCHAR(255),
 PRIMARY KEY(userId)
 );

INSERT INTO user (firstName, lastName, userId, userName, password) VALUES ("dev","eloper", uuid(), "dev", "password");