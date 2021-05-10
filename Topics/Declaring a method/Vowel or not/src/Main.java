import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'A') {
            return true;
        } else if (ch == 'e' || ch == 'E') {
            return true;
        } else if (ch == 'i' || ch == 'I') {
            return true;
        } else if (ch == 'o' || ch == 'O') {
            return true;
        } else {
            return ch == 'u' || ch == 'U';
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}