CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(150),
    status VARCHAR(30),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INT,
    amount DECIMAL(10,2),
    status VARCHAR(30),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO customer(name, email, status)
VALUES
('Rahul', 'rahul@gmail.com', 'ACTIVE'),
('Priya', 'priya@gmail.com', 'ACTIVE');

INSERT INTO orders(customer_id, amount, status)
VALUES
(1, 1500.00, 'CREATED'),
(2, 2500.00, 'CREATED');