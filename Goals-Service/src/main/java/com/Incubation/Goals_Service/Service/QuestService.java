package com.Incubation.Goals_Service.Service;
import com.Incubation.Goals_Service.Entity.Goals;
import com.Incubation.Goals_Service.Entity.Quest;
import com.Incubation.Goals_Service.Repo.GoalsRepository;
import com.Incubation.Goals_Service.Repo.QuestRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {
    @Autowired
    private QuestRepository questRepository;

    public List<Quest> getAll(String userName) {
        return questRepository.findByUserNameIgnoreCase(userName);
    }

    public Quest addQuest(Quest quest)
    {

        Quest newQuest = new Quest(
                quest.getUserName(),
                quest.getQuestName(),
                false,true
        );
        questRepository.save(newQuest);
        return newQuest;
    }

    public Boolean updateQuest(Integer questId, Boolean completed){

        Quest quest = questRepository.findById(questId).get();
        quest.setCompleted(completed);
        questRepository.save(quest);
            return true;
    }

    public Boolean deleteQuest(Integer questId){

//        Quest quest = questRepository.findById(questId).get();
        questRepository.deleteById(questId);
        return true;
    }

}
