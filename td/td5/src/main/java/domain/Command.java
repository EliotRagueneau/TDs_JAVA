package domain;

import domain.product.Product;

import java.util.Objects;

public class Command {
    public final String id;
    private Product product;
    private int quantity;

    public Command(String id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void  decreaseQuantity() {
        quantity--;
    }

    public int getPrice() {
        return quantity * product.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return Objects.equals(id, command.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
