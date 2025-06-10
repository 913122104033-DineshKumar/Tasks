public class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    private static void print (Tree node) {
        String leftData = node.left == null ? "-" : String.valueOf(node.left.data);
        String rightData = node.right == null ? "-" : String.valueOf(node.right.data);
        System.out.println("(" +  leftData + ", " + node.data + ", " + rightData + ")");
    }

    private static void dfs (Tree node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        print(node);
        dfs(node.right);
    }

    public static void main (String[] args) {
        Tree tree = new Tree(3);
        tree.left = new Tree(4);
        tree.right = new Tree(2);
        dfs(tree);
    }

}
