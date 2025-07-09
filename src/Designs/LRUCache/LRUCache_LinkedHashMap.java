import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache_LinkedHashMap extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache_LinkedHashMap(int capacity) {
        //initial capacity. load factor - when to increase the size. Access order - not only maintain insert order, also maintain order for iteration.
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}