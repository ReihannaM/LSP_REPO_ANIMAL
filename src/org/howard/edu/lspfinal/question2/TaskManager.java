package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a collection of tasks, supporting operations such as add, retrieve, update, and display by status.
 */
public class TaskManager {
    private Map<String, Task> taskMap = new HashMap<>();

    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (taskMap.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        taskMap.put(name, new Task(name, priority, status));
    }

    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!taskMap.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return taskMap.get(name);
    }

    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        Map<String, List<Task>> grouped = new HashMap<>();

        for (Task task : taskMap.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        for (String status : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> tasks = grouped.getOrDefault(status, new ArrayList<>());
            for (Task t : tasks) {
                System.out.println("  " + t);
            }
        }
    }
}
