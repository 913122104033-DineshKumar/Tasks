import java.util.Scanner;
import java.util.Stack;

public class Arrays {

    private static void reverse (int[] nums, int s, int e) {
        int start = s;
        int end = e;
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] reverseInBlockSize (int[] nums, int blockSize) {
        for (int i = 0; i < nums.length; i += blockSize) {
            reverse(nums, i, Math.min(nums.length - 1, i + (blockSize - 1)));
        }
        return nums;
    }

    private static int factor (int num) {
        int factors = (num == 1) ? 1 : 2;
        for (int factor = 2; factor <= num / 2; factor++) {
            if (num % factor == 0) {
                factors++;
            }
        }
        return factors;
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int[] sortUsingFactor (int[] nums) {
        int n = nums.length;
        int[] factors = new int[n];
        for (int i = 0; i < n; i++) {
            factors[i] = factor(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int minFactor = factors[i];
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (factors[j] < minFactor) {
                    minFactor = factors[j];
                    minInd = j;
                }
            }
            if (i != minInd) {
                swap(factors, i, minInd);
                swap(nums, i, minInd);
            }
        }
        return nums;
    }

    private static int[] nge (int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = 0; i < n - 1; i++) {
            int dist = nums[i + 1] - nums[i];
            int nge = -1;
            for (int j = i + 1; j < n; j++) {
                int nDist = nums[j] - nums[i];
                if (nDist > 0 && nDist < dist) {
                    dist = nDist;
                    nge = nums[j];
                }
            }
            ans[i] = nge;
        }
        return ans;
    }

    private static int[] nextGreaterElement (int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.empty() && nums[st.peek()] < nums[i]) {
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }
        while (!st.empty()) {
            ans[st.pop()] = -1;
        }
        return ans;
    }

    private static boolean isVowel (char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static String longestConsantsSubstring (String s) {
        int n = s.length();
        int start = 0, prev = 0;
        int maxLen = 0;
        for (int ind = 0; ind < n; ind++) {
            char c = s.charAt(ind);
            if (isVowel(c)) {
                int windowSize = ind - (prev + 1);
                if (windowSize > maxLen) {
                    maxLen = windowSize;
                    start = prev + 1;
                    prev = ind;
                }
            }
        }
        return s.substring(start, Math.min(n, start + maxLen));
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(longestConsantsSubstring(s));
//        System.out.println("Enter Array size: ");
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        System.out.println("Enter Array Elements: ");
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        int[] ans = nge(nums);
//        for (int num : ans) {
//            System.out.print(num + " ");
//        }
    }
}
