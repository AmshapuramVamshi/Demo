package IntegerPrograms;

public class EvenOddNumbers {
    public static void main(String[] args) {
        //Single Number
        int number = 10;
        if (checkEvenOdd(number)) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }

        // Finding Even and Odd from Array
        int[] array = {2, 7, 11, 64, 96, 45, 68};
        for (int i : array) {
            if (checkEvenOdd(i)) {
                System.out.println(i + " : Even Number");
            } else {
                System.out.println(i + " : Odd Number");
            }
        }
    }

    public static boolean checkEvenOdd(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
