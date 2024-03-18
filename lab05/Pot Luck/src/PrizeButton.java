import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Prize button made from specifying JButton
 * @author Mehmet Feyyaz Kucuk
 * @version 28.03.2021
 */
public class PrizeButton extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int position;

    /**
     * Initalizes the prize button.
     */
    public PrizeButton() {
        position = (int) (Math.random() * 25 + 1);
        setText("" + position);
        setPreferredSize(new Dimension(50, 50));
    }

    /**
     * Reveals the when star when prize button is pressed.
     */
    public void revealContent() {
        setPreferredSize(new Dimension(50, 50));
        setForeground(Color.ORANGE);
        setFont(getFont().deriveFont(18f)); 
        setText("\u2605");
    }

    /**
     * Setter method.
     * @param position is the position on the grid to be set.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Getter method.
     * @return is position of the button on the grid.
     */
    public int getPosition() {
        return position;
    }
    
}
