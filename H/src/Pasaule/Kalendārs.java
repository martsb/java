package Pasaule;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Kalendārs implements ActionListener {
    private static Container c;
    private static JFrame ekrāns;
    private static JLabel mazaisSkaitītājs;
    private static JPanel panelis;
    private static JButton iestatīšana;
    private static JButton ieslēgšana;
    private static JButton ātrumaPoga;
    private static boolean ieslēgts = true;
    private static int sekundes = 0, minūtes = 0, stundas = 0, dienas = 0, mēneši = 0, gadi = 0;
    private static int ātrumaCipars = 1;
    private static Timer timer;

    Kalendārs() {
        ekrāns = new JFrame();
        ekrāns.setBounds(600, 300, 500, 500);
        ekrāns.setVisible(true);
        ekrāns.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekrāns.setLayout(null);
        c = ekrāns.getContentPane();

        mazaisSkaitītājs = new JLabel();
        mazaisSkaitītājs.setBackground(Color.gray);
        mazaisSkaitītājs.setForeground(Color.black);
        mazaisSkaitītājs.setOpaque(true);
        mazaisSkaitītājs.setBounds(0, 0, 100, 50);
        mazaisSkaitītājs.setText("-- : -- : --");
        c.add(mazaisSkaitītājs);

        ieslēgšana = new JButton();
        ieslēgšana.setBounds(0, 50, 100, 50);
        ieslēgšana.setBackground(Color.orange);
        ieslēgšana.setText("Ieslēgt");
        ieslēgšana.setFocusable(false);
        ieslēgšana.addActionListener(this);
        c.add(ieslēgšana);

        iestatīšana = new JButton();
        iestatīšana.setBounds(0, 100, 100, 50);
        iestatīšana.setBackground(Color.yellow);
        iestatīšana.setText("Iestatījumi");
        iestatīšana.setFocusable(false);
        iestatīšana.addActionListener(this);
        c.add(iestatīšana);
        
        ātrumaPoga = new JButton();
        ātrumaPoga.setBounds(0, 150, 120, 50);
        ātrumaPoga.setBackground(Color.orange);
        ātrumaPoga.setText("Ātrums: " + ātrumaCipars);
        ātrumaPoga.setFocusable(false);
        ātrumaPoga.addActionListener(this);
        c.add(ātrumaPoga);
    }

    static void skaitītLaiku() {
    	ieslēgšana.setEnabled(false);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sekundes++;
                if (sekundes >= 60) {
                    minūtes++;
                    sekundes = 0;
                }
                if (minūtes >= 60) {
                    stundas++;
                    minūtes = 0;
                }
                if (stundas >= 24) {
                    dienas++;
                    stundas = 0;
                }
                if (dienas >= 30) {
                    mēneši++;
                    dienas = 0;
                }
                if (mēneši >= 60) {
                    gadi++;
                    mēneši = 0;
                }
                iestatītTekstu();
                ieslēgšana.setText("Apturēt");
            }
        };

        timer = new Timer(1000 / ātrumaCipars, taskPerformer);
        timer.start();
    }

    static void iestatītTekstu() {
        String h = "";
        String m = "";
        String s = "";
        if (stundas < 10) h = "0";
        if (minūtes < 10) m = "0";
        if (sekundes < 10) s = "0";

        String teksts = h + stundas + " : " + m + minūtes + " : " + s + sekundes;
        mazaisSkaitītājs.setText(teksts);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ieslēgšana) {
            skaitītLaiku();
        }
        if (e.getSource() == iestatīšana) {
            System.out.println("Otra Poga");
        }
        if (e.getSource() == ātrumaPoga) {
            ātrumaCipars *= 2;
            if(ātrumaCipars > 128) ātrumaCipars = 1;
            timer.setDelay(1000/ātrumaCipars);
            ātrumaPoga.setText("Ātrums: " + ātrumaCipars);
        }
    }

    public static void main(String[] args) {
        new Kalendārs();
    }
}