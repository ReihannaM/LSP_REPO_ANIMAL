package org.howard.edu.lspfinal.question3;

public class Driver {
    public static void main(String[] args) {
        // Create sales report and generate it
        Report salesReport = new SalesReport();
        salesReport.generateReport();

        // Create inventory report and generate it
        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
