import javax.swing.JButton;
import java.awt.*;

/**
 * Bomb button made from specifying JButton
 * @author Mehmet Feyyaz Kucuk
 * @version 28.03.2021
 */
public class BombButton extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = -3191930252142829438L;

    private int position;
    private boolean isPressed;

    /**
     * Initalizes bomb button.
     */
    public BombButton() {
        position = (int) (Math.random() * 25 + 1);
        isPressed = false;
        setText("" + position);
        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    /**
     * Draws the bomb using Graphics2D interface.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isPressed) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.GRAY);
            g2d.fillRect(20, 13, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.fillArc(15, 15, 20, 20, 0, 360);
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawArc(25, 8, 10, 10, 30, 150);

        }
    }

    /**
     * Getter method.
     * @return is position of the button on the grid.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter method.
     * @param position is the position on the grid to be set.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Setter method.
     * @param isPressed is the indication of the button being pressed.
     */
    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }
    
}