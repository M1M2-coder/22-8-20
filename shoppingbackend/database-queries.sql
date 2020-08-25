CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

--Insert 3 dummy categories.
INSERT INTO category(name,description,image_url,is_active)
	   VALUES('Laptop','All What You Want To Know About Televisions','Cat_1.png',true);
INSERT INTO category(name,description,image_url,is_active)
	   VALUES('Television','All What You Want To Know About Mobiles','Cat_2.png',true);
INSERT INTO category(name,description,image_url,is_active)
	   VALUES('Mobile','All What You Want To Know About Laptops','Cat_3.png',true);

-- user detail table
CREATE TABLE user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled boolean,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	CONSTRAINT pk_user_detail_id PRIMARY KEY (id)
);

--Insert 3 dummy users.
INSERT INTO user_detail(first_name,last_name,role,enabled, password, email,contact_number)
	   VALUES('Mahmoud','Ahmadieh','ADMIN',true,'admin','mahmoud@gmail.com','9991119991');
INSERT INTO user_detail(first_name,last_name,role,enabled, password, email,contact_number)
	   VALUES('Mark','Daou','USER',true,'12345','mark@gmail.com','7771119991');
INSERT INTO user_detail(first_name,last_name,role,enabled, password, email,contact_number)
	   VALUES('Hana','Jawhar','USER',true,'12345','hana@gmail.com','8881119991');
	   
--Create table product.
CREATE TABLE product(
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)
);
	   
-- adding five products
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );
	   
	   
	   
	   
	











	   