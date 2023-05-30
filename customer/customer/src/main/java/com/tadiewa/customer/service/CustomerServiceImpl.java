/**
 * @author : tadiewa
 * date: 5/22/2023
 */


package com.tadiewa.customer.service;

import com.tadiewa.customer.exeception.BadRequestException;
import com.tadiewa.customer.model.Customer;
import com.tadiewa.customer.repository.CustomerRepository;
import com.tadiewa.customer.exeception.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl {
    private CustomerRepository repository;

    public List<Customer> getAllUsers() {
        return repository.findAll();
    }

    public void saveCustomer(Customer customer) {
        Customer user = repository.findByEmail(customer.getEmail());
        if (Objects.nonNull(user)) {
            throw new BadRequestException(Error.USER_ALREADY_EXISTS.getErrorCode(),
                    Error.USER_ALREADY_EXISTS.getErrorMessage());
        }
        repository.save(customer);
    }

    public Customer updateUCustomerInfo(Customer customer) {
        Customer customerToUpdate =  findCustomerByMobileNumber(customer.getMobileNumber());
        return Customer.builder()
                .contactAddress(customer.getContactAddress())
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .gender(customer.getGender())
                .dateOfBirth(customer.getDateOfBirth())
                .password(customer.getPassword())
                .mobileNumber(customer.getMobileNumber())
                .build();
    }

    public Customer findCustomerByMobileNumber( String mobileNumber) {
        return repository.findCustomerByMobileNumber(mobileNumber)
                .orElseThrow(() -> new BadRequestException(Error.USER_NOT_FOUND.getErrorCode(),
                        Error.USER_NOT_FOUND.getErrorMessage()));
    }
}
