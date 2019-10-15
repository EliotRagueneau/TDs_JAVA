package fr.ubordeaux.ao;



import org.jdom2.Element;

public class Circle implements Shape {
    Point center;
    int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void save(Element svg) {
        Element circleSVG = new Element("circle");
        circleSVG.setAttribute("cx", String.valueOf(center.x));
        circleSVG.setAttribute("cy", String.valueOf(center.y));
        circleSVG.setAttribute("r", String.valueOf(radius));

        svg.addContent(circleSVG);
    }
}