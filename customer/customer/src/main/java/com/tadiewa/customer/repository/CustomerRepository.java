/**
 * @author : tadiewa
 * date: 5/22/2023
 */

package com.tadiewa.customer.repository;

import com.tadiewa.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    Customer findByEmail(String email);
    Optional<Customer> findCustomerByMobileNumber(String mobileNumber);
}
