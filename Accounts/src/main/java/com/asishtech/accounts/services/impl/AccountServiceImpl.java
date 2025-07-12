package com.asishtech.accounts.services.impl;

import com.asishtech.accounts.constants.AccountConstants;
import com.asishtech.accounts.dto.CustomerDTO;
import com.asishtech.accounts.entity.Account;
import com.asishtech.accounts.entity.Customer;
import com.asishtech.accounts.exception.CustomerAlreadyExistsException;
import com.asishtech.accounts.mapper.CustomerMapper;
import com.asishtech.accounts.repository.AccountRepository;
import com.asishtech.accounts.repository.CustomerRepository;
import com.asishtech.accounts.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customerDTO.getMobileNumber() + " already exists");
        }
        Customer customer = customerMapper.toCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        Account account = createAccount(savedCustomer);
        accountRepository.save(account);
    }

    private Account createAccount(Customer customer) {

        Account account = new Account();
        account.setCustomerId(customer.getId());
        long randomAccountNumber = 1000000000L + new Random().nextInt( 900000000);
        account.setAccountNumber(String.valueOf(randomAccountNumber));
        account.setAccountType(AccountConstants.ACCOUNT_TYPE);
        account.setBalance(BigDecimal.ZERO);
        account.setBranchAddress(AccountConstants.BRANCH_ADDRESS);
       return account;
    }
}
