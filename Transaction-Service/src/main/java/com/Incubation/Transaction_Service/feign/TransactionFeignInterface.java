package com.Incubation.Transaction_Service.feign;

//import com.Incubation.Transaction_Service.Entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("USERS-SERVICE")
public interface TransactionFeignInterface {
    @GetMapping("/public/getBalance")
    public Long getBalance1(@Param("username") String name);

//    @PostMapping("/public/updateBalance")
//    public Long addBalance(@Param("username") String name, @Param("operation") String operation, @Param("amount") Long amount);


}
