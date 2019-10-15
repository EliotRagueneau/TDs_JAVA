public class EntierPositif {
    private int value;

    public EntierPositif(int value) {
        if (value >= 0) {
            this.value = value;
        } else {
            throw new RuntimeException("Entier positif doit être positif");
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 0) {
            this.value = value;
        } else {
            throw new RuntimeException("Entier positif doit être positif");
        }
    }
}
