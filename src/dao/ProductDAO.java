package dao;

import model.Product;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void addProduct(Product p) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO products VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, p.getProductId());
        ps.setString(2, p.getProductName());
        ps.setString(3, p.getCategory());
        ps.setDouble(4, p.getUnitPrice());
        ps.executeUpdate();
        con.close();
    }

    public List<Product> getAllProducts() throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM products";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("category"),
                    rs.getDouble("unit_price")
            );
            list.add(p);
        }
        con.close();
        return list;
    }
    // Search by ID
    public Product getProductById(int id) {
        Product p = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM products WHERE product_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("category"),
                        rs.getDouble("unit_price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    // Update product
    public boolean updateProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE products SET product_name=?, category=?, unit_price=? WHERE product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getCategory());
            ps.setDouble(3, p.getUnitPrice());
            ps.setInt(4, p.getProductId());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete product
    public boolean deleteProduct(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM products WHERE product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
