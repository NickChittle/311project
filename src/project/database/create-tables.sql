DROP TABLE IF EXISTS ITEMS;
CREATE TABLE ITEMS
(
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  PRICE FLOAT,
  DESCRIPTION varchar(255),
  CATEGORY varchar(50),
  PRIMARY KEY(ID)
);

INSERT INTO ITEMS VALUES (DEFAULT, 'Pizza', 10.99, 'It\'s Pretty Good', 'entree');
INSERT INTO ITEMS VALUES (DEFAULT, 'Burger', 9.99, 'It\'s Really Good', 'entree');
INSERT INTO ITEMS VALUES (DEFAULT, 'Brownie', 5.99, 'It\'s So Good', 'dessert');
INSERT INTO ITEMS VALUES (DEFAULT, 'Garlic Bread With Cheese', 5.99, 'It\'s the Best', 'appetizer');
