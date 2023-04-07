-- Insert sample data for products
INSERT INTO product (id_product, name, price) VALUES (1, 'Apple', 0.5);
INSERT INTO product (id_product, name, price) VALUES (2, 'Banana', 0.3);
INSERT INTO product (id_product, name, price) VALUES (3, 'Orange', 0.4);
INSERT INTO product (id_product, name, price) VALUES (4, 'Strawberries', 0.8);
INSERT INTO product (id_product, name, price) VALUES (5, 'Blueberries', 0.6);
INSERT INTO product (id_product, name, price) VALUES (6, 'Grapes', 1.2);
INSERT INTO product (id_product, name, price) VALUES (7, 'Kiwi', 0.9);
INSERT INTO product (id_product, name, price) VALUES (8, 'Mango', 1.5);
INSERT INTO product (id_product, name, price) VALUES (9, 'Milk', 1.2);
INSERT INTO product (id_product, name, price) VALUES (10, 'Bread', 1.0);
INSERT INTO product (id_product, name, price) VALUES (11, 'Eggs', 2.5);
INSERT INTO product (id_product, name, price) VALUES (12, 'Butter', 3.0);
INSERT INTO product (id_product, name, price) VALUES (13, 'Cereal', 4.5);
INSERT INTO product (id_product, name, price) VALUES (14, 'Toothpaste', 2.0);
INSERT INTO product (id_product, name, price) VALUES (15, 'Shampoo', 5.0);

-- Insert sample data for carts
INSERT INTO cart (id_cart) VALUES (1);
INSERT INTO cart (id_cart) VALUES (2);
INSERT INTO cart (id_cart) VALUES (3);
INSERT INTO cart (id_cart) VALUES (4);
INSERT INTO cart (id_cart) VALUES (5);
INSERT INTO cart (id_cart) VALUES (6);
INSERT INTO cart (id_cart) VALUES (7);

-- Insert sample data for cart_items
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (1, 1, 1, 5);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (2, 1, 2, 3);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (3, 2, 3, 2);
iNSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (4, 3, 4, 10);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (5, 3, 5, 8);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (6, 4, 6, 4);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (7, 4, 7, 6);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (8, 5, 8, 3);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (9, 5, 1, 10);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (10, 6, 9, 2);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (11, 6, 10, 1);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (12, 6, 11, 12);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (13, 7, 12, 1);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (14, 7, 13, 2);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (15, 7, 14, 1);
INSERT INTO cart_item (id_cart_item, cart_id, product_id, quantity) VALUES (16, 7, 15, 1);
