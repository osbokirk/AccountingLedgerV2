CREATE PROCEDURE MakePayment(IN description VARCHAR(255), IN vendor VARCHAR(255), IN amount DOUBLE)
BEGIN
    INSERT INTO payments (description, vendor, amount) VALUES (description, vendor, amount);
END;
