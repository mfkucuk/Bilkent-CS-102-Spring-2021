import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A personalized panel for the pot luck app.
 * @author Mehmet Feyyaz Kucuk
 * @version 28.03.2021
 */
public class AppPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 7423260591494600866L;

    private int attempt;
    private JLabel gameMessage;
    private BombButton bomb1;
    private BombButton bomb2;
    private PrizeButton prize;

    /**
     * Initalizes the AppPanel for the pot luck.
     */
    public AppPanel() {

        // Initalize attempt number.
        attempt = 0;

        // Initalize game message JLabel.
        gameMessage = new JLabel("Attempts: " + attempt);

        // Initalize first bomb.
        bomb1 = new BombButton();
        bomb1.addActionListener(new BombButtonActionListener());

        // Initalize second bomb.
        bomb2 = new BombButton();
        bomb2.addActionListener(new BombButtonActionListener());

        // Initalize prize button.
        prize = new PrizeButton();
        prize.addActionListener(new PrizeButtonActionListener());

        // Make sure the positions of all three buttons are different.
        while (bomb1.getPosition() == prize.getPosition()) {
            bomb1.setPosition((int) (Math.random() * 25 + 1));
        }

        while (bomb2.getPosition() == prize.getPosition() || bomb2.getPosition() == bomb1.getPosition()) {
            bomb2.setPosition((int) (Math.random() * 25 + 1));
        }

        for (int i = 1; i <= 25; i++) {
            if (i == bomb1.getPosition()) {
                add(bomb1);
                continue;
            }
            if (i == bomb2.getPosition()) {
                add(bomb2);
                continue;
            }
            if (i == prize.getPosition()) {
                add(prize);
                continue;
            }

            JButton regularButton = new JButton("" + i);
            regularButton.addActionListener(new ButtonActionListener());
            regularButton.setPreferredSize(new Dimension(50, 50));

            add(regularButton);
        }
        add(gameMessage);
    }

    /**
     * Sets the dimensions of the panel.
     * @return is the dimensions of the panel.
     */
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    /**
     * Listens regular buttons for clicks.
     */
    public class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setEnabled(false);
            attempt++;
            gameMessage.setText("Attempts: " + attempt);
        }
    }
    
    /**
     * Listens bomb buttons for clicks.
     */
    public class BombButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            attempt++;
            gameMessage.setText("Sorry! You are blown up at attempt " + attempt + "!");
            revealAllContent();
            
        }

    }

    /**
     * Listens prize button for clicks.
     */
    public class PrizeButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            attempt++;
            gameMessage.setText("You got it in " + attempt + " attempts!");
            revealAllContent();
            
        }

    }

    /**
     * Reveals all bomb and prize button when any of them are clicked.
     */
    private void revealAllContent() {
        prize.revealContent();
        bomb1.setIsPressed(true);
        bomb2.setIsPressed(true);
        repaint();

        for ( Component c : getComponents() ) {
            c.setEnabled(false);
        }

        prize.setEnabled(true);
    }
}
