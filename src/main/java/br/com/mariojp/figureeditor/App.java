package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();

            JToolBar toolBar = new JToolBar();
            toolBar.setFloatable(false);
            JButton ellipseButton = new JButton("Elipse");
            JButton rectangleButton = new JButton("Retângulo");
            toolBar.add(ellipseButton);
            toolBar.add(rectangleButton);

            ellipseButton.addActionListener(e -> {
                panel.setCurrentFigureType(FigureFactory.FigureType.ELLIPSE);
            });

            rectangleButton.addActionListener(e -> {
                panel.setCurrentFigureType(FigureFactory.FigureType.RECTANGLE);
            });

            frame.setLayout(new BorderLayout());

            frame.add(toolBar, BorderLayout.NORTH); // Toolbar no topo
            frame.add(panel, BorderLayout.CENTER); // Painel no centro

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
