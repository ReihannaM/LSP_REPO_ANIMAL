import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ETLPipeline {
    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "output/transformed_products.csv";

    public static void main(String[] args) {
        List<String[]> products = extractData(INPUT_FILE);

        if (products.isEmpty()) {
            System.err.println("No data found in input file. Exiting.");
            return;
        }

        List<String[]> transformedProducts = transformData(products);
        loadData(OUTPUT_FILE, transformedProducts);
    }

    // Extract: Read CSV file and store data in a list
    public static List<String[]> extractData(String filename) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
            String line = br.readLine(); // Read header, but don't add it to data
            if (line == null) {
                System.err.println("Error: Input file is empty.");
                return data;
            }
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return data;
    }

    // Transform: Apply transformations to product data
    public static List<String[]> transformData(List<String[]> products) {
        List<String[]> transformed = new ArrayList<>();
        transformed.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"}); // Add header

        for (String[] product : products) {
            if (product.length < 4) {
                System.err.println("Skipping malformed row: " + Arrays.toString(product));
                continue;
            }

            String productId = product[0];
            String name = product[1].toUpperCase(); // Convert to uppercase
            double price;
            try {
                price = Double.parseDouble(product[2]); // Convert price to double
            } catch (NumberFormatException e) {
                System.err.println("Invalid price value for product ID " + productId + ": " + product[2]);
                continue;
            }
            String category = product[3];

            // Apply discount to Electronics
            if (category.equalsIgnoreCase("Electronics")) {
                price *= 0.9; // 10% discount
                price = Math.round(price * 100.0) / 100.0; // Round to 2 decimals
            }

            // Rename category if price > $500
            if (category.equalsIgnoreCase("Electronics") && price > 500) {
                category = "Premium Electronics";
            }

            // Assign price range
            String priceRange;
            if (price <= 10) {
                priceRange = "Low";
            } else if (price <= 100) {
                priceRange = "Medium";
            } else if (price <= 500) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }

            transformed.add(new String[]{productId, name, String.format("%.2f", price), category, priceRange});
        }
        return transformed;
    }

    // Load: Save transformed data to a new CSV file
    public static void loadData(String filename, List<String[]> data) {
        try {
            // Ensure output directory exists
            Files.createDirectories(Paths.get(filename).getParent());

            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filename))) {
                for (String[] row : data) {
                    bw.write(String.join(",", row));
                    bw.newLine();
                }
                System.out.println("Data successfully written to " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

