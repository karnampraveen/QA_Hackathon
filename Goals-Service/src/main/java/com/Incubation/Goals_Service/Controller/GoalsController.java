package com.Incubation.Goals_Service.Controller;

import com.Incubation.Goals_Service.Entity.Goals;
import com.Incubation.Goals_Service.Service.GoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/goals")
public class GoalsController {

    @Autowired
    private GoalsService goalsService;

    @GetMapping("/getAll")
    public List<Goals> getAllCategories(@RequestParam("userName") String userName) {
        return goalsService.getCategories(userName);
    }

    @PostMapping("/new")
    public Goals addNewCategory(@RequestBody Goals goal) { // Accepting Goals object
        return goalsService.addNewCategory(goal); // Pass the entire Goals object
    }

    @PutMapping("/update")
    public Goals updateCategory(@RequestParam("userName") String userName,
                                @RequestParam("oldGoalName") String oldGoalName,
                                @RequestParam("newGoalName") String newGoalName,
                                @RequestParam("target") Long target,
                                @RequestParam("enabled") Boolean enabled,
                                @RequestParam("saved") Long saved) {  // Add saved param
        return goalsService.updateCategory(userName, oldGoalName, newGoalName, target, enabled, saved);
    }

    @PutMapping("/addSaving")
    public Goals addSaving(@RequestParam("userName") String userName,
                           @RequestParam("GoalName") String GoalName,
                           @RequestParam("amount") Long amount) {
        return goalsService.addSaving(userName, GoalName, amount);
    }
}
