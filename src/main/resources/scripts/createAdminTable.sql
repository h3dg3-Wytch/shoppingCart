CREATE TABLE admins(
    adminId INT NOT NULL AUTO_INCREMENT,
    userId VARCHAR(36),
    FOREIGN KEY(userId) REFERENCES user(userId),
    PRIMARY KEY(adminId)
);

SELECT userId AS userId into @userIDVar from user where userName = "dev";
INSERT INTO admins (userId) VALUES (@userIDVar);