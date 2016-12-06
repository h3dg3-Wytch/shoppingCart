CREATE TABLE user( firstName VARCHAR(255),
 lastName VARCHAR(255),
 userId INT NOT NULL AUTO_INCREMENT,
 userName VARCHAR(255),
 password VARCHAR(255),
 PRIMARY KEY(userId)
 );

INSERT INTO user (firstName, lastName, userName, password) VALUES ("dev","eloper", "dev", "password");