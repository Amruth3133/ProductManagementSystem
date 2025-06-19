package model;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private double unitPrice;

    public Product(int productId,String productName,String category,double unitPrice)
    {
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.unitPrice=unitPrice;
    }

    public int getProductId()
    {
        return productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public String getCategory()
    {
        return category;
    }
    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void SetProductId(int productId)
    {
        this.productId=productId;
    }
    public void setProductName(String productName)
    {
        this.productName=productName;
    }
    public void setCategory(String category)
    {
        this.category=category;
    }
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice=unitPrice;
    }
}
