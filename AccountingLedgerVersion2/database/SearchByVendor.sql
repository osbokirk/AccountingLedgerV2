CREATE PROCEDURE SearchByVendor(IN vendorName VARCHAR(255))
BEGIN
    SELECT * FROM transactions WHERE vendor = vendorName;
END;