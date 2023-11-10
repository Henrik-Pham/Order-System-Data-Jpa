package com.example.jpademo;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.DocFlavor;
import java.net.URL;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private final String customerUrl = ("http://localhost:8080/api/customer");

    @Test
    void shouldGetListOfCustomers() throws Exception {
        mockMvc.perform(get(customerUrl))
                .andExpect(status().isOk()); /** andExpect is the assertion **/
                //.andExpect(JsonPath);
    }
}
