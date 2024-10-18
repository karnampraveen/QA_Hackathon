package com.Incubation.Transaction_Service.rest;

import com.Incubation.Transaction_Service.Dtos.TransactionResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Incubation.Transaction_Service.Entity.Transaction;
import com.Incubation.Transaction_Service.Service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:person-schema.sql","classpath:person-data.sql"})
public class TransactionControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TransactionService transactionService;


    @Test
    void testGetAll() throws Exception {
        RequestBuilder mockReq = MockMvcRequestBuilders.get("/transaction/getAll?userName=admin1");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<TransactionResponseDto> getAllTrans = transactionService.getAllTransactions("admin1");
//        String getPersonAsJson = this.mapper.writeValueAsString(getPerson);

        ResultMatcher checkBody = MockMvcResultMatchers.content().json(getAllTrans);
        this.mvc.perform(mockReq).andExpect(checkStatus).andExpect(checkBody);

    }
//
//    @Test
//    void testGetByIdNotPresent() throws Exception {
//        RequestBuilder mockReq = MockMvcRequestBuilders.get("/person/5");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();
////        Person getPerson = new Person(2,"Guess Who?",99,"Guess What?");
////        String getPersonAsJson = this.mapper.writeValueAsString(getPerson);
//
////        ResponseEntity<String> noPersonError = new ResponseEntity<>("No person found with ID : 5", HttpStatus.NOT_FOUND);
////        String getNoPersonAsJson = this.mapper.writeValueAsString(noPersonError);
//
//        ResultMatcher checkBody = MockMvcResultMatchers.content().string("No person found with ID : 5");
//
//        this.mvc.perform(mockReq).andExpect(checkStatus).andExpect(checkBody);
//
//    }
//
//
//    @Test
//    void testUpdateById() throws Exception {
//        RequestBuilder mockReq = MockMvcRequestBuilders.patch("/update/1").param("name","Praveen").param("age","90");
//                //.param("name","Updated Name");
////                params("name","Updated Name");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        Person getPerson = new Person(1,"Praveen",90,"BegBorrowSteal");
//        String getPersonAsJson = this.mapper.writeValueAsString(getPerson);
//
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(getPersonAsJson);
//        this.mvc.perform(mockReq).andExpect(checkStatus).andExpect(checkBody);
//
//    }
//
//
//    @Test
//    void testGetAll() throws Exception {
//        RequestBuilder mockReq = MockMvcRequestBuilders.get("/getAll");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        List<Person> getPersons = new ArrayList<>();
//
//        Person getPerson1 = new Person(1,"TomDickHarry",10,"BegBorrowSteal");
//        Person getPerson2 = new Person(2,"Guess Who?",99,"Guess What?");
//        getPersons.add(getPerson1);
//        getPersons.add(getPerson2);
//
//        String getPersonAsJson = this.mapper.writeValueAsString(getPersons);
//
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(getPersonAsJson);
//        this.mvc.perform(mockReq).andExpect(checkStatus).andExpect(checkBody);
//
//    }
//
//
//    @Test
//    void testRemoveById() throws Exception {
//        RequestBuilder mockReq = MockMvcRequestBuilders.delete("/remove/2");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        Person getPerson = new Person(2,"Guess Who?",99,"Guess What?");
//        String getPersonAsJson = this.mapper.writeValueAsString(getPerson);
//
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(getPersonAsJson);
//        this.mvc.perform(mockReq).andExpect(checkStatus).andExpect(checkBody);
//
//    }

}
