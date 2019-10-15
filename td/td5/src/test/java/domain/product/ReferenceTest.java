package domain.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceTest  {
    @Test
    void create() {
        for (int i = 0; i < Reference.alphabet.length() - 10; i++) {
            Reference ref = new Reference();
            System.out.println(ref.value);
        }
    }
}