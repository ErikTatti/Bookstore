DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS application_user;

CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO category (name) VALUES
('Classic'),
('Fantasy'),
('Mystery'),
('Science Fiction'),
('Young Adult');

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publication_year INTEGER NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);
 
INSERT INTO book (title, author, publication_year, isbn, price, category_id) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, '9780743273565', 7.99, 1),
('To Kill a Mockingbird', 'Harper Lee', 1960, '9780061120084', 6.99, 1),
('1984', 'George Orwell', 1949, '9780451524935', 9.99, 1),
('Pride and Prejudice', 'Jane Austen', 1813, '9780679783268', 5.99, 1),
('The Catcher in the Rye', 'J.D. Salinger', 1951, '9780316769488', 6.99, 1),
('The Hobbit', 'J.R.R. Tolkien', 1937, '9780345534835', 8.99, 2),
('The Lord of the Rings', 'J.R.R. Tolkien', 1954, '9780345339706', 12.99, 2),
('The Silmarillion', 'J.R.R. Tolkien', 1977, '9780345325815', 10.99, 2),
('The Da Vinci Code', 'Dan Brown', 2003, '9780307474278', 11.99, 3),
('Angels & Demons', 'Dan Brown', 2000, '9780671027360', 10.99, 3),
('Inferno', 'Dan Brown', 2013, '9780385537858', 13.99, 3),
('The Lost Symbol', 'Dan Brown', 2009, '9780385504225', 12.99, 3),
('Digital Fortress', 'Dan Brown', 1998, '9780312944926', 9.99, 3),
('The Hunger Games', 'Suzanne Collins', 2008, '9780439023481', 8.99, 4),
('Catching Fire', 'Suzanne Collins', 2009, '9780439023498', 9.99, 4),
('Mockingjay', 'Suzanne Collins', 2010, '9780439023511', 10.99, 4);

CREATE TABLE application_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password_Hash VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

INSERT INTO application_user (username, password_Hash, role) VALUES
('user', '$2a$10$4XXGNu904amNx2Q0tPL4OOZiLP012ULGVI2a8Em4SAJGCtQG1WBJu', 'USER'),
('admin', '$2a$10$YAvqdDch33w5BecjHl6WP.LjpNaYy9jQlTcE.Krl3ib7VvzRiKUta' , 'ADMIN');
