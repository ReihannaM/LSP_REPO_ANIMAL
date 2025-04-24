package org.howard.edu.lspfinal.question3;

public abstract class Report {
    // Template method defining the general workflow
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    // Steps to be implemented by subclasses
    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}
