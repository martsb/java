package vas23;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private JFrame frame;
    private JPanel currentScene;

    public Game() {
        frame = new JFrame("Game Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Initialize the main menu scene
        currentScene = new MainMenuScene(this);

        frame.add(currentScene);
        frame.setVisible(true);
    }

    public void switchScene(JPanel newScene) {
        frame.remove(currentScene);
        currentScene = newScene;
        frame.add(currentScene);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
            new Game();
    }
}

class MainMenuScene extends JPanel {
    private Game game;

    public MainMenuScene(Game game) {
        this.game = game;

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the gameplay scene when the "Play" button is clicked
                game.switchScene(new GameplayScene(game));
            }
        });

        add(playButton);
    }
}

class GameplayScene extends JPanel {
    private Game game;
    private JLabel label1, label2;

    public GameplayScene(Game game) {
        this.game = game;

        // Set the layout to null
        setLayout(null);

        // Create and position JLabels
        label1 = new JLabel("Label 1");
        label1.setBounds(100, 100, 100, 20); // x, y, width, height
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        
        label2 = new JLabel("Label 2");
        label2.setBounds(300, 200, 100, 20); // x, y, width, height
        label2.setOpaque(true);
        label2.setBackground(Color.red);
        
        // Add JLabels to the panel
        add(label1);
        add(label2);
    }

    // Add rendering and game logic for the gameplay scene
}