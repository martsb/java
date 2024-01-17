package vas23;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JLabel Image Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            ImageIcon imageIcon = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\bord.png");
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(50, 50, 100, 100);

            frame.setLayout(null);
            frame.add(imageLabel);
            frame.setVisible(true);
        });
    }
}