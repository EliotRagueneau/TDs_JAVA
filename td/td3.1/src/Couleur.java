import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Couleur {
    private final static Pattern hexaPattern = Pattern.compile("#[0-9A-F]{6}");
    private static Matcher matcher;
    private int red, green, blue;

    public Couleur(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new RuntimeException("Each color channel must be between 0 and 255");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Couleur(String webColorString) {
        matcher = hexaPattern.matcher(webColorString);
        if (matcher.find()) {
            this.red = Integer.parseInt(webColorString.substring(1, 3), 16);
            this.green = Integer.parseInt(webColorString.substring(3, 5), 16);
            this.blue = Integer.parseInt(webColorString.substring(5, 7), 16);
        } else {
            throw new RuntimeException("webColorString must be like #01239AF");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Couleur)) return false;
        Couleur couleur = (Couleur) o;
        return red == couleur.red &&
                green == couleur.green &&
                blue == couleur.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}
