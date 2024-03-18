import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Custom panel for convert numbers.
 * @author Mehmet Feyyaz Kucuk
 * @version 29.03.2021
 */
public class AppPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    // Properties
    private JLabel decimalLabel;
    private JLabel hexLabel;
    private JLabel binaryLabel;
    private JTextField decimalField;
    private JTextField hexField;
    private JTextField binaryField;
    
    ArrayList<Character> hexCharacters = new ArrayList<Character>();

    // Constructor
    /**
     * Initalizes the panel.
     */
    public AppPanel() {
        setLayout(new GridLayout(3, 2));

        // Define hex characters.
        hexCharacters.add('A');
        hexCharacters.add('B');
        hexCharacters.add('C');
        hexCharacters.add('D');
        hexCharacters.add('E');
        hexCharacters.add('F');

        decimalLabel = new JLabel("Decimal");
        hexLabel = new JLabel("Hex");
        binaryLabel = new JLabel("Binary");
        decimalField = new JTextField("0");
        decimalField.addActionListener(new DecimalLabelListener());
        decimalField.setPreferredSize(new Dimension(200, 150));
        hexField = new JTextField("0");
        hexField.addActionListener(new HexLabelListener());
        binaryField = new JTextField("0");
        binaryField.addActionListener(new BinaryLabelListener());

        add(decimalLabel);
        add(decimalField);
        add(hexLabel);
        add(hexField);
        add(binaryLabel);
        add(binaryField);
    }

    // Methods
    /**
     * Converts binart to decimal.
     * @param binary is the binary number.
     * @return is decimal that is converted.
     */
    private int binaryToDecimal(String binary) {
        if (binary.equals("0")) {
            return 0;
        }

        int result;
        int degree;

        result = 0;
        degree = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            result += Integer.parseInt(String.valueOf(binary.charAt(i))) * (int) Math.pow(2, degree);
            degree++;
        }

        return result;
    }

    /**
     * Converts hex to decimal.
     * @param hex is the hex number.
     * @return is hex that is converted.
     */
    private int hexToDecimal(String hex) {
        if (hex.equals("0")) {
            return 0;
        }

        int result;
        int degree;

        result = 0;
        degree = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            if (Character.isDigit(hex.charAt(i))) {
                result += Integer.parseInt(String.valueOf(hex.charAt(i))) * (int) Math.pow(16, degree);
            }
            else {
                result += (hexCharacters.indexOf(hex.charAt(i)) + 10) * (int) Math.pow(16, degree);
            }
            degree++;
        }

        return result;
    }

    /**
     * Converts decimal to binary.
     * @param decimal is the decimal to be converted.
     * @return is the binary that is converted.
     */
    private String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        String result;

        result = "";
        while (decimal >= 1) {
            result += decimal % 2; 
            decimal = decimal / 2;
        }

        return reverse(result);
    }

    /**
     * Converts decimal to hex.
     * @param decimal is the decimal to be converted.
     * @return is the hex that is converted.
     */
    private String decimalToHex(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        String result;

        result = "";
        while (decimal >= 1) {
            if (decimal % 16 < 10) {
                result += decimal % 16;
            }
            else {
                result += hexCharacters.get(decimal % 16 - 10);
            }

            decimal = decimal / 16;
        }

        return reverse(result);
    }

    /**
     * Returns the reversed string, (written for decimalToBinary method.)
     * @param s is the string to be reversed.
     * @return is the reversed string.
     */
    private static String reverse(String s) {
        String result;

        result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }

    /**
     * Listents binary label for conversions.
     */
    public class BinaryLabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            decimalField.setText("" + binaryToDecimal(binaryField.getText()));
            hexField.setText(decimalToHex(binaryToDecimal(binaryField.getText())));
        }
        
    }

    /**
     * Listents hex label for conversions.
     */
    public class HexLabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            decimalField.setText("" + hexToDecimal(hexField.getText()));
            binaryField.setText(decimalToBinary(hexToDecimal(hexField.getText())));
            
        }
        
    }

    /**
     * Listents decimal label for conversions.
     */
    public class DecimalLabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            binaryField.setText(decimalToBinary(Integer.parseInt(decimalField.getText())));
            hexField.setText(decimalToHex(Integer.parseInt(decimalField.getText())));
        }
        
    }

}