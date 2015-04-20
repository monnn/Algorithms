package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */

public class QueueWithList {

    private class Node{
        String item;
        Node next;
    }

    private Node first ;
    private Node last = null;

    private void enqueue(String item){

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    private String dequeue(){
        Node currentFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return currentFirst.item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args){
        QueueWithList queue = new QueueWithList();
        queue.enqueue("cats");
        queue.enqueue("love");
        queue.enqueue("dogs");
        System.out.println(queue.dequeue());
    }

}
