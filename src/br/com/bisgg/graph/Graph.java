package br.com.bisgg.graph;

import br.com.bisgg.graph.scene.Node;

import java.util.List;

public class Graph {

    private List<Edges> edges;
    private Node node;

    public Graph (Node node, List<Edges> edges) {
        this.node = node;
        this.edges = edges;
    }

    public List<Edges> getEdges() {
        return edges;
    }

    public void setEdges(List<Edges> edges) {
        this.edges = edges;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
