import java.util.Scanner;

public class TaskDay9 {
    private static int[] pickIndex (int[] nums, int pickIndex, int putIndex) {
        int pickElement = nums[pickIndex];
        int adder = pickIndex > putIndex ? -1 : 1;
        int start = pickIndex;
        int end = putIndex + 1;
        while (start != end) {
            nums[start] = nums[start + adder];
            start += adder;
        }
        nums[putIndex] = pickElement;
        return nums;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pickIndex = scanner.nextInt();
        int putIndex = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ans = pickIndex(nums, pickIndex, putIndex);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
