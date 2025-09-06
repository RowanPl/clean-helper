package com.cleanhelper.dto;

import java.util.List;

public class EnergyProfileInputDTO {
    private Long userId;
    private Long taskTypeId;
    private Double predictedCost;
    private List<Integer> historyWindow;

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
