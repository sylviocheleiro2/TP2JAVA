package org.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Visualizar Lista de Tarefas");
            System.out.println("2. Adicionar Nova Tarefa");
            System.out.println("3. Ver Detalhes da Tarefa");
            System.out.println("4. Marcar Tarefa como Concluída");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    taskManager.displayTasks();
                    break;
                case 2:
                    System.out.println("Digite o título da tarefa:");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa:");
                    String description = scanner.nextLine();
                    System.out.println("Digite a data de criação da tarefa:");
                    String creationDate = scanner.nextLine();
                    Task newTask = new Task(title, description, creationDate);
                    taskManager.addTask(newTask);
                    System.out.println("Tarefa adicionada com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o número da tarefa para ver detalhes:");
                    int taskIndex = scanner.nextInt();
                    taskManager.viewTaskDetails(taskIndex - 1);
                    break;
                case 4:
                    System.out.println("Digite o número da tarefa para marcar como concluída:");
                    int completedTaskIndex = scanner.nextInt();
                    taskManager.markTaskAsCompleted(completedTaskIndex - 1);
                    break;
                case 0:
                    System.out.println("Saindo da aplicação.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
