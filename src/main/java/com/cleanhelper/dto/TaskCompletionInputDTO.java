package com.cleanhelper.dto;

import java.time.LocalDateTime;

public class TaskCompletionInputDTO {
    private Long taskId;
    private Long userId;
    private Integer actualCost;
    private LocalDateTime completedAt;
    private boolean exceptional;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getActualCost() {
        return actualCost;
    }

    public void setActualCost(Integer actualCost) {
        this.actualCost = actualCost;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public boolean isExceptional() {
        return exceptional;
    }

    public void setExceptional(boolean exceptional) {
        this.exceptional = exceptional;
    }
}
