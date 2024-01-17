package r;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class circle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCircularPoints(g);
    }

    private void drawCircularPoints(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100; // Adjust the radius as needed
        int numberOfPoints = 4; // Adjust the number of points as needed

        double angleIncrement = 2 * Math.PI / numberOfPoints;

        for (int i = 0; i < numberOfPoints; i++) {
            double angle = i * angleIncrement;
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));

            g2d.setColor(Color.BLACK);
            if (i>1)             g2d.setColor(Color.RED);

            g2d.fillRect(x, y, 20, 20); // Draw a small rectangle for each point
        }
        double angle = Math.PI / 6;
        int x = (int) (centerX + radius * Math.cos(angle));
        int y = (int) (centerY + radius * Math.sin(angle));
        g2d.fillRect(x, y, 20, 20); // Draw a small rectangle for each point
    
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Circular Points Drawer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setContentPane(new circle());
            frame.setVisible(true);
        });
    }
}