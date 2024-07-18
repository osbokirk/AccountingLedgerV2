CREATE PROCEDURE CustomSearch(IN startDate DATE, IN endDate DATE, IN vendorName VARCHAR(255))
BEGIN
    SELECT * FROM transactions WHERE report_date BETWEEN startDate AND endDate AND vendor LIKE vendorName;
END;