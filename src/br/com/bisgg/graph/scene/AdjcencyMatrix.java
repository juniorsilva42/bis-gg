package br.com.bisgg.graph.scene;

public class AdjcencyMatrix implements GraphSceneInterface {

    private int nodes;
    private int edges;
    private int[][] matrix;

    public AdjcencyMatrix (int nodes, int edges) {
        this.matrix = new int[nodes][edges];
    }

    public void setValue (int i, int j, int value) {
        this.matrix[i][j] = value;
    }

    public void setGraph () {
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

    @Override
    public void getMinorMajorLength() {

    }
}
