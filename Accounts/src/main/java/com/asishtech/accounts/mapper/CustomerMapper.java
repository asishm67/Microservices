package com.asishtech.accounts.mapper;

import com.asishtech.accounts.dto.CustomerDTO;
import com.asishtech.accounts.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@Component
public class CustomerMapper {
    /**
     * Converts a Customer entity to a CustomerDTO object.
     *
     * @param customer the Customer entity to convert
     * @return a new CustomerDTO object with values copied from the given Customer entity
     */
    public static CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    /**
     * Converts a CustomerDTO object to a Customer entity.
     *
     * @param customerDTO the CustomerDTO object to convert
     * @return a new Customer entity with values copied from the given CustomerDTO
     */
    public static Customer toCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }
}
