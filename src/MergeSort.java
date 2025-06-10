import java.util.Scanner;

public class MergeSort {

    private static int ind = 0;

    private static void add (int[] nums, int[] ans, int start, int end, int op) {
        int startIndex = start;
        int endIndex = end;
        int operation = op;
        while (startIndex != endIndex) {
            ans[ind++] = nums[startIndex];
            startIndex += operation;
        }
    }

    private static int[] merge (int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int start1 = 0, start2 = 0;
        int op1 = 1, op2 = 1;
        int end1 = n1, end2 = n2;
        if (nums1[0] > nums1[1]) {
            start1 = n1 - 1;
            end1 = -1;
            op1 = -1;
        }
        if (nums2[0] > nums2[1]) {
            start2 = n2 - 1;
            end2 = -1;
            op2 = -1;
        }
        int[] ans = new int[n1 + n2];
        while (start1 != end1 && start2 != end2) {
            if (nums1[start1] <= nums2[start2]) {
                ans[ind++] = nums1[start1];
                start1 += op1;
            } else {
                ans[ind++] = nums2[start2];
                start2 += op2;
            }
        }
        add(nums1, ans, start1, end1, op1);
        add(nums2, ans, start2, end2, op2);
        return ans;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }
        int[] ans = merge(nums1, nums2);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

}
