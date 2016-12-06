CREATE DATABASE shoppingCart;

CREATE USER 'developer'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON shoppingCart.* TO 'developer'@'localhost';

FLUSH PRIVILEGES;