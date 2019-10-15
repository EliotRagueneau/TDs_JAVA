package fr.ubordeaux.ao;

public class Main {
    public static void main(String[] args) {
        SVG svg = new SVG(400, 400);

        Point a = new Point(50, 50);
        Circle circle = new Circle(a, 10);
        svg.addShape(circle);

        Point b = new Point(100, 100);
        Rectangle rectangle = new Rectangle(b, 15, 15);
        svg.addShape(rectangle);

        Line line = new Line(a, b);
        svg.addShape(line);

        svg.save();
    }
}
