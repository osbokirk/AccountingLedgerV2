CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowReportsByPreviousMonth`(in startDate Date,in endDate date)
BEGIN
Select * From transactions Where date between startDate and endDate;
END