package com.Incubation.Transaction_Service.Controller;

import com.Incubation.Transaction_Service.Dtos.TransactionResponseDto;
import com.Incubation.Transaction_Service.Entity.Transaction;
import com.Incubation.Transaction_Service.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getAll")
    public List<TransactionResponseDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/new")
    public TransactionResponseDto addTransaction(@RequestBody Transaction transaction)
    {
        return transactionService.addTransaction(transaction);
    }

}
