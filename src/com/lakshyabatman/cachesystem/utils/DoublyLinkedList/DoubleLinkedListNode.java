package com.lakshyabatman.cachesystem.utils.DoublyLinkedList;

public class DoubleLinkedListNode<K,V> {
    public DoubleLinkedListNode<K,V> next;

    public DoubleLinkedListNode<K,V> prev;

    public V value;

    public K key;

    public DoubleLinkedListNode(K k, V v) {
        this.next = null;
        this.prev = null;
        this.value = v;
        this.key = k;
    }

    public DoubleLinkedListNode() {
        this.next = null;
        this.prev = null;
    }
}
