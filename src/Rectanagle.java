import java.util.Scanner;

public class Rectanagle {

    private static int[] findSides (int[][] rec) {
        int left1 = (int) 1e9, right1 = -(int) 1e9, top1 = -(int) 1e9, bottom1 = (int) 1e9;
        for (int[] r : rec) {
            left1 = Math.min(left1, r[0]);
            right1 = Math.max(right1, r[0]);
            top1 = Math.max(top1, r[1]);
            bottom1 = Math.min(bottom1, r[1]);
        }
        return new int[] { left1, right1, top1, bottom1 };
    }

    private static String findOverlapping (int[][] r1, int[][] r2) {
        int[] rect1Sides = findSides(r1);
        int leftR1 = rect1Sides[0];
        int rightR1 = rect1Sides[1];
        int topR1 = rect1Sides[2];
        int bottomR1 = rect1Sides[3];
        int[] rect2Sides = findSides(r2);
        int leftR2 = rect2Sides[0];
        int rightR2 = rect2Sides[1];
        int topR2 = rect2Sides[2];
        int bottomR2 = rect2Sides[3];
        if (rightR2 < leftR1 || topR2 < bottomR1 || leftR2 < rightR1 || bottomR2 < topR1) {
            return "Not Overlapping";
        }
        return "Overlapping";
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] r1 = { { 1, 2 }, { 1, 1 }, { 3, 1 }, { 3, 2 } };
        int[][] r2 = { { 1, 2 }, { 1, 4 }, { 3, 2 }, { 3, 4 } };
        System.out.println(findOverlapping(r1, r2));
    }
}
