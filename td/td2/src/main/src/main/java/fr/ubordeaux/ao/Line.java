package fr.ubordeaux.ao;

import org.jdom2.Element;

public class Line implements Shape {
    Point firstPoint;
    Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public void save(Element svg) {
        Element lineSVG = new Element("line");
        lineSVG.setAttribute("x1", String.valueOf(firstPoint.x));
        lineSVG.setAttribute("y1", String.valueOf(firstPoint.y));
        lineSVG.setAttribute("x2", String.valueOf(secondPoint.x));
        lineSVG.setAttribute("y2", String.valueOf(secondPoint.y));

        svg.addContent(lineSVG);

    }
}