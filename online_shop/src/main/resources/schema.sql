    DROP DATABASE IF EXISTS vvv;

CREATE DATABASE vvv;

USE vvv;
CREATE TABLE appProduct(
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(67),
  productDescription VARCHAR(67),
  productGuarantee VARCHAR(67),
  productPrice VARCHAR(67)
);

CREATE TABLE productProvider(
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(67),
  shopBrancheNr VARCHAR(60),
  address VARCHAR(60),
  phoneNumber VARCHAR(60),
  email VARCHAR(60),
  appProduct_id INT,
  FOREIGN KEY (appProduct_id)
    REFERENCES appProduct(id)
);

CREATE TABLE productCustomer(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(60),
  address VARCHAR(60),
  phoneNumber VARCHAR(60),
  email VARCHAR(70),
  productProvider_id int,
  FOREIGN KEY (productProvider_id)
    REFERENCES productProvider(id)
);

CREATE TABLE appService (
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(60),
  serviceDescription VARCHAR(60),
  serviceLength VARCHAR(60),
  servicePrice VARCHAR(60)
);

CREATE TABLE serviceProvider(
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(60),
  companyType VARCHAR(60),
  address VARCHAR(60),
  phoneNumber VARCHAR(60),
  email VARCHAR(60),
  appService_id INT,
  FOREIGN KEY (appService_id)
    REFERENCES appService(id)
);

CREATE TABLE serviceCustomer(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(60),
 address VARCHAR(60),
  phoneNumber VARCHAR(60),
  email VARCHAR(70),
  serviceProvider_id int,
  FOREIGN KEY (serviceProvider_id)
    REFERENCES serviceProvider(id)
);