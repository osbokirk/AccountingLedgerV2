CREATE PROCEDURE `CALL ShowReportsByPreviousYear` (in startDate date, in endDate date)
BEGIN
Select * from transactions where date between startDate and endDate;
END
