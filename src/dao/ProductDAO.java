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
}
