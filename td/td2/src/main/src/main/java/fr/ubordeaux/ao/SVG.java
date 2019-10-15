package fr.ubordeaux.ao;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class SVG {
    private int width;
    private int heigth;
    private List<Shape> shapes;
    private Document document;

    public SVG(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void save() {
        document = new Document();
        Element svg = new Element("svg");
        svg.setAttribute("viewBox", String.format("%d %d %d %d", 0, 0, width, heigth));
        document.addContent(svg);

        for (Shape shape : shapes) {
            shape.save(svg);
        }

        try {
            Writer writerSVG = new FileWriter("my.svg");
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, writerSVG);
            writerSVG.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}