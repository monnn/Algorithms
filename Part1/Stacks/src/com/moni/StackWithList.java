package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */

public class StackWithList {

    private class Node {

        String item;
        Node prev;
    }

    private Node top = null;

    private void push (String item) {
        Node oldTop = top;
        top = new Node();
        top.prev = oldTop;
        top.item = item;
    }

    private String pop () {
        String item = top.item;
        top = top.prev;
        return item;
    }

    private boolean isEmpty(){
        return top == null;
    }

    @Override
    public String toString() {
        return "StackWithArray{" +
                "top=" + top.item +
                '}';
    }

    public static void main(String[] args){
        StackWithList stack = new StackWithList();
        stack.push("cats");
        stack.push("love");
        stack.push("dogs");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.toString());
    }
}
