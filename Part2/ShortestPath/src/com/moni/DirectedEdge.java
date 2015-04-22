package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class DirectedEdge {

    public final int v;
    public final int w;
    public final double weight;

    public DirectedEdge(int v, int w, double weight) {
        if (v < 0 || w < 0) {
            throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        }
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return v + " -> " + w + ", weight = " + weight + ";";
    }

    public static void main(String[] args){
        DirectedEdge e = new DirectedEdge(12, 23, 3.14);
        System.out.println(e);
    }
}
