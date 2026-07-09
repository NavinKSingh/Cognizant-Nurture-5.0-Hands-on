package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AccountController.class);

    // Sample in-memory data
    private List<Account> accountList = new ArrayList<>() {{
        add(new Account(1001, "Savings", 50000.00, "Navin Kumar"));
        add(new Account(1002, "Current", 150000.00, "Rahul Sharma"));
        add(new Account(1003, "Savings", 25000.00, "Priya Singh"));
    }};

    // GET /accounts - Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        LOGGER.info("START - getAllAccounts");
        LOGGER.debug("accounts={}", accountList);
        LOGGER.info("END - getAllAccounts");
        return accountList;
    }

    // GET /accounts/{accountNumber} - Get account by number
    @GetMapping("/{accountNumber}")
    public Account getAccountByNumber(@PathVariable int accountNumber) {
        LOGGER.info("START - getAccountByNumber");
        LOGGER.debug("accountNumber={}", accountNumber);

        Account account = accountList.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);

        LOGGER.debug("account={}", account);
        LOGGER.info("END - getAccountByNumber");
        return account;
    }
}
