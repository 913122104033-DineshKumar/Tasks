package Cache;

import java.util.HashMap;
import java.util.Map;

class DoublyList {
    String id;
    String value;
    DoublyList prev;
    DoublyList next;
    public DoublyList (String id, String value) {
        this.id = id;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}

public class LRU {
    Map<String, DoublyList> cache;
    int size;
    int currentSize;
    DoublyList lessFrequentNode;
    DoublyList recentlyUsedNode;

    public LRU (int size) {
        this.size = size;
        this.currentSize = 0;
        this.lessFrequentNode = null;
        this.recentlyUsedNode = null;
        this.cache = new HashMap<>();
    }

    public void put (String id, String value) {
        DoublyList node = new DoublyList(id, value);
        if (lessFrequentNode == null && recentlyUsedNode == null) {
            lessFrequentNode = node;
        } else {
            if (currentSize >= size) {
                if (lessFrequentNode != null) {
                    DoublyList removeNode = lessFrequentNode;
                    DoublyList nextNode = removeNode.next;
                    nextNode.prev = null;
                    lessFrequentNode = nextNode;
                    cache.remove(removeNode.id);
                }
            }
            recentlyUsedNode.next = node;
            node.prev = recentlyUsedNode;
        }
        if (lessFrequentNode != null && lessFrequentNode.next == null) {
            lessFrequentNode.next = recentlyUsedNode;
        }
        recentlyUsedNode = node;
        currentSize++;
        cache.put(id, node);
    }

    public String get (String id) {
        if (!cache.containsKey(id)) {
            return "No Value is there";
        }
        DoublyList highlyUsedNode = cache.get(id);
        DoublyList previousNode = recentlyUsedNode;
        previousNode.next = highlyUsedNode;
        highlyUsedNode.prev = previousNode;
        highlyUsedNode.next = null;
        recentlyUsedNode = highlyUsedNode;
        cache.put(id, recentlyUsedNode);
        cache.put(previousNode.id, previousNode);
        return cache.get(id).value;
    }

}
