package collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<T> implements Collection<T> {

    private T[] array = (T[]) new Object[1];
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size(); i++) {

            if (array[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {

        T[] newArray = (T[]) new Object[size()];
        System.arraycopy(array, 0, newArray, 0, size());
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) this.toArray();
    }

    @Override
    public boolean add(T t) {

        if (array.length == size()) {
            T[] oldArray = array;
            array = (T[]) new Object[this.size() * 2];
            System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }
        array[size++] = t;

        return true;
    }

    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < size(); i++) {
            if (this.array[i].equals(o)) {
                System.arraycopy(array, i + 1, array, i, size() - 1 - i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object o : c) {
            if (!this.contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        for (T o : c) {
            this.add(o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            this.remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size(); i++) {
            if (!c.contains(array[i]))
                /*Счетчик цикла необходимо уменьшать при каждом удалении.
              Потому что удаление элемента из коллекции не просто уменьшает size,
               а еще и сдвигает элементы в массиве.*/
                remove(array[i--]);
        }
        return true;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[1];
        size = 0;
    }

    private class ElementsIterator implements Iterator<T> {

        private int size;

        @Override
        public boolean hasNext() {
            return size < ArrayCollection.this.size();
        }

        @Override
        public T next() {
            if (size > ArrayCollection.this.size()) {
                throw new NoSuchElementException();
            }

                return array[size++];
        }
    }

}
