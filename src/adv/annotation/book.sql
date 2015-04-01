CREATE TABLE
    books
    (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(50) NOT NULL,
        isbn VARCHAR(50) NOT NULL,
        author_id INT NOT NULL,
        PRIMARY KEY (id)
    )