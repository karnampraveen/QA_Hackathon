package com.Incubation.Goals_Service.Repo;
import com.Incubation.Goals_Service.Entity.Goals;
import com.Incubation.Goals_Service.Entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Integer> {
    List<Quest> findByUserNameIgnoreCase(String name);
    Quest findByUserNameIgnoreCaseAndQuestNameIgnoreCase(String userName, String questName);

}
