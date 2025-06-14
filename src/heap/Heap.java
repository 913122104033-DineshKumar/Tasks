package heap;

public class Heap {
    private int val;
    private Heap left;
    private Heap right;
    private Heap parent;

    public Heap (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public void setVal (int val) {
        this.val = val;
    }

    public Heap offer (int val, boolean isLeft) {
        Heap node = new Heap(val);
        node.parent = this;
        if (isLeft && this.left == null) {
            this.left = node;
        } else if (!isLeft && this.right == null) {
            this.right = node;
        } else {
            if (isLeft) {
                return this.left.offer(val, false);
            }
            return this.right.offer(val, true);
        }
        node.heapifyUp();
        return node;
    }

    public int peek () {
        return this.val;
    }

    public void heapifyUp () {
        if (this.parent != null && this.val > this.parent.val) {
            int temp = this.val;
            this.val = this.parent.val;
            this.parent.val = temp;
            this.parent.heapifyUp();
        }
    }

    private static void print (Heap node) {
        String leftData = node.left == null ? "-" : String.valueOf(node.left.val);
        String rightData = node.right == null ? "-" : String.valueOf(node.right.val);
        System.out.println("(" +  leftData + ", " + node.val + ", " + rightData + ")");
    }

    public static void dfs (Heap node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        print(node);
        dfs(node.right);
    }

    public int getVal() {
        return val;
    }

    public Heap getLeft() {
        return left;
    }

    public Heap getRight() {
        return right;
    }

    public Heap getParent() {
        return parent;
    }

    public void setLeft(Heap left) {
        this.left = left;
    }

    public void setRight(Heap right) {
        this.right = right;
    }

    public void setParent(Heap parent) {
        this.parent = parent;
    }
}
