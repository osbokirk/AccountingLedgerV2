package com.example.AccountingLedgerVersion2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    public List<Transaction>  monthToDate(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue()-1, LocalDate.now().getMonth().maxLength());
        List<Transaction> transactions = new ArrayList<>();
        //Transactions = repository.monthToDate(localDate);
        return transactions;
    }
    public List<Transaction>  previousMonth(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue() - 1,1);
        LocalDate localDate2 = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue() ,1 );
        List<Transaction> transactions = new ArrayList<>();
        //return repository.previousMonth(localDate,localDate2);
        return transactions;
    }
    public List<Transaction>  yearToDate(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear()-1,12,31);
        List<Transaction> transactions = new ArrayList<>();
        //transactions = repository.yearToDate(localDate);
        return transactions;
    }
    public List<Transaction> previousYear(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),1,1);
        LocalDate localDate2 =LocalDate.of(LocalDate.now().getYear()-2,12, 31);
        List<Transaction> transactions = new ArrayList<>();
        //transactions = repository.previousYear(localDate,localDate2);
        return transactions;
    }
}
