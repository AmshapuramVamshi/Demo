package StringPrograms;

public class CapitalString {
    public static void main(String[] args) {
        String str = "my name is vamshi kumar";
        String[] array = str.split("\\s");

        StringBuilder sb = new StringBuilder();
        for (String word : array) {
            sb.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        System.out.println(sb);
    }
}
