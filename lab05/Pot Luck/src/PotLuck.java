import javax.swing.JFrame;

/**
 * Pot Luck game
 * @author Mehmet Feyyaz Kucuk
 * @version 28.03.2021
 */
public class PotLuck {
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame();
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Pot Luck");
        f.add(new AppPanel());
        f.setVisible(true);
        f.pack();

    }
}
