package com.example.AccountingLedgerVersion2;


import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//mapping
@RequestMapping("/transactions")


public class Controller {

//repository needed
    @GetMapping("")
    public List<Transaction> returnAll() {
    //return
    }

    @GetMapping("/Deposit")
    public List<Transaction> returnDeposits() {

    }

    @GetMapping("/Payment")
    public List<Transaction> returnPayments() {

    }

    @PostMapping("/Transaction/{addTransaction}")
    public void addTransaction(@RequestBody Transaction transaction) {
        //whatever in here

    }

    @GetMapping("/monthToDate")
    public List<Transaction> monthToDate() {
    //return
    }

    @GetMapping("/previousMonth")
    public List<Transaction> previousMonth() {
        //return
    }

    @GetMapping("/yearToDate")
    public List<Transaction> yearToDate() {
        //return
    }

    @GetMapping("/previousYear")
    public List<Transaction> previousYear() {
        //return
    }

    @GetMapping("/Vendor/{searchByVendor}")
    public List<Transaction> searchByVendor(@RequestParam String vendorName) {

    }

    @GetMapping("/Custom/{customSearch}")
    public List<Transaction> customSearch(@RequestParam () Date startDate,
                                          Date endDate, String description, Double amount) {

    }


}
