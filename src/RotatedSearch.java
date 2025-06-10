import java.util.Scanner;

public class RotatedSearch {

    private static int search (int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[high] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(search(new int[]{ 3, 4, 5, 1, 2 }, 1));
    }

}
