package com.Incubation.Transaction_Service.Service;
import com.Incubation.Transaction_Service.Dtos.TransactionResponseDto;
import com.Incubation.Transaction_Service.Entity.Transaction;
import com.Incubation.Transaction_Service.Repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CategoryService categoryService;

    public TransactionResponseDto addTransaction(Transaction transaction)
    {
//        Transaction transaction = TransactionRequestDtoToTransaction(transactionRequestDto);
            transactionRepository.save(transaction);
            return transactionToTransactionResponseDto(transaction);
    }

    public List<TransactionResponseDto> getAllTransactions()  {
        List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<>();
        List<Transaction> transactions = transactionRepository.findAll();
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
            categoryService.getCategoryById(transaction.getCategoryId()).getCategoryName(),
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
