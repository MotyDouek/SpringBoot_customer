package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired //we inject the customerService
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping //tells spring boot that a client can reach this data
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

}
