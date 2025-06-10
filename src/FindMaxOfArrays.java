import java.util.Scanner;

public class FindMaxOfArrays {

    private static int[] findMax (int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int max = 0;
        int[] ans = new int[n];
        for (int ind = n - 1; ind >= 0; ind--) {
            max = Math.max(max, nums[ind]);
            prefixMax[ind] = max;
        }
        for (int ind = 0; ind < n; ind++) {
            if (nums[ind] >= prefixMax[ind]) {
                ans[ind] = nums[ind];
            } else {
                ans[ind] = -1;
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ans = findMax(nums);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

}
