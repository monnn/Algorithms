package com.moni;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class ArrayBag<Item> implements Iterable<Item> {


    Item[] elements;
    private int numberOfElements = 0;

    public ArrayBag(int size) {
        this.elements = (Item[]) new Object[size];

    }

    public void add(Item item){
        elements[numberOfElements] = item;
        numberOfElements++;
    }

    public boolean isEmpty(){
        return numberOfElements == 0;
    }

    public int size(){
        return numberOfElements;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {

    }

    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }
}
