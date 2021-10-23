package com.lakshyabatman.cachesystem.policy;

public abstract class StoragePolicy<K,V> {

    protected final int capacity;

    public abstract void put(K key, V value);

    StoragePolicy(int capacity) {
        this.capacity = capacity;
    }

    public abstract V get(K key);


}
