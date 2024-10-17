package com.Incubation.Goals_Service.Controller;

import com.Incubation.Goals_Service.Entity.Goals;
import com.Incubation.Goals_Service.Entity.Quest;
import com.Incubation.Goals_Service.Service.GoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private GoalsService goalsService;

    @GetMapping("/getAll")
    public List<Quest> getAll(@Param("userName") String userName) {
        return goalsService.getAll(userName);
    }

    @PostMapping("/new")
    public Quest addNewCategory(@RequestBody Quest quest)
    {
        return goalsService.addQuest(quest);
    }

    @PutMapping("/update")
    public Boolean updateQuest(@RequestParam ("userName") String userName,
                                @RequestParam("questName") String questName, @RequestParam("completed") Boolean completed)
    {
        return goalsService.updateQuest(userName, questName, completed);
    }

    @DeleteMapping("/delete")
    public Boolean deleteQuest(@RequestParam ("userName") String userName, @RequestParam("questName") String questName)
    {
        return transactionService.deleteQuest(userName,questName);
    }

}
