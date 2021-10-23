package com.lakshyabatman.cachesystem;

import com.lakshyabatman.cachesystem.policy.StoragePolicy;

public class Cache<K,V> {

    private final StoragePolicy<K,V> storage;

    Cache(StoragePolicy<K,V>  storage) {
        this.storage = storage;
    }

    public void put(K key, V value) {
        this.storage.put(key,value);
    }

    public V get(K key) {
        return this.storage.get(key);
    }
}
