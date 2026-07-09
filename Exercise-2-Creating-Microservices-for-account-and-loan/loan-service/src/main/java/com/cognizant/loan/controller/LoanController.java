package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoanController.class);

    // Sample in-memory data
    private List<Loan> loanList = new ArrayList<>() {{
        add(new Loan(2001, "Home Loan", 5000000.00, 8.5, "Navin Kumar"));
        add(new Loan(2002, "Car Loan",  800000.00,  9.0, "Rahul Sharma"));
        add(new Loan(2003, "Personal Loan", 200000.00, 12.0, "Priya Singh"));
    }};

    // GET /loans - Get all loans
    @GetMapping
    public List<Loan> getAllLoans() {
        LOGGER.info("START - getAllLoans");
        LOGGER.debug("loans={}", loanList);
        LOGGER.info("END - getAllLoans");
        return loanList;
    }

    // GET /loans/{loanId} - Get loan by ID
    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable int loanId) {
        LOGGER.info("START - getLoanById");
        LOGGER.debug("loanId={}", loanId);

        Loan loan = loanList.stream()
                .filter(l -> l.getLoanId() == loanId)
                .findFirst()
                .orElse(null);

        LOGGER.debug("loan={}", loan);
        LOGGER.info("END - getLoanById");
        return loan;
    }

    // GET /loans/customer/{customerName} - Get loans by customer name
    @GetMapping("/customer/{customerName}")
    public List<Loan> getLoansByCustomer(@PathVariable String customerName) {
        LOGGER.info("START - getLoansByCustomer");
        LOGGER.debug("customerName={}", customerName);

        List<Loan> customerLoans = loanList.stream()
                .filter(l -> l.getCustomerName()
                        .equalsIgnoreCase(customerName))
                .toList();

        LOGGER.debug("customerLoans={}", customerLoans);
        LOGGER.info("END - getLoansByCustomer");
        return customerLoans;
    }
}
