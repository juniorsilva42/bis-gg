package br.com.bisgg.graph;

public class Graph {

    private Edges edges;
    private Node nodes;

    public Graph (Node nodes, Edges edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Edges getEdges() {
        return edges;
    }

    public void setEdges(Edges edges) {
        this.edges = edges;
    }

    public Node getNodes() {
        return nodes;
    }

    public void setNodes(Node nodes) {
        this.nodes = nodes;
    }
}
