package ca.bytetube.ood._08_shoppingcart.model;

public class Product {
    private String id;
    private double unitPrice;
    private String name;


    public Product(String id, double unitPrice, String name) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
