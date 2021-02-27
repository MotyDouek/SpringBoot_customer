package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    //used for setup when the app starts
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        return useFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerRepository();
    }

}
