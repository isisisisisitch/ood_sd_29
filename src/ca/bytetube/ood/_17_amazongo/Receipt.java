package ca.bytetube.ood._17_amazongo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Receipt {
    String orderId;
    Map<Product, Integer> items = new LinkedHashMap<>();
    Price subtotal = new Price(0.0, "USD");
    Price total = new Price(0.0, "USD");

    public Receipt(String orderId) {
        this.orderId = orderId;
    }

    public void add(Product product, int qty) {
        items.put(product, qty);
        subtotal = subtotal.add(product.getPrice().multiply(qty));
        total = subtotal;
    }

    public Price getTotal() {
        return total;
    }


    public Price getSubtotal() {
        return subtotal;
    }


    public Map<Product, Integer> getItems() {
        return items;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
