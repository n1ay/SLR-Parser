package com.github.n1ay.parser;

import java.util.Hashtable;

public class Hashmatrix<K1, K2, V> {
    private int cols;
    public Hashtable<K1, Hashtable<K2, V>> matrix;

    public Hashmatrix(int rows, int cols) {
        this.cols = cols;
        matrix = new Hashtable<>(rows);
    }

    public V get(K1 key1, K2 key2) {
        return matrix.get(key1).get(key2);
    }

    public void put(K1 key1, K2 key2, V value) {
        try {
            matrix.get(key1).put(key2, value);

        } catch (NullPointerException ex) {
            Hashtable<K2, V> hashtable = new Hashtable<>(cols);
            hashtable.put(key2, value);
            matrix.put(key1, hashtable);
        }
    }

    public Hashmatrix<K1, K2, V> add(K1 key1, K2 key2, V value) {
        put(key1, key2, value);
        return this;
    }
}
