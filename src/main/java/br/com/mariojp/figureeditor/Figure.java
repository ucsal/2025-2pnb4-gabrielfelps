package br.com.mariojp.figureeditor;

import java.awt.*;

public class Figure {
    private final Shape shape;
    private final Color color;

    public Figure(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(shape);
        g2.setColor(new Color(0,0,0,70));
        g2.setStroke(new BasicStroke(1.2f));
        g2.draw(shape);
    }
}
