package com.example.AccountingLedgerVersion2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//mapping
@RequestMapping("/transactions")


public class Controller {
    @Autowired
    TransactionService transactionService;

    @GetMapping("")
    public List<Transaction> returnAll() {
    return transactionService.getAll();
    }

    @GetMapping("/Deposit")
    public List<Transaction> returnDeposits() {
    return transactionService.getAllDeposits();
    }

    @GetMapping("/Payment")
    public List<Transaction> returnPayments() {
    return transactionService.getAllPayments();
    }

    @PostMapping("/Transaction/Deposit/{addDeposit}")
    public void addDeposit(@RequestBody Transaction transaction) {
    }

    @PostMapping("/Transaction/Payment/{addPayment}")
    public void addPayment(@RequestBody Transaction transaction) {
    }

    @GetMapping("/monthToDate")
    public List<Transaction> monthToDate() {
    return transactionService.monthToDate();
    }

    @GetMapping("/previousMonth")
    public List<Transaction> previousMonth() {
        return transactionService.previousMonth();
    }

    @GetMapping("/yearToDate")
    public List<Transaction> yearToDate() {
        return transactionService.yearToDate();
    }

    @GetMapping("/previousYear")
    public List<Transaction> previousYear() {
       return transactionService.previousYear();
    }

    @GetMapping("/Vendor/{searchByVendor}")
    public List<Transaction> searchByVendor(@RequestParam String vendorName) {
        return transactionService.searchByVendor(vendorName);
    }

    @GetMapping("/Custom/{customSearch}")
    public List<Transaction> customSearch(@RequestParam () Date startDate,
                                          Date endDate, String description, Double amount) {
        return transactionService.customSearch(startDate, endDate, description);
    }


}
