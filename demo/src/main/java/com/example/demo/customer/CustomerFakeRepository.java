package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Barak D", "123", "email@gmail.com"),
                new Customer(2L, "Shir D", "321", "email@gmail.com")
        );
    }

}
