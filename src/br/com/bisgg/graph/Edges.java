package br.com.bisgg.graph;

public class Edges {

    private final Node from, to;

    public Edges (Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString () {
        return "["+from+ "=> "+to+"]";
    }
}
