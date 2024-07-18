CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowReportsByMonthToDate`(in  startDate Date)
BEGIN
Select * From transaction Where date > startDate;
END