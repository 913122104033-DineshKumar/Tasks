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

    private static long reverse (long n, int gap) {
        long num = n;
        long ans = 0;
        while (gap > 0) {
            long rem = num % 10;
            ans = (ans * 10) + rem;
            num /= 10;
            gap--;
        }
        return ans;
    }

    private static long rightRotate (long n, int rotations) {
        int cnt = 0;
        long num = n;
        while (num != 0) {
            cnt++;
            num /= 10;
        }
        long reverse = reverse(n, cnt);
        long rightPart = reverse(reverse, rotations);
        long leftPart =  reverse;
        int gap = rotations;
        while (gap > 0) {
            leftPart /= 10;
            gap--;
        }
        leftPart = reverse(leftPart, (cnt - rotations) + 1);
        return (leftPart * 10) + rightPart;
    }

    private static void leftRotate (long n, int rotations) {
        int cnt = 0;
        long num = n;
        while (num != 0) {
            num /= 10;
            cnt++;
        }
        num = n;
        int gap = rotations;
        long leftPart = 0;
        while (gap > 0) {
            long rem = num % 10;
            leftPart = (leftPart * 10) + rem;
            num /= 10;
            gap--;
        }
        gap = cnt - rotations;
        long rightPart = 0;
        while (gap > 0) {
            long rem = num % 10;
            rightPart = (rightPart * 10) + rem;
            num /= 10;
            gap--;
        }
    }

    private static void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int[] swapOdd (int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (nums[start] % 2 == 1 && nums[end] % 2 == 1) {
                swap(start, end, nums);
            }
            if (nums[start] % 2 == 0) {
                start++;
            }
            if (nums[end] % 2 == 0) {
                end--;
            }
        }
        return nums;
    }

    private static int[] alternateSort (int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            int minInd = left;
            int min = nums[left];
            for (int j = left; j <= right; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minInd = j;
                }
            }
            if (left != minInd) {
                if (i % 2 == 0) {
                    swap(left, minInd, nums);
                    left++;
                } else {
                    swap(right, minInd, nums);
                    right--;
                }
            }
        }
        return nums;
    }

    private static boolean isBlock (int element, int[] block) {
        for (int i = 0; i < 3; i++) {
            if (element == block[i]) {
                return true;
            }
        }
        return false;
    }

    private static int[] frequentElements (int[] nums) {
        int n = nums.length;
        int[][] freq = new int[n][2];
        for (int num : nums) {
            putInFreq(freq, num);
        }
        int k = 3;
        int[] ans = new int[k];
        int ind = 0;
        while (k-- > 0) {
            int max = freq[ind][1];
            int element = freq[ind][0];
            for (int i = 1; i < n; i++) {
                if (max < freq[i][1] && !isBlock(element, ans)) {
                    max = freq[i][1];
                    element = freq[i][0];
                }
            }
            ans[ind++] = element;
        }
        return ans;
    }

    private static void putInFreq(int[][] freq, int num) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][0] == num) {
                freq[i][1] += 1;
                break;
            } else if (freq[i][0] == 0) {
                freq[i][0] = num;
                freq[i][1] = 1;
                break;
            }
        }
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

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        int[] ans = frequentElements(nums);
//        for (int num : ans) {
//            System.out.print(num + " ");
//        }
    }
}
