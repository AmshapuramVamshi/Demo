package IntegerPrograms;

public class PrimeNumber {
    public static void main(String[] args) {
        // Prime number for Single number
        int n = 8;
        if (singleNumber(n)) {
            System.out.println(n + " : Prime");
        } else {
            System.out.println(n + " : Not Prime");
        }
        // Prime number from Array
        int[] array = {2, 4, 11, 5, 7, 9, 34};
        for (int number : array) {
            if (singleNumber(number)) {
                System.out.println(number + ": Prime");
            } else {
                System.out.println(number + ": Not Prime");
            }
        }
    }

    public static boolean singleNumber(int number) {
        int temp = 0;
        for (int i = 2; i <= number - 1; i++) {
            if (number % i == 0) {
                temp = temp + 1;
            }
        }
        if (temp > 0) {
            return false;
        } else {
            return true;
        }
    }
}
