package collections.linkedlist;

import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private Item<T> firstInList = null;

    private Item<T> lastInList = null;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        for (T item : this) {
            if (item.equals(o)) return true;
        }
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator(0);
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)

        Object[] array = new Object[size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.get(i);
        }
        return array;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        //TODO

        // END
    }

    @Override
    public boolean add(final T newElement) {
        // BEGIN (write your solution here)
        if (isEmpty()) {
            Item<T> item = new Item<>(newElement, null, null);
            this.firstInList = item;
            this.lastInList = item;
            this.size++;
            return true;
        }

        Item<T> item = new Item<>(newElement, lastInList, null);
        this.lastInList.nextItem = item;
        this.lastInList = item;
        this.size++;
        return true;
        // END
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)
        //TODO
        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final T item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)

        for (int i = 0; i < size; i++) {
            getItemByIndex(i).element = null;
            getItemByIndex(i).nextItem = null;
            getItemByIndex(i).prevItem = null;
        }
        firstInList = lastInList = null;
        size = 0;

        // END
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException{
        // BEGIN (write your solution here)
        //TODO

        // END
    }


    private void remove(final Item<T> current) {
        // BEGIN (write your solution here)
        //TODO

        // END
    }

    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object o) {
        // BEGIN (write your solution here)
        int index = -1;
        if (o == null) return index;
        for (T item : this) {
            index++;
            if (item.equals(o)) return index;
        }
        return -1;
        // END
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)
        Item<T> item = getItemByIndex(index);
        T oldItem = item.element;
        item.element = element;
        return oldItem;
        // END
    }

    @Override
    public T get(final int index) {
        // BEGIN (write your solution here)
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        int count = -1;
        for (T item : this) {
            count++;
            if (index == count) return item;
        }
        return null;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
        Item<T> item;

        if (index < (size >> 1)) {
            item = firstInList;
            for (int i = 0; i < index; i++) {
                item = item.nextItem;
            }
            return item;
        } else {
            item = lastInList;
            for (int i = size() - 1; i > index; i--) {
                item = item.prevItem;
            }
            return item;
        }


        // END
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;

        private Item<T> lastReturnedItemFromIterator;

        private int index;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)
                this.index = index;
            // END
        }

        @Override
        public boolean hasNext() {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public int previousIndex(){
            // BEGIN (write your solution here)

            // END
        }
        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)

            // END
        }


        @Override
        public void remove() {
            // BEGIN (write your solution here)

            // END
        }
    }

    private static class Item<T> {

        private T element;

        private Item<T> nextItem;

        private Item<T> prevItem;

        Item(final T element, final Item<T> prevItem, final Item<T> nextItem) {
            this.element = element;
            this.nextItem = nextItem;
            this.prevItem = prevItem;
        }


        public Item<T> getNextItem() {
            return nextItem;
        }

        public Item<T> getPrevItem() {
            return prevItem;
        }
    }
}