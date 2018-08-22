package br.com.bisgg.graph;

public class Node {

    private int identifier;

    public Node(final int identifier) {
        this.identifier = identifier;
    }

    public int getIdentifier () {
        return identifier;
    }

    public void setName(int identifier) {
        this.identifier = identifier;
    }
}
