/**
 * @author : tadiewa
 * date: 5/22/2023
 */


package com.tadiewa.customer.controller;

import com.tadiewa.customer.model.Customer;
import com.tadiewa.customer.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private  final CustomerServiceImpl service;

    @GetMapping("/get-all-users")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Customer customer){
        service.saveCustomer(customer);
    }
    @PutMapping("/update-user-info")
    public ResponseEntity<Customer> updateUserInfo(@RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(service.updateUCustomerInfo(customer));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Customer> getUserById(@PathVariable String mobileNumber) {
        return ResponseEntity.ok(service.findCustomerByMobileNumber(mobileNumber));
    }
}
