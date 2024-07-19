package com.example.AccountingLedgerVersion2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class TransactionService {

    @Autowired
    DAO dao;

    public List<Transaction>  monthToDate(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue()-1, LocalDate.now().getMonth().maxLength());
        List<Transaction> transactions = new ArrayList<>();
        Date date = java.sql.Date.valueOf(localDate);
        try {
            ResultSet  resultSet = dao.showReportsByMonthToDate((java.sql.Date) date);
            transactions = mapResults(resultSet,transactions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
    public List<Transaction>  previousMonth(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue() - 1,1);
        Date date1 = java.sql.Date.valueOf(localDate);
        LocalDate localDate2 = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue() ,1 );
        Date date2 = java.sql.Date.valueOf(localDate2);
        List<Transaction> transactions = new ArrayList<>();
        try {
            ResultSet  resultSet = dao.showReportsByPreviousMonth((java.sql.Date) date1,(java.sql.Date)date2);
            transactions = mapResults(resultSet,transactions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
    public List<Transaction>  yearToDate(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear()-1,12,31);
        Date date = java.sql.Date.valueOf(localDate);
        List<Transaction> transactions = new ArrayList<>();

        try {
            ResultSet  resultSet = dao.showReportsByYearToDate((java.sql.Date) date);
            transactions = mapResults(resultSet,transactions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
    public List<Transaction> previousYear(){
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),1,1);
        Date date = java.sql.Date.valueOf(localDate);
        LocalDate localDate2 =LocalDate.of(LocalDate.now().getYear()-2,12, 31);
        Date date2 = java.sql.Date.valueOf(localDate);
        List<Transaction> transactions = new ArrayList<>();
        try {
            ResultSet  resultSet = dao.showReportsByPreviousYear((java.sql.Date) date, (java.sql.Date) date2);
            transactions = mapResults(resultSet,transactions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //transactions = repository.previousYear(localDate,localDate2);
        return transactions;
    }
    public List<Transaction> getAll(){
        List<Transaction> transactions = new ArrayList<>();
        try{
            ResultSet resultSet = dao.showAllLedgers();
            transactions = mapResults(resultSet, transactions);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }

    public List<Transaction> getAllDeposits(){
        List<Transaction> transactions = new ArrayList<>();
        try{
            ResultSet resultSet = dao.showAllDeposits();
            transactions = mapResults(resultSet, transactions);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }

    public List<Transaction> getAllPayments(){
        List<Transaction> transactions = new ArrayList<>();
        try{
            ResultSet resultSet = dao.showAllPayments();
            transactions = mapResults(resultSet, transactions);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }

    public List<Transaction> searchByVendor(String vendor){
        List<Transaction> transactions = new ArrayList<>();
        try{
            ResultSet resultSet = dao.searchByVendor(vendor);
            transactions = mapResults(resultSet, transactions);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }
    public void addPayment(String description,String vendor, double amount){
        if(amount > 0){
            amount *= -1;
        }
        try{
            dao.makePayment(description,vendor,amount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDeposit(String description,String vendor, double amount){
        if(amount < 0){
            amount *= -1;
        }
        try{
            dao.addDeposit(description,vendor,amount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Transaction> customSearch(Date date,Date endDate,String vendor){
        List<Transaction> transactions = new ArrayList<>();
        try{
            ResultSet resultSet = dao.customSearch((java.sql.Date) date, (java.sql.Date) endDate,vendor);
            transactions = mapResults( resultSet,transactions);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }





    public List<Transaction> mapResults(ResultSet resultSet, List<Transaction> transactions){
        try{
            while (resultSet.next()){
                    Date date = resultSet.getDate("Date");
                    Time time = resultSet.getTime("Time");
                    double amount = resultSet.getDouble("amount");
                    String vendor = resultSet.getString("vendor");
                    String description = resultSet.getString("description");

                    Transaction transaction = new Transaction(date,time,description,vendor,amount);
                    transactions.add(transaction);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return transactions;
    }
}
