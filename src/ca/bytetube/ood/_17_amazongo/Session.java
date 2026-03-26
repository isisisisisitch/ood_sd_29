package ca.bytetube.ood._17_amazongo;

public class Session {
    private String id;
    private Customer customer;
    private Basket basket = new Basket();

    public Session(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
