import java.util.Scanner;

public class Subset {

    public static void printSubset (int start, int end, int[] nums) {
        int adder = start > end ? -1 : 1;
        int startIndex = start;
        while (startIndex != end + 1) {
            System.out.print(nums[startIndex] + " ");
            startIndex += adder;
        }
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
        printSubset(pickIndex, putIndex, nums);
        //int[] ans = (nums, pickIndex, putIndex);
//        for (int num : ans) {
//            System.out.print(num + " ");
//        }
    }
}
