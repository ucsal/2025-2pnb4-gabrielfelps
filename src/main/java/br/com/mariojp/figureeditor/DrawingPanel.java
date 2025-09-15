
package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    private final List<Figure> figures = new ArrayList<>();
    private Point startDrag = null;

    private FigureFactory.FigureType currentFigureType = FigureFactory.FigureType.ELLIPSE;

    DrawingPanel() {
        
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        var mouse = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && startDrag == null) {
                    Figure f = FigureFactory.createFigure(currentFigureType, e.getPoint());
                    figures.add(f);
                    repaint();
                }
            }
        };
        addMouseListener(mouse);        
        addMouseMotionListener(mouse);

    }

    public void setCurrentFigureType(FigureFactory.FigureType type) {
        this.currentFigureType = type;
    }

    void clear() {
        figures.clear();
        repaint();
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Figure f : figures) {
            f.draw(g2);
        }

        g2.dispose();
    }

}
