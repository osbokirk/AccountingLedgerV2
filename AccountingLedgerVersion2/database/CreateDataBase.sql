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
)
INSERT INTO transactions (date, time, description, vendor, amount) VALUES
('2024-01-15', '12:30:00', 'Purchase groceries', 'Local Supermarket', 50.25),
('2024-02-10', '14:15:00', 'Dinner with friends', 'Restaurant XYZ', 75.50),
('2024-03-20', '09:00:00', 'Monthly rent payment', 'Landlord Inc.', 1200.00),
('2024-04-05', '11:45:00', 'Internet bill', 'Internet Provider', 60.00),
('2024-05-12', '16:00:00', 'New phone purchase', 'Tech Store ABC', 799.99),
('2024-06-08', '13:20:00', 'Gasoline refill', 'Gas Station XYZ', 45.75),
('2024-07-25', '19:30:00', 'Concert tickets', 'TicketMaster', 150.00),
('2023-08-14', '10:00:00', 'Health insurance premium', 'Insurance Company', 200.00),
('2023-09-03', '08:45:00', 'Flight booking', 'Airline ABC', 350.00),
('2023-10-22', '15:10:00', 'Hotel reservation', 'Hotel XYZ', 180.50);



;