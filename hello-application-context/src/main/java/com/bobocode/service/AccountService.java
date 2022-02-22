package com.bobocode.service;

import com.bobocode.dao.AccountDao;
import com.bobocode.model.Account;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Provides service API for {@link Account}.
 */

@Service
public class AccountService {
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findRichestAccount() {
        List<Account> accounts = accountDao.findAll();
        return accounts.stream()
                .max(Comparator.comparing(Account::getBalance))
                .get();
    }

}
