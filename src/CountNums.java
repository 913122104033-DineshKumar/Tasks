import java.util.Scanner;

public class CountNums {

    private static String count (long n) {
        StringBuilder sb = new StringBuilder();
        long num = n;
        long prev = num % 10;
        num /= 10;
        int cnt = 1;
        while (num != 0) {
            long current = num % 10;
            if (prev == current) {
                cnt++;
            } else {
                sb.append(prev);
                sb.append(cnt);
                prev = current;
                cnt = 1;
            }
            num /= 10;
        }
        sb.append(prev);
        sb.append(cnt);
        return sb.reverse().toString();
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(count(n));
    }
}
