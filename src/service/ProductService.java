package service;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductService {
    ProductDAO dao=new ProductDAO();
    public void addProduct(Product p)
    {
        try{
            dao.addProduct(p);
            System.out.println("✅ Product added successfully!");
        } catch (Exception e) {
            System.out.println("❌ Failed to add product: " + e.getMessage());
        }
    }

    public void viewAllProducts() {
        try {
            List<Product> list = dao.getAllProducts();
            for (Product p : list) {
                System.out.println(p.getProductId() + " | " +
                        p.getProductName() + " | " +
                        p.getCategory() + " | ₹" +
                        p.getUnitPrice());
            }
        } catch (Exception e) {
            System.out.println("❌ Error fetching products: " + e.getMessage());
        }
    }
    public void searchProduct(int id) {
        Product p = dao.getProductById(id);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void updateProduct(Product p) {
        boolean updated = dao.updateProduct(p);
        if (updated) {
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    public void deleteProduct(int id) {
        boolean deleted = dao.deleteProduct(id);
        if (deleted) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found or delete failed.");
        }
    }

}
