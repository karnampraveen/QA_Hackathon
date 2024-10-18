package com.Incubation.Goals_Service.Service;
import com.Incubation.Goals_Service.Entity.Goals;
import com.Incubation.Goals_Service.Repo.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalsService {
    @Autowired
    private GoalsRepository goalsRepository;

    public List<Goals> getCategories(String userName) {
        return goalsRepository.findByUserNameAndEnabled(userName,true);
    }

//    @Override
//    public boolean existsCategory(int id) {
//        return categoryRepository.existsById(id);
//    }

    public Goals getCategoryById(int id)  {
        return goalsRepository.findById(id).get();
    }

    public Goals addNewCategory(Goals goal) {
        Goals newGoal = new Goals(
                goal.getUserName(),
                goal.getGoalName(),
                goal.getTarget(),
                0L,  // Default value for saved
                true // Default value for enabled
        );
        goalsRepository.save(newGoal);
        return newGoal;
    }

    public Goals updateCategory(String userName, String oldGoalName, String newGoalName, Long target, Boolean enabled, Long saved) {
        Goals goals = goalsRepository.findByUserNameIgnoreCaseAndGoalNameIgnoreCase(userName, oldGoalName);
        goals.setGoalName(newGoalName);
        goals.setTarget(target);
        goals.setEnabled(enabled);
        goals.setSaved(saved);  // Set the new saved value
        goalsRepository.save(goals);
        return goals;
    }


    public Goals addSaving(String userName, String GoalName, Long amount){

        Goals goals = goalsRepository.findByUserNameIgnoreCaseAndGoalNameIgnoreCase(userName,GoalName);
        goals.setTarget(goals.getTarget() + amount);
        goalsRepository.save(goals);
        return goals;
    }

    public Boolean deleteGoal(Integer goalId){

        goalsRepository.deleteById(goalId);
        return true;
    }


}
