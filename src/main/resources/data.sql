-- Insert price rules
INSERT INTO price_rule (ID_PRICE_RULE, description, price_rule_type, simple_price)
VALUES (1, 'Regular price', 'SIMPLE', 5),
       (2, 'Three for a dollar', 'THREE_FOR_DOLLAR', 9),
       (3, 'Price per pound', 'PER_POUND', 3),
       (4, 'Buy two, get one free', 'BUY_TWO_GET_ONE_FREE', 7);

-- Insert products
INSERT INTO product (id_Product, name, id_price_rule, quantity)
VALUES (1, 'Apples', 3, 100),
       (2, 'Oranges', 1, 80),
       (3, 'Bananas', 2, 120),
       (4, 'Grapes', 1, 50),
       (5, 'Canned beans', 4, 200),
       (6, 'Pasta', 1, 150);

-- Insert carts
INSERT INTO cart (id_Cart)
VALUES (1), (2), (3);

-- Insert cart items
INSERT INTO cart_item (id_Cart_Item, product_id, cart_id, quantity)
VALUES (1, 1, 1, 3),
       (2, 2, 1, 2),
       (3, 3, 1, 5),
       (4, 4, 2, 1),
       (5, 5, 2, 6),
       (6, 6, 2, 4),
       (7, 1, 3, 2),
       (8, 2, 3, 3),
       (9, 3, 3, 1),
       (10, 4, 3, 2);
