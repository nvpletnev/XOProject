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
            if (item == o) return true;
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
        if (a.length < size)
            a = (T1[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Item<T> x = firstInList; x != null; x = x.nextItem)
            result[i++] = x.element;

        if (a.length > size)
            a[size] = null;
        return a;
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
        if(o == null) return false;
        for (T t: this) {
            if (o.equals(t)) {
                remove(getItemByIndex(indexOf(t)));
                return true;
            }
        }
        return false;

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
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        T removedItem = getItemByIndex(index).element;
        remove(getItemByIndex(index));
        return removedItem;
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
        if (element == null) throw new IllegalStateException();
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
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
        return getItemByIndex(index).element;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
        Item<T> item;

        if (index < (size >> 1)) {
            item = firstInList;
            for (int i = 0; i < index; i++) {
                item = item.getNextItem();
            }
            return item;
        } else {
            item = lastInList;
            for (int i = size() - 1; i > index; i--) {
                item = item.getPrevItem();
            }
            return item;
        }


        // END
    }

    private void remove(final Item<T> current) {
        // BEGIN (write your solution here)
        Item<T> nextNode;
        Item<T> prevNode;

        if (current.equals(firstInList)) {
            firstInList = firstInList.getNextItem();
            size--;
        } else if (current.equals(lastInList)) {
            lastInList = lastInList.getPrevItem();
            size--;
        } else {
            nextNode = current.getNextItem();
            prevNode = current.getPrevItem();
            prevNode.nextItem = nextNode;
            nextNode.prevItem = prevNode;
            size--;
        }
        // END
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;

        private Item<T> lastReturnedItemFromIterator;

        private int index;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            currentItemInIterator = (index == size()) ? null : getItemByIndex(index);
            this.index = index;
            // END
        }

        @Override
        public boolean hasNext() {
            // BEGIN (write your solution here)
            return LinkedList.this.size() > index;
            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)

            if (!hasNext()) throw new NoSuchElementException();
            lastReturnedItemFromIterator = currentItemInIterator;
            currentItemInIterator = currentItemInIterator.getNextItem();
            index++;
            return lastReturnedItemFromIterator.element;
            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
            return index > 0;
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            if (!hasPrevious()) throw new NoSuchElementException();
            currentItemInIterator = (currentItemInIterator == null) ? lastInList : currentItemInIterator.prevItem;
            lastReturnedItemFromIterator = currentItemInIterator;
            index--;
            return lastReturnedItemFromIterator.element;

            // END
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)
            if (lastReturnedItemFromIterator == null) throw new IllegalStateException();
            lastReturnedItemFromIterator.element = element;
            // END
        }

        @Override
        public int previousIndex(){
            // BEGIN (write your solution here)
            return index - 1;
            // END
        }
        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            return index;
            // END
        }


        @Override
        public void remove() {
            // BEGIN (write your solution here)
            if (lastReturnedItemFromIterator == null) throw new IllegalStateException();
            Item<T> lastNext = lastReturnedItemFromIterator.getNextItem();
            LinkedList.this.remove(lastReturnedItemFromIterator);
            if (currentItemInIterator == lastReturnedItemFromIterator) {
                currentItemInIterator = lastNext;
            }
            else index--;
            lastReturnedItemFromIterator = null;
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