package Castom;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CastomArrayList<T> {

    private Object[] array;
    private int size;

    public CastomArrayList() {
        size = 0;
        array = new Object[10];

    }

    private void checkArraySize(int minSize) {
        if (minSize - array.length > 0) {
            int newSize = array.length * 2;
            if(newSize - minSize < 0) {
                newSize = minSize;
            }
            array = Arrays.copyOf(array, newSize);
        }
    }

    public void add(int i, T element) {
        checkArraySize(size + 1);
        System.arraycopy(array, i, array, i + 1, size - i);
        array[i] = element;
        size++;
    }

    public void addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(size, item);
        }
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    public T get(int i) {
        return (T) array[i];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeByIndex(int i) {
        T removedElement = (T) array[i];
        System.arraycopy(array, i + 1, array, i, size - i - 1);
        return removedElement;
    }

    public boolean removeByVolume(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                removeByIndex(i);
                return true;
            }
        }
        return false;
    }

    public void sort(Comparator<? super T> c) {
        Arrays.sort(array, 0, size, (Comparator<Object>) c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
