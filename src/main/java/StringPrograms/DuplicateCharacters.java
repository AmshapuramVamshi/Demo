package StringPrograms;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String name = "amshapuramvamshikumar";
        char[] chars = name.toCharArray();
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean repeated = false;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    repeated = true;
                    break;
                }
            }
            if (repeated) {
                sb.append(chars[i]);
                count++;
            }
        }
        System.out.println(sb + " = " + count);
    }
}
