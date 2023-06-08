package deque;

import java.util.Deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements deque.Deque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        public Node pre;
        public T item;
        public Node next;

        public Node(T i) {
            item = i;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null);
        size = 0;
    }

    //Adds an item of type T to the front of the deque
@Override
    public void addFirst(T item) {
        Node first = new Node(item);
        if (sentinel.next == null) {
            sentinel.next = first;
            first.next = sentinel;
            sentinel.pre = first;
            first.pre = sentinel;
        } else {
            first.next = sentinel.next;
            sentinel.next = first;
            first.pre = sentinel;
            first.next.pre = first;

        }
        size += 1;
    }

    //Adds an item of type T to the back of the deque.
@Override
    public void addLast(T item) {
        Node last = new Node(item);
        if (isEmpty()) {
            sentinel.pre = last;
            last.next = sentinel;
            sentinel.next = last;
            last.pre = sentinel;
        } else {
            last.next = sentinel;
            sentinel.pre.next = last;
            last.pre = sentinel.pre;
            sentinel.pre = last;

        }
        size += 1;
    }



    //Returns the number of items in the deque.
@Override
    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        if (sentinel.next != null) {
            Node p = sentinel;
            while (p.next != sentinel) {
                System.out.print(p.next.item + " ");
                p = p.next;
            }
        }
        System.out.println();
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
@Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node first = sentinel.next;
        if (size == 1) {
            sentinel.next = null;
            sentinel.pre = null;
        } else {
            sentinel.next = first.next;
            first.next.pre = sentinel;
        }
        first.next = null;
        first.pre = null;
        size -= 1;
        return first.item;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
@Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node last = sentinel.pre;
        if (size == 1) {
            sentinel.next = null;
            sentinel.pre = null;
        } else {
            sentinel.pre = last.pre;
            last.pre.next = sentinel;
        }
        last.next = null;
        last.pre = null;
        size -= 1;
        return last.item;
    }

    //Gets the item at the given index
@Override
    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        Node p = sentinel;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }

    //The Deque objects we’ll make are iterable
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node node;

        LinkedListIterator() {
            this.node = sentinel.next;
        }
@Override
        public boolean hasNext() {
            return this.node != sentinel;
        }
@Override
        public T next() {
            T ret = this.node.item;
            this.node = this.node.next;
            return ret;
        }

    }

    //Returns whether the parameter o is equal to the Deque.
@Override
    public boolean equals(Object o) {
        if (o instanceof Deque && ((Deque<?>) o).size() == size) {
            Iterator<T> it1 = iterator();
            Iterator<?> it2 = ((Deque<?>) o).iterator();
            for (int i = 0; i < size; i++) {
                if (!it1.next().equals(it2.next())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //Same as get, but uses recursion.
    public T getRecursive(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        return getRecursivehelper(index, sentinel.next);
    }

    public T getRecursivehelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursivehelper(index - 1, p.next);
        }
    }
}

