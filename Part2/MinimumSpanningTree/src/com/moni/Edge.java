package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Edge implements Comparable<Edge> {

    public final int v;
    public final int w;
    public final double weight;

    @Override
    public int compareTo(Edge that) {
        if(this.weight() < that.weight()){
            return -1;
        }
        else if (this.weight() > that.weight()) {
            return +1;
        }
        else {
            return 0;
        }
    }

    public Edge(int v, int w, double weight) {
        if (v < 0 || w < 0) {
            throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        }
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        }
        else if (vertex == w) {
            return v;
        }
        else {
            throw new IllegalArgumentException("Illegal endpoint");
        }
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return v + " -> " + w + ", weight = " + weight + ";";
    }

    public static void main(String[] args){
        Edge e = new Edge(12, 23, 3.14);
        System.out.println(e);
    }
}
