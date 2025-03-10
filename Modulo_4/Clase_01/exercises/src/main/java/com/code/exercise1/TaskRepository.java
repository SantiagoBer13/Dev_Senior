package com.code.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskRepository implements IRepository {
    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new LinkedList<>();
    }

    @Override
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    @Override
    public Task findById(String idTask) {
        for (Task task : tasks) {
            if (task.getId().equals(idTask)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public void removeTasksCompleted() {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isCompleted()) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Task> getTasksNoCompleted() {
        List<Task> tasksNoCompleted = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                tasksNoCompleted.add(task);
            }
        }
        return tasksNoCompleted;
    }
    
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}