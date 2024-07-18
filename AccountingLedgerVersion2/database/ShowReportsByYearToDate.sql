CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowReportsByYearToDate`(in startedDate date)
BEGIN
Select * From transactions where date > startedDate;
END