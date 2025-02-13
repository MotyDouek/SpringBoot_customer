package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired //we inject the customerService
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping //tells spring boot that a client can reach this data
    List<Customer> getCustomers() {
        return customerService.getCustomer();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/Exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("api request for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER ID " + id);
    }

}
