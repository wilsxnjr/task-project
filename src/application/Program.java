package application;

import model.entities.Task;
import model.enums.Status;
import model.services.Manage;
import model.services.ManageService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Manage manage = new ManageService();

        //manage.createTask(new Task(3, "Study", "Study java", LocalDateTime.now(), LocalDateTime.of(2026, 2, 12, 14, 30, 30), Status.PENDING));

        manage.setAsCompleted(3);
    }
}