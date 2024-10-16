package com.Incubation.Transaction_Service.Service;
import com.Incubation.Transaction_Service.Dtos.TransactionResponseDto;
import com.Incubation.Transaction_Service.Entity.Transaction;
import com.Incubation.Transaction_Service.Repo.TransactionRepository;
import com.Incubation.Transaction_Service.feign.TransactionFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionFeignInterface transactionFeignInterface;

    @Autowired
    BudgetService budgetService;

    public TransactionResponseDto addTransaction(Transaction transaction)
    {
//        Transaction transaction = TransactionRequestDtoToTransaction(transactionRequestDto);
            if (Objects.equals(transaction.getTransactionType().toUpperCase(), "INCOME")) {
                    Optional<Transaction> checkTransaction = transactionRepository.findByUserNameAndTransactionType(transaction.getUserName(),"INCOME");
                    if(checkTransaction.isPresent()){
                        Transaction existingTransaction = checkTransaction.get();
                        existingTransaction.setAmount(existingTransaction.getAmount()+transaction.getAmount());
                        existingTransaction.setDate(LocalDate.now());
                        existingTransaction.setTransactionType("INCOME");
                        transactionRepository.save(existingTransaction);
                    }
                    else{
                        transaction.setDate(LocalDate.now());
                        transaction.setTransactionType("INCOME");
                        transactionRepository.save(transaction);
                    }
//                Long updatedBal = transactionFeignInterface.addBalance(transaction.getUserName(), "ADD", transaction.getAmount());
//                Long updatedBal = transactionFeignInterface.getBalance1(transaction.getUserName());
            }
            else{
                transaction.setDate(LocalDate.now());
                transactionRepository.save(transaction);
            }
            return transactionToTransactionResponseDto(transaction);
    }


    public Double getIncome(String userName)
    {
        Optional<Transaction> checkTransaction = transactionRepository.findByUserNameAndTransactionType(userName,"INCOME");
        if(checkTransaction.isPresent()){
            Transaction existingTransaction = checkTransaction.get();
            return existingTransaction.getAmount();
        }
        else{
            return 0D;
        }

    }
    public List<TransactionResponseDto> getAllTransactions(String name)  {
        List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<>();
        List<Transaction> transactions = transactionRepository.findByUserName(name);
        for (Transaction transaction: transactions) {
            transactionResponseDtoList.add(transactionToTransactionResponseDto(transaction));
        }

        return transactionResponseDtoList;
}

//private Transaction TransactionRequestDtoToTransaction(TransactionRequestDto transactionRequestDto) throws UserNotFoundException, CategoryNotFoundException {
//    return new Transaction(
//            userService.findByEmail(transactionRequestDto.getUserEmail()),
//            categoryService.getCategoryById(transactionRequestDto.getCategoryId()),
//            transactionRequestDto.getDescription(),
//            transactionRequestDto.getAmount(),
//            transactionRequestDto.getDate()
//    );
//}

private TransactionResponseDto transactionToTransactionResponseDto(Transaction transaction) {

    return new TransactionResponseDto(
            transaction.getTransactionId(),
            transaction.getCategory(),
            transaction.getTransactionType(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getDate()
    );
}
//
//private Map<String, List<TransactionResponseDto>> groupTransactionsByDate(List<TransactionResponseDto> transactionResponseDtoList) {
//    LocalDate today = LocalDate.now();
//    LocalDate yesterday = today.minusDays(1);
//
//    return transactionResponseDtoList.stream().collect(Collectors.groupingBy(t -> {
//
//                if (t.getDate().equals(today)) {
//                    return "Today";
//                }else if (t.getDate().equals(yesterday)) {
//                    return "Yesterday";
//                }else {
//                    return t.getDate().toString();
//                }
//            }))
//            .entrySet().stream()
//            .sorted((entry1, entry2 ) -> {
//                if (entry1.getKey().equals("Today")) return -1;
//                else if (entry2.getKey().equals("Today")) return 1;
//                else if (entry1.getKey().equals("Yesterday")) return -1;
//                else if (entry2.getKey().equals("Yesterday")) return 1;
//                else return entry2.getKey().compareTo(entry1.getKey());
//            })
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//}

}
