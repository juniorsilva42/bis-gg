package br.com.bisgg.graph.bisgg.graph;

public class Graph {

    private static int edges;
    private static int nodes;

    public Graph (int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public static int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public static int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }
}
