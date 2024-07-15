package com.example.AccountingLedgerVersion2;

import java.time.LocalDate;

public class TransactionService {
    public void monthToDate(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),1);
        //return repository.monthToDate(localDate);
    }
    public void previousMonth(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue() - 1,1);
        LocalDate localDate2 = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue() - 1, 30);

        //return repository.previousMonth(localDate,localDate2);
    }
    public void yearToDate(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),1,1);
        //return repository.yearToDate(localDate);
    }
    public void previousYear(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear() - 1,1,1);
        LocalDate localDate2 =LocalDate.of(LocalDate.now().getYear(),1, 1);
        //return repository.previousYear(localDate,localDate2);
    }
}
