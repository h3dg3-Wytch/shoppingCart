CREATE TABLE orders(
    orderId INT NOT NULL AUTO_INCREMENT,
    productId VARCHAR(36),
    userId VARCHAR(36),
    FOREIGN KEY (productId) REFERENCES product(productId),
    FOREIGN KEY (userId) REFERENCES user(userId),
    PRIMARY KEY(orderId)
);

SELECT userId AS userId into @userIDVar from user where userName = "dev";
SELECT productId as productId into @productIDVar FROM product WHERE productName = "A Chair";

INSERT INTO orders (productId, userId) VALUES (@productIDVar, @userIDVar );