package me.creeper.creepermodtest.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class CTMArray<T> {
    private final Deque<T> deque = new ArrayDeque<>();
    private final int maxSize;

    public CTMArray(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T element) {
        deque.addLast(element);
        if (deque.size() > maxSize) {
            deque.removeFirst();
        }
    }

    public Deque<T> values() { return deque; }

    public Object[] toArray() { return deque.toArray(); }

    @Override
    public String toString() { return deque.toString(); }
}
