package br.com.mariojp.figureeditor;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class FigureFactory {

    public enum FigureType {
        ELLIPSE,
        RECTANGLE
    }

    private static final int DEFAULT_SIZE = 60;
    private static final Color DEFAULT_COLOR = new Color(30, 144, 255);

    public static Figure createFigure(FigureType type, Point point) {
        Shape shape;


        switch (type) {
            case RECTANGLE:
                shape = new Rectangle2D.Double(point.x, point.y, DEFAULT_SIZE, DEFAULT_SIZE);
                break;
            case ELLIPSE:
            default:
                shape = new Ellipse2D.Double(point.x, point.y, DEFAULT_SIZE, DEFAULT_SIZE);
                break;
        }

        return new Figure(shape, DEFAULT_COLOR);
    }
}