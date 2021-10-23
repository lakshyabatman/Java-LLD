package com.lakshyabatman.cachesystem.policy;

import com.lakshyabatman.cachesystem.utils.DoublyLinkedList.DoubleLinkedListNode;
import com.lakshyabatman.cachesystem.utils.DoublyLinkedList.DoublyLinkedList;

import java.util.HashMap;

public class LRUStoragePolicy<K,V> extends StoragePolicy<K,V> {

    private final DoublyLinkedList<K,V> list;
    private final HashMap<K,DoubleLinkedListNode<K,V>> map;


    public LRUStoragePolicy(int capacity) {
        super(capacity);
        this.list = new DoublyLinkedList<>(capacity);
        this.map = new HashMap<>();

    }


    public boolean isFull() {
        return map.size() == this.capacity;
    }





    @Override
    public void put(K key, V value) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode<K,V>  node = map.get(key);
            list.remove(node);
            DoubleLinkedListNode<K,V> newNode = list.addInFront(key,value);
            map.put(key,newNode);
        }else {
            if(isFull()) {
                DoubleLinkedListNode<K,V> n = this.list.popBack();
                map.remove(n.key);
            }

            DoubleLinkedListNode<K,V> newNode = list.addInFront(key,value);
            map.put(key,newNode);

        }
    }

    @Override
    public V get(K key) {

       if(map.containsKey(key)) {
           DoubleLinkedListNode<K,V>  node = map.get(key);
           list.remove(node);
           DoubleLinkedListNode<K,V> newNode = list.addInFront(key,node.value);
           map.put(key,newNode);
           return node.value;
       }else {
           return null;
       }
    }
}
