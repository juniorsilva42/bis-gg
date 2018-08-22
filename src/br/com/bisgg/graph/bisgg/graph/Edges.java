package br.com.bisgg.graph.bisgg.graph;

public class Edges {

    private final int from, to;

    public Edges (int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString () {
        return "["+from+ "=> "+to+"]";
    }
}
