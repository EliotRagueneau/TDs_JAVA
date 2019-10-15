package domain.basket;

import domain.Command;
import domain.product.Product;

import java.util.HashMap;
import java.util.Iterator;

public class Basket extends AbstractBasket {

    public Basket() {
        commands = new HashMap<>();
    }

    public void addCommand(Product product, int quantity) {
        if (commands.containsKey(product.ref)) {
            commands.get(product.ref).increaseQuantity();
        } else {
            commands.put(product.ref, new Command(product.ref.value, product, quantity));
        }
    }

    public void addCommand(Product product) {
        addCommand(product, 1);
    }

    public void increaseCommandQuantityByProductName(String productName) {
        for (Command command : commands.values()) {
            if (command.getProduct().name.equals(productName)) {
                command.increaseQuantity();
                break;
            }
        }
    }

    public void decreaseCommandQuantityByProductName(String productName) {
        Iterator<Command> it = commands.values().iterator();
        while (it.hasNext()) {
            Command command = it.next();
            if (command.getProduct().name.equals(productName)) {
                command.decreaseQuantity();
                if (command.getQuantity() == 0) {
                    it.remove();
                }
                break;
            }
        }
    }

    public void removeProductByName(String name) {
        commands.values().removeIf(command -> command.getProduct().name.equals(name));
    }

    public ValidatedBasket validate() {
        return new ValidatedBasket(commands);
    }

}
