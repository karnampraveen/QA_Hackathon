package com.Incubation.Goals_Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questId;
    private String userName;
    private String questName;
    private Boolean completed;
    private Boolean enabled;

    public Quest() {
    }

    public Quest(Integer questId, String userName, String questName, Boolean completed , Boolean enabled) {
        this.questId = questId;
        this.userName = userName;
        this.questName = questName;
        this.completed = completed;
        this.enabled = enabled;
    }

    public Quest(String userName, String questName) {
        this.userName = userName;
        this.questName = questName;
    }

    public Quest(String userName, String questName, Boolean completed, Boolean enabled) {
        this.userName = userName;
        this.questName = questName;
        this.completed = completed;
        this.enabled = enabled;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
