package heap;

public class Main {
    public static Heap root;
    public static Heap leafNode;

    private static void buildHeap (int[] nums) {
        int cnt = 0;
        for (int val : nums) {
            if (root == null) {
                root = new Heap(val);
                leafNode = root;
            } else {
                leafNode = leafNode.offer(val, cnt % 2 == 0);
            }
            cnt++;
        }
    }

    public static void main (String[] args) {
        root = null;
        leafNode = null;
        buildHeap(new int[]{ 11, 27, 35, 22, 37, 18 });
        System.out.println(root.getVal());
        Heap.dfs(root);
    }

}
