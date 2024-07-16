package com.example.AccountingLedgerVersion2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {
    TransactionService serv = new TransactionService();
    @Test
    void monthToDate() {
        List<Transaction> item = serv.monthToDate();
        assertEquals(0,item.size());
    }

    @Test
    void previousMonth() {
        List<Transaction> item = serv.previousMonth();
        assertEquals(1,item.size());
    }

    @Test
    void yearToDate() {
        List<Transaction> item = serv.yearToDate();
        assertEquals(6,item.size());
    }

    @Test
    void previousYear() {
        List<Transaction> item = serv.previousYear();
        assertEquals(3,item.size());
    }

    @Test
    void returnAll(){
        List<Transaction> item = new ArrayList<>();
        assertEquals(10,item.size());
    }
}