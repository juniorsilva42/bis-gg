package br.com.bisgg.graph;

import java.util.List;

public class Graph {

    private List<Edges> edgesOrigin;
    private int nodes;

    public Graph (int nodes, List<Edges> edges) {
        this.nodes = nodes;
        this.edgesOrigin = edgesOrigin;
    }

    public List<Edges> getEdgesOrigin() {
        return edgesOrigin;
    }

    public void setEdgesOrigin(List<Edges> edgesOrigin) {
        this.edgesOrigin = edgesOrigin;
    }

    public int getNode() {
        return nodes;
    }

    public void setNode(int node) {
        this.nodes = node;
    }
}
