package com.cleanhelper.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EnergyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private TaskType taskType;

    private Double predictedCost;

    @ElementCollection
    private List<Integer> historyWindow;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Double getPredictedCost() {
        return predictedCost;
    }

    public void setPredictedCost(Double predictedCost) {
        this.predictedCost = predictedCost;
    }

    public List<Integer> getHistoryWindow() {
        return historyWindow;
    }

    public void setHistoryWindow(List<Integer> historyWindow) {
        this.historyWindow = historyWindow;
    }
}
