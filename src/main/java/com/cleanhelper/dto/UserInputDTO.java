package com.cleanhelper.dto;

public class UserInputDTO {
    private String username;
    private String email;
    private String password;
    private Integer weeklyEnergyCap;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getWeeklyEnergyCap() {
        return weeklyEnergyCap;
    }

    public void setWeeklyEnergyCap(Integer weeklyEnergyCap) {
        this.weeklyEnergyCap = weeklyEnergyCap;
    }
}
