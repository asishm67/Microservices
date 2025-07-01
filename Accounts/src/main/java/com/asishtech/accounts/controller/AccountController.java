package com.asishtech.accounts.controller;

import com.asishtech.accounts.constants.AccountConstants;
import com.asishtech.accounts.dto.AccountDTO;
import com.asishtech.accounts.dto.CustomerDTO;
import com.asishtech.accounts.dto.ResponseDTO;
import com.asishtech.accounts.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/get-accounts")
    public String getAccounts() {
        return "Hello Accounts";
    }
    @PostMapping("/create-account")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {

        accountService.createAccount(customerDTO);

        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }
}
