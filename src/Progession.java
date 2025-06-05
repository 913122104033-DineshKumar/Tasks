import java.util.Scanner;

import static java.util.Collections.swap;

public class Progession {
    private static void arithimeticProgression (int a, int d, int n) {
        for (int i = a; i <= a * (n - 1); i += d) {
            System.out.println(i + " ");
        }
    }
    private static void geometricProgression (int a, int d, int n) {
        int num = a;
        for (int i = 1; i <= n; i++) {
            System.out.println(num);
            num *= d;
        }
    }

    private static void progression (int a, int d, int n, char type) {
        int multiplicationFactor;
        int adder;
        if (type == 'a') {
            multiplicationFactor = 1;
            adder = d;
        } else {
            multiplicationFactor = d;
            adder = 0;
        }
        int num = a;
        for (int i = 1; i <= n; i++) {
            System.out.println(num);
            num = (num * multiplicationFactor) + adder;
        }
    }

    private static void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void sort (int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i += 2) {
            int max = nums[i];
            int maxInd = i;
            int min = nums[i];
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > max){
                    max = nums[j];
                    maxInd = j;
                }
                if (nums[j] < min) {
                    min = nums[j];
                    minInd = j;
                }
            }
            swap(i, maxInd, nums);
            swap(i + 1, minInd, nums);
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

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

    private static String compress (String s) {
        StringBuilder ans = new StringBuilder();
        char prev = s.charAt(0);
        int cnt = 1;
        int ind;
        for ( ind = 1; ind < s.length(); ind++) {
            char current = s.charAt(ind);
            if (current != prev) {
                if (cnt > 1) {
                    ans.append(cnt);
                }
                ans.append(prev);
                cnt = 1;
                prev = current;
            } else {
                cnt++;
            }

        }
        if (ind == s.length() - 1) {
            if (cnt > 1) {
                ans.append(cnt);
            }
            ans.append(prev);
        }
        return ans.toString();
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(convertor(2768, 32));
    }
}
