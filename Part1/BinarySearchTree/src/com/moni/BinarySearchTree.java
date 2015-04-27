package com.moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        Key key;
        Value value;
        Node leftChild, rightChild;
        int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public void put(Key key, Value value){
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    public Node put(Node node, Key key, Value value){
        if (node == null){
            return new Node(key, value, 1);
        }
        if (key.compareTo(node.key) < 0){
            node.leftChild  = put(node.leftChild,  key, value);
        } else if (key.compareTo(node.key) > 0){
            node.rightChild = put(node.rightChild, key, value);
        } else{
            node.value = value;
        }
        node.N = 1 + size(node.leftChild) + size(node.rightChild);
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return get(node.leftChild, key);
        } else if (key.compareTo(node.key) > 0) {
            return get(node.rightChild, key);
        } else {
            return node.value;
        }
    }

    public void delete(Key key){
        delete(root, key);
    }

    public Node delete(Node node, Key key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) > 0){
            node.rightChild = delete(node.rightChild, key);
        } else if (key.compareTo(node.key) < 0){
            node.leftChild = delete(node.leftChild, key);
        } else {
            if (node.rightChild == null){
                return node.leftChild;
            }
            if (node.leftChild == null){
                return node.rightChild;
            }
            Node x = node;
            node = min(x.rightChild);
            node.rightChild = deleteMin(x.rightChild);
            node.leftChild = x.leftChild;
        }
        node.N = size(node.leftChild) + size(node.rightChild) + 1;
        return node;
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node node){
        if (node.leftChild == null){
            return node;
        } else
            return min(node.leftChild);
    }

    public Key max(){
        return max(root).key;
    }

    public Node max(Node node){
        if (node.rightChild == null){
            return node;
        }else
            return max(node.rightChild);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    public Node deleteMin(Node node){
        if (node.leftChild == null){
            return node.rightChild;
        } node.leftChild = deleteMin(node.leftChild);
        return node;
    }

    public void deleteMax(){
        deleteMax(root);
    }

    public Node deleteMax(Node node){
        if (node.rightChild == null){
            return node.leftChild;
        } node.rightChild = deleteMax(node.rightChild);
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key low, Key high) {
        if (x == null){
            return;
        }
        if (low.compareTo(x.key) < 0) {
            keys(x.leftChild, queue, low, high);
        }
        if (low.compareTo(x.key) <= 0 && high.compareTo(x.key) >= 0){
            queue.add(x.key);
        }
        if (high.compareTo(x.key) > 0){
            keys(x.rightChild, queue, low, high);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
        String[] array = {"a","s","f","e","g","r","m","n","b"};
        for (int i = 0; i < array.length ; i++) {
            bst.put(array[i], i);
        }
        for (String s: bst.keys()){
            System.out.println(s + " " + bst.get(s));
        }
    }

}
