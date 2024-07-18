CREATE PROCEDURE AddDeposit(IN description VARCHAR(255), IN vendor VARCHAR(255), IN amount DOUBLE)
BEGIN
    INSERT INTO deposits (description, vendor, amount) VALUES (description, vendor, amount);
END;