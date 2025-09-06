package com.cleanhelper.dto;

import java.util.List;

public class EnergyProfileDTO {
    private Long id;
    private Long userId;
    private Long taskTypeId;
    private Double predictedCost;
    private List<Integer> historyWindow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
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
