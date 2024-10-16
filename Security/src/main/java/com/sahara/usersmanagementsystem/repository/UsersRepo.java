package com.sahara.usersmanagementsystem.repository;


import com.sahara.usersmanagementsystem.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<OurUsers, Integer> {

    Optional<OurUsers> findByName(String name);
}
