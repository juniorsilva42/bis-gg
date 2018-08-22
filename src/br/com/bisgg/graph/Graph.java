package br.com.bisgg.graph;

public class Graph {

    private int edges;
    private int nodes;
    private int[][] matrizAdjacencia;

    public Graph (int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public void setGraph (int i, int j, int value) {
        this.matrizAdjacencia[i][j] = value;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }
}
