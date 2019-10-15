package fr.ubordeaux.ao;

public class SmallCaseString {
    private String value;

    public SmallCaseString(String name) {
        this.setValue(name);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (!value.matches("[a-z]{3,10}")) {
            throw new IllegalArgumentException("Name must be between 3 and 10 small case characters");
        }

        this.value = value;
    }
}
