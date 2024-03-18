import java.util.ArrayList;

/**
 * Some static functions which solve problems using recursion logic.
 * @author Mehmet Feyyaz Kucuk
 * @version 4.10.2021
 */
public class Recursion {
    public static void main(String[] args) throws Exception {

        ArrayList<String> words1 = new ArrayList<String>();
        words1.add("Apple");
        words1.add("Banana");
        words1.add("Canyon");

        ArrayList<String> words2 = new ArrayList<String>();
        words2.add("Master");
        words2.add("Moon");
        words2.add("Monkey");

        System.out.println(removeR("refrigerators"));
        System.out.println(decimalToHex(1249));
        System.out.println(isLexicographic(words1));
        System.out.println(isLexicographic(words2));
        System.out.println(reverse("Attack on Titan"));
        printEvenNumbers(3);
        
    }

    /**
     * Removes all the occurences of letter 'r' in a string.
     * @param s is the string.
     * @return is string with letter 'r's removed.
     */
    public static String removeR(String s) {

        // Base case
        if (s.length() == 0) {
            return "";
        }

        if (s.charAt(0) == 'r') {
            return "" + removeR(s.substring(1));
        }
        else {
            return s.charAt(0) + removeR(s.substring(1));
        }
    }

    /**
     * Converts a decimal number to a hex number form.
     * @param decimal is the base 10 number.
     * @return is the base 16 number.
     */
    public static String decimalToHex(int decimal) {
        String[] hexCharacters = new String[]{"A", "B", "C", "D", "E", "F"};

        // Base case
        if (decimal <= 1) {
            return "";
        }

        if (decimal % 16 >= 10) {
            return decimalToHex(decimal / 16) + hexCharacters[decimal % 16 - 10];
        }
        else {
            return decimalToHex(decimal / 16) + (decimal % 16);
        }
    }

    /**
     * Checks whether a group of words are listed lexicographically.
     * @param words is the list of words.
     * @return is the boolean indicating whether if it's lexicographic or not.
     */
    public static boolean isLexicographic(ArrayList<String> words) {
        
        // Base case
        if (words.size() <= 1) {
            return true;
        }

        if (words.get(0).compareTo(words.get(1)) <= 0) {
            words.remove(0);
            return isLexicographic(words);
        }
        else {
            return false;
        }
    }

    /**
     * Reverses a string.
     * @param s is the string to be reversed.
     * @return is the reversed form.
     */
    public static String reverse(String s) {
        
        // Base case
        if (s.length() == 0) {
            return "";
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }

    /**
     * Prints all even n-digit numbers whose digits increase from left to right.
     * @param n is the digit.
     * @param startingNum is the smallest n-digit number.
     */
    public static void printEvenNumbers(int n, int startingNum) {

        // n can't be greater 8 (eg. n = 9 -> 123456789).
        if (n > 8) {
            System.out.println("n cannot be greater than 8!");
            return;
        }

        // Base step
        if (startingNum > Math.pow(10, n) - 1) {
            return;
        }

        
        if (isIncreasing(startingNum)) {
            System.out.println(startingNum);
        }

        printEvenNumbers(n, startingNum + 2);
    }

    /**
     * Prints all even n-digit numbers whose digits increase from left to right.
     * Overloads the original printEvenNumbers because the user does not know about startingPoint.
     * @param n is the digit.
     */
    public static void printEvenNumbers(int n) {
        printEvenNumbers(n, (int) Math.pow(10, n - 1));
    }


    /**
     * 
     * @param num
     * @return
     */
    private static boolean isIncreasing(int num) {

        // Base step
        if (num < 10) {
            return true;
        }

        if (num % 10 > (num % 100) / 10) {
            return isIncreasing((num - num % 10) / 10);
        }
        else {
            return false;
        }
    }
}
