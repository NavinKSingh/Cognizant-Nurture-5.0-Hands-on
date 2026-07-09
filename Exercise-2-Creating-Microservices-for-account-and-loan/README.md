# Microservices Project - Account & Loan Services

## Architecture

```
Client Request
     |
     v
API Gateway (port: 8765)
     |
     |-----> Account Service (port: 8081)
     |-----> Loan Service    (port: 8082)
```

## Services

| Service         | Port | Description                    |
|----------------|------|--------------------------------|
| Account Service | 8081 | Account related REST APIs      |
| Loan Service    | 8082 | Loan related REST APIs         |
| API Gateway     | 8765 | Single entry point for all APIs|

## How to Run (3 Steps)

### Step 1 - Account Service Start Karo
```
IntelliJ mein account-service/AccountServiceApplication.java
Right Click -> Run
```

### Step 2 - Loan Service Start Karo
```
IntelliJ mein loan-service/LoanServiceApplication.java
Right Click -> Run
```

### Step 3 - API Gateway Start Karo
```
IntelliJ mein api-gateway/ApiGatewayApplication.java
Right Click -> Run
```

## Test APIs

### Direct Access (Service directly)
```
GET http://localhost:8081/accounts
GET http://localhost:8081/accounts/1001
GET http://localhost:8082/loans
GET http://localhost:8082/loans/2001
GET http://localhost:8082/loans/customer/Navin Kumar
```

### Via API Gateway (Gateway ke through)
```
GET http://localhost:8765/accounts
GET http://localhost:8765/accounts/1001
GET http://localhost:8765/loans
GET http://localhost:8765/loans/2001
```

## Expected Responses

### GET /accounts
```json
[
  {"accountNumber":1001,"accountType":"Savings","balance":50000.0,"customerName":"Navin Kumar"},
  {"accountNumber":1002,"accountType":"Current","balance":150000.0,"customerName":"Rahul Sharma"},
  {"accountNumber":1003,"accountType":"Savings","balance":25000.0,"customerName":"Priya Singh"}
]
```

### GET /loans
```json
[
  {"loanId":2001,"loanType":"Home Loan","loanAmount":5000000.0,"interestRate":8.5,"customerName":"Navin Kumar"},
  {"loanId":2002,"loanType":"Car Loan","loanAmount":800000.0,"interestRate":9.0,"customerName":"Rahul Sharma"},
  {"loanId":2003,"loanType":"Personal Loan","loanAmount":200000.0,"interestRate":12.0,"customerName":"Priya Singh"}
]
```
