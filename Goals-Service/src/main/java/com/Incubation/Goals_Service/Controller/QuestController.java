package com.Incubation.Goals_Service.Controller;

import com.Incubation.Goals_Service.Entity.Goals;
import com.Incubation.Goals_Service.Entity.Quest;
import com.Incubation.Goals_Service.Service.GoalsService;
import com.Incubation.Goals_Service.Service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private QuestService questService;

    @GetMapping("/getAll")
    public List<Quest> getAll(@Param("userName") String userName) {
        return questService.getAll(userName);
    }

    @PostMapping("/new")
    public Quest addQuest(@RequestBody Quest quest)
    {
        return questService.addQuest(quest);
    }

    @PutMapping("/update")
    public Boolean updateQuest(@RequestParam ("questId") Integer questId,
                                 @RequestParam("completed") Boolean completed)
    {
        return questService.updateQuest(questId, completed);
    }

    @DeleteMapping("/delete")
    public Boolean deleteQuest(@RequestParam ("questId") Integer questId)
    {
        return questService.deleteQuest(questId);
    }

}
