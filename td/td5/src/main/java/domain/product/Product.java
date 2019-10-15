package domain.product;

import java.util.Objects;

public class Product {
    public final Reference ref;
    public final String name;
    public final String description;
    public final int price;

    Product(Reference ref, String name, String description, int price) {
        this.ref = ref;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getTextualRepresentation() {
        return String.format("%s");
        // TODO Textual rep
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price &&
                ref.equals(product.ref) &&
                name.equals(product.name) &&
                description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref, name, description, price);
    }
}
