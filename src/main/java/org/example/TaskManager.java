package org.example;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

class TaskManager {
    private ArrayList<Task> taskList;
    private int userPoints;
    private String lastCompletionDate;

    public TaskManager() {
        this.taskList = new ArrayList<>();
        this.userPoints = 0;
        this.lastCompletionDate = "";
    }

    public void addTask(Task task) {
        taskList.add(task);
        task.resetDailyCompletedTasks();
    }

    public void displayTasks() {
        System.out.println("Lista de Tarefas:");
        if(taskList.size() < 1){
            System.out.println("Lista de Tarefas está vazia");
        }
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println((i + 1) + ". " + task.getTitle() + " - " + (task.isCompleted() ? "Concluída" : "Pendente"));
        }
    }

    public void viewTaskDetails(int index) {
        if (index >= 0 && index < taskList.size()) {
            Task task = taskList.get(index);
            System.out.println("Detalhes da Tarefa:");
            System.out.println("Título: " + task.getTitle());
            System.out.println("Descrição: " + task.getDescription());
            System.out.println("Data de Criação: " + task.getCreationDate());
            System.out.println("Data de Conclusão: " + task.getCompletionDate());
            System.out.println("Situação: " + (task.isCompleted() ? "Concluída" : "Pendente"));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < taskList.size()) {
            Task task = taskList.get(index);
            if (!task.isCompleted()) {
                task.markAsCompleted();
                task.setCompletionDate("Data atual");
                System.out.println("Tarefa marcada como concluída.");
            } else {
                System.out.println("Esta tarefa já está concluída.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
        Task completedTask = taskList.get(index);
        completedTask.incrementDailyCompletedTasks();

        updatePoints(completedTask.getDailyCompletedTasks());
    }

    private void updatePoints(int dailyCompletedTasks) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

        if (currentDate.equals(lastCompletionDate)) {
            if (dailyCompletedTasks >= 5) {
                userPoints += 2;
            } else if (dailyCompletedTasks >= 3) {
                userPoints += 1;
            }
        } else {
            if (!lastCompletionDate.isEmpty()) {
                userPoints -= 1;
            }
            lastCompletionDate = currentDate;
            userPoints += 1;
        }

        System.out.println("Pontuação atual: " + userPoints);
    }
}