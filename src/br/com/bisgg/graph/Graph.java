package br.com.bisgg.graph;

public class Graph {

    private int edges;
    private int nodes;
    private int[][] matrizAdjacencia;

    public Graph (int edges, int nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public void setGraph (int i, int j, int value) {
        this.matrizAdjacencia[i][j] = value;
    }

    public int getEdges () {
        return this.edges;
    }

    public int getNodes () {
        return this.edges;
    }
}
