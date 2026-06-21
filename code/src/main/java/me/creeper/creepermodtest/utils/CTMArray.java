package me.creeper.creepermodtest.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTMArray<?>)) return false;
        CTMArray<?> other = (CTMArray<?>)o;
        return maxSize == other.maxSize
                && deque.equals(other.deque);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(maxSize);
        for (T element : deque) {
            result = 31 * result + Objects.hashCode(element);
        }
        return result;
    }
}
