package br.com.bisgg.graph.scene;

import java.util.*;

public class AdjacencyList implements GraphSceneInterface {

    private List<Integer>[] nodes;
    private int nodesOrder;

    public AdjacencyList (int order) {
        this.nodes = new LinkedList[order];
        this.nodesOrder = order;

        for (int i = 0; i < this.nodesOrder; i++)
            nodes[i] = new LinkedList<>();

    }

    public void set (int i, int j) {
    }

    @Override
    public void getLengthNode(int node) {

    }

    @Override
    public boolean isAdjacent(int node1, int node2) {
        return false;
    }

    @Override
    public void getNodeAdjacency(int node) {

    }
}
