CREATE TABLE UserProfile (
    id      INTEGER NOT NULL AUTO_INCREMENT,
    name    VARCHAR(128) NOT NULL,
    phone   VARCHAR(128) NOT NULL,
    address VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);