package com.lakshyabatman.cachesystem;

import com.lakshyabatman.cachesystem.policy.LRUStoragePolicy;

public class Main {

    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(new LRUStoragePolicy<>(3));
        cache.put("1", 10);
        cache.put("2",32);
        System.out.println(cache.get("1"));
        cache.put("3",21);
        cache.put("4",31);
        System.out.println(cache.get("2"));
        cache.put("5",31);
        cache.put("4",31);
        System.out.println(cache.get("3"));
        cache.put("6",31);
        System.out.println(cache.get("5"));
    }
}
