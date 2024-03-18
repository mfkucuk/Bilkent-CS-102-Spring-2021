import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Convert Numbers App
 * @author Mehmet Feyyaz Kucuk
 * @version 31.03.2021
 */
public class ConvertNumbers {
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame();

        f.setPreferredSize(new Dimension(300, 450));
        f.add(new AppPanel());
        f.setTitle("Convert Numbers");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
    }
}
