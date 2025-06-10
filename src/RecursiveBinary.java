public class RecursiveBinary {

    private static int[] toBinary (int n) {
        if (n == 1) {
            return new int[]{ n, 1 };
        }
        int bits = 0;
        int cnt = 0;
        int num = n;
        while (num  != 0) {
            int rem = num % 2;
            bits = (bits * 10) + rem;
            num /= 2;
            cnt++;
        }
        return new int[]{ bits, cnt };
    }

    private static int power (int n) {
        int power = 1;
        for (int i = 0; i < n; i++) {
            power *= 10;
        }
        return power;
    }

    private static int binaryFrequency (int n) {
        int ans = 0;
        int num = n;
        int prev = num % 10;
        num /= 10;
        int cnt = 1;
        while (num != 0) {
            int current = num % 10;
            if (prev == current) {
                cnt++;
            } else {
                int[] value = toBinary(cnt);
                int pow = power(value[1]);
                ans = (ans * pow) + value[0];
                prev = current;
                cnt = 1;
            }
            num /= 10;
        }
        int[] value = toBinary(cnt);
        int pow = power(value[1]);
        ans = (ans * pow) + value[0];
        return ans;
    }

    private static int recursion (int n) {
        if (n == 11 || n == 10) {
            return 0;
        }
        int ans = binaryFrequency(n);
        return 1 + recursion(ans);
    }

    public static void main (String[] args) {
        System.out.println(recursion(223));
    }

}
