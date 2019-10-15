package domain.product;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static Map<Reference, Product> productMap = new HashMap<>();

    public static Product createProduct(String name, String description, int price) {
        if (name.length() > 20){
            throw new IllegalArgumentException("name must be at max 20 alphanum char");
        }
        if (description.length() > 200) {
            throw new IllegalArgumentException("description must be less than 200 chars");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must be positive");
        }

        Reference ref = new Reference();
        productMap.putIfAbsent(ref, new Product(ref, name, description, price));
        return productMap.get(ref);
    }
}
