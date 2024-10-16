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

    public Goals addNewCategory(String userName, String goalName, Long target)
    {

        Goals goal = new Goals(
                userName,
                goalName,
                target,
                0L,
                true
        );

            goalsRepository.save(goal);
            return goal;
    }

    public Goals updateCategory(String userName, String oldGoalName, String newGoalName, Long target, Boolean enabled){

        Goals goals = goalsRepository.findByUserNameIgnoreCaseAndGoalNameIgnoreCase(userName,oldGoalName);
        goals.setGoalName(newGoalName);
        goals.setTarget(target);
        goals.setEnabled(enabled);
        goalsRepository.save(goals);
            return goals;
    }

    public Goals addSaving(String userName, String GoalName, Long amount){

        Goals goals = goalsRepository.findByUserNameIgnoreCaseAndGoalNameIgnoreCase(userName,GoalName);
        goals.setTarget(goals.getTarget() + amount);
        goalsRepository.save(goals);
        return goals;
    }

}
