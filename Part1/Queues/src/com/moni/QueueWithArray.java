package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */

public class QueueWithArray {

    private String[] queueArray;
    private int size;
    private int head = 0;
    private int tail = 0;
    private int currentSize = 0;

    public QueueWithArray(int size) {
        this.size = size;
        queueArray = new String[size];
    }

    public void enqueue(String item) {
        if(isFull()) {
            System.out.println("Queue is full! Resizing.");
            resize(2 * queueArray.length);
        }
            queueArray[tail++] = item;
        if (tail == queueArray.length) {
            tail = 0;
        }
            currentSize++;

    }

    public String dequeue() {
        if (isEmpty()){
            return "Queue is empty";
        }
        String currentHead = queueArray[head];
        queueArray[head] = null;
        head++;
        currentSize--;
        if (head == queueArray.length){
            head = 0;
        }
        if (currentSize > 0 && currentSize == queueArray.length/4){
            resize(queueArray.length/2);
        }
        return currentHead + " is removed";
    }

    public void resize(int newSize) {
        String[] resizedArray = new String[newSize];
        for (int i = 0; i < currentSize; i++, head++) {
            resizedArray[i] = queueArray[head];
            queueArray = resizedArray;
            head = 0;
            tail = currentSize ;
        }
    }

    private void displayTheQueue() {
        for (int i = 0; i < queueArray.length; i++) {
            System.out.println(queueArray[i]);
        }
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == queueArray.length;
    }

    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray(3);
        queue.enqueue("cats");
        queue.enqueue("love");
        queue.enqueue("dogs");
        queue.displayTheQueue();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("cats");
        queue.enqueue("love");
        queue.enqueue("dogs");
        queue.enqueue("cats");
        queue.enqueue("love");
        queue.enqueue("dogs");
        queue.displayTheQueue();

    }
}
