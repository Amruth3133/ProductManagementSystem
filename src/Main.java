import java.util.InputMismatchException;
import java.util.Scanner;
import model.Product;
import service.ProductService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        while (true) {
            System.out.println("\n=== Product Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice;
            try {
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                sc.nextLine(); // clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Unit Price: ");
                    double price = sc.nextDouble();

                    Product p = new Product(id, name, category, price);
                    service.addProduct(p);
                    break;

                case 2:
                    service.viewAllProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID to search: ");
                    int searchId = sc.nextInt();
                    service.searchProduct(searchId);
                    break;

                case 4:
                    System.out.print("Enter Product ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new category: ");
                    String newCat = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    Product updatedProduct = new Product(upId, newName, newCat, newPrice);
                    service.updateProduct(updatedProduct);
                    break;

                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = sc.nextInt();
                    service.deleteProduct(delId);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    return;


                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}

