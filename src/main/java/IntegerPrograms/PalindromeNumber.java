package IntegerPrograms;

public class PalindromeNumber {
    public static void main(String[] args) {
        // Palindrome number for single element
        int number = 1234321;
        if (checkPalindromeNumber(number)) {
            System.out.println("Palindrome Number");
        } else {
            System.out.println("Not a Palindrome Number");
        }

        // Palindrome number for Multiple element
        int array[] = {121, 434, 665, 777, 838, 10101, 98};
        for (int value : array) {
            if (checkPalindromeNumber(value)) {
                System.out.println(value + " : Palindrome Number");
            } else {
                System.out.println(value + " : Not a Palindrome Number");
            }
        }
    }

    public static boolean checkPalindromeNumber(int value) {
        int store = value;
        int remainder = 0;
        int reverse = 0;
        while (value > 0) {
            remainder = value % 10;
            reverse = reverse * 10 + remainder;
            value = value / 10;
        }
        if (reverse == store) {
            return true;
        } else {
            return false;
        }
    }
}
