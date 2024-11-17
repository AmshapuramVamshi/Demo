package StringPrograms;

public class ReverseString {
    public static void main(String[] args) {
        //  Method One
        String str1 = "automatintesting";
        String reverse = "";
        int length = str1.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + str1.charAt(i);
        }
        System.out.println("Reversing the given String");
        System.out.println("Method1: " + reverse);

        String str2 = "automation";
        char[] charArray =str2.toCharArray();
        String rev = "";
        for (int i=charArray.length-1; i>=0;i--){
            rev +=charArray[i];
        }
        System.out.println("Method2: " + rev);
    }
}
