package com.bobocode.web.controller;

import com.bobocode.dao.AccountDao;
import com.bobocode.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController("/accounts")
public class AccountRestController {

    private AccountDao accountDao;

    @Autowired
    public AccountRestController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    // Implement method that handles GET request and returns a list of accounts
    @GetMapping
    public List<Account> getAllAccounts(){
        return accountDao.findAll();
    }

    // Implement method that handles GET request with id as path variable and returns account by id
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Long id){
        return accountDao.findById(id);
    }


    // Implement method that handles POST request, receives account as request body, saves account and returns it
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account saveAccount(@RequestBody Account account){
        accountDao.save(account);
        return account;
    }

    // Implement method that handles PUT request with id as path variable and receives account as request body.
    @PutMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable("id") Long id, @RequestBody Account account){
        if(Objects.equals(account.getId(), id)){
            throw new IllegalArgumentException("Account id and path variable are the same");
        }
        accountDao.save(account);
    }

    // Implement method that handles DELETE request with id as path variable removes an account by id
    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable("id") Long id){
        accountDao.remove(accountDao.findById(id));
    }

}
