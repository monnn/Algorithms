package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */

public class StackWithArray {

    private int size;
    private int top = -1;
    private String[] stackArray;

    public StackWithArray(int size) {
        this.size = size;
        stackArray = new String[size];
    }

    public void push(String item){
        if (top == size - 1) {
            System.out.println("The stack is full! Resizing.");
            resize( 2 * stackArray.length);
        }
        top++;
        stackArray[top] = item;
    }

    public void resize(int newSize){
        String[] resizedArray = new String[newSize];
        for (int i = 0; i < top; i++) {
            resizedArray[i] = stackArray[i];
            stackArray = resizedArray;
        }
    }

    public String pop(){
        if (top >= 0) {
            String currentTop = stackArray[top];
            stackArray[top] = null;
            top--;
            return currentTop + " is removed";
        } else {
            return "The stack is empty";
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    private void displayTheStack() {
        for (int i = 0; i < stackArray.length; i++) {
            System.out.println(stackArray[i]);
        }
    }

    public static void main(String[] args){
        StackWithArray stack = new StackWithArray(3);
        stack.push("cats");
        stack.push("love");
        stack.push("dogs");
        stack.displayTheStack();
        System.out.println(stack.pop());
        stack.displayTheStack();
        stack.isEmpty();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("cats");
        stack.push("love");
        stack.push("dogs");
        stack.displayTheStack();
        stack.push("cats");
        stack.push("love");
        stack.push("dogs");
        stack.displayTheStack();
    }
}
