public class Binary {

    private static String convertor (int n, int base) {
        int num = n;
        StringBuilder ans = new StringBuilder();
        while (num > 1) {
            int rem = num % base;
            if (rem > 9) {
                char bit = (char) ((rem - 9) % 26 + (int) 'A');
                ans.append(bit);
            } else {
                ans.append(rem);
            }
            num /= base;
        }
        if (num != 0) {
            ans.append(num);
        }
        return ans.reverse().toString();
    }

    private static int num(int n) {
        int num = n;
        int pow = 1;
        int ans = 0;
        while (num != 0) {
            int rem = num / 2;
            ans += pow * rem;
            pow *= 2;
            num /= 2;
        }
        return ans;
    }

    private static int addition(int a, int b) {
        return num(a) + num(b);
    }

    private static int[] countOnesAndZeros (int n) {
        int num = n;
        int ones = 0;
        int zeroes = 0;
        while (num  != 0) {
            int rem = num % 2;
            if (rem == 0) {
                zeroes++;
            } else {
                ones++;
            }
            num /= 2;
        }
        return new int[] { ones, zeroes };
    }

    private static int bitAddition (int a, int b) {
        int num1 = a;
        int num2 = b;
        int pos = 1;
        int extras = 0;
        int ans = 0;
        while (num1 > 0 || num2 > 0) {
            int rem1 = num1 % 10;
            int rem2 = num2 % 10;
            int sum = rem1 + rem2 + extras;
            ans = ((sum % 2) * pos) + ans;
            extras += (sum / 2);
            num1 /= 10;
            num2 /= 10;
            pos *= 10;
        }
        if (extras > 0) {
            ans = (extras * pos) + ans;
        }
        return ans;
    }

}
