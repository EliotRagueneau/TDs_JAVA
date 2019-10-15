package domain.basket;

import domain.Command;
import domain.product.Reference;

import java.util.Map;

public abstract class AbstractBasket {
    protected Map<Reference, Command> commands;

    public int getAmount() {
        int amount = 0;
        for (Command command : commands.values()) {
            amount += command.getPrice();
        }
        return amount;
    }
}
