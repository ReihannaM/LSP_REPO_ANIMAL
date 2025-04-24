package org.howard.edu.lspfinal.question2;

/**
 * Thrown when a task is not found in the manager.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
