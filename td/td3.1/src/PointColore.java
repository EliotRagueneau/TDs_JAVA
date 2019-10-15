public class PointColore extends Point2D {
    private Couleur couleur;

    public PointColore(EntierPositif x, EntierPositif y, Couleur couleur) {
        super(x, y);
        this.couleur = couleur;
    }
}
