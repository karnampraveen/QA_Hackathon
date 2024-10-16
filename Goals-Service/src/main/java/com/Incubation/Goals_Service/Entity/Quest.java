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
    private String status;
    private boolean enabled;

    public Quest() {
    }

    public Quest(Integer questId, String userName, String questName, String status, boolean enabled) {
        this.questId = questId;
        this.userName = userName;
        this.questName = questName;
        this.status = status;
        this.enabled = enabled;
    }

    public Quest(String userName, String questName, String status, boolean enabled) {
        this.userName = userName;
        this.questName = questName;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
