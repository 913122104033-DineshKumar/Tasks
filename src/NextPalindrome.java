import java.util.Scanner;

public class NextPalindrome {

    private static int breakInteger (int n, int pow) {
        return n / pow;
    }

    private static int power (int n) {
        int power = 1;
        for (int i = 0; i < n; i++) {
            power *= 10;
        }
        return power;
    }

    private static int nextPalindrome (int n) {
        int num = n;
        int cnt = 1;
        while (num != 0) {
            cnt++;
            num /= 10;
        }
        int pow = power(cnt - 1);
        int ind = 0;
        num = n;
        int leftPart = 0;
        int rightPart = 0;
        while (ind < cnt / 2) {
            int currentValue = breakInteger(num, pow);
            leftPart = (currentValue * pow) + leftPart;
            rightPart = (rightPart * 10) + currentValue;
            num = num % pow;
            pow /= 10;
            ind++;
        }
        if (cnt % 2 == 1) {
            pow *= 10;
            int middle = num / pow;
            int temp = leftPart + (middle * pow) + rightPart;
            if (temp > n) {
                return temp;
            }
            return leftPart + ((middle + 1) * pow) + rightPart;
        }
        int ans = leftPart + rightPart;
        while (ans < n) {
            ans += power(n) + 10;
        }
        return ans;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nextPalindrome(n));
    }

}
