
INSERT INTO appProduct(name, productDescription, productGuarantee, productPrice) VALUES
  ('name 1','productDescription 1','productGuarantee 1','productPrice 1'),
  ('name 2','productDescription 2','productGuarantee 2','productPrice 2');

INSERT INTO productProvider(name,shopBrancheNr,address,phoneNumber,email,appProduct_id) VALUES
  ('Floor 1','shopBrancheNr 1','address 1','phoneNumber 1','email 1', 1),
  ('Floor 2','shopBrancheNr 2','address 2','phoneNumber 2','email 2', 1),
  ('Floor 3','shopBrancheNr 3','address 3','phoneNumber 3','email 3', 2);

INSERT INTO productCustomer(name,address,phoneNumber,email,  productProvider_id) VALUES
  ('name 1','address 1', 'phoneNumber 1', 'email 1',  1),
  ('name 2', 'address 2','phoneNumber 2','email 2', 2),
  ('name 3','address 3', 'phoneNumber 3', 'email 3', 2),
  ('name 4','address 4','phoneNumber 4','email 4', 3);


INSERT INTO appService(name, serviceDescription,serviceLength,servicePrice) VALUES
  ('name 1','serviceDescription 1','serviceLength 1','servicePrice 1'),
  ('name 2','serviceDescription 2','serviceLength 2','servicePrice 2');

INSERT INTO serviceProvider(name,companyType,address,phoneNumber,email, appService_id) VALUES
  ('name 1','companyType 1','address 1','phoneNumber 1','email 1', 1),
  ('name 2','companyType 2','address 2','phoneNumber 2','email 2', 1),
  ('name 3','companyType 3','address 3','phoneNumber 3','email 3', 2);

INSERT INTO serviceCustomer(name,address,phoneNumber,email, serviceProvider_id) VALUES
  ('name 1','address 1','phoneNumber 1','email 1', 1),
  ('name 2','address 2','phoneNumber 2','email 2', 2),
  ('name 3','address 3','phoneNumber 3','email 3', 2),
  ('name 4','address 4','phoneNumber 4','email 4', 3);
