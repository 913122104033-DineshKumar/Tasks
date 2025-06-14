package heap;

import java.util.LinkedList;
import java.util.Queue;

public class HeapTree {
    private Heap root;
    private Queue<Heap> queue;

    public HeapTree (int val) {
        this.root = new Heap(val);
        this.queue = new LinkedList<>();
        this.queue.add(root);
    }

    public void offer (int val) {
        Heap node = new Heap(val);
        while (!queue.isEmpty()) {
            Heap parent = queue.poll();
            if (parent.getLeft() == null) {
                parent.setLeft(node);
                node.setParent(parent);
                queue.offer(node);
                break;
            } else if (parent.getRight() == null) {
                parent.setRight(node);
                node.setParent(parent);
                queue.offer(node);
                queue.poll();
                break;
            } else {
                queue.poll();
            }
        }
        node.heapifyUp();
    }

    public Heap getRoot () {
        return root;
    }

}
