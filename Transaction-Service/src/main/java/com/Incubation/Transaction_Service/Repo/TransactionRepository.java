package com.Incubation.Transaction_Service.Repo;

import com.Incubation.Transaction_Service.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserName(String name);

    Optional<Transaction> findByUserNameAndTransactionType(String name, String transactionType);

    Optional<List<Transaction>> findByUserNameAndCategory(String name, String category);
}

