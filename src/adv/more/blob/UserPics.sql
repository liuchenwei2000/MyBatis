CREATE TABLE
    user_pics
    (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(50) NOT NULL,
        pic BLOB,
        bio LONGTEXT,
        PRIMARY KEY (id)
    )