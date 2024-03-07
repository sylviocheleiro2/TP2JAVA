package org.example;

class Task {
    private String title;
    private String description;
    private String creationDate;
    private String completionDate;
    private boolean completed;
    private int dailyCompletedTasks;

    public Task(String title, String description, String creationDate) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = false;
        this.dailyCompletedTasks = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }
    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }
    public int getDailyCompletedTasks() {
        return dailyCompletedTasks;
    }

    public void incrementDailyCompletedTasks() {
        this.dailyCompletedTasks++;
    }

    public void resetDailyCompletedTasks() {
        this.dailyCompletedTasks = 0;
    }
}