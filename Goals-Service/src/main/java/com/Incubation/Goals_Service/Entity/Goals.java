package com.Incubation.Goals_Service.Entity;
import jakarta.persistence.*;

@Entity
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goalId;
    private String userName;
    private String goalName;
    private Long target;
    private Long saved;
    private boolean enabled;

    public Goals() {
    }

    public Goals(Integer goalId, String userName, String goalName, Long target, Long saved, boolean enabled) {
        this.goalId = goalId;
        this.userName = userName;
        this.goalName = goalName;
        this.target = target;
        this.saved = saved;
        this.enabled = enabled;
    }

    public Goals(String userName, String goalName, Long target, Long saved, boolean enabled) {
        this.userName = userName;
        this.goalName = goalName;
        this.target = target;
        this.saved = saved;
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCategoryId() {
        return goalId;
    }

    public void setCategoryId(Integer goalId) {
        this.goalId = goalId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Long getSaved() {
        return saved;
    }

    public void setSaved(Long saved) {
        this.saved = saved;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
