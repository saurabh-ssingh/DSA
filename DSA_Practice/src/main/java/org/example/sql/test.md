Here’s a set of tables, sample data, and some interview-style SQL questions to test your skills. We'll create a simple schema with a **Book Store** theme.

---

### Schema: `book_store`

#### Table: `authors`
```sql
CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(50) NOT NULL
);
```

#### Table: `books`
```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author_id INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    published_date DATE NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);
```

#### Table: `customers`
```sql
CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(50) NOT NULL
);
```

#### Table: `orders`
```sql
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    book_id INT NOT NULL,
    order_date DATE NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    total_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
```

---

### Sample Data: `INSERT` Queries

#### Insert Data for `authors`
```sql
INSERT INTO authors (name, country) VALUES
('J.K. Rowling', 'UK'),
('George R.R. Martin', 'USA'),
('Haruki Murakami', 'Japan'),
('Agatha Christie', 'UK'),
('Chinua Achebe', 'Nigeria');
```

#### Insert Data for `books`
```sql
INSERT INTO books (title, author_id, genre, price, published_date) VALUES
('Harry Potter and the Sorcerer''s Stone', 1, 'Fantasy', 19.99, '1997-06-26'),
('A Game of Thrones', 2, 'Fantasy', 24.99, '1996-08-06'),
('Norwegian Wood', 3, 'Fiction', 15.50, '1987-09-04'),
('Murder on the Orient Express', 4, 'Mystery', 10.99, '1934-01-01'),
('Things Fall Apart', 5, 'Historical Fiction', 12.99, '1958-06-17');
```

#### Insert Data for `customers`
```sql
INSERT INTO customers (name, email, city) VALUES
('Alice Johnson', 'alice@example.com', 'New York'),
('Bob Smith', 'bob@example.com', 'Los Angeles'),
('Charlie Brown', 'charlie@example.com', 'Chicago');
```

#### Insert Data for `orders`
```sql
INSERT INTO orders (customer_id, book_id, order_date, quantity, total_price) VALUES
(1, 1, '2024-12-01', 2, 39.98),
(2, 3, '2024-12-03', 1, 15.50),
(3, 5, '2024-12-04', 3, 38.97),
(1, 4, '2024-12-05', 1, 10.99);
```

---

### SQL Interview Questions

1. **Basic Queries**
    - Find all books written by authors from the UK.
    - Retrieve customer names and email addresses who ordered more than one book.

2. **Join Queries**
    - List all orders along with the customer name and the book title.
    - Find the total revenue generated from each book.

3. **Aggregation**
    - Count how many books have been ordered by each customer.
    - Calculate the total revenue generated from all orders.

4. **Subqueries**
    - Find the name of the customer who spent the most money on books.
    - List all books that have never been ordered.

5. **Advanced Queries**
    - Retrieve all authors who have written books in the "Fantasy" genre.
    - Find the book with the highest price and its author.

6. **Updates and Deletes**
    - Increase the price of all books in the "Fantasy" genre by 10%.
    - Delete all orders where the total price is less than $20.

---

Let me know if you need explanations for any of the queries!

Here are the answers to the SQL interview questions:

---

### 1. **Basic Queries**

- **Find all books written by authors from the UK:**
  ```sql
  SELECT b.title 
  FROM books b
  JOIN authors a ON b.author_id = a.id
  WHERE a.country = 'UK';
  ```

- **Retrieve customer names and email addresses who ordered more than one book:**
  ```sql
  SELECT c.name, c.email
  FROM customers c
  JOIN orders o ON c.id = o.customer_id
  GROUP BY c.name, c.email
  HAVING SUM(o.quantity) > 1;
  ```

---

### 2. **Join Queries**

- **List all orders along with the customer name and the book title:**
  ```sql
  SELECT c.name AS customer_name, b.title AS book_title, o.quantity, o.total_price, o.order_date
  FROM orders o
  JOIN customers c ON o.customer_id = c.id
  JOIN books b ON o.book_id = b.id;
  ```

- **Find the total revenue generated from each book:**
  ```sql
  SELECT b.title, SUM(o.total_price) AS total_revenue
  FROM orders o
  JOIN books b ON o.book_id = b.id
  GROUP BY b.title;
  ```

---

### 3. **Aggregation**

- **Count how many books have been ordered by each customer:**
  ```sql
  SELECT c.name, COUNT(o.book_id) AS books_ordered
  FROM orders o
  JOIN customers c ON o.customer_id = c.id
  GROUP BY c.name;
  ```

- **Calculate the total revenue generated from all orders:**
  ```sql
  SELECT SUM(total_price) AS total_revenue
  FROM orders;
  ```

---

### 4. **Subqueries**

- **Find the name of the customer who spent the most money on books:**
  ```sql
  SELECT name
  FROM customers
  WHERE id = (
    SELECT customer_id
    FROM orders
    GROUP BY customer_id
    ORDER BY SUM(total_price) DESC
    LIMIT 1
  );
  ```

- **List all books that have never been ordered:**
  ```sql
  SELECT title
  FROM books
  WHERE id NOT IN (SELECT book_id FROM orders);
  ```

---

### 5. **Advanced Queries**

- **Retrieve all authors who have written books in the "Fantasy" genre:**
  ```sql
  SELECT DISTINCT a.name
  FROM authors a
  JOIN books b ON a.id = b.author_id
  WHERE b.genre = 'Fantasy';
  ```

- **Find the book with the highest price and its author:**
  ```sql
  SELECT b.title, a.name AS author, b.price
  FROM books b
  JOIN authors a ON b.author_id = a.id
  ORDER BY b.price DESC
  LIMIT 1;
  ```

---

### 6. **Updates and Deletes**

- **Increase the price of all books in the "Fantasy" genre by 10%:**
  ```sql
  UPDATE books
  SET price = price * 1.10
  WHERE genre = 'Fantasy';
  ```

- **Delete all orders where the total price is less than $20:**
  ```sql
  DELETE FROM orders
  WHERE total_price < 20;
  ```

---

Let me know if you need further clarifications!

Let me know if you need further clarification!

Here are **30 SQL questions with their answers** for practice and interview preparation.

---

### **Basic Queries**

1. **Find the names of all authors.**  
   **Answer:**
    - *J.K. Rowling*
    - *George R.R. Martin*
    - *Haruki Murakami*
    - *Agatha Christie*
    - *Chinua Achebe*

2. **Find all books priced above $15.**  
   **Answer:**
    - *Harry Potter and the Sorcerer's Stone*
    - *A Game of Thrones*
    - *Norwegian Wood*

3. **List the names of all customers.**  
   **Answer:**
    - *Alice Johnson*
    - *Bob Smith*
    - *Charlie Brown*

4. **Find the total number of orders placed.**  
   **Answer:**
    - *4*

5. **Retrieve the cities where customers live.**  
   **Answer:**
    - *New York*
    - *Los Angeles*
    - *Chicago*

---

### **Join Queries**

6. **List all books along with their author's name.**  
   **Answer:**
    - *Harry Potter and the Sorcerer's Stone, J.K. Rowling*
    - *A Game of Thrones, George R.R. Martin*
    - *Norwegian Wood, Haruki Murakami*
    - *Murder on the Orient Express, Agatha Christie*
    - *Things Fall Apart, Chinua Achebe*

7. **Find all orders with customer name and book title.**  
   **Answer:**
    - *Alice Johnson, Harry Potter and the Sorcerer's Stone*
    - *Bob Smith, Norwegian Wood*
    - *Charlie Brown, Things Fall Apart*
    - *Alice Johnson, Murder on the Orient Express*

8. **Retrieve the country of the author for each book.**  
   **Answer:**
    - *Harry Potter and the Sorcerer's Stone, UK*
    - *A Game of Thrones, USA*
    - *Norwegian Wood, Japan*
    - *Murder on the Orient Express, UK*
    - *Things Fall Apart, Nigeria*

9. **Find all customers who ordered books written by UK authors.**  
   **Answer:**
    - *Alice Johnson*

10. **List customers and the total quantity of books they ordered.**  
    **Answer:**
- *Alice Johnson: 3*
- *Bob Smith: 1*
- *Charlie Brown: 3*

---

### **Aggregation Queries**

11. **Find the total revenue generated.**  
    **Answer:**
- *$105.44*

12. **Count the number of books in each genre.**  
    **Answer:**
- *Fantasy: 2*
- *Fiction: 1*
- *Mystery: 1*
- *Historical Fiction: 1*

13. **Find the average price of all books.**  
    **Answer:**
- *$16.69*

14. **Find the highest total price in the orders table.**  
    **Answer:**
- *$39.98*

15. **Find the total number of books written by authors from the USA.**  
    **Answer:**
- *1*

---

### **Subqueries**

16. **Find the customer who placed the largest order (total price).**  
    **Answer:**
- *Alice Johnson*

17. **List books that have never been ordered.**  
    **Answer:**
- *A Game of Thrones*

18. **Find the most expensive book and its author.**  
    **Answer:**
- *A Game of Thrones, George R.R. Martin*

19. **Find authors whose books have been ordered more than twice.**  
    **Answer:**
- *J.K. Rowling*
- *Chinua Achebe*

20. **List customers who haven’t placed any orders.**  
    **Answer:**
- *None (All customers have placed orders)*

---

### **Advanced Queries**

21. **Retrieve all authors who have written books priced below $20.**  
    **Answer:**
- *Haruki Murakami*
- *Agatha Christie*
- *Chinua Achebe*

22. **Find books written by authors from either Japan or Nigeria.**  
    **Answer:**
- *Norwegian Wood*
- *Things Fall Apart*

23. **Find the book with the oldest publication date.**  
    **Answer:**
- *Murder on the Orient Express (1934-01-01)*

24. **Find books that belong to the "Fantasy" genre and have been ordered.**  
    **Answer:**
- *Harry Potter and the Sorcerer's Stone*

25. **Retrieve authors whose books are in the "Historical Fiction" genre.**  
    **Answer:**
- *Chinua Achebe*

---

### **Updates and Deletes**

26. **Increase the price of all books in the "Fiction" genre by 5%.**  
    **Updated Price:**
- *Norwegian Wood: $16.28*

27. **Mark orders with total price below $20 as "Low Value" (Assume a column for status).**  
    **Affected Orders:**
- *Norwegian Wood (Order ID: 2)*
- *Murder on the Orient Express (Order ID: 4)*

28. **Delete all books with a price below $12.**  
    **Deleted Book:**
- *Murder on the Orient Express*

29. **Reduce the quantity of all orders placed on 2024-12-04 by 1.**  
    **Updated Quantities:**
- *Charlie Brown, Things Fall Apart: 2*

30. **Update the city of a customer to "Unknown" if no orders exist.**  
    **Affected Customers:**
- *None (All customers have orders)*

---

These questions and answers should give you a solid foundation for practicing SQL and preparing for interviews. Let me know if you need more challenging queries!