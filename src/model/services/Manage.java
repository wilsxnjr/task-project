package model.services;

import model.entities.Task;

import java.util.List;

public interface Manage {

    List<Task> getTasks();
    void createTask(Task task);
    void getAllTasks();

}