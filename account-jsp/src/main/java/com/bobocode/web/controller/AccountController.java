package com.bobocode.web.controller;

import com.bobocode.TestDataGenerator;
import com.bobocode.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This controller provides endpoint that generates a list of {@link Account} and passes it to the view.
 */

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final TestDataGenerator testDataGenerator;

    @Autowired
    public AccountController(TestDataGenerator testDataGenerator) {
        this.testDataGenerator = testDataGenerator;
    }

    @GetMapping("/accounts")
    public String handler(@RequestParam(name = "size", defaultValue = "10") int size, Model model) {
        List<Account> accountList = Stream.generate(testDataGenerator::generateAccount)
                .limit(size)
                .collect(Collectors.toList());
        model.addAttribute("accountList", accountList);
        return "accounts";
    }

}
