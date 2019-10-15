package domain.product;


import java.util.Objects;

public class Reference {
    protected static String alphabet = "0123456789"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvxyz";
    protected static final int REFERENCE_LENGTH = 20;
    protected static int[] indexes = new int[REFERENCE_LENGTH];
    private static boolean first = true;

    public final String value;

    public Reference() {
        if (first) {
            indexes[REFERENCE_LENGTH - 1] = -1;
            first = false;
        }
        StringBuilder stringBuilder = new StringBuilder(REFERENCE_LENGTH);
        addOne(REFERENCE_LENGTH - 1);
        for (int i = 0; i < REFERENCE_LENGTH; i++) {
            stringBuilder.append(alphabet.charAt(indexes[i]));
        }
        value = stringBuilder.toString();
    }

    private void addOne(int index) {
        indexes[index] += 1;
        if (indexes[index] == alphabet.length()) {
            indexes[index] = 0;
            addOne(index - 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reference)) return false;
        Reference reference = (Reference) o;
        return Objects.equals(value, reference.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
