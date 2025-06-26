package com.asishtech.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    @GetMapping("/get-accounts")
    public String getAccounts() {
        return "Hello Accounts";
    }
}
