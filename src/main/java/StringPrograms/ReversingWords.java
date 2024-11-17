package StringPrograms;

public class ReversingWords {
    public static void main(String[] args) {
        String str = "Automation Testing Engineer in Java";
        reversingTextOfWords(str);
        System.out.println();
        reversingWords(str);
    }

    public static void reversingTextOfWords(String str) {
        String[] stringArray = str.toLowerCase().split(" ");
        for (String e : stringArray) {
            String reverse = "";
            for (int i = e.length() - 1; i >= 0; i--) {
                reverse = reverse + e.charAt(i);
            }
            System.out.print(reverse + " ");
        }
    }

    public static void reversingWords(String str) {
        String[] stringArray = str.toLowerCase().split(" ");
        String reverse = "";
        for (int i = stringArray.length - 1; i >= 0; i--) {
            reverse = reverse + stringArray[i] + " ";
        }
        System.out.println("Reversing Words: " + reverse);
    }
}
