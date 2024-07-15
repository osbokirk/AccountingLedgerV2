USE sys;

# ---------------------------------------------------------------------- #
# Target DBMS:           MySQL                                           #
# Project name:          accountingLedger                                      #
# ---------------------------------------------------------------------- #
DROP DATABASE IF EXISTS accountingLedger;

CREATE DATABASE IF NOT EXISTS accountingLedger;

USE accountingLedger;

# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE users (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    description VARCHAR(50) NOT NULL,
    vendor VARCHAR(255) NOT NULL,
    amount float NOT NULL,
    PRIMARY KEY (transaction_id)
);