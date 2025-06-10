import java.util.Scanner;

public class SpaceJustification {

    private static void justify (String s, int start, int end, int lineWidth) {
        int size = end - start + 1;
        System.out.println(size);
        int spaces = 0;
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i + start);
            if (c == ' ') {
                spaces++;
            }
        }
        int extraSpaces = lineWidth - size;
        if (spaces == 0) {
            System.out.println(" ".repeat(extraSpaces) + "|");
        }
        int evenSpace = extraSpaces / spaces;
        int extras = extraSpaces % spaces;
        String toBeAdded = (" ").repeat(evenSpace);
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i + start);
            if (c == ' ') {
                System.out.print(toBeAdded);
                if (extras > 0) {
                    System.out.print(" ");
                    extras -= 1;
                }
            } else {
                System.out.print(c);
            }
        }
        System.out.print("|");
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int lineWidth = scanner.nextInt();
        justify(s, 0, s.length() - 1, lineWidth);
    }

}
