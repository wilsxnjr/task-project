package model.services;

import model.entities.Task;
import model.enums.Status;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ManageService implements Manage {

    String path = "C:\\Users\\PC\\Desktop\\Course Java\\task-project\\in.txt";

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public List<Task> getTasks() {
        List<Task> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(", ");
                list.add(new Task(Integer.parseInt(fields[0]), fields[1], fields[2], LocalDateTime.parse(fields[3], fmt), LocalDateTime.parse(fields[4], fmt), Status.valueOf(fields[5])));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void createTask(Task task) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(task.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void getAllTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(", ");
                getTasks().add(new Task(Integer.parseInt(fields[0]), fields[1], fields[2], LocalDateTime.parse(fields[3], fmt), LocalDateTime.parse(fields[4], fmt), Status.valueOf(fields[5])));
                line = br.readLine();
            }
            for (Task task : getTasks()) {
                System.out.println(task);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Task getById(int id) {
        for (Task task : getTasks()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public void setAsCompleted(int id) {
        List<Task> list = getTasks();
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
           for (Task task : list) {
               if (task.getId() == id) {
                   task.setStatus(Status.COMPLETED);
               }
               bw.write(task.toString());
               bw.newLine();
           }
       } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
}