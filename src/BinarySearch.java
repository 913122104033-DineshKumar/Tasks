import java.util.Scanner;

public class BinarySearch {

    private static int[] findDifference (int dist, int nDist, int ans, int value) {
        if (dist > nDist) {
            dist = nDist;
            ans = value;
        }
        return new int[] { dist, ans };
    }

    private static int search (int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int dist = Integer.MAX_VALUE;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return target;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            int nDist = Math.abs(nums[mid] - target);
            if (dist > nDist) {
                dist = nDist;
                ans = nums[mid];
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int search = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(search(nums, search));
//        int[] ans = pickIndex(nums, pickIndex, putIndex);
//        for (int num : ans) {
//            System.out.print(num + " ");
//        }
    }

}
