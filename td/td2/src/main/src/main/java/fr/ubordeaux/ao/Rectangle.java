package fr.ubordeaux.ao;

import org.jdom2.Element;

public class Rectangle implements Shape {
    Point origin;
    int width;
    int height;


    public Rectangle(Point origin, int width, int height) {
        this.origin = origin;
        this.width = width;
        this.height = height;
    }


    @Override
    public void save(Element svg) {
        Element rectangleSVG = new Element("rect");
        rectangleSVG.setAttribute("x", String.valueOf(origin.x));
        rectangleSVG.setAttribute("y", String.valueOf(origin.y));
        rectangleSVG.setAttribute("width", String.valueOf(width));
        rectangleSVG.setAttribute("height", String.valueOf(height));

        svg.addContent(rectangleSVG);

    }
}