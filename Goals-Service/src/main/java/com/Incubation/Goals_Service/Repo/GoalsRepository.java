package com.Incubation.Goals_Service.Repo;
import com.Incubation.Goals_Service.Entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Integer> {
    List<Goals> findByUserName(String name);
    List<Goals> findByUserNameAndEnabled(String name, Boolean enabled);
    Goals findByUserNameIgnoreCaseAndGoalNameIgnoreCase(String userName, String goalName);

}
