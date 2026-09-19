CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(320) NOT NULL UNIQUE,
    status VARCHAR(40) NOT NULL DEFAULT 'ACTIVE',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL REFERENCES customers(id),
    amount NUMERIC(12, 2) NOT NULL,
    status VARCHAR(40) NOT NULL DEFAULT 'CREATED',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO customers (name, email) VALUES
    ('Ada Lovelace', 'ada@example.com')
ON CONFLICT (email) DO NOTHING;

INSERT INTO orders (customer_id, amount) 
SELECT id, 125.50 FROM customers WHERE email = 'ada@example.com'
AND NOT EXISTS (SELECT 1 FROM orders WHERE amount = 125.50);