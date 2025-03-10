package com.code.exercise1;

import java.util.List;

public interface IRepository {

    void addTask(Task task);
    Task findById(String idTask);
    void removeTasksCompleted();
    List<Task> getTasksNoCompleted();

}
