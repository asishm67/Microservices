package com.asishtech.accounts.services;

import com.asishtech.accounts.dto.CustomerDTO;
import jakarta.validation.constraints.Pattern;

public interface AccountService {
    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccount(String mobileNumber);

    boolean deleteAccount( String mobileNumber);
}
