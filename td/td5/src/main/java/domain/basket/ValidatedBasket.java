package domain.basket;

import domain.Command;
import domain.product.Reference;

import java.util.HashMap;
import java.util.Map;

public class ValidatedBasket extends AbstractBasket{
    public ValidatedBasket(Map<Reference, Command> commands) {
        this.commands = new HashMap<>(commands);
    }
}
