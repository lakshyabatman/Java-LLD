package com.lakshyabatman.cachesystem.utils.DoublyLinkedList;

public class DoublyLinkedList<K,V> {

    private final DoubleLinkedListNode<K,V> head;

    public DoublyLinkedList(int capacity) {
        this.head = new DoubleLinkedListNode<>();
        this.head.prev = head;
        this.head.next =this.head;
    }


    public DoubleLinkedListNode<K,V> addInFront(K k, V v) {
        DoubleLinkedListNode<K,V> node = new DoubleLinkedListNode<>(k,v);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        return node;
    }


    public DoubleLinkedListNode<K,V> popBack() {
        return remove(head.prev);
    }

    public DoubleLinkedListNode<K,V> remove(DoubleLinkedListNode<K,V> node) {
        DoubleLinkedListNode<K,V> prev = node.prev;
        DoubleLinkedListNode<K,V> next = node.next;

        prev.next = next;
        next.prev = prev;
        return node;
    }

}
