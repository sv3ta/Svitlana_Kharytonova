package ua.home.task2;

public class Task2 {

    private static char firstNonRepeatingLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String subString1 = str.substring(0, i).toLowerCase();
            String subString2 = str.substring(i + 1).toLowerCase();
            if (!subString1.contains(Character.toString(ch)) && !subString2.contains(Character.toString(ch))) {
                return ch;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter("stress"));
    }
}
