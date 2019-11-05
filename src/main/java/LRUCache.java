import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 );  缓存容量
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 **/

class LRUCache {

    private int capacity = 0;
    private Entry head;
    private Entry tail;
    private HashMap<Integer, Entry> hashMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Entry entry = hashMap.get(key);
            popToTail(entry);
            return entry.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Entry entry = hashMap.get(key);
            entry.setValue(value);
            popToTail(entry);
        } else {
            Entry entry = new Entry(key, value);
            if (hashMap.size() >= capacity) {
                Entry first = head.next;
                head.next = first.next;
                first.next.prev = head;
                hashMap.remove(first.getKey());
            }
            hashMap.put(key, entry);
            addToTail(entry);
        }
    }

    public void popToTail(Entry entry) {
        Entry prev = entry.prev;
        Entry next = entry.next;
        prev.next = next;
        next.prev = prev;
        Entry last = tail.prev;
        last.next = entry;
        entry.prev = last;
        entry.next = tail;
        tail.prev = entry;
    }

    public void addToTail(Entry entry) {
        Entry last = tail.prev;
        last.next = entry;
        entry.prev = last;
        entry.next = tail;
        tail.prev = entry;
    }

    static class Entry {
        private Entry prev;
        private Entry next;
        private int key;
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry getPrev() {
            return prev;
        }

        public void setPrev(Entry prev) {
            this.prev = prev;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}