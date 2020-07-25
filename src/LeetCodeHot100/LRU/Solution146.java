package LeetCodeHot100.LRU;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * 进阶:
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     */

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
    }
}
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer,DLinkedNode> cacheMap ;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap= new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        size =0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }else {
            DLinkedNode node = cacheMap.get(key);
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node;
        if(!cacheMap.containsKey(key)){
            node = new DLinkedNode(key,value);
            cacheMap.put(key,node);
            addToHead(node);
            size++;
            if(size>this.capacity){
                DLinkedNode res = removeTail();
                cacheMap.remove(res.key);
                size--;
            }
        }else {
            node = cacheMap.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private DLinkedNode removeTail( ){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
