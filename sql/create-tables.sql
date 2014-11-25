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

DROP TABLE IF EXISTS BILLS;
CREATE TABLE BILLS
(
  ID INT NOT NULL AUTO_INCREMENT,
  TOTAL FLOAT,
  TIP_TYPE INT,
  TIP_AMOUNT FLOAT,
  TIP_PERCENT FLOAT,
  PRIMARY KEY(ID)
);

DROP TABLE IF EXISTS BILLS_ITEMS;
CREATE TABLE BILLS_ITEMS
(
  BILL_ID INT NOT NULL REFERENCES BILLS(ID),
  ITEM_ID INT NOT NULL REFERENCES ITEMS(ID),
  QUANTITY INT
);

INSERT INTO ITEMS VALUES (DEFAULT, 'Single 4oz. Patty', 4.15, 'description', 'Original Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Double 4oz. Patty', 5.65, 'description', 'Original Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Cheeseburger', 4.69, 'description', 'Original Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Double Cheeseburger', 6.20, 'description', 'Original Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Bacon Cheeseburger', 5.25, 'description', 'Original Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Double Bacon Cheese', 6.85, 'description', 'Original Hamburgers');

INSERT INTO ITEMS VALUES (DEFAULT, 'Primetime Single', 5.25, 'Fried Egg, Fries, Cheese, Classic Sauce, Lettuce, Tomato, Onion', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Primetime Double', 6.65, 'Fried Egg, Fries, Cheese, Classic Sauce, Lettuce, Tomato, Onion', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Big Greek Single', 5.25, 'Feta Cheese, Tzatzki, Lettuce, Tomato, Onion', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Big Greek Double', 6.65, 'Feta Cheese, Tzatzki, Lettuce, Tomato, Onion', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Baconegg\'r Single', 5.79, 'Fried Egg, Bacon, Cheese, Lettuce, Ketchup, Tomato, Onion', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Baconegg\'r Double', 7.25, 'Fried Egg, Bacon, Cheese, Lettuce, Ketchup, Tomato, Onion', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Canadian Single', 5.35, 'Pemeal Bacon & Cheese', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Canadian Double', 6.99, 'Pemeal Bacon & Cheese', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Montreal Burger Single', 5.99, 'Smoked Meat & Melted Swiss with Mustard', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Montreal Burger Double', 7.39, 'Smoked Meat & Melted Swiss with Mustard', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Baja Burger Single', 5.35, 'Cream Cheese, Cheddar & Jalepenos', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Baja Burger Double', 6.99, 'Cream Cheese, Cheddar & Jalepenos', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Bacon Mushroom Swiss Single', 5.35, 'Bacon, Mushrooms & Swiss Cheese', 'Specialty Hamburgers');
INSERT INTO ITEMS VALUES (DEFAULT, 'Bacon Mushroom Swiss Double', 6.99, 'Bacon, Mushrooms & Swiss Cheese', 'Specialty Hamburgers');

INSERT INTO ITEMS VALUES (DEFAULT, 'Portobello Veggie Melt', 5.49, 'description', 'Specialty Sandwiches');
INSERT INTO ITEMS VALUES (DEFAULT, 'Chicken Breast', 5.65, 'description', 'Specialty Sandwiches');
INSERT INTO ITEMS VALUES (DEFAULT, 'Chicken N\' Bacon Melt', 6.65, 'description', 'Specialty Sandwiches');
INSERT INTO ITEMS VALUES (DEFAULT, 'Chicken Greek Style', 6.65, 'description', 'Specialty Sandwiches');
INSERT INTO ITEMS VALUES (DEFAULT, 'Cajun Chicken Caesar', 6.65, 'description', 'Specialty Sandwiches');
INSERT INTO ITEMS VALUES (DEFAULT, 'Canadian Chicken Melt', 6.85, 'description', 'Specialty Sandwiches');

INSERT INTO ITEMS VALUES (DEFAULT, 'Classic Poutine', 5.29, 'Smooth rich gravy poured all over fresh cut fries & 100% real cheese curds', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'Chicken N\' Bacon', 8.25, 'Fresh cut fries with gravy, fried onions, mushrooms, classic cheese curds & BBQ sauce', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'Chili Poutine', 6.99, 'Fresh cut fries with homemade chili & cheddar cheese curds', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'Bacon N\' Cheddar Poutine', 6.99, 'Gravy, crisy bacon strips, w/ cheddar cheese curds', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'Pulled Pork Poutine', 7.25, 'Fresh cut fries with gravy, pulled pork,BBQ sauce & classic cheese curds', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'Montreal Poutine', 7.25, 'Fresh cut fries with gravay, smoked meat & dill cheese curds', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'The Prime', 7.25, 'Fresh cut fries with gravy, Simon\'s ground beef, dill cheese curds, fried onions & mushrooms', 'Simon\'s Poutinerie');
INSERT INTO ITEMS VALUES (DEFAULT, 'Big Texas', 8.25, 'Fresh cut fries with gravy, pulled pork, bacon, cheddar cheese curds, BBQ sauce & fried onions', 'Simon\'s Poutinerie');

INSERT INTO ITEMS VALUES (DEFAULT, 'Prime Style or Cajun Reg', 3.09, 'description', 'Fresh Cut Fries');
INSERT INTO ITEMS VALUES (DEFAULT, 'Prime Style or Cajun Large', 3.79, 'description', 'Fresh Cut Fries');
INSERT INTO ITEMS VALUES (DEFAULT, 'Prime Style or Cajun Family Size', 4.50, 'description', 'Fresh Cut Fries');
INSERT INTO ITEMS VALUES (DEFAULT, 'Feta Fries', 5.29, 'description', 'Fresh Cut Fries');
INSERT INTO ITEMS VALUES (DEFAULT, 'Gravy', 0.95, 'description', 'Fresh Cut Fries');

INSERT INTO ITEMS VALUES (DEFAULT, 'Bacon', 1.15, 'description', 'Extras');
INSERT INTO ITEMS VALUES (DEFAULT, 'Cheese', 0.80, 'description', 'Extras');
INSERT INTO ITEMS VALUES (DEFAULT, 'Fried Egg', 0.89, 'description', 'Extras');
INSERT INTO ITEMS VALUES (DEFAULT, 'Beef Patty', 1.90, 'description', 'Extras');

INSERT INTO ITEMS VALUES (DEFAULT, 'Pop', 1.60, 'description', 'Drinks');
INSERT INTO ITEMS VALUES (DEFAULT, 'Water', 1.30, 'description', 'Drinks');
INSERT INTO ITEMS VALUES (DEFAULT, 'Bacon', 1.15, 'description', 'Extras');
