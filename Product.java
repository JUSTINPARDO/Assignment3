import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Product implements Comparable<Product> {
    private final String id;
    private String name;
    private String category;
    private double price;

    public Product(String id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return this.id.compareTo(other.id);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Category: %s, Price: $%.2f",
                id, name, category, price);
    }

    private static double parsePrice(String input) {
        try {
            int dollarIndex = input.lastIndexOf('$');
            if (dollarIndex == -1) return 0.0;
            String priceStr = input.substring(dollarIndex + 1)
                    .split("-")[0]
                    .replace(",", "")
                    .trim();
            return Double.parseDouble(priceStr);
        } catch (Exception e) {
            return 0.0;
        }
    }
    public static void main(String[] args) {
        RedBlackBST<String, Product> productBST = new RedBlackBST<>();

        Scanner scanner = new Scanner(System.in);
        csvRead(productBST);
        insertHardcodedProducts(productBST);

        while (true) {
            System.out.println("\nProduct Search System");
            System.out.println("1. Search for a product by ID");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter product ID: ");
                String searchId = scanner.nextLine().trim();
                Product result = productBST.get(searchId);
                if (result != null) {
                    System.out.println("Product found: " + result);
                } else {
                    System.out.println("Product not found");
                }
            } else if (choice == 2) {
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    private static void csvRead(RedBlackBST<String, Product> productBST) {
        try (BufferedReader reader = new BufferedReader(new FileReader("amazon-product-data.csv"))) {
            reader.readLine(); // Skip header line

            String line;
            while ((line = reader.readLine()) != null) {
                int idLength = 32;
                if (line.length() < idLength) continue;

                String uniqueId = line.substring(0, idLength).trim();
                int lastDollarIndex = line.lastIndexOf('$');
                if (lastDollarIndex == -1) continue;

                String beforePrice = line.substring(idLength, lastDollarIndex).trim();
                double price = parsePrice(line.substring(lastDollarIndex));

                String name = beforePrice;
                String category = "Uncategorized";

                int lastPipeIndex = beforePrice.lastIndexOf('|');
                if (lastPipeIndex != -1) {
                    name = beforePrice.substring(0, lastPipeIndex).trim();
                    category = beforePrice.substring(lastPipeIndex + 1).trim();
                }

                Product product = new Product(uniqueId, name, category, price);
                productBST.put(uniqueId, product);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void insertHardcodedProducts(RedBlackBST<String, Product> productBST) {
        Product[] hardcodedProducts = {
                new Product("Product Insert 1", "Headphones", "Collectibles", 9.99),
                new Product("2144315a823e47df748abef74f8d68dc", "Headphones", "Collectibles", 9.98),
        };
        for (Product product : hardcodedProducts) {
            if (productBST.get(product.getId()) == null) {
                productBST.put(product.getId(), product);
                System.out.println("Added product: " + product);
            } else {
                System.out.println("Product with ID " + product.getId() + " already exists");
            }
        }
    }
}