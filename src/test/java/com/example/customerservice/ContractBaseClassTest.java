package com.example.customerservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(classes = CustomerServiceApplication.class)
@RunWith(SpringRunner.class)
public class ContractBaseClassTest {

    @Autowired
    private CustomerRestController customerRestController;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        Mockito.when(this.customerRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Customer(1L, "Bob"),
                        new Customer(2L, "Jane")));

        RestAssuredMockMvc.standaloneSetup(this.customerRestController);
    }
}
