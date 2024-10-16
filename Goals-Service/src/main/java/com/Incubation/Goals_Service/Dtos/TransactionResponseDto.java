package com.Incubation.Goals_Service.Dtos;
import java.time.LocalDate;

public class TransactionResponseDto {

    private Long transactionId;
    private String categoryName;
    private String transactionType;
    private String description;
    private double amount;
    private LocalDate date;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(Long transactionId, String categoryName, String transactionType, String description, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.categoryName = categoryName;
        this.transactionType = transactionType;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
