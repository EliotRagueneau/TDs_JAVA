package fr.ubordeaux.ao;

import org.jdom2.Element;

public class Ellipse implements Shape {
    Point center;
    int radiusX;
    int radiusY;

    @Override
    public void save(Element svg) {
        Element ellipseSVG = new Element("ellipse");
        ellipseSVG.setAttribute("cx", String.valueOf(center.x));
        ellipseSVG.setAttribute("cy", String.valueOf(center.y));
        ellipseSVG.setAttribute("rx", String.valueOf(radiusX));
        ellipseSVG.setAttribute("ry", String.valueOf(radiusY));

        svg.addContent(ellipseSVG);
    }
}