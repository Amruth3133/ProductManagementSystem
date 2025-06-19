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
}
