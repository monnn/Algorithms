package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */

public class UndirectedGraph {

    public int V;
    public int E;
    public Bag<Integer>[] adj;


    public UndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

//    public void readFromFile(File file) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
//
//        for (int i = 0; i < V; i++) {
//            String line = br.readLine();
//            V = line.charAt(0);
//        }
//
//        br.close();
//    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int numberOfEdges(){
        return E;
    }

    public int numberOfVertices(){
        return V;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges ");
        for (int v = 0; v < V; v++) {
            s.append('\n');
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(6, 2);
        graph.addEdge(1, 3);
        System.out.println(graph);
    }
}
