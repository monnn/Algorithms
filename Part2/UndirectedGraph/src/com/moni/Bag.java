package com.moni;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Bag<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> first;

    public Bag() {
        first = null;
        size = 0;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<Integer>();
        bag.add(13);
        bag.add(17);
        bag.add(14);
        System.out.println("size of bag = " + bag.size());

        }
    }

