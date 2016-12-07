CREATE TABLE product(
    productId VARCHAR(36),
    productName VARCHAR(255),
    productPrice DECIMAL(10, 2),
    productImageURL VARCHAR(255),
    productDescription TEXT,
    PRIMARY KEY (productId)
);

INSERT INTO product VALUES (uuid(), "A Chair", 55.00, "image.jpg", "A Nice Chair, SIT ON ME");
